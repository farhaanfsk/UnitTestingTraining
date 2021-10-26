package com.epam.unittesting.UnitTestingTask.task1;
import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
public class CustomRunnerExample {
	public static void main(String args[]) {
		XmlSuite suite = new XmlSuite();
		suite.setName("TmpSuite");
		XmlTest test = new XmlTest(suite);
		test.setName("TmpTest");
		TestNG tng = new TestNG();
		List<String> suites = new ArrayList<String>();
		suites.add("testng.xml");
		tng.setTestSuites(suites);
		tng.run(); 
	}
	
	
}
