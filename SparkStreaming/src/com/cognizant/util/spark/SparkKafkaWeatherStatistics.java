package com.cognizant.util.spark;

import java.util.HashMap;
import java.util.Map;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaPairReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka.KafkaUtils;

import com.cognizant.spark.model.YearWiseRainFall;
import com.cognizant.util.spark.mapper.RainFallStatisticsMapper;
import com.cognizant.util.spark.pairfunction.RainFallStatisticsPair;
import com.cognizant.util.spark.reducer.RainFallStatisticsReducer;

import scala.Tuple2;

public class SparkKafkaWeatherStatistics {
	public static void main(String[] args) {
		SparkConf sparkConf = new SparkConf().setAppName("JavaKafkaWordCount").setMaster("local[2]");
		// Create the context with 2 seconds batch size
		JavaStreamingContext jssc = new JavaStreamingContext(sparkConf, new Duration(5000));
		Map<String, Integer> topicMap = new HashMap<String, Integer>();
		topicMap.put("test", 1);
		JavaPairReceiverInputDStream<String, String> messages =  KafkaUtils.createStream(jssc,"localhost:2181","ddd",topicMap);
		JavaDStream<String> lines = messages.map(new Function<Tuple2<String, String>, String>() {
			@Override
			public String call(Tuple2<String, String> tuple2) {
				return tuple2._2();
			}
		});
		JavaDStream<YearWiseRainFall> yearDistrictWiseRainFall = lines.flatMap(new RainFallStatisticsMapper());
		JavaPairDStream<String, YearWiseRainFall> yearAvg = yearDistrictWiseRainFall.mapToPair(new RainFallStatisticsPair());
		JavaPairDStream<String, YearWiseRainFall>  reduced = yearAvg.reduceByKey(new RainFallStatisticsReducer());
		reduced.print();
		jssc.start();
		jssc.awaitTermination();
	}

}
