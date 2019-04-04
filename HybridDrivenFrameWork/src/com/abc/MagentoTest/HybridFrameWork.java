package com.abc.MagentoTest;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HybridFrameWork {

	public static void main(String[] args) throws InterruptedException, IOException
	{
		
		FileInputStream fis = new FileInputStream("Z:\\Selenium_components\\jan_batch\\HybridDrivenFrameWork\\src\\com\\abc\\Utilities\\hybrid.properties");
		//create a connection between property file and the test script
		Properties p = new Properties();
		//create the object of the property file
		p.load(fis);
		//pass the data present in the property file from fileInputStream(fis) to the test script
		
		String myacctloc = p.getProperty("myacct");
		//get the value of the key (given as a parameter) and store it in the local variable in the test script
		String emailloc = p.getProperty("email");
		String passwordloc = p.getProperty("password");
		String loginloc = p.getProperty("login");
		String logoutloc = p.getProperty("logout");
		
		String urldata = p.getProperty("urldata");
		String emaildata = p.getProperty("emaildata");
		String passdata = p.getProperty("passworddata");
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//writing this bcoz we don't want to use thread.sleep
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		driver.get(urldata);
		driver.findElement(By.xpath(myacctloc)).click();
		//initially we had used thread.sleep
		//Thread.sleep(5000);
		
		driver.findElement(By.xpath(emailloc)).sendKeys(emaildata);
		driver.findElement(By.xpath(passwordloc)).sendKeys(passdata);
		driver.findElement(By.xpath(loginloc)).click();
		//Thread.sleep(5000);
		System.out.print("till here only");
		driver.findElement(By.xpath(logoutloc)).click();
		driver.close();
	}
}
