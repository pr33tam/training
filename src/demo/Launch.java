package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Launch {

	public static void main(String[] args) {
		int i=50;
		
		while(i>0) {
		System.setProperty("webdriver.chrome.driver","./Software/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://imarticus.learntron.net/#!");
		driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/form/div[2]/div[2]/input")).sendKeys("Preetam Baranwal");
		driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/form/div[3]/div[2]/input")).sendKeys("123");
		driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/form/button")).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/button[2]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		i--;
//		
		}
		
	}

}
