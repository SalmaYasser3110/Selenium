package pagesLevelSet;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class HomePage {
    String url="https://www.levelset.com/";
    By getPaid = By.xpath("//a[text()=\"Get paid \"]");
    WebDriver driver;
    public HomePage(WebDriver driver){this.driver=driver;}
    public void NavigateToHomePage(){
        driver.get(url);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("home-head-row-1")));
    }
    public void ClickOnGetPaid(){
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(getPaid)).click();
            driver.findElement(getPaid).click();
        }
        catch (TimeoutException e){
            driver.navigate().refresh();
        }
    }
}
