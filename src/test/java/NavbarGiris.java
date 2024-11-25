import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.time.Duration;

public class NavbarGiris {
    private WebDriver driver;
    private WebDriverWait wait;


    private static final Logger logger = Logger.getLogger(LoginTests.class);

    public NavbarGiris(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void testNavbar() throws InterruptedException {            //methodlar

        try {
            List<WebElement> navbarElements = driver.findElements(By.cssSelector("nav a"));
            for (int i = 0; i < navbarElements.size(); i++) {

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));


                navbarElements = driver.findElements(By.cssSelector("nav a"));
                WebElement element = navbarElements.get(i);
                String elementText = element.getText();
                String elementHref = element.getAttribute("href");

                try {
                    wait.until(ExpectedConditions.elementToBeClickable(element));
                    element.click();


                    // Sayfa başlığını kontrol et
                    if (!driver.getTitle().isEmpty()) {
                        System.out.println("Başarılı: " + elementText + " sayfası yüklendi -> " + elementHref);
                    } else {
                        System.err.println("Başarısız: " + elementText + " sayfası yüklenemedi.");
                    }

                } catch (Exception e) {
                    System.err.println("Element tıklanabilir değil: " + elementText);
                }
                driver.navigate().back();
            }

        } catch (Exception e) {
            System.err.println("Navbar testi sırasında hata oluştu: " + e.getMessage());
        }
    }
}

