package ApiDemo;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeTest;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

import java.io.IOException;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import io.appium.java_client.android.AndroidElement;
import utilities.ScreenShots;
import utilities.ScrollElement;


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
  public void tapOnMethod() throws IOException 
  {
		ScreenShots ss = new ScreenShots((AndroidDriver<MobileElement>) driver);
		driver.findElementByAccessibilityId("Views").click();
	/*	MobileElement view=driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"])"));
        TouchAction act =new TouchAction(driver);
        act.tap(view);
        act.moveTo(x, y)*/
		wait = new WebDriverWait(driver,50);
		ss.takeScreenShots("ViewsPage");
		

		
		
  }
	@Test(priority=1)
	public void scrollToElement() throws InterruptedException, IOException
	{
		ScreenShots ss = new ScreenShots((AndroidDriver<MobileElement>) driver);
		ScrollElement se = new ScrollElement((AndroidDriver<MobileElement>) driver);
		

		MobileElement viewsList = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView" + 	""));			
		String searchText = "Seek Bar";
		
		MobileElement trgt = se.ScrollToElement(viewsList, searchText);	
					
					  ss.takeScreenShots("Views Scroll");
					  trgt.click();
					  Thread.sleep(2000);
				  
	}
	
	@Test(priority=2)
	public void seekBarMove() throws InterruptedException, NullPointerException, IOException
	{	
		ScreenShots ss = new ScreenShots((AndroidDriver<MobileElement>) driver);
		 /* ScrollElement se = new ScrollElement((AndroidDriver<MobileElement>) driver);
	
	    MobileElement viewsList = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView" + 	""));			
	    String searchContact = "Seek Bar";
	
	     MobileElement trgtcontact = se.ScrollToElement(viewsList, searchContact);	
				
				  ss.takeScreenShots("Views Scroll");
				  trgtcontact.click();
				  Thread.sleep(2000);*/
		(new TouchAction(driver)).tap(36, 174).perform();
		ss.takeScreenShots("SeekBar Before");
		Thread.sleep(1000);
		(new TouchAction(driver)).tap(670, 174).perform();
		ss.takeScreenShots("SeekBar After");
		driver.navigate().back();
		Thread.sleep(1000);
	/*	try
		{
				MobileElement seekbar = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.SeekBar"));;

						  int startX = seekbar.getLocation().getX();
						  int startY = seekbar.getLocation().getY();
						  int endX = (startX+seekbar.getSize().getWidth());
//						  int end50X = (int) (startX+((seekbar.getSize().getWidth())*0.51));

						  
					    TouchAction action = new TouchAction(driver);						  			 
						 action.longPress(startX, startY).moveTo(endX, startY).release().perform();						  				  			  		 
			

				}	
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
		}*/
	}
	@Test(priority=3)
	public void hortizonalSwipe() throws IOException, InterruptedException
	{
		ScreenShots ss = new ScreenShots((AndroidDriver<MobileElement>) driver);
        ScrollElement se = new ScrollElement((AndroidDriver<MobileElement>) driver);
		MobileElement viewsList = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView" + 	""));			
		String searchText = "Tabs";
		
		MobileElement trgt = se.ScrollToElement(viewsList, searchText);					                         
		ss.takeScreenShots("Tabs");
		trgt.click();
	    Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"5. Scrollable\"]").click();/* xpath ://android.widget.TextView[@content-desc="5. Scrollable"]*/
        ss.takeScreenShots("Scrollable");
        boolean tabisPresent =false;
		for(int i =1;i<=10;i++)
		{
			try {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				tabisPresent = driver.findElementByXPath("//*[@text='TAB 24']").isDisplayed();
				tabisPresent = true;
				break;
			} catch (Exception e) {
				Dimension dim = driver.manage().window().getSize();
				int height = dim.getHeight();
				int width = dim.getWidth();
				int y = (int)(height*0.20);
				int startx = (int)(width*0.75);
				int endx = (int)(width*0.35);
				driver.swipe(startx, y, endx, y, 500);;
			}
		}
		ss.takeScreenShots("TAB_24");
		driver.navigate().back();

		wait = new WebDriverWait(driver,50);
		driver.navigate().back();
	}
	@Test(priority=4)
	  public void multiTouch() throws IOException, InterruptedException 
	  {
		ScreenShots ss = new ScreenShots((AndroidDriver<MobileElement>) driver);
		
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Splitting Touches across Views\"]").click();
		Thread.sleep(2000);
		TouchAction actionOne = new TouchAction(driver);
		actionOne.press(157, 925);
		actionOne.moveTo(163, -520);
		

		TouchAction actionTwo = new TouchAction(driver);
		actionTwo.press(543, 1027);
		actionTwo.moveTo(43, -520);
	
		
		ss.takeScreenShots("BeforeMulTiTouch");
		MultiTouchAction action = new MultiTouchAction(driver);
		action.add(actionOne);
		Thread.sleep(2000);
		action.add(actionTwo);
		action.perform();
		ss.takeScreenShots("AfterMultiTouch");
		Thread.sleep(2000);			
	  }

  @AfterTest
  public void afterTest() 
  {
	  driver.quit();
  }

}
