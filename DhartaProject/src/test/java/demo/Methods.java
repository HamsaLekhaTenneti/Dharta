package demo;



import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

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

public class Methods {
    private WebDriver driver;
    private WebDriverWait wait;
    WebElement emailId = driver.findElement(By.id("email"));
    WebElement password = driver.findElement(By.id("password"));
    WebElement loginSubmit = driver.findElement(By.xpath("//button[@type='submit']"));
    WebElement dharta = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='flex']")));
    WebElement dhartMethod = driver.findElement(By.xpath("//div[@class='flex']")); // Update if incorrect
    WebElement sidebarToggle = driver.findElement(By.id("sidebar-toggle"));
    WebElement reportButton = driver.findElement(By.xpath("//button/span[text()='Reports']"));
    WebElement logoutButton = driver.findElement(By.xpath("//button[text()='Logout']"));
    WebElement confirmButton = driver.findElement(By.xpath("//button[@type='submit']"));
    public Methods() {
        // WebDriver initialization can be done in openBrowser method
    }

    // Initialize WebDriver
    public boolean openBrowser(String browserName) {
        if ("CHROME".equalsIgnoreCase(browserName)) {
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return true;
        } else {
            System.out.println("Invalid browser given");
            return false;
        }
    }

    // Open the page and check if title matches
    public boolean openPage(String url) {
        driver.manage().window().maximize();
        driver.get(url);
        try {
            wait.until(ExpectedConditions.titleIs("dharta - Dharta"));
            System.out.println("Page is Opened");
            return true;
        } catch (Exception e) {
            System.out.println("Page is not opened");
            return false;
        }
    }

    // Perform login
    public boolean login(String userName, String pwd) {
   

        emailId.sendKeys(userName);
        password.sendKeys(pwd);
        loginSubmit.click();

        try {
           
            if (dhartMethod.isDisplayed()) {
                System.out.println("Login success");
                return true;
            }
        } catch (Exception e) {
            System.out.println("Login not successful");
        }
        return false;
    }

    // Navigate to reports and interact with elements
    public void navigateToReports() {
        
        sidebarToggle.click();        
        reportButton.click();
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Testing']")));
        button.click();
        WebElement active = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Active']")));
        active.click();
    }

    // Click on specific report links
    public void clickOnReport(String reportName) {
        WebElement reportLink = driver.findElement(By.linkText(reportName));
        reportLink.click();
    }

    // Perform logout
    public void logout() {
      
        logoutButton.click();
        confirmButton.click();
    }

    // Highlight an element
    public void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
    }

    // Take a screenshot and save it to a specified location
    public void takeScreenshot(String filePath) throws IOException {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(filePath);
        Files.copy(scrFile, destFile);
    }

    // Close the browser
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Main method for executing the tests
    public static void main(String[] args) {
        Methods app = new Methods();

        if (app.openBrowser("CHROME")) {
            try {
                if (app.openPage("https://app.dharta.io/")) {
                    if (app.login("admin@ocular.nz", "tqnlrnz67")) {
                        app.navigateToReports();
                        app.takeScreenshot("screenshot.png");
                        app.logout();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                app.closeBrowser();
            }
        }

        System.out.println("Execution completed");
    }
    public void payments1() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click on sidebar toggle
        WebElement sidebarToggle = driver.findElement(By.id("sidebar-toggle"));
        sidebarToggle.click();

        // Click on the specific button within the sidebar
        WebElement reportsButton = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/div[2]/div[2]/div[1]/button/span"));
        reportsButton.click();

        // Wait for and click the payments link
        WebElement paymentsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sidebar\"]/div[2]/div[2]/div[3]/div/div/div[2]/a")));
        paymentsLink.click();

        // Click on sidebar toggle again to close it
        sidebarToggle.click();

        // Wait for the duration filter and click on '12-months'
        WebElement twelveMonthsFilter = wait.until(ExpectedConditions.elementToBeClickable(By.id("12-months")));
        twelveMonthsFilter.click();

        // Select "Outbound" from the dropdown
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@class='form-select input w-40']")));
        dropdown.selectByVisibleText("Outbound");

        // Wait for and click on the 'Testing' link
        WebElement testingLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Testing']")));
        testingLink.click();

        // Wait for and click on the 'Active' status
        WebElement activeStatus = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Active']")));
        activeStatus.click();
}

}



