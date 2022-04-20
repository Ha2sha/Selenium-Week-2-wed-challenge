package testsuit;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //find username element & send values
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("Harsha11");

        //find password element & send values
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("harsha@2");

        //find login button & click on it
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        //requirement
        String expectedText = "Accounts Overview";

        //find actualText element & get text
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text(),'Accounts Overview')]"));
        String actualText = actualTextElement.getText();

        //validating expected & actual texts
        Assert.assertEquals("SignIn Successfully", expectedText, actualText);
    }

    @Test
    public void verifyTheErrorMessage() {
        //find username element & send values
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("___");

        //find password element & send values
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("___");

        //find login button & click on it
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        //requirement
        String expectedText = "The username and password could not be verified";

        //find actualText element & get text
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text(),'Accounts Overview')]"));
        String actualText = actualTextElement.getText();

        //validating expected & actual texts
        Assert.assertEquals("Invalid Username & Password", expectedText, actualText);
    }

    @Test
    public void userShouldLogOutSuccessfully(){
        //find username element & send values
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("Harsha11");

        //find password element & send values
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("harsha@2");

        //find login button & click on it
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        //find Logout element & click on it
        WebElement logoutButton = driver.findElement(By.linkText("Log Out"));
        logoutButton.click();

        //this is from requirement
        String expectedText="Customer Login";

        //find Customerlogin element & get text
        WebElement customerLoginElement=driver.findElement(By.xpath("//h2[contains(text(),'Customer Login')]"));
        String actualText=customerLoginElement.getText();

        //validating expected & actual text
        Assert.assertEquals("Logout Successfully",expectedText,actualText);

    }

    @After
    public void teraDown() {
        //closeBrowser();
    }
}
