import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class ProjectTest4 {
    public WebDriver wDriver;
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
    void setWEandClick(String XPATH){
        WebElement newElement = wDriver.findElement(By.xpath(XPATH));
        newElement.click();
    }

    @Test
    public void fourthTest() throws InterruptedException{
        String testTag;
        setPageMethod("IMDb");
        setWEandClick("/html//div[@id='rso']/div[1]/div[@class='g']//a[@href='https://www.imdb.com/']/h3[@class='LC20lb']");
        WebElement searchIMDb = wDriver.findElement(By.name("q"));
        searchIMDb.sendKeys("Robert Downey Jr.");
        searchIMDb.submit();
        WebElement testElement = wDriver.findElement(By.xpath("/html//div[@id='main']//span[@class='findSearchTerm']"));
        testTag = testElement.getTagName();
        Assert.assertEquals(testTag, "span");
        System.out.println("Tag name of search result is " + testTag);
    }

    @AfterMethod
    public void closeTest(){
        wDriver.quit();
    }
}
