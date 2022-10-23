import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Chrome {

    public static void setUp() {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = getWebDriver("firefox");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--incognito");
        driver.manage().window().maximize();

        driver.get("https://yandex.ru/");
        driver.quit();
    }

    static WebDriver getWebDriver(String browserName) {
        switch (browserName) {
            case "chrome":
                return new ChromeDriver();
            case "firefox":
                return new FirefoxDriver();
            default:
                throw new RuntimeException("Incorrect BrowserName");
        }
    }
}
