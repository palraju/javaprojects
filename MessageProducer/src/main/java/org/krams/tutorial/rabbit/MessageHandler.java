package org.krams.tutorial.rabbit;

import org.apache.log4j.Logger;

public class MessageHandler {

	protected Logger logger = Logger.getLogger("client");
	
	public void handleMessage(String text) {
		logger.debug("Received: " + text);
	}
}
