import com.sun.org.apache.xpath.internal.operations.Gte;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class ProjectTest {
    public WebDriver wDriver;
    public String gText;
    public String tURL = "http://www.google.com";

    @BeforeMethod
    public void setTest(){
        System.setProperty("webdriver.chrome.driver", "C:/drivers2/chromedriver.exe");
        wDriver = new ChromeDriver();
        wDriver.navigate().to(tURL);
        wDriver.manage().window().maximize();
    }

    void setPageMethod(String Text){
        WebElement search = wDriver.findElement(By.name("q"));
        search.sendKeys(Text);
        search.submit();
    }

    @Test
    public void firstTest() throws InterruptedException{
        setPageMethod("IMDb");
        WebElement tLink = wDriver.findElement(By.xpath("/html//div[@id='rso']/div[1]/div[@class='g']//a[@href='https://www.imdb.com/']/h3[@class='LC20lb']"));
        gText = tLink.getText();
        Thread.sleep(2000);
        Assert.assertEquals(gText, "IMDb: Ratings, Reviews, and Where to Watch the Best Movies ...");
        System.out.println("Best website for getting info about movies is: " + gText);
    }

    @AfterMethod
    public void closeTest(){
        wDriver.quit();
    }
}

