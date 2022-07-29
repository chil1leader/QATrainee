import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CookieTest {
    protected static WebDriver driver;
    private final Logger logger = LogManager.getLogger(CookieTest.class);
    String env = System.getProperty("browser", "chrome");

    public WebDriver getDriver() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
        options.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
        options.addArguments("--incognito");

        return new ChromeDriver(options);
    }

    @BeforeEach
    public void setUp() {
        logger.info("env = " + env);
        driver = WebDriverFactory2.getDriver(env.toLowerCase());
        driver = getDriver();
        logger.info("Драйвер запущен");
    }

    @AfterEach
    public void setDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен");
        }
    }

    @Test
    public void CookiesTest() {
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.get("https://www.dns-shop.ru/");
        driver.manage().window().maximize();
        logger.info(String.format("Browser Window Height: %d", driver.manage().window().getSize().getHeight()));
        logger.info(String.format("Browser Window Width: %d", driver.manage().window().getSize().getWidth()));
        logger.info("Драйвер стартовал");

        logger.info("Добавленные куки");
        driver.manage().addCookie(new Cookie("Cookie 1", "This is cookie 1"));
        Cookie cookie1 = driver.manage().getCookieNamed("Cookie 1");
        logger.info(String.format("Domain: %s", cookie1.getDomain()));
        logger.info(String.format("Expiry: %s",cookie1.getExpiry()));
        logger.info(String.format("Name: %s",cookie1.getName()));
        logger.info(String.format("Path: %s",cookie1.getPath()));
        logger.info(String.format("Value: %s",cookie1.getValue()));
        logger.info("--------------------------------------");

        logger.info(driver.getTitle());
        logger.info(driver.getCurrentUrl());
        WebElement technicPage = driver.findElement(By.xpath("//*[@id=\"homepage-desktop-menu-wrap\"]/div/div[1]/div[1]/a"));
        technicPage.click();
        List<WebElement> categories = driver.findElements(By.className("subcategory__title"));
        for (WebElement category : categories) {
            logger.info("Текущая категория - " + category.getAttribute("outerText"));

        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
