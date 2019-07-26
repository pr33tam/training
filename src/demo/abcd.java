package demo;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;



public class abcd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");
		
		Properties p = new Properties();
		
		try {
			p.load(new FileInputStream("./new.properties"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ChromeOptions options = new ChromeOptions();  
		options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
		WebDriver driver = new ChromeDriver(options);
		driver.get(p.getProperty("URL"));
		System.out.println("Opening URL:" + driver.getTitle());
		int count = 0;
		while (count++ != 50) {
			
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[4]/form/button")));
			
			
			WebElement usernameField = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/form/div[2]/div[2]/input"));
			usernameField.sendKeys(p.getProperty("username"));
			
			WebElement passwordField = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/form/div[3]/div[2]/input"));
			passwordField.sendKeys(p.getProperty("password"));
			
			WebElement button = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/form/button"));
			button.click();
			
			System.out.println("Loggging in.. " + driver.getTitle());
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			wait.until(ExpectedConditions.elementToBeClickable(By.className("logout-button")));
			
			WebElement logoutButton = driver.findElement(By.className("logout-button"));
			logoutButton.click();
			System.out.println("Logging Out..");
			
			
			
			}
		driver.close();
		System.out.println("DONE WITH INCREASING");
	}

}

