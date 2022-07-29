import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory2 {
    public static Logger logger = LogManager.getLogger(WebDriverFactory2.class);

    public static WebDriver getDriver(String browsername) {
        switch (browsername) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                logger.info("Драйвер для Google Chrome");
                return new ChromeDriver();
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                logger.info("Драйвер для Mozilla Firefox");
                return new FirefoxDriver();
            default:
                throw new RuntimeException("Incorrect browser name");
        }

    }
}
