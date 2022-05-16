package practice_01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_TekrarTesti {

        // 1. Bir class oluşturun : C01_TekrarTesti
        // 2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
        // a.google web sayfasına gidin. https://www. amazon.com/
        //         b. Search(ara) “city bike”
        // c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        // d. “Shopping” e tıklayın.
        // e. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // a.google web sayfasına gidin. https://www.amazon.com/
        driver.get("https://www.amazon.com");

        // b. Search(ara) “city bike”
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("city bike" + Keys.ENTER);

        // c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        WebElement viewResults = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[1]"));
        String numberOfResults[] = viewResults.getText().split(" ");
        System.out.println("İlgili sonuclarin sayisi: " + numberOfResults[2]);

        // d. “Shopping” e tıklayın. --> Shopping tuşu yok...

        // e. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
        WebElement firsProduct = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span"));
        firsProduct.click();

        Thread.sleep(2000);
        driver.close();

    }
}