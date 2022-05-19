package automationExerciseCom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase2 {

    WebDriver driver;

    @Before
    public void setUp() {
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        //8-Sayfayi kapatin
        //driver.close();
    }

    @Test
    public void test01() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement testElementi = driver.findElement(By.xpath("(//button[@class='btn btn-success'])[1]"));
        Assert.assertTrue(testElementi.isDisplayed());
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        //5. Verify 'Login to your account' is visible
        WebElement loginYazisi = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(loginYazisi.isDisplayed());
        //6. Enter correct email address and password
        driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("erendeneme1903@gmail.com");
        driver.findElement(By.xpath("(//input[@type='password'])")).sendKeys("deneme123");
        //7. Click 'login' button
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        //8. Verify that 'Logged in as username' is visible
        WebElement isimleGirisYapildiYazisi = driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        Assert.assertTrue(isimleGirisYapildiYazisi.isDisplayed());
        //9. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
        //10. Verify that 'ACCOUNT DELETED!' is visible --> site hata veriyor...
        WebElement hesapSilindi = driver.findElement(By.xpath("//h4[text()='Are you sure you want to delete this Delete Account?']"));
        Assert.assertTrue(hesapSilindi.isDisplayed());
    }
}
