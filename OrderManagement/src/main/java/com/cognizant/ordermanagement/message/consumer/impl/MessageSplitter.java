package com.cognizant.ordermanagement.message.consumer.impl;

import java.util.ArrayList;

import org.springframework.integration.splitter.AbstractMessageSplitter;
import org.springframework.messaging.Message;

public class MessageSplitter extends AbstractMessageSplitter {
	@Override
	protected ArrayList<?> splitMessage(Message<?> message) {
		ArrayList<?> messages = (ArrayList<?>) message.getPayload();
		System.out.println("Total messages: " + messages.size());
		for (Object mess : messages) {
			System.out.println(mess.toString());
		}
		return messages;
	}
}