package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        driver.findElement(By.linkText("Sign In")).click();
        String expectedMessage = "Welcome Back!";
        WebElement actualMessage = driver.findElement(By.xpath("//h2[@class='page__heading']"));
        String actualMessage1 = actualMessage.getText();
        //System.out.println(actualMessage1);
        Assert.assertEquals("Error Message is not Displayed", expectedMessage, actualMessage1);
    }
    @Test
    public void verifyTheErrorMessage(){
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.id("user[email]")).sendKeys("abcd@yahoo.com");
        driver.findElement(By.id("user[password]")).sendKeys("12345");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String expectedMessage = "Invalid email or password.";
        WebElement actualElement= driver.findElement(By.xpath("//li[@class='form-error__list-item']"));
        String actualMessage= actualElement.getText();
        System.out.println(actualMessage);
        Assert.assertEquals(actualMessage,expectedMessage);


    }

}