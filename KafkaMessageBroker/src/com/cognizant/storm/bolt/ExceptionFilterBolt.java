package com.cognizant.storm.bolt;

import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

public class ExceptionFilterBolt extends BaseRichBolt  {

	private OutputCollector _collector;
	
	@Override
	public void execute(Tuple input) {
		String inputString = input.getString(0);    
		if(inputString != null && inputString.contains("Exception")){
			//System.out.println(inputString);
			_collector.emit(input, new Values(inputString));
		    _collector.ack(input);
		}		
	}

	@Override
	public void prepare(Map conf, TopologyContext context, OutputCollector collector) {
		_collector = collector;		
	}
	
	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("exception"));
	}	
}
