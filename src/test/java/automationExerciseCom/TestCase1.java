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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class TestCase1 {

    WebDriver driver;

    @Before
    public void setUp() {
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
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement testElementi = driver.findElement(By.xpath("(//button[@class='btn btn-success'])[1]"));
        Assert.assertTrue(testElementi.isDisplayed());
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        //5. Verify 'New User Signup!' is visible
        WebElement newUserYaziElementi = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue(newUserYaziElementi.isDisplayed());
        //6. Enter name and email address
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Eren");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("erendeneme1903@gmail.com");
        //7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement accountInfYazisi = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        Assert.assertTrue(accountInfYazisi.isDisplayed());
        //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("deneme123");
        WebElement gunKutusu = driver.findElement(By.xpath("//select[@id='days']"));
        Select select = new Select(gunKutusu);
        select.selectByIndex(20);
        WebElement ayKutusu = driver.findElement(By.xpath("//select[@id='months']"));
        Select select2 = new Select(ayKutusu);
        select2.selectByIndex(6);
        WebElement yilKutusu = driver.findElement(By.xpath("//select[@id='years']"));
        Select select3 = new Select(yilKutusu);
        select3.selectByIndex(20);
        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//label[text()='Sign up for our newsletter!']")).click();
        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//input[@id='optin']")).click();
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Eren");
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Ustaoglu");
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("deneme");
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("deneme adres");
        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("deneme adres");
        WebElement ulkeSecimi = driver.findElement(By.xpath("//select[@id='country']"));
        Select select4 = new Select(ulkeSecimi);
        select4.selectByIndex(2);
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("deneme");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Istanbul");
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("34123");
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("1234567890");
        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//*[text()='Create Account']")).click();
        //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement hesapOlustuYazisi = driver.findElement(By.xpath("//b[text()='Account Created!']"));
        Assert.assertTrue(hesapOlustuYazisi.isDisplayed());
        //15. Click 'Continue' button
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        //16. Verify that 'Logged in as username' is visible
        WebElement isimleGirisYapildiYazisi = driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        Assert.assertTrue(isimleGirisYapildiYazisi.isDisplayed());
        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button --> site hata veriyor...
        WebElement hesapSilindi = driver.findElement(By.xpath("//h4[text()='Are you sure you want to delete this Delete Account?']"));
        Assert.assertTrue(hesapSilindi.isDisplayed());
    }
}
