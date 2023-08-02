package com.UtilsLayer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.BaseLaye.BaseClass;

public class RetryAnalyzer extends BaseClass implements IRetryAnalyzer{

	int counter = 0;
	int maxRetryLimit = 5;
	
	public boolean retry(ITestResult result) {
		if(counter<maxRetryLimit) {
			counter++;
			return true;
		}
		return false;
	}

}
