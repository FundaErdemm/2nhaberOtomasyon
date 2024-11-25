import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

public class ZiyaretciFormuTest {
    private WebDriver driver;
    private WebDriverWait wait;

    public ZiyaretciFormuTest(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

        public void ziyaretciformdoldur() {

            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.2ntech.com.tr/hr");


            try {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().window().maximize();

                driver.findElement(By.id("name")).sendKeys("Funda Erdem Adıtepe");
                driver.findElement(By.id("birth")).sendKeys("24.12.1993");
                driver.findElement(By.id("tcKimlik")).sendKeys("18034309402");
                driver.findElement(By.id("phone")).sendKeys("05342977188");
                driver.findElement(By.id("email")).sendKeys("fndaerdm@gmail.com");

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));
                fileInput.sendKeys("C:\\Users\\Monster Notebook\\Desktop\\CV - FundaErdemAdıtepe.pdf");

                Thread.sleep(1000);
                WebElement egitim = driver.findElement(By.cssSelector("button:nth-of-type(2)"));
                egitim.click();

                WebElement ileri = driver.findElement(By.cssSelector("[type='submit']"));
                ileri.click();

                Thread.sleep(2000);
                WebElement pozisyon = driver.findElement(By.cssSelector(".gap-3.grid > div:nth-of-type(2)"));
                pozisyon.click();

                driver.findElement(By.cssSelector(".py-2")).click();


                WebElement successMessage = driver.findElement(By.id("success-message"));
                if (successMessage.isDisplayed()) {
                    System.out.println("Form başarıyla gönderildi!");
                } else {
                    System.err.println("Form gönderimi başarısız.");
                }


            } catch (Exception e) {
                System.err.println("Test sırasında hata oluştu: " + e.getMessage());
            } finally {

                        }
        }


    }

