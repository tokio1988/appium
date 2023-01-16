import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.Helper;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SwipeTest {
    public static void main(String[] args) throws MalformedURLException {
        File file = new File("src/test/resources/apps/ApiDemos.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP,file.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2 API 30");

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);

        WebElement viewsOption = Helper.scrollToElement("textContains(\"Views\")",driver);
        viewsOption.click();

        TouchAction touchAction = new TouchAction(driver);

        touchAction.press(PointOption.point(100,500)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(100,200)).release().perform();

        touchAction.press(PointOption.point(100,500)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(100,900)).release().perform();
    }
}
