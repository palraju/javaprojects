package com.cognizant.storm.bolt;

import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

public class PrintSQLException extends BaseRichBolt{
	@Override
	public void execute(Tuple input) {
		String inputString = input.getString(0); 
		if(inputString != null && inputString.contains("SQL")){
			System.out.println("SQLException Bolt:"+inputString);		
		}
	}

	@Override
	public void prepare(Map arg0, TopologyContext arg1, OutputCollector arg2) {
		
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer arg0) {
		
	}
}
