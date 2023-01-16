import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.Helper;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DragAndDrop {
    public static void main(String[] args) throws MalformedURLException {
        File file = new File("src/test/resources/apps/ApiDemos.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP,file.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2 API 30");

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);

        WebElement viewsOption = Helper.scrollToElement("textContains(\"Views\")",driver);
        viewsOption.click();

        driver.findElementByAccessibilityId("Date Widgets").click();
        driver.findElementByAccessibilityId("2. Inline").click();
        driver.findElementByXPath("//*[@content-desc='10']").click();

        //driver.findElementByXPath("//*[@content-desc='10']").click();
        //driver.findElementByXPath("//*[@content-desc='45']").click();

        MobileElement starPoint = driver.findElementByXPath("//*[@content-desc='15']");
        MobileElement targetPoint = driver.findElementByXPath("//*[@content-desc='30']");

        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(starPoint)).withDuration(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(targetPoint.getCenter())).release().perform();
    }
}
