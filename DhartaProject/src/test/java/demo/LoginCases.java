package demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class LoginCases {
	
	String webUrl = "https://app.dharta.io/";
	Integer sleepTime = 2000;
	WebDriver driver = new ChromeDriver();
	
	@Test
	public void LoginIn() throws InterruptedException {	
		driver.get(webUrl);
		Thread.sleep(sleepTime);
		
		try {
	    	
	    	// Login check
	    	WebElement username=driver.findElement(By.xpath("//input[@id='email']"));
	        username.sendKeys("admin@ocular.nz");
	        WebElement password=driver.findElement(By.id("password"));
	        password.sendKeys("tqnlrnz67");
	        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
	        login.click();
	        
	        Thread.sleep(sleepTime);
	       // WebElement dharta = driver.findElement(By.xpath("//div[@class='flex']"));
	        //highLighterMethod(driver,dharta);
	        driver.manage().window().maximize();
	        
	        String expectedUrl= driver.getCurrentUrl();
	        Assert.assertEquals(expectedUrl,webUrl);
	        
	        System.out.println("Login Successfull");
	
	    } catch (Exception e) {
	    	
	    }
		
		driver.close();
					    
	}
	
	@Test
	public void LoginOut() throws InterruptedException {
		driver.get(webUrl);
		Thread.sleep(sleepTime);
		
		try {
	    	
			// Login check
	    	WebElement username=driver.findElement(By.xpath("//input[@id='email']"));
	        username.sendKeys("admin@ocular.nz");
	        WebElement password=driver.findElement(By.id("password"));
	        password.sendKeys("tqnlrnz67");
	        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
	        login.click();
	        Thread.sleep(2000);
	        
	        // Logout check
	        WebElement adminuser=driver.findElement(By.xpath("/html/body/div/div[2]/nav/div[1]/div/div[2]/div/div/div[1]/button"));
	        Thread.sleep(2000);
	        adminuser.click();
	        WebElement logout=driver.findElement(By.xpath("//button[@type='submit']"));
	        logout.click();
	    	System.out.println("Logout Successfull");
	    	
	    } catch (Exception e) {
	    	
	    }
		
	    driver.close(); 
	    
	}

	//	private void highLighterMethod(WebDriver driver, WebElement dharta) {
			// TODO Auto-generated method stub
			
	//	}
	}

