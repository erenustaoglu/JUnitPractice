package practice_01;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.List;
public class C02_TekrarTesti {
    /*
    1. C01_TekrarTesti isimli bir class olusturun -->olusturuldu
    2. https://www.amazon.com/ adresine gidin
    3. Browseri tam sayfa yapin
    4. Sayfayi “refresh” yapin
    5. Sayfa basliginin “Spend less” ifadesi icerdigini test edin
    6. Gift Cards sekmesine basin
    7. Birthday butonuna basin
    8. Best Seller bolumunden ilk urunu tiklayin
    9. Gift card details’den 25 $’i secin
    10. Urun ucretinin 25$ oldugunu test edin
    11. Sayfayi kapatin
     */
    public static void main(String[] args) {
        //1. C01_TekrarTesti isimli bir class olusturun
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //2. https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com");
        //3. Browseri tam sayfa yapin
        driver.manage().window().maximize();
        //4. Sayfayi “refresh” yapin
        driver.navigate().refresh();
        //5. Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String actualSayfaBasligi = driver.getTitle();
        String istenilenMetin = "Spend less";
        if (actualSayfaBasligi.contains(istenilenMetin)) {
            System.out.println("Sayfa basliginin " + istenilenMetin + " icerme testi PASSED");
        } else System.out.println("Sayfa basliginin " + istenilenMetin + " icerme testi FAILED");
        //6. Gift Cards sekmesine basin
        driver.findElement(By.xpath("//a[text()='Gift Cards']")).click();
        //7. Birthday butonuna basin
        driver.findElement(By.xpath("//a[@aria-label='Birthday gift cards']")).click();
        //8. Best Seller bolumunden ilk urunu tiklayin
        List<WebElement> bestSellerUrunleri = driver.findElements(By.xpath("//div[@id='acs-product-block-0']"));
        bestSellerUrunleri.get(0).click();
        //9. Gift card details’den 25 $’i secin
        driver.findElement(By.xpath("//button[@value='25']")).click();
        //10. Urun ucretinin 25$ oldugunu test edin
        WebElement actualUrunUcreti = driver.findElement(By.xpath("//span[.='$25.00']"));
        String exceptedUrunUcreti = "25$";
        if (actualUrunUcreti.getText().equals(exceptedUrunUcreti)) {
            System.out.println(exceptedUrunUcreti + " = " + actualUrunUcreti.getText() + " .Test PASSED");
        } else System.out.println(exceptedUrunUcreti + " != " + actualUrunUcreti.getText() + " .Test FAILED");
        //11. Sayfayi kapatin
        driver.close();
    }
}