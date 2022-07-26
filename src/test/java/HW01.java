import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW01 {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(HW01.class);

    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Драйвер запущен!");
    }

    @Test
    public void openPage(){
        driver.get("https://www.dns-shop.ru/");
        logger.info("Драйвер стартовал");
    }

    @AfterEach
    public void setDown(){
        if(driver != null){
            driver.quit();
            logger.info("Драйвер завершил работу!");
        }
    }
}
