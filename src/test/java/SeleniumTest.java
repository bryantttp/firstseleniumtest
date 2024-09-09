import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumTest {
    // Interface. Control browser and help find elements
    WebDriver driver;

    // Like a set-up code
    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    // Helps clean up our test and operates like a post-condition
    @AfterClass
    public void tearDown(){
        // Closes every window and quits driver
        driver.quit();
        // driver.close(); this only closes the window
    }

    @Test
    public void testLoggingIntoApplication() throws InterruptedException{
        Thread.sleep(2000);
        // WebElement is an interface that represents the HTML element
        // 'By' class used to locate elements
        WebElement username = driver.findElement(By.name("username")); // Element with property name of username
        // Sends info to the element
        username.sendKeys("Admin");

        var password = driver.findElement(By.name("password")); // var is a java keyword that infers data type based on the method
        password.sendKeys("admin123");

        // button has no element/name to it and since its the only button class, we can use this tag
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(2000); // Selenium has many ways to 'sleep' a task, this is not used usually
        String actualResult = driver.findElement(By.tagName("h6")).getText();
        String expectedResult = "Dashboard";

        Assert.assertEquals(actualResult,expectedResult);
    }

}
