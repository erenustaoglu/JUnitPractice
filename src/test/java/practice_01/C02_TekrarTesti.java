package practice_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//1-C02_TekrarTesti isimli bir class olusturun
//2- https://www.amazon.com/ adresine gidin
//3- Browseri tam sayfa yapin
//4-Sayfayi “refresh” yapin
//5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin
//6- Gift Cards sekmesine basin
//7- Birthday butonuna basin
//8- Best Seller bolumunden ilk urunu tiklayin
//9- Gift card details’den 25 $’i secin
//10-Urun ucretinin 25$ oldugunu test edin
//10-Sayfayi kapatin

public class C02_TekrarTesti {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //3- Browseri tam sayfa yapin
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        //10-Sayfayi kapatin
        driver.close();
    }

    @Test
    public void Test(){
        //2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com");
        //4-Sayfayi “refresh” yapin
        driver.navigate().refresh();
        //5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        System.out.println(driver.getTitle());
        if (driver.getTitle().contains("Spend less")) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
        //6- Gift Cards sekmesine basin
        driver.findElement(By.linkText("Gift Cards")).click();
        //7- Birthday butonuna basin
        driver.findElement(By.xpath("(//span[@class='a-size-base a-color-base'])[28]")).click();
        //8- Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//span[@class='nav-a-content'])[2]")).click();
        driver.findElement(By.xpath("(//img[@class='a-dynamic-image p13n-sc-dynamic-image p13n-product-image'])[1]")).click();
        //9- Gift card details’den 25 $’i secin
        WebElement giftCard25 =  driver.findElement(By.xpath("(//button[@id='gc-mini-picker-amount-1'])[1]"));
        giftCard25.click();
        //10-Urun ucretinin 25$ oldugunu test edin
        if (giftCard25.getText().equals("$25")){
            System.out.println("Gift card test passed");
        } else {
            System.out.println("Gift Card test failed");
        }
    }
}