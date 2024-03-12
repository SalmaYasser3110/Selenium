import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;

public class TestCase1 {
    //variables
    WebDriver driver = new ChromeDriver();
    String url ="https://www.saucedemo.com/";
    String username_value ="standard_user";
    String Password_value ="secret_sauce";
    String itemAddToCart1 ="Sauce Labs Bike Light";
    String itemAddToCart2 ="Sauce Labs Fleece Jacket";
    String items_block ="inventory_item";

    //selectors
    By username = By.id("user-name");
    By password = By.id("password");
    By login_button = By.id("login-button");
    By cart = By.className("shopping_cart_badge");


    @BeforeTest
    public void BeforeTest(){
        driver.get(url);
        driver.findElement(username).sendKeys(username_value);
        driver.findElement(password).sendKeys(Password_value);
        driver.findElement(login_button).click();
    }
    @Test
    public void Test1(){
        List<WebElement> items_exist= findList(items_block);
        Assert.assertEquals(items_exist.size(),6,"The number of items is not 6!");
    }
    @Test
    public void Test2(){

        addToCart(itemAddToCart1).click();
        addToCart(itemAddToCart2).click();

        driver.findElement(cart).click();
        Assert.assertTrue(itemAdded(itemAddToCart1).isDisplayed());
        Assert.assertTrue(itemAdded(itemAddToCart2).isDisplayed());

    }
    @AfterTest
    public void AfterTest(){
        driver.quit();
    }

    public WebElement addToCart(String search){
        String genericXpath = "//div[text()='%s']/../../following-sibling::div/button";
        String finalXpath = String.format(genericXpath,search);
        return driver.findElement(By.xpath(finalXpath));
    }
    public WebElement itemAdded(String search){
        String genericXpath = "//div[text()='%s']";
        String finalXpath = String.format(genericXpath,search);
        return driver.findElement(By.xpath(finalXpath));
    }
    public List<WebElement> findList(String search){
        String genericXpath = "//div[@class='%s']";
        String finalXpath = String.format(genericXpath,search);
        return driver.findElements(By.xpath(finalXpath));
    }
}
