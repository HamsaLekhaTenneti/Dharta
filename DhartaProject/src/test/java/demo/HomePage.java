package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

    static WebDriver driver;
    
    DhartaMethods Testcase = new DhartaMethods();

	private Object executeScript;
    public void openDropdown(By dropdownLocator) {
        WebElement dropdownElement = driver.findElement(dropdownLocator);
        dropdownElement.click();
    }
    
    public void selectProjectByText(By dropdownLocator, String projectName) {
        openDropdown(dropdownLocator);
        By projectOptionLocator = By.xpath("//a[contains(text(), '" + projectName + "')]");
        WebElement projectOption = driver.findElement(projectOptionLocator);
        projectOption.click();
    }
    
    public void organisationInfo() {
    	
    	WebElement organisation =driver.findElement(By.xpath("//a[text()='Organisation Info']"));
    	organisation.click();
    }
    
    public boolean tabSelected(String tabName) {
        By tabLocator = By.xpath("//ul[@class='tabs_header']//li[text()='" + tabName + "' and contains(@class, 'selected')]");
        WebElement tab = driver.findElement(tabLocator);
        return tab != null;
    }
    public void scrollDown() {
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	jse.executeScript("window.scrollBy(0,250)");
    }
    }
    

   

      

       
