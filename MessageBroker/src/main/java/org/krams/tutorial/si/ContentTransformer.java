package org.krams.tutorial.si;

import org.apache.log4j.Logger;

/**
 *  Retrieves the <b>content</b> entry and returns it as an array of Strings. 
 *  This assumes the content is delimited by semicolon.
 *  
 *  @author Krams at {@link http://krams915@blogspot.com}
 */
public class ContentTransformer {

	protected static Logger logger = Logger.getLogger("integration");
	private static final String DELIMITER = ";";
	
	public String[] transform(String content) {
		System.out.println("Original data: " + content);		
		String[] contentArray = content.split(DELIMITER);		
		System.out.println("Tranformed data: " + contentArray);
		return contentArray;
	}
}
