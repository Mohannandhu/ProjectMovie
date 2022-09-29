package org.movie;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	
	public static JavascriptExecutor r ;
	public static void launchChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}

	public static void getUrl(String url) {
		driver.get(url);

	}
	
	public static void browserQuit() {
		driver.quit();

	}

	public static void winMax() {
		driver.manage().window().maximize();

	}
	
	public static void moveapageUpDown( boolean exe,WebElement exe1 ) {
		r = (JavascriptExecutor) driver;
	r.executeScript("arguments[0].scrollIntoView"+(exe), exe1);

	}
	public static void printText(WebElement exe) {
		String text = exe.getText();
		System.out.println(text);

		}
	public static void navigateNextUrl(String s) {
		driver.navigate().to(s);

	}
	public static void implicityWait(int value) {
		driver.manage().timeouts().implicitlyWait(value, TimeUnit.SECONDS);
	

	}

}
