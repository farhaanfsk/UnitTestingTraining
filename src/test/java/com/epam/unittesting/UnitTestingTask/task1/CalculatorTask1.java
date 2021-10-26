package com.epam.unittesting.UnitTestingTask.task1;

import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.epam.tat.module4.Calculator;

public class CalculatorTask1 {
	static Logger log = Logger.getLogger("CalculatorTask1.class");
	Calculator calculator;
	long number1 = 25, number2 = 3;
	int number3 = 4;

	@DataProvider(name = "input-data")
	public Object[][] dataProvider() {
		return new Object[][] { { 1, 3 }, { 2, 2 }, { 4, 0 } };
	}

	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		log.info("Before class initializing the Calculator class");
		calculator = new Calculator();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		log.info("After class Running GC");
		System.gc();
	}

	@BeforeGroups("Positive")
	public void beforePGroup() {
		log.info("Executeing positive Tests");
	}

	@AfterGroups("Positive")
	public void afterPGroup() {
		log.info("Positive test case execution finished");
	}

	@BeforeGroups("Negative")
	public void beforeNGroup() {
		log.info("Executeing Negative Tests");
	}

	@AfterGroups("Negative")
	public void afterNGroup() {
		log.info("Negative test case execution finished");
	}

	@Test(dataProvider = "input-data", groups = { "Positive" }, description = "Positive case 1")
	public void testAddition(int a, int b) {
		System.out.println("Addition is " + calculator.sum(a, b));
		Assert.assertEquals(calculator.sum(a, b), 4);
	}

	@Test(groups = { "Positive" }, description = "Positive case 2")
	public void testMultiplication() {
		System.out.println("Multiplication is " + calculator.mult(number1, number2));
		Assert.assertEquals(calculator.mult(number1, number2), 75);
	}

	@Test(groups = { "Positive" }, description = "Positive case 3")
	public void testDivision() {
		Assert.assertEquals(calculator.div(number3, 2), 2);
	}

	@Test(groups = { "Positive" }, description = "Positive case 4")
	public void testPositiveFunction() {
		System.out.println("A is positive " + calculator.isPositive(number1));
		Assert.assertTrue(calculator.isPositive(number1));
	}

	@Test(groups = { "Positive" }, description = "Positive case 5")
	public void testGetClass() {
		System.out.println("Class is " + calculator.getClass());
		Assert.assertTrue(calculator.getClass().toString().contains("Calculator"));
	}

	@Test(groups = { "Negative" }, description = "Negative case 1")
	public void testSquareRoot() {
		System.out.println("Square root is is " + calculator.sqrt(number1));
		Assert.assertNotEquals(calculator.sqrt(number1), 5);
	}

	@Test(groups = { "Negative" }, description = "Negative case 2")
	public void testPowerFunction() {
		System.out.println("Power is " + calculator.pow(number1, number2));
		Assert.assertNotEquals(calculator.pow(number1, number2), 15625);
	}

	@Test(groups = { "Negative" }, description = "Negative case 3")
	public void testNegativeFunction() {
		System.out.println("A is negative " + calculator.isNegative(number1));
		Assert.assertFalse(calculator.isNegative(number1));
	}

	@Test(groups = { "Negative" }, description = "Negative case 4")
	public void testCosineFunction() {
		System.out.println("Cosine is " + calculator.cos(number3));
		Assert.assertNotEquals(calculator.cos(number3), 1);
	}

	@Test(groups = { "Negative" }, description = "Negative case 5", expectedExceptions = ArithmeticException.class)
	public void divisionWithException() {
		Assert.assertNotEquals(1 / 0, 1);
	}
}
