package demo;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.Assert;

import com.google.common.io.Files;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class LoginFunctionality extends DhartaMethods{
	 DhartaMethods dhartaMethods=new DhartaMethods();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
  
		 WebDriver driver = new ChromeDriver();

		    driver.get("https://app.dharta.io/");
		    Thread.sleep(2000);
		    
		    System.out.println("hamsa");
		    WebElement username=driver.findElement(By.xpath("//input[@id='email']"));
	        username.sendKeys("admin@ocular.nz");
	        WebElement password=driver.findElement(By.id("password"));
	       
	        password.sendKeys("tqnlrnz67");
	        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
	        login.click();
	        Thread.sleep(2000);
	        WebElement dharta = driver.findElement(By.xpath("//div[@class='flex']"));
	        highLighterMethod(driver,dharta);
	        driver.manage().window().maximize();
	        String actualUrl="https://app.dharta.io/";
	        String expectedUrl= driver.getCurrentUrl();
	        Assert.assertEquals(expectedUrl,actualUrl);
	        Thread.sleep(2000);
	        WebElement sideToggle = driver.findElement(By.xpath("//*[@id=\"sidebar-toggle\"]"));
	        sideToggle.click();
	        Thread.sleep(2000);
	        WebElement reports = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/div[2]/div[2]/div[1]/button/span"));
	        reports.click();
	        Thread.sleep(2000);
	        WebElement adminuser=driver.findElement(By.xpath("/html/body/div/div[2]/nav/div[1]/div/div[2]/div/div/div[1]/button"));
	        Thread.sleep(2000);
	        adminuser.click();
	        WebElement logout=driver.findElement(By.xpath("//button[@type='submit']"));
	        logout.click();
	        //dhartaMethods.reports();
	    	System.out.println("Login-logout Successfull");
	    	driver.quit();
	}

	
	public static void TakesScreenshot(WebDriver driver) throws IOException {
		// TODO Auto-generated method stub
		Object Screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(((ru.yandex.qatools.ashot.Screenshot) Screenshot).getImage(), "png", new File("C:\\\\Users\\\\Hamsa\\\\eclipse-workspace\\\\DhartaProject\\\\screenshots.png"));
			}


	public static void highLighterMethod(WebDriver driver, WebElement dharta){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', ' border: 2px solid red;');", dharta);
	}
	
	
	
}
