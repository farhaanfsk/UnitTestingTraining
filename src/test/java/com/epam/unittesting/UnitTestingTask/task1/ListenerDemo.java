package com.epam.unittesting.UnitTestingTask.task1;

import java.util.logging.Logger;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerDemo implements ITestListener {
	static Logger log = Logger.getLogger("ListenerDemo.class");

	public void onTestStart(ITestResult result) {
		log.info(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		log.info(result.getMethod() + " : " + result.isSuccess());
	}

	public void onTestFailure(ITestResult result) {
		log.info("Test Failed : " + result.getTestName());
	}

	public void onTestSkipped(ITestResult result) {
		log.info("Test Skipped : " + result.getTestName());
	}

	public void onStart(ITestContext context) {
		for (String s : context.getExcludedGroups())
			log.info(s);
	}

	public void onFinish(ITestContext context) {
		log.info(context.getHost());
	}
}
