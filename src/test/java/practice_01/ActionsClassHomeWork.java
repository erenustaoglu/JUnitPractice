package practice_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsClassHomeWork {

    //Yeni Class olusturun ActionsClassHomeWork
    //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
    //2- Hover over Me First" kutusunun ustune gelin
    //3- Link 1" e tiklayin
    //4- Popup mesajini yazdirin
    //5- Popup'i tamam diyerek kapatin
    //6- “Click and hold" kutusuna basili tutun
    //7-“Click and hold" kutusunda cikan yaziyi yazdirin
    //8- “Double click me" butonunu cift tiklayin

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2- Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        WebElement hoverKutusu = driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));
        actions.click(hoverKutusu).perform();
        //3- Link 1" e tiklayin
        WebElement hoverKutusuLink1 = driver.findElement(By.xpath("(//*[text()='Link 1'])[1]"));
        hoverKutusuLink1.click();
        //4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //6- “Click and hold" kutusuna basili tutun
        WebElement clickHoldKutusu = driver.findElement(By.xpath("(//div[@class='col-lg-12 text-center'])[3]"));
        actions.clickAndHold(clickHoldKutusu).perform();
        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickHoldKutusu.getText());
        //8- “Double click me" butonunu cift tiklayin
        WebElement doubleClickButonu = driver.findElement(By.xpath("//div[@id='double-click']"));
        actions.doubleClick(doubleClickButonu).perform();
    }
}
