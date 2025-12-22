package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ytest {
	public static void main(String[] args) throws Throwable {
		
		//Changed Name
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Actions act = new Actions(driver);
		driver.get("https://www.youtube.com/");
		driver.findElement(By.name("search_query")).sendKeys("Monica song", Keys.ENTER);
		driver.findElement(By.xpath("//yt-formatted-string[contains(@aria-label,'Monica - Video Song')]")).click();	
		try {
			WebElement skip = driver.findElement(By.id("skip-button:2"));
			if (wait.until(ExpectedConditions.visibilityOf(skip)) != null) {
				skip.click();
			}
		} catch (Exception e) {
			System.out.println("No Skip Button");
		}
		try {
			driver.findElement(By.xpath("//button[@aria-label='No thanks']")).click();
		} catch (Exception e) {
			System.out.println("No No Tnx Button");
		}
		WebElement scrn = driver.findElement(By.id("player"));
		act.moveToElement(scrn).click();
		WebElement fullscrn = driver.findElement(By.xpath("//button[@data-title-no-tooltip='Full screen']"));
		wait.until(ExpectedConditions.visibilityOf(fullscrn));
		fullscrn.click();
		Thread.sleep(5000);
		act.moveToElement(scrn);
		Thread.sleep(1000);
		fullscrn.click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(1000);
		System.out.println("Played Monica Song Successfully");
		System.out.println("### JENKINS EXECUTION CONFIRMED ###");
		driver.quit();
	}
}
