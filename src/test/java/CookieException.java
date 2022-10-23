//перехват исключения InvalidCookieDomainException (вызывается, когда куки добавляется в другой домен вместо текущего URL адреса.)
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.InvalidCookieDomainException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookieException {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(SampleTest.class);

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void test() {
        try {
            driver.get("https://www.dns-shop.ru/");
            driver.manage().addCookie(
                    new Cookie.Builder("Cookie 1", "This Is Cookie 1")
                            .domain( "https://www.dnsshop.ru/")
                            .build());
            Cookie cookie1  = driver.manage().getCookieNamed("Cookie 1");
            logger.info(String.format("Domain: %s", cookie1.getDomain()));
            logger.info(String.format("Expiry: %s",cookie1.getExpiry()));
            logger.info(String.format("Name: %s",cookie1.getName()));
            logger.info(String.format("Path: %s",cookie1.getPath()));
            logger.info(String.format("Value: %s",cookie1.getValue()));
        } catch (InvalidCookieDomainException e) {
            logger.info("InvalidCookieDomainException: " + e.getRawMessage());
        }
    }

    @AfterEach
    public void setDown() {
        if(driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }
}
