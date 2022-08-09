package com.cognizant.util.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import com.cognizant.spark.model.YearWiseRainFall;
import com.cognizant.util.spark.mapper.RainFallStatisticsMapper;
import com.cognizant.util.spark.pairfunction.RainFallStatisticsPair;
import com.cognizant.util.spark.reducer.RainFallStatisticsReducer;

public class SparkStreamReader {

	public static void wordCountJava7(String dir) {
		// Define a configuration to use to interact with Spark
		SparkConf conf = new SparkConf().setMaster("local").setAppName("Weather Stat App");
		// Create a Java version of the Spark Context from the configuration
		JavaSparkContext sc = new JavaSparkContext(conf);
		// Load the input data, which is a text file read from the command line
		JavaRDD<String> input = sc.textFile(dir).repartition(1);
		JavaRDD<YearWiseRainFall> yearDistrictWiseRainFall = input.flatMap(new RainFallStatisticsMapper());
		JavaPairRDD<String, YearWiseRainFall> yearAvg = yearDistrictWiseRainFall.mapToPair(new RainFallStatisticsPair());
		JavaPairRDD<String, YearWiseRainFall> reduced = yearAvg.reduceByKey(new RainFallStatisticsReducer());
		reduced.saveAsTextFile("output");
	}

	public static void main(String[] args) {
		wordCountJava7("C:\\Raju\\hadoop\\weatherData");
	}
}