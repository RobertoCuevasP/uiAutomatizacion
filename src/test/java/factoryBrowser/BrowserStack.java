package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStack implements IBrowser{
    public static final String USERNAME = "robertocuevaspin1";
    public static final String AUTOMATE_KEY = "a8mEcGWTjY7h1GVnEDnb";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Override
    public WebDriver create() {
        DesiredCapabilities caps = new DesiredCapabilities();

        WebDriver driver = null;

        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "80.0");
        caps.setCapability("name", "robertocuevaspin1's First Test");

        try {
            driver = new RemoteWebDriver(new URL(URL), caps);
        } catch (MalformedURLException e){
            e.printStackTrace();
        }
        return driver;
    }

}
