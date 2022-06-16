package automationExerciseCom;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class TestCase5 {

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
        driver.close();

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
        //5. Verify 'New User Signup!' is visible
        WebElement newUserSignUpButonu = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue(newUserSignUpButonu.isDisplayed());
        //6. Enter name and already registered email address
        //7. Click 'Signup' button
        Faker faker = new Faker();
        Actions actions = new Actions(driver);
        WebElement newUserNameButonu = driver.findElement(By.xpath("//input[@type='text']"));
        actions.click(newUserNameButonu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys("erendeneme1903@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
        //8. Verify error 'Email Address already exist!' is visible
        WebElement emailKayıtlıYazisi = driver.findElement(By.xpath("//*[text()='Email Address already exist!']"));
        Assert.assertTrue(emailKayıtlıYazisi.isDisplayed());
    }
}
