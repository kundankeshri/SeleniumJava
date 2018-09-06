package cerner;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class A11YCapableWebDriverEventListener extends AbstractWebDriverEventListener {

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigating to: '" + url + "'");
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("After navigating to: '" + url + "'");
		testAccessibility(url,driver);
	}

	public void testAccessibility(String url, WebDriver driver) {
		
	 try{
		URL callBackURL = this.getClass().getResource(("/resource/axeA11y.js"));
		URL scriptURL1  = this.getClass().getResource(("/resource/axe.min.js"));
		//URL callBackURL = this.getClass().getResource(("/resource/discernabu.js"));
	
		
		/*AXE.inject(driver, scriptURL1); 
		AXE.inject(driver, callBackURL); */
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		/*JSONObject responseJSON=	new AXE.Builder(driver,scriptURL1).analyze();

		JSONArray violations = responseJSON.getJSONArray("violations");

		if (violations.length() == 0) {
			//assertTrue("No violations found", true);
			System.out.println("No Violations");
		} else {
			AXE.writeResults("C:/A11YProject/A11YAutoEvaluator/logs/page", responseJSON);
			System.out.println("Violations:responseJSON");
			//assertTrue(AXE.report(violations), false);
		}*/
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		//System.out.println("Value of the:" + element.toString()
			//	+ " before any changes made");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		//System.out.println("Element value changed to: " + element.toString());
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		//System.out.println("Trying to click on: " + element.toString());
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		//System.out.println("Clicked on: " + element.toString());
	}

	public void beforeNavigateBack(WebDriver driver) {
		//System.out.println("Navigating back to previous page");
	}

	public void afterNavigateBack(WebDriver driver) {
		//System.out.println("Navigated back to previous page");
	}

	public void beforeNavigateForward(WebDriver driver) {
		//System.out.println("Navigating forward to next page");
	}

	public void afterNavigateForward(WebDriver driver) {
		//System.out.println("Navigated forward to next page");
	}

	public void onException(Throwable error, WebDriver driver) {
		//System.out.println("Exception occured: " + error);
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		//System.out.println("Trying to find Element By : " + by.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		//System.out.println("Found Element By : " + by.toString());
	}

	/*
	 * non overridden methods of WebListener class
	 */
	public void beforeScript(String script, WebDriver driver) {
		//System.out.println("beforeScript : " + script.toString());
	}

	public void afterScript(String script, WebDriver driver) {
		//System.out.println("beforeScript : " + script.toString());
	}
	
 }

