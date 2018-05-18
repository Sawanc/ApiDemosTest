package utilities;
	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
	import java.io.File;
	import java.io.IOException;

	import io.appium.java_client.MobileElement;
	import io.appium.java_client.android.AndroidDriver;

	public class ScreenShots 
	{
		AndroidDriver<MobileElement> driver;
		public ScreenShots(AndroidDriver<MobileElement> driver)
		{
			this.driver = driver;
		}
		public void ScreenShots1(AndroidDriver<MobileElement> driver2) {
			// TODO Auto-generated constructor stub
		}
		public void takeScreenShots(String ScreenName) throws IOException
		{
			File srcFile = driver.getScreenshotAs(OutputType.FILE);
			File targetFile = new File("C:\\Users\\Sawan Choubisa\\Desktop\\ScreenShots"+ScreenName+".png");
			FileUtils.copyFile(srcFile, targetFile);
			System.out.println("ScreenShot captured :"+targetFile);
		}
	}

