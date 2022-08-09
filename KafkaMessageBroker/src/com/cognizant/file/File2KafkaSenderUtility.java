package com.cognizant.file;

import java.io.BufferedReader;
import java.io.FileReader;

import com.cognizant.kafka.producer.KafkaProducer;
import com.cognizant.model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class File2KafkaSenderUtility {

	private KafkaProducer kafkaProducer;
	private String fileName;

	public KafkaProducer getKafkaProducer() {
		return kafkaProducer;
	}

	public void setKafkaProducer(KafkaProducer kafkaProducer) {
		this.kafkaProducer = kafkaProducer;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public File2KafkaSenderUtility(KafkaProducer kafkaProducer, String fileName) {
		super();
		this.kafkaProducer = kafkaProducer;
		this.fileName = fileName;
	}

	public File2KafkaSenderUtility() {
		super();
	}

	public void sendFileLines2Kafka() {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			for (String line; (line = br.readLine()) != null;) {
				// process the line.
				sendLine2Kafka(line);
			}
			// line is not visible here.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendLine2Kafka(String line) {
		kafkaProducer.sendMessage(line);
	}

	public static void main(String[] args) throws JsonProcessingException, InterruptedException {
		String fileName = "C:\\Raju\\hadoop\\weatherData\\Delhi_DATA2.txt";
		KafkaProducer kafkaProducer = new KafkaProducer("logstashtest");		
		ObjectMapper mapper = new ObjectMapper();
		File2KafkaSenderUtility file2KafkaUtil = new File2KafkaSenderUtility(kafkaProducer,fileName);
		for(int i=40;i<80;i++){
			Employee e = new Employee();
			e.setEmpname("RAJU PAL - "+(i+1));
			e.setHobby("Dancing");
			e.setSalary(4500 + 20*i);
			String empString = mapper.writeValueAsString(e);
			Thread.sleep(100);
			file2KafkaUtil.sendLine2Kafka(empString);
		}
		
	}
}
