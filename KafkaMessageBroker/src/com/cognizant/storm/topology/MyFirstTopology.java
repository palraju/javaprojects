package com.cognizant.storm.topology;

import java.util.UUID;

import com.cognizant.storm.bolt.ExceptionFilterBolt;
import com.cognizant.storm.bolt.PrintDBException;
import com.cognizant.storm.bolt.PrintSQLException;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.spout.SchemeAsMultiScheme;
import backtype.storm.topology.TopologyBuilder;
import storm.kafka.BrokerHosts;
import storm.kafka.KafkaSpout;
import storm.kafka.SpoutConfig;
import storm.kafka.StringScheme;
import storm.kafka.ZkHosts;

public class MyFirstTopology {
	private static String topicName = "test";
	
	public static void main(String[] args) throws Exception {		
		BrokerHosts hosts = new ZkHosts("localhost:2181");
		SpoutConfig spoutConfig = new SpoutConfig(hosts, topicName, "/" + topicName, UUID.randomUUID().toString());
		spoutConfig.scheme = new SchemeAsMultiScheme(new StringScheme());
		//spoutConfig.forceFromStart = true;
		spoutConfig.startOffsetTime = kafka.api.OffsetRequest.EarliestTime();
		KafkaSpout kafkaSpout = new KafkaSpout(spoutConfig);		
		LocalCluster cluster = new LocalCluster();
	    TopologyBuilder builder = new TopologyBuilder();
		spoutConfig.scheme = new SchemeAsMultiScheme(new StringScheme());
		builder.setSpout("spout", kafkaSpout);
		builder.setBolt("exceptionFilter", new ExceptionFilterBolt()).shuffleGrouping("spout");
		builder.setBolt("printSQLException", new PrintSQLException()).shuffleGrouping("exceptionFilter");
		builder.setBolt("printDBException", new PrintDBException()).shuffleGrouping("exceptionFilter");
		Config config = new Config();
		cluster.submitTopology("kafka-test", config, builder.createTopology());
		Thread.sleep(600000);
	}
}