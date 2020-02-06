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

public class ProjectTest2 {
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
    public void secondTest() throws InterruptedException{
        String gRating, newRating, finalLocation;
        int index, index2;
        setPageMethod("IMDb");
        setWEandClick("/html//div[@id='rso']/div[1]/div[@class='g']//a[@href='https://www.imdb.com/']/h3[@class='LC20lb']");
        wDriver.navigate().to("https://www.imdb.com/chart/top/?ref_=nv_mv_250");
        WebElement getRating = wDriver.findElement(By.xpath("/html//div[@id='main']/div[@class='article']//div[@class='seen-collection']//table[@class='chart full-width']//th[.='IMDb Rating']"));
        gRating = getRating.getLocation().toString();
        index = gRating.indexOf(")");
        newRating = gRating.split("\\(", index-1)[1];
        index2 = gRating.indexOf(")");
        finalLocation = newRating.split("\\)", index2)[0];
        System.out.println("Location of IMDb rating section begins on: " + finalLocation);
        Assert.assertEquals(finalLocation, "630, 206");
    }

    @AfterMethod
    public void closeTest(){
        wDriver.quit();
    }
}