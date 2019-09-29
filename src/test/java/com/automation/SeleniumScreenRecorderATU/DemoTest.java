package com.automation.SeleniumScreenRecorderATU;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.IInvokedMethod;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import atu.testrecorder.exceptions.ATUTestRecorderException;

public class DemoTest {

	WebDriver driver;
	DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-MM-SS");
	Date date = new Date();
	String path = "TestVideo/";
	AUTestRecorderClass recorder;
	//ListenersClass listeners = new ListenersClass();
	

	@BeforeClass
	public void setUp()  {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Driver/chromedriver.exe");
		driver = new ChromeDriver();
		AUTestRecorderClass.deleteOldFile(path);
		//String methodName = DemoTest.class.getMethods()[0].getName()+ "-" + dateFormat.format(date);
		//String methodName = listeners.beforeInvoKation((IInvokedMethod) method.getTestMethod())+"_" + dateFormat.format(date);
		

	}
	@BeforeMethod
	public void beforeMethod(Method method)throws ATUTestRecorderException{
		String methodName = method.getName()+"_" + dateFormat.format(date);
		recorder = new AUTestRecorderClass(path,methodName, true);		
		recorder.start();
	}

	@Test
	public void navigationTest() throws Exception {		
		driver.get("https://www.google.com");
		driver.navigate().to("https://www.facebook.com");
		driver.navigate().back();
		driver.navigate().forward();
	}
	@Test
	public void navigationTest2() throws Exception {
		driver.get("https://www.facebook.com");
		driver.navigate().to("https://www.google.com");
		driver.navigate().back();
		driver.navigate().forward();
	}
	@AfterClass
	public void tearDown() {
		if (driver != null)
			driver.quit();
		driver = null;
		
	}
	@AfterMethod
	public void afterMethod() throws ATUTestRecorderException {
		recorder.stop();
	}

}
