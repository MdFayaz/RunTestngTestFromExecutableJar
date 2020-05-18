package fayaz.google.searchtest;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GoogleSearch {

	WebDriver driver;

	@Test
	public void launchBrowser() {
//		String PWD = System.getProperty("user.dir");
		String evn_var_chrome_driver_path = System.getenv("chrome_driver_path");
		System.setProperty("webdriver.chrome.driver", evn_var_chrome_driver_path + "\\chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("Selenium monk");
	}

	/*
	 * @Test public void searchText() { WebElement search =
	 * driver.findElement(By.name("q")); search.sendKeys("Selenium monk");
	 * driver.findElement(By.id("tophf")).click(); WebElement searchButton =
	 * driver.findElement(By.name("btnK")); searchButton.click(); customWait(15); }
	 */
	private void customWait(int sec) {
		try {
			Thread.sleep(1000 * sec);
		} catch (InterruptedException ie) {

		}

	}

	@Test
	public void tearDown() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}
}