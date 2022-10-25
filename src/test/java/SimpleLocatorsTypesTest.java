import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SimpleLocatorsTypesTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(SimpleLocatorsTypesTest.class);
    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        logger.info("Драйвер стартовал!");
    }
    @Test
    public void searchByIdTest(){
        driver.get("https://kintern.myacademy.lanit.ru/login/briliant");
        logger.info("Открыта страница myacademy.lanit - " + "https://kintern.myacademy.lanit.ru/login/briliant");
        // Поиск элемента по атрибуту id элемента
        WebElement element = driver.findElement(By.id("user_login_form_login"));
        logger.info("WebElement: " + element.getTagName());
        element.sendKeys("LOGIN id");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void searchByNameTest(){
        driver.get("https://kintern.myacademy.lanit.ru/login/briliant");
        logger.info("Открыта страница myacademy.lanit - " + "https://kintern.myacademy.lanit.ru/login/briliant");
        // Поиск элемента по атрибуту name элемента
        WebElement element = driver.findElement(By.name("user_login_form[login]"));
        logger.info("WebElement: " + element.getTagName());
        element.sendKeys("LOGIN name");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void searchByClassTest(){
        driver.get("https://kintern.myacademy.lanit.ru/login/briliant");
        logger.info("Открыта страница myacademy.lanit - " + "https://kintern.myacademy.lanit.ru/login/briliant");
        // Поиск элемента по атрибуту class элемента
        List<WebElement> elements = driver.findElements(By.className("text-input"));
        for(WebElement element : elements)
            logger.info("WebElement: " + element.getText());
    }
    @Test
    public void searchByTagTest(){
        driver.get("https://kintern.myacademy.lanit.ru/login/briliant");
        logger.info("Открыта страница myacademy.lanit - \" + \"https://kintern.myacademy.lanit.ru/login/briliant");
        // Поиск элемента по тегу элемента
        List<WebElement> elements = driver.findElements(By.tagName("form"));
        for(WebElement element : elements)
            logger.info("WebElement: " + element.getText());
    }@Test
    public void searchByLinkTextTest(){
        driver.get("https://kintern.myacademy.lanit.ru/login/briliant");
        logger.info("Открыта страница myacademy.lanit - \" + \"https://kintern.myacademy.lanit.ru/login/briliant");
        // Поиск элемента по тексту ссылки
        WebElement element = driver.findElement(By.linkText("забыли пароль?"));
        logger.info("WebElement: " + element.getText());
        element.click();
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void searchByPartialLinkTextTest(){
        driver.get("https://kintern.myacademy.lanit.ru/login/briliant");
        logger.info("Открыта страница myacademy.lanit - \" + \"https://kintern.myacademy.lanit.ru/login/briliant");
        // Поиск элемента по частичному тексту ссылки
        WebElement element = driver.findElement(By.partialLinkText("забыли"));
        logger.info("WebElement: " + element.getText());
        element.click();
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void searchByCssSelectorTest(){
        driver.get("https://kintern.myacademy.lanit.ru/login/briliant");
        logger.info("Открыта страница myacademy.lanit - \" + \"https://kintern.myacademy.lanit.ru/login/briliant");
        // Поиск элемента по CSS селектору
        WebElement element1 = driver.findElement(By.cssSelector("input#user_login_form_login"));
        logger.info("WebElement: " + element1.getTagName());
        logger.info("Id: " + element1.getAttribute("id"));
        element1.sendKeys("Login");
        // Поиск элемента по CSS селектору
        WebElement element2 = driver.findElement(By.cssSelector("input#user_login_form_password"));
        logger.info("WebElement: " + element2.getTagName());
        logger.info("Id: " + element2.getAttribute("id"));
        element2.sendKeys("Password");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void searchByXpathQueryTest(){
        driver.get("https://kintern.myacademy.lanit.ru/login/briliant");
        logger.info("Открыта страница myacademy.lanit - \" + \"https://kintern.myacademy.lanit.ru/login/briliant");
        // Поиск элемента по XPATH запросу
        WebElement element1 = driver.findElement(By.xpath(".//input[@id='user_login_form_login']"));
        logger.info("WebElement: " + element1.getTagName());
        logger.info("Id: " + element1.getAttribute("id"));
        element1.sendKeys("Login");
        // Поиск элемента по XPATH запросу
        WebElement element2 = driver.findElement(By.xpath(".//input[@id='user_login_form_password']"));
        logger.info("WebElement: " + element2.getTagName());
        logger.info("Id: " + element2.getAttribute("id"));
        element2.sendKeys("Password");
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
