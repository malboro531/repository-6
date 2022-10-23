import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverMethodsTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(WebDriverMethodsTest.class);
    // Чтение передаваемого параметра browser (-Dbrowser)
    String env = System.getProperty("browser", "chrome");

    @BeforeEach
    public void setUp() {
        logger.info("env = " + env);
        driver = WebDriverFactory.getDriver(env.toLowerCase());
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void seacrhDNSTest() {
        driver.get("https://www.dns-shop.ru/");
        logger.info("Открыта страница DNS - " + "https://www.dns-shop.ru/");
        // Вывод заголовка страницы в терминал
        String title = driver.getTitle();
        logger.info("title - " + title.toString());
        // Вывод текущего URL в терминал
        String currentUrl = driver.getCurrentUrl();
        logger.info("current URL - " + currentUrl.toString());
        // Ввод текста в поле для поиска
        String searchInputXpath = "/html/body/header/nav/div/div[1]/form/div/input";
        WebElement searchInput = driver.findElement(By.xpath(searchInputXpath));
        String searchText = "Samsung";
        searchInput.sendKeys(searchText);
        // Нажатие кнопка "Найти"
        String searchButtonXpath = "/html/body/header/nav/div/div[1]/form/div/div[2]/span[2]";
        WebElement searchButton = driver.findElement(By.xpath(searchButtonXpath));
        searchButton.click();
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
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
