package testsuit;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl="https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSigningUpPageDisplay(){

        //finding Register Link & clicking on it
        WebElement registerLink=driver.findElement(By.linkText("Register"));
        registerLink.click();

        //this is from requirement
        String expectedText="Signing up is easy!";

        //finding textMessage element & get text
        WebElement textMessage=driver.findElement(By.xpath("//h1[@class='title']"));
        String actualText=textMessage.getText();

        //validating actual & expected text
        Assert.assertEquals("Register link not working", expectedText, actualText);

    }
    @Test
    public void userShouldRegisterAccountSuccessfully(){

        //finding Register Link & clicking on it
        WebElement registerLink=driver.findElement(By.linkText("Register"));
        registerLink.click();

        //finding firstname element & sending values
        WebElement firstName=driver.findElement(By.id("customer.firstName"));
        firstName.sendKeys("Harsha");

        //finding lastName element & sending values
        WebElement lastName=driver.findElement(By.id("customer.lastName"));
        lastName.sendKeys("Patel");

        //finding Address element & sending values
        WebElement address=driver.findElement(By.id("customer.address.street"));
        address.sendKeys("101 E. Huntington Drive");

        //finding city element & sending values
        WebElement city=driver.findElement(By.id("customer.address.city"));
        city.sendKeys("USA");

        //finding state element & sending values
        WebElement state=driver.findElement(By.id("customer.address.state"));
        state.sendKeys("USA");

        //finding Zipcode element & sending values
        WebElement zip=driver.findElement(By.id("customer.address.zipCode"));
        zip.sendKeys("91016");

        //finding Phone number element & sending values
        WebElement phoneNumber=driver.findElement(By.id("customer.phoneNumber"));
        phoneNumber.sendKeys("91256897450");

        //finding SSN element & sending values
        WebElement ssn=driver.findElement(By.id("customer.ssn"));
        ssn.sendKeys("08785850");

        //finding UserName element & sending values
        WebElement userName=driver.findElement(By.id("customer.username"));
        userName.sendKeys("harsha11");

        //finding password element & sending values
        WebElement password=driver.findElement(By.id("customer.password"));
        password.sendKeys("harsha@2");

        //finding password element & sending values
        WebElement confirmPassword=driver.findElement(By.id("repeatedPassword"));
        confirmPassword.sendKeys("harsha@2");

        //finding password element & Click on it
        WebElement registerButton=driver.findElement(By.xpath("//input[@value='Register']"));
        registerButton.click();

        //This is from the requirement
        String expectedMsg="Your account was created successfully. You are now logged in.";

        WebElement actualMsgElement=driver.findElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"));
        String actualMsg=actualMsgElement.getText();

        //validating expected & actual message
        Assert.assertEquals("Registered Successfully.",expectedMsg,actualMsg);


    }

    @After
    public void teraDown(){

        //closeBrowser();
    }
}
