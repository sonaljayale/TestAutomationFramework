import com.automationbysonal.brower.DriverManger;
import com.automationbysonal.components.ElementFindBy;
import com.automationbysonal.properties.PropertiesLoader;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SampleTest {
    @Test
    public void loadBrowserTest() throws Exception {
        PropertiesLoader.initializeProperties();
        PropertiesLoader.validateConfigurations();
        DriverManger driverManger = new DriverManger();
        driverManger.loadDriver();
        DriverManger.driver.get("https://www.google.com");
        Thread.sleep(1000);
        ElementFindBy findBy = new ElementFindBy(DriverManger.driver);
        WebElement element = findBy.findElementBy("GooglePage.tbx_Search");
        element.sendKeys("News");
        Thread.sleep(5000);
        driverManger.closeBrowser();

        /*we need account from github.com
        *
        * */
    }
}
