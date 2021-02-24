package com.test;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandling {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("redmi smartphones", Keys.ENTER);
		
		String parendWindow = driver.getWindowHandle();
		Thread.sleep(2000);
		WebElement fe = driver.findElement(By.xpath("(//img[@alt='Redmi 9A (Nature Green, 2GB Ram, 32GB Storage) | 2GHz Octa-core Helio G25 Processor'])[1]"));
		fe.click();
		Set<String> childwindow = driver.getWindowHandles();
		
		for (String id1 : childwindow) {
			driver.switchTo().window(id1);
				
			}
			
		WebElement ab = driver.findElement(By.id("add-to-cart-button"));
		ab.click();
		driver.quit();
		
		
			
		}	
		
	
}

