import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

public class LoginTests extends NavbarTest {

    private static final Logger logger = Logger.getLogger(LoginTests.class);

    @Test
    void navbargiristesti() throws InterruptedException {

        NavbarGiris navbarGiris = new NavbarGiris(driver);
        AramaYap aramaYap = new AramaYap(driver);
        ZiyaretciFormuTest ziyaretci= new ZiyaretciFormuTest(driver);

        navbarGiris.testNavbar();
        aramaYap.searchAndVisitArticle(8);
        ziyaretci.ziyaretciformdoldur();


    }
}





