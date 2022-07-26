import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;


public class WebDriverFactory {
    private static Logger logger = LogManager.getLogger(WebDriverFactory.class);

    public static WebDriver getDriver(String browsername){
        switch (browsername){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                logger.info("Драйвер для Google Chrome");
                return new ChromeDriver();
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                logger.info("Драйвер для Mozilla Firefox");
                return new FirefoxDriver();
            case "edge":
                logger.info("Драйвер для edge");
                return new EdgeDriver();
            case "opera":
                logger.info("Драйвер для Opera");
                return new OperaDriver();
            case "explorer":
                logger.info("Драйвер для explorer");
                return new InternetExplorerDriver();
            default:
                throw new RuntimeException("Incorrect browser name");
        }
    }
}
