package ApiDemo;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeTest;
import java.net.URL;
import java.util.NoSuchElementException;

import javax.swing.JOptionPane;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

import java.io.IOException;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import io.appium.java_client.android.AndroidElement;


public class ApiDemoTest {
  
	 AndroidDriver<MobileElement> driver;
     WebDriverWait wait;

     
     @BeforeTest
     public void beforeTest() throws MalformedURLException 
     {
         DesiredCapabilities caps = new DesiredCapabilities();
         caps.setCapability("deviceName", "Nexus 5X API P");
         caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
         caps.setCapability("platformName", "Android");
         caps.setCapability("platformVersion", "P");
         caps.setCapability("skipUnlock","true");
         caps.setCapability("appPackage", "io.appium.android.apis");
         caps.setCapability("appActivity","io.appium.android.apis.ApiDemos");
         caps.setCapability("noReset","true");
         driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),caps);
     }
	
	@Test(priority=0)
  public void Click() 
  {
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
		wait = new WebDriverWait(driver, 50);
  }
	
  @AfterTest
  public void afterTest() 
  {
	  //driver.quit();
  }

}
