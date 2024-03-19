package pagesLevelSet;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DocumentPage {
    WebDriver driver;
    String price = null;
    int index=0;
    public DocumentPage(WebDriver driver){this.driver=driver;}
    public String getPriceOf(String documentName){
        do {
            try {
                price= new WebDriverWait(driver, Duration.ofSeconds(10))
                        .until(ExpectedConditions.visibilityOfElementLocated(pathPriceOf(documentName))).getText();
                break;
            } catch (TimeoutException e) {
                driver.navigate().refresh();
                index ++;
            }
        }while (index<3);
        return price;
    }
    public By pathPriceOf(String item){
        String genericXpath = "//div[ normalize-space()='%s']/following-sibling::div/span[@class='price-amount']";
        String finalXpath = String.format(genericXpath,item);
        return By.xpath(finalXpath);
    }
}