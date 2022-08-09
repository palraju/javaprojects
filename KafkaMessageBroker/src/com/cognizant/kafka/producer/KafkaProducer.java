package com.cognizant.kafka.producer;

import java.util.Properties;

import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class KafkaProducer {
    private String topic = "test";
    
    public String getTopicName() {
		return topic;
	}
	public void setTopic (String topicName) {
		this.topic = topicName;
	}
	
    public KafkaProducer(String topicName) {
		super();
		this.topic = topicName;
	}
    
	public void sendMessage(String messageString){
        Properties properties = new Properties();
        properties.put("metadata.broker.list","localhost:9092");
        properties.put("serializer.class","kafka.serializer.StringEncoder");
        ProducerConfig producerConfig = new ProducerConfig(properties);
        kafka.javaapi.producer.Producer<String,String> producer = new kafka.javaapi.producer.Producer<String, String>(producerConfig);
        KeyedMessage<String, String> message =new KeyedMessage<String, String>(topic,messageString);
        producer.send(message);
        producer.close();
    }
    public static void main(String[] args){
    	new KafkaProducer("test").sendMessage("Hello World!!!!");    	
    }
}