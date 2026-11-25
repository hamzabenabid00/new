package Helper;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Config {
    public static WebDriver driver;

    // Connect to the Firefox running INSIDE the Docker container
    public static void openBrowser() throws Exception {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("-headless");
        // Read from environment variable (Docker/compose), fallback to localhost (Eclipse)
        String gridUrl = System.getenv().getOrDefault("SELENIUM_URL", "http://localhost:4444");
        driver = new RemoteWebDriver(new URL(gridUrl), options);
    }

    public static void maxwin() {
        driver.manage().window().maximize();
    }

    public static void attent(int s) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(s));
    }
}