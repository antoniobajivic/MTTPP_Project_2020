import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class ProjectTest5 {
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
    public void fifthTest() throws InterruptedException{
        setPageMethod("IMDb");
        setWEandClick("/html//div[@id='rso']/div[1]/div[@class='g']//a[@href='https://www.imdb.com/']/h3[@class='LC20lb']");
        WebElement testSize = wDriver.findElement(By.xpath("/html//a[@id='home_img_holder']"));
        String tSize = testSize.getSize().toString();
        System.out.println("IMDb icon has test size: " + tSize);
        Thread.sleep(2000);
        wDriver.navigate().to(tURL);
        wDriver.navigate().back();
        wDriver.navigate().back();
        Thread.sleep(1000);
        WebElement searchBox = wDriver.findElement(By.name("q"));
        searchBox.clear();
        setPageMethod("Internet Movie Database");
        setWEandClick("/html//div[@id='rso']/div[1]/div[@class='g']//a[@href='https://www.imdb.com/']/h3[@class='LC20lb']");
        WebElement realSize = wDriver.findElement(By.xpath("/html//a[@id='home_img_holder']"));
        String rSize = realSize.getSize().toString();
        System.out.println("IMDb icon has real size: " + rSize);
        Thread.sleep(2000);
        Assert.assertEquals(rSize, tSize);
        System.out.println("IMDb icon has final real size: " + rSize);
    }

    @AfterMethod
    public void closeTest(){
        wDriver.quit();
    }
}

