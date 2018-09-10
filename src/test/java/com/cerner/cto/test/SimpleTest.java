package com.cerner.cto.test;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cerner.TargetBrowser;

public class SimpleTest {
	@Test
	public void test1() throws Exception {

		TargetBrowser browser = new TargetBrowser();
		
		String accessibility = System.getenv("ACCESSIBILITY");
		//System.out.println(accessibility);
		String browse = "CHROME";
		String exeLocation = "C:\\AxeProjectImpl(03082017)\\browser\\chromedriver.exe";

		WebDriver webDriver = browser.toUse(TargetBrowser.BROWSER.valueOf(browse),accessibility)
				.webDriverWithExeAt(exeLocation);
		
        webDriver.get("https://localhost:3005");
        Thread.sleep(5000);
        webDriver.findElement(By.xpath("//*[@id='holder']/div[2]/form/div[2]/input")).clear();
        webDriver.findElement(By.xpath("//*[@id='holder']/div[2]/form/div[2]/input")).sendKeys("C15602");
        webDriver.findElement(By.xpath("//*[@id='holder']/div[2]/form/div[3]/input")).clear();
        webDriver.findElement(By.xpath("//*[@id='holder']/div[2]/form/div[3]/input")).sendKeys("Usha6@910");
        Thread.sleep(5000);
        webDriver.findElement(By.xpath("//*[@id='holder']/div[2]/form/button")).submit();
        Thread.sleep(5000);
        webDriver.findElement(By.xpath("//*[@id='menu']/li[5]/button")).click();
        Thread.sleep(5000);
              
	}
}
