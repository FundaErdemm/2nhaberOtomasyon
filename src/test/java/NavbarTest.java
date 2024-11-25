import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class NavbarTest {
    protected WebDriver driver;
    protected NavbarGiris navbargiris;
    protected ZiyaretciFormuTest ziyaretci;
    protected WebDriver driver1;

    private static final Logger logger = Logger.getLogger(LoginTests.class);

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://2nhaber.com/");
        logger.info("Test başlıyor: 2nhabergiristesti");
        navbargiris = new NavbarGiris(driver);




    }

/*   @AfterEach
    void tearDown() {
        logger.info("Test tamamlandı: 2nhabergiristesti");
        if (driver != null) {
            driver.quit();
        }
    }

*/
}