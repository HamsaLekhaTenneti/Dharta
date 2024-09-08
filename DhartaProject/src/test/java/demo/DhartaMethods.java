package demo;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;


import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


public class DhartaMethods {

	
  
	 private static final String Active = null;
	static WebDriver driver;
    static boolean openBrowser(String browserName)
    {
    	boolean status;
    	switch(browserName.toUpperCase())
    	{
    	case"CHROME":
    		driver=new ChromeDriver();
    		status=true;
    		break;
    	default:
    		System.out.println("invalid browser given");
    		status=false;
    	}
    	return(status);
    	
    }
    
	static boolean openPage(String url) throws InterruptedException
	{
		String expTitle="dharta - Dharta";
		String actTitle;
		driver.get(url);
		 Thread.sleep(5000);
	    actTitle=driver.getTitle();
		if(actTitle.equals(expTitle))
		{
			System.out.println("Page is Opened");
			return(true);
		}
		else
		{
			System.out.println("Page is not opened");
			return(false);
		}
	}
     
	public static boolean login(String userName,String pwd) throws InterruptedException
	{
		driver.manage().window().maximize();
		 
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		WebElement dharta = driver.findElement(By.xpath("//div[@class='flex']"));
        highLighterMethod1(driver,dharta);
		try
		{
        	driver.findElement(By.xpath("/html/body/div/div[2]/nav/div[1]/div/div[2]/div/div/div[1]/button")).isDisplayed();
			System.out.println("Login success");
			return(true);
		}
 
		catch(Exception e)
		{
			System.out.println("Login not success");
			return(false);
         }
     }
	
	public void reports() throws Exception
	{
        driver.findElement(By.xpath("//*[@id=\"sidebar-toggle\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"sidebar\"]/div[2]/div[2]/div[1]/button/span")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'py-1 bg-white')]//a[contains(@class,'block px-4 py-2 text-sm leading-5 text-gray-700 hover:text-orange-500 transition hover:scale-105 whitespace-nowrap')][normalize-space()='Contracts']")));
        button.click();
        WebElement sideToggle = driver.findElement(By.xpath("//*[@id=\"sidebar-toggle\"]"));
        sideToggle.click();
        Thread.sleep(1000);
       /* driver.findElement(By.xpath("//a[@title='Testing']")).click();
        Thread.sleep(3000);
    	WebElement Active=driver.findElement(By.xpath("//span[text()='Active']"));
       	Active.click();
    	Thread.sleep(3000);*/
       }
		

	void contracts() {
		driver.findElement(By.xpath("//div/a[1][@ href=\"https://app.dharta.io/reports/contracts\"]")).click();
	}
	void payments() {
		driver.findElement(By.xpath("//div/a[@href='https://app.dharta.io/reports/payments']"));
	}
	void paymentDashboard() {
	WebElement Twelve_month=driver.findElement(By.id("12-months"));
	WebElement TwentyFour_month=driver.findElement(By.id("24-months"));
	WebElement ThirtySix_month=	driver.findElement(By.id("36-months"));
	WebElement Draft=driver.findElement(By.xpath("//input[@value='Draft']"));
	WebElement Active=driver.findElement(By.xpath("//input[@value='Active']"));
	WebElement In_Negotiation=driver.findElement(By.xpath("//input[@value='In Negotiation']"));
	WebElement Complete=driver.findElement(By.xpath("//input[@value='Complete']"));
		Select objSelect = new Select(driver.findElement(By.xpath("//select[@class='form-select input w-40']")));
		
	}
	
	void logout()
	{
		 driver.findElement(By.xpath("/html/body/div/div[2]/nav/div[1]/div/div[2]/div/div/div[1]/button")).click();
	     driver.findElement(By.xpath("//button[@type='submit']")).click();
	       
	}
	public static void highLighterMethod(WebDriver driver, WebElement dharta){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', ' border: 2px solid red;');", dharta);
	}
	void closeBrowser()
	{
		driver.quit();
		
	}
	
	void screenShots() throws Exception 
	{
		TakesScreenshot scrShot=((TakesScreenshot)driver);
		//take a screenshot and save into temp file scrFile varible

		File scrFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Create a destination file where we need screnshot

		File destFil=new File("C:\\Users\\Hamsa\\eclipse-workspace\\DhartaProject");
		//copy taken screenshot into destination file

		Files.copy(scrFile, destFil);
		driver.close();
	}
	
	   void payments1(String months,String ContractType,String status) throws Exception
	   {
		   

     	WebElement month_12=driver.findElement(By.xpath("//input[@id='12-months']"));
     	WebElement month_24=driver.findElement(By.xpath("//input[@id='24 months']"));
     	WebElement month_36=driver.findElement(By.xpath("//input[@id='36 months']"));		
        Select objSelect = new Select(driver.findElement(By.xpath("//select[@class='form-select input w-40']")));
       objSelect.selectByVisibleText("Outbound");
        objSelect.selectByVisibleText("Inbound");
        objSelect.selectByVisibleText("All");
      //  selectCheckboxByIndex(Active);
       	
       	
    	Thread.sleep(3000);
    
      
    	Thread.sleep(3000);
       }

	   
       static void highLighterMethod1(WebDriver driver, WebElement dharta){
   		JavascriptExecutor js = (JavascriptExecutor) driver;
   		js.executeScript("arguments[0].setAttribute('style', ' border: 2px solid red;');", dharta);
   	}
   	
   	
	public static void main(String[] args) throws Exception 
	{
		DhartaMethods login=new DhartaMethods();
		if(login.openBrowser("ChRoMe")==true) {
		
		}
		{
			
			if(login.openPage("https://app.dharta.io/"))
				if(login.login("admin@ocular.nz", "tqnlrnz67"))
					//login.highLighterMethod(driver,dharta);
							login.reports();
			login.screenShots();
			        
				{
					login.logout();
				}
			login.closeBrowser();		
		}
		System.out.println("hamsa");
	}
	
	
     

    public void extractAndSelectLink(String projectTitleToSelect) {
        // Find all the div elements containing links
        List<WebElement> linkContainers = driver.findElements(By.cssSelector("div.h-10.px-2.text-xs"));
        
        for (WebElement container : linkContainers) {
            // Find the link within the current container
            WebElement linkElement = container.findElement(By.cssSelector("a"));
            
            // Extract title and href attributes
            String title = linkElement.getAttribute("title");
            String url = linkElement.getAttribute("href");
            
            // Print the extracted data (optional)
            System.out.println("Title: " + title);
            System.out.println("URL: " + url);
            
            // Select the link if it matches the desired project title
            if (title.equalsIgnoreCase(projectTitleToSelect)) {
                System.out.println("Selecting link: " + title);
                linkElement.click(); // Click the link
                break; // Exit the loop once the desired link is clicked
            }
        }
    }
    
       
       public void reportsName(String reportName) {
 
   		
   		DhartaMethods reports = new DhartaMethods();
   		
   		if(reports.equals("Contracts")) {
   			
   			reports.contracts();
   			
   		}else if(reports.equals("Payments")) {
   			
   			reports.payments();
   			
   		}else if(reports.equals("Deliverables")) {
   			
   			reports.deliverables();
   			
   		}
       
   }

	private void deliverables() {
		// TODO Auto-generated method stub
		
	}
	
    public void selectDropdownOptions(WebDriver driver, String dropdownId, String optionValue) {
        // Locate the dropdown element by its ID
        WebElement dropdownElement = driver.findElement(By.xpath("//select[@class='form-select input w-40']"));

        // Create a Select object to interact with the dropdown
        Select dropdown = new Select(dropdownElement);

        // Select the option by its value
        dropdown.selectByValue(optionValue);
    }
    public static void selectRadioButtonByVisibleText(WebDriver driver, String visibleText) {
        try {
            // Locate the label containing the specified visible text
            WebElement label = driver.findElement(By.xpath("//label[span[text()='" + visibleText + "']]"));

            // Debugging: Print out the label's text and associated 'for' attribute
            System.out.println("Label found with text: " + label.getText());
            String forAttribute = label.getAttribute("for");
            System.out.println("Associated 'for' attribute value: " + forAttribute);

            // Ensure the 'for' attribute is correctly retrieved
            if (forAttribute == null || forAttribute.isEmpty()) {
                System.out.println("No 'for' attribute found on the label.");
                return;
            }

            // Find the associated radio button using the 'for' attribute
            WebElement radioButton = driver.findElement(By.id(forAttribute));

            // Check if the radio button is not already selected
            if (!radioButton.isSelected()) {
                // Click the radio button to select it
                radioButton.click();
                System.out.println("Radio button with ID '" + forAttribute + "' selected.");
            } else {
                System.out.println("Radio button with ID '" + forAttribute + "' is already selected.");
            }
        } catch (Exception e) {
            // Print stack trace for debugging
            e.printStackTrace();
        }
    }
    public static void selectCheckboxByValue(WebDriver driver, String value) {
        // Locate the checkbox input by its value attribute
        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox' and @value='" + value + "']"));

        // Check if the checkbox is not already selected
        if (!checkbox.isSelected()) {
            // Click the checkbox to select it
            checkbox.click();
            System.out.println("Checkbox with value '" + value + "' selected.");
        } else {
            System.out.println("Checkbox with value '" + value + "' is already selected.");
        }
    }
	   public static void selectRadioButtonByText(WebDriver driver, By radioLocator, String radioText) {
	        List<WebElement> radios = driver.findElements(radioLocator);
	        for (WebElement radio : radios) {
	            WebElement label = radio.findElement(By.xpath("following-sibling::label")); // Adjust XPath as needed
	            if (label.getText().equalsIgnoreCase(radioText) && !radio.isSelected()) {
	                radio.click();
	                System.out.println("Selected radio button: " + radioText);
	                return; // Exit after selecting the radio button
	            }
	        }
	        System.out.println("No radio button found with text: " + radioText);
	    }
	   
	   public void projects() {
		   List<WebElement> allLinks = driver.findElements(By.tagName("a"));
	   }
	   
	   public static void toggleCheckboxByValue(WebDriver driver, String value) {
	        // Locate the checkbox input by its value attribute
	        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox' and @value='" + value + "']"));

	        // Check if the checkbox is currently selected
	        if (checkbox.isSelected()) {
	            // If selected, click to deselect
	            checkbox.click();
	            System.out.println("Checkbox with value '" + value + "' has been deselected.");
	        } else {
	            // If not selected, click to select
	            checkbox.click();
	            System.out.println("Checkbox with value '" + value + "' has been selected.");
	        }
	    }
	   
	   public void interactWithProjectLinks(String status) {
	        // Locate the list of project items
	        List<WebElement> items = driver.findElements(By.xpath("//*[@id=\"main-body\"]/main/div/div[3]/div[1]"));

	        // Iterate through each item
	        for (WebElement item : items) {
	            try {
	                // Find the status element
	                WebElement statusElement = item.findElement(By.cssSelector("div.h-5.w-5"));
	                String statusText = statusElement.getAttribute("title");

	                // Check if the status matches the specified status
	                if (status.equals("All") || statusText.equalsIgnoreCase(status)) {
	                    // Find the link element
	                    WebElement link = item.findElement(By.cssSelector("a"));

	                    // Ensure the link is clickable
	                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	                    wait.until(ExpectedConditions.elementToBeClickable(link));

	                    // Print link details and click the link
	                    String linkText = link.getText();
	                    String linkHref = link.getAttribute("href");
	                    System.out.println("Clicking on: " + linkText + " (" + linkHref + ")");
	                    
	                    link.click();

	                    // Optionally, wait for a new page to load if required
	                    // For example, wait for a specific element on the new page
	                    // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("selector-for-new-page-element")));

	                    // Go back to the previous page if needed
	                    driver.navigate().back();

	                    // Re-locate the list of project items after navigating back
	                    items = driver.findElements(By.cssSelector("div.h-10.px-2.text-xs"));
	                }
	            } catch (Exception e) {
	                System.out.println("Error interacting with item: " + e.getMessage());
	            }
	        }
	    }
	   
	   public static void clickItemByTitle(WebDriver driver, String title) {
	        // Locate the item based on its title attribute
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		   WebElement item = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	                "//div[@class='h-10 px-2 text-xs odd:bg-white even:bg-slate-100 flex items-center max-w-48']" +
	                "[div[@title='All']]/following-sibling::div//a[@title='" + title + "']")));


	        // Click the link associated with the item
	        item.click();
	        System.out.println("Clicked on the item with title '" + title + "'.");
	    
	    }
	   
	   public static void selectCheckbox(WebDriver driver, String checkboxId) {
	        // Locate the checkbox using its ID
	        WebElement checkbox = driver.findElement(By.xpath("//select[@class='form-select input w-40']"));

	        // Check if the checkbox is not already selected
	        if (!checkbox.isSelected()) {
	            // Click the checkbox to select it
	            checkbox.click();
	        }
	          }
}


