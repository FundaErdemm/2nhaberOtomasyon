import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;
import java.time.Duration;
import java.util.List;

public class AramaYap {
    private WebDriver driver;
    private WebDriverWait wait;

    private static final Logger logger = Logger.getLogger(AramaYap.class);
    public AramaYap(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void searchAndVisitArticle(int articleIndex) {
        try {

            WebElement searchButton = driver.findElement(By.cssSelector(".elementor-widget-cmsmasters-search__popup-trigger-container"));
            searchButton.click();

            WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='s']")));
            searchInput.sendKeys("istanbul", Keys.ENTER);


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            // 8. article içindeki a.cmsmasters-animation öğesini seç

// 8. article içindeki a.cmsmasters-animation öğesini seç

            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".cmsmasters-blog__posts >*")));
            List<WebElement> articles = driver.findElements(By.cssSelector(".cmsmasters-blog__posts >*"));
            System.out.println("Toplam makale sayısı: " + articles.size());


            if (articleIndex >= 1 && articleIndex <= articles.size()) {
                System.out.println(articleIndex);
                WebElement article = articles.get(articleIndex - 1);// 1 tabanlı indeks için -1
                System.out.println(article);
                    article.click();

                   // articles.get(7).click();


            }
            else {
                System.out.println("Geçersiz makale indeksi.");
            }


        } catch (Exception e) {
            logger.error("Hata oluştu: " + e.getMessage());
        }
    }


}

