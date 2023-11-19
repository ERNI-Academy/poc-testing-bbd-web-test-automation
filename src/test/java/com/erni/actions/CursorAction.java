package com.erni.actions;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CursorAction {
	
	private static CursorAction instance = new CursorAction();
	
	private Logger logger = LoggerFactory.getLogger(CursorAction.class);
	
	/**
	 * Returns instance of the class
	 * 
	 * @return instance
	 */
	public static CursorAction getInstance(){
		return instance;
	}
	
	public CursorAction click(WebElement elem) throws Exception{
		elem.click();
		logger.info("Clicking element");
		return this;
	}

}
