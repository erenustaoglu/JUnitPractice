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

public class TestCase6 {

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
        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//a[@href='/contact_us']")).click();
        //5. Verify 'GET IN TOUCH' is visible
        WebElement getInTouchYazisi = driver.findElement(By.xpath("//*[text()='Get In Touch']"));
        Assert.assertTrue(getInTouchYazisi.isDisplayed());
        //6. Enter name, email, subject and message
        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        WebElement nameKutusu = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
        actions.click(nameKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.lorem().characters())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.lorem().characters())
                .perform();
        //7. Upload file
        WebElement dosyaSecButonu = driver.findElement(By.xpath("//input[@type='file']"));
        String farkliKisim=System.getProperty("user.home");
        String ortakKisim= "\\Desktop\\text.txt";
        String yuklenecekDosya= farkliKisim+ortakKisim;
        dosyaSecButonu.sendKeys(yuklenecekDosya);
        //8. Click 'Submit' button
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        //9. Click OK button
        driver.switchTo().alert().accept();
        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement successYazisi = driver.findElement(By.xpath("//div[@class='status alert alert-success']"));
        Assert.assertTrue(successYazisi.isDisplayed());
        //11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("(//a[@href='/'])[2]")).click();
        WebElement anaSayfaEkraniElementi = driver.findElement(By.xpath("(//button[@class='btn btn-success'])[1]"));
        Assert.assertTrue(testElementi.isDisplayed());
    }
}
