package utilities;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ScrollToElement 
{
	AndroidDriver<MobileElement> driver;
	public void ScrollElement(AndroidDriver<MobileElement> driver)
	{
		this.driver = driver ;
	}
	public MobileElement scrollToExactElement(MobileElement ele,String str) 
	{
		return ((AndroidElement) ele)
				.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
						+ "new UiSelector().text(\""+str+"\"));");

	}

	 public MobileElement ScrollToElement(MobileElement ele, String str) 
	 {
		 return ((AndroidElement) ele)
			.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
					+ "new UiSelector().textContains(\""+str+"\"));");
		 
	}
	 public void ScrollStepWise(MobileElement ele, int step) 
	 {
		 ((AndroidElement) ele)
			.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollForward("+step+"))");
	}

}


