import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pagesLevelSet.HomePage;
import pagesLevelSet.DocumentPage;

public class TestCase2 {
    WebDriver driver;
    HomePage homePage;
    DocumentPage documentPage;

    @BeforeTest
    public void beforeTest(){
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        documentPage = new DocumentPage(driver);
    }
    @Test
    public void TestLevelSet(){

        homePage.NavigateToHomePage();
        homePage.ClickOnGetPaid();
        Assert.assertEquals(documentPage.getPriceOf("File a Lien"),"$449","The Price is not as the expected");
        Assert.assertEquals(documentPage.getPriceOf("Release a Lien"),"$149","The Price is not as the expected");
        Assert.assertEquals(documentPage.getPriceOf("Exchange a Waiver"),"Free","The Price is not as the expected");

    }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}