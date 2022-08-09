package org.krams.tutorial.si;

import java.util.ArrayList;

import org.apache.log4j.Logger;

/**
 *  Accepts a byte array and converts it as an ArrayList
 *  
 *  @author Krams at {@link http://krams915@blogspot.com}
 */
public class MessageHandler {

	protected Logger logger = Logger.getLogger("integration");
	 
	public ArrayList<String> handleMessage(byte[] data) {
		logger.debug("Received: " + new String(data));
		
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add(new String(data));
		
		return arrayList;
	}
	
}
