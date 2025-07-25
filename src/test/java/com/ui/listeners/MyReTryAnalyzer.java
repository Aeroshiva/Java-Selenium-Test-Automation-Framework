package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;

public class MyReTryAnalyzer implements IRetryAnalyzer {

	/*
	 * ITestResult --> gives information about test **> failed test
	 * if retry method return true --> go ahead Rerun the failed tests
	 * if retry method return false --> TestNG will mark the tests as a failed tests
	 * 
	 */
	//	private static final int MAX_NUMBER_OF_ATTEMPTS = Integer.parseInt(PropertiesUtil.readProperty(Env.DEV, "MAX_NUMBER_OF_ATTEMPTS")) ;  reading from properties file

	private static final int MAX_NUMBER_OF_ATTEMPTS = JSONUtility.readJSON(Env.QA).getMAX_NUMBER_OF_ATTEMPTS();
	private static int  currentAttempt = 1;
	
	
	
	@Override
	public boolean retry(ITestResult result) {
		if(currentAttempt<=MAX_NUMBER_OF_ATTEMPTS) {
			currentAttempt++;
			return true;

		}
		
		return false;
	}
	
	
	
	
	
	
	
}
