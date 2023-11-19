package com.erni.commons;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.erni.actions.InputAction;
import com.erni.actions.CursorAction;
import com.erni.actions.WaitAction;

public class PageBase {
	
	protected InputAction input = InputAction.getInstance();
	protected CursorAction mouse = CursorAction.getInstance();
	protected WaitAction wait = WaitAction.getInstance();
	
	protected Verify verify = new Verify();
	protected Logger logger = LoggerFactory.getLogger(WaitAction.class);
	protected WebDriver driver;

}
