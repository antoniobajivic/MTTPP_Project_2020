import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class ProjectTest3 {
    public WebDriver wDriver;
    public String tURL = "http://www.google.com";
    public String testURL;

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
    void setWEandClick(String XPATH){
        WebElement newElement = wDriver.findElement(By.xpath(XPATH));
        newElement.click();
    }

    @Test
    public void thirdTest() throws InterruptedException{
        setPageMethod("IMDb");
        String tURL = "https://www.imdb.com/";
        wDriver.navigate().to(tURL);
        wDriver.navigate().back();
        wDriver.navigate().back();
        WebElement searchBox = wDriver.findElement(By.name("q"));
        searchBox.clear();
        setPageMethod("Internet Movie Database");
        setWEandClick("/html//div[@id='rso']/div[1]/div[@class='g']//a[@href='https://www.imdb.com/']/h3[@class='LC20lb']");
        testURL = wDriver.getCurrentUrl();
        Thread.sleep(3000);
        Assert.assertEquals(testURL, tURL);
        System.out.print("\nURL test: " + testURL);
    }

    @AfterMethod
    public void closeTest(){
        wDriver.quit();
    }
}