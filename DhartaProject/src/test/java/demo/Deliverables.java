package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Deliverables {

	 private WebDriver driver;
	 
	 public static void CheckBox(WebDriver driver, String value) {
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
	 
	 public class ProjectSelection {

		    // Method to find the h1 element based on the provided header text
		    public WebElement getHeaderByName(WebDriver driver, String headerText) {
		        // Construct the XPath dynamically using the provided header text
		        String xpath = "//h1[normalize-space()='" + headerText + "']";
		        // Find the element using the constructed XPath
		        WebElement headerElement = driver.findElement(By.xpath(xpath));
		        return headerElement;
		    }
	}
	 
	 public void scrollToElement() {
	        try {
	            WebElement element = waitForElementVisible(By.xpath("//main[@class='w-full overflow-auto']"));
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("arguments[0].scrollIntoView(true);", element);
	        } catch (Exception e) {
	            System.out.println("Error scrolling to element: " + e.getMessage());
	        }
	    }

	private WebElement waitForElementVisible(By locator) {
		// TODO Auto-generated method stub
		return null;
		
		
	}
}


