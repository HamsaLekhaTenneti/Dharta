package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class AutomatedTestcases extends DhartaMethods
{
   
   
public static void main(String[] args) throws Exception {
	   DhartaMethods Testcase = new DhartaMethods();

	   
	   

	// Login and logout
	   Testcase.openBrowser("Chrome");
	   Testcase.openPage("https://app.dharta.io/");
	  
	   Testcase.login("admin@ocular.nz", "tqnlrnz67");
	   Testcase.reports();
	   Thread.sleep(5000);
	   Testcase.selectRadioButtonByVisibleText(driver, "36 months");
	   System.out.println("Radio Button 24 months found: ");
	   Thread.sleep(5000);
	 Testcase.selectDropdownOptions(driver, "form-select", "All");
	   System.out.println("inbound ");
	   Thread.sleep(5000);
	 DhartaMethods.toggleCheckboxByValue(driver, "Complete");
	 Thread.sleep(5000);
	 Testcase.extractAndSelectLink( "Testing");
	 Thread.sleep(5000);
	  System.out.println("Active");
	   Thread.sleep(5000);
	   Testcase.logout();
       Testcase.closeBrowser();
      }

    



     
   

         
}


