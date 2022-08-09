package com.cognizant.ordermanagement.message.consumer.impl;

import org.springframework.messaging.Message;

public class ProductFilter {

	public Boolean filter(Message<?> content) {
		System.out.println(content);
		if (content.getHeaders().get("keyword").toString().equalsIgnoreCase("SALES")) {
			return true;
		}
		if (content.getHeaders().get("keyword").toString().equalsIgnoreCase("INVENTORY")) {
			return true;
		}
		if (content.getHeaders().get("keyword").toString().equalsIgnoreCase("ORDER")) {
			return true;
		}
		System.out.println("Invalid keyword found");
		return false;
	}
}
