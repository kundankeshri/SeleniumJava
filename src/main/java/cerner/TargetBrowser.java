package cerner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
public class TargetBrowser {
	public static enum BROWSER{FIREFOX,CHROME,IEXPLORER,SAFARI};
	private BROWSER chosen;
	private String checkAccessibility;
	protected EventFiringWebDriver eventFiringDriverForA11y;
	protected A11YCapableWebDriverEventListener a11yListerner;


	public TargetBrowser toUse(BROWSER browser , String accessibility){
		chosen = browser;
		System.out.println("accessibility"+accessibility);
		checkAccessibility = accessibility ;
		return this;
	}

	public WebDriver webDriverWithExeAt(String exeLocation){
		WebDriver driver = null;
		try {

			System.out.println("chosen"+chosen);
			System.out.println("checkAccessibility"+checkAccessibility);

			if (chosen == BROWSER.FIREFOX) {

				/*DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
				desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);*/
				FirefoxProfile fprofile = new FirefoxProfile();

				//fprofile.setPreference("browser.download.dir", ReportPath.getInstance().getReportPath());
				fprofile.setPreference("browser.download.folderList", 2);
				fprofile.setPreference("browser.helperApps.neverAsk.saveToDisk",
						"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;"+ "application/pdf;"
				+ "application/vnd.openxmlformats-officedocument.wordprocessingml.document;" + "text/plain;" + "text/csv");
				fprofile.setPreference( "browser.download.manager.showWhenStarting", false );
				fprofile.setPreference( "pdfjs.disabled", true );
				//driver = new FirefoxDriver(fprofile);
				driver = new FirefoxDriver();
			}

		   if(chosen == BROWSER.CHROME && checkAccessibility == "ACCESSIBILITY"){
				 System.out.println("InsideChosen1"+chosen);
				System.setProperty("webdriver.chrome.driver",exeLocation);
				ChromeOptions options = new ChromeOptions();
				options.addArguments("load-extension=C:/KeshriKundanAccess/extension/a11yChromeExtn");
				options.addArguments("--start-maximized");
				DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
				desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
				driver=new ChromeDriver(desiredCapabilities);
			}else {
				 System.out.println("InsideChosen2"+chosen);
				System.setProperty("webdriver.chrome.driver",exeLocation);
				ChromeOptions options = new ChromeOptions();
				//options.addArguments("load-extension=C:/KeshriKundanAccess/extension/a11yChromeExtn");
				options.addArguments("--start-maximized");
				DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
				desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
				driver=new ChromeDriver(desiredCapabilities);
			}
			if(chosen == BROWSER.IEXPLORER){
				System.setProperty("webdriver.ie.driver",exeLocation);
				DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
				/*ieCapabilities.setCapability("nativeEvents", false);
				ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
				ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
				ieCapabilities.setCapability("disable-popup-blocking", true);
				ieCapabilities.setCapability("enablePersistentHover", true);
				ieCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				ieCapabilities.setCapability("start-maximized", true);*/
				ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
				ieCapabilities.setCapability("ignoreZoomSetting", true);

				driver = new InternetExplorerDriver(ieCapabilities);
				driver.manage().window().maximize();
			}
			if(chosen == BROWSER.SAFARI){

				SafariOptions safariOptions = new SafariOptions();
				safariOptions.setUseCleanSession(true);
				driver=new SafariDriver(safariOptions);

			}
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
			eventFiringDriverForA11y = new EventFiringWebDriver(driver);
			a11yListerner = new A11YCapableWebDriverEventListener();
			eventFiringDriverForA11y.register(a11yListerner);


		} catch (Exception exception) {
			//TBD Logger
			//report.reportException("getDriver", new RuntimeException(exception.getMessage()));
		}
		return eventFiringDriverForA11y;


	}


}
