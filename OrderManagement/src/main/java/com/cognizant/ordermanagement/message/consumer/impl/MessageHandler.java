package com.cognizant.ordermanagement.message.consumer.impl;

import java.util.ArrayList;

public class MessageHandler {
	public ArrayList<String> handleMessage(byte[] data) {
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add(new String(data));
		return arrayList;
	}
}