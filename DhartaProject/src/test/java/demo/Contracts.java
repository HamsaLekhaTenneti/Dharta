package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Contracts {

	//public static boolean main(String[] args) {
		// TODO Auto-generated method stub

		//final String Active = null;
	//	WebDriver driver;
	  
		
		
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
	   public void selectDropdownOptions(WebDriver driver, String dropdownId, String optionValue) {
	        // Locate the dropdown element by its ID
	        WebElement dropdownElement = driver.findElement(By.xpath("//select[@class='form-select input w-40']"));

	        // Create a Select object to interact with the dropdown
	        Select dropdown = new Select(dropdownElement);

	        // Select the option by its value
	        dropdown.selectByValue(optionValue);
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
	   
}
