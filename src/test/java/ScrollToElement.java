import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class ScrollToElement {
    public static void main(String[] args) throws MalformedURLException {
        File file = new File("src/test/resources/apps/ApiDemos.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP,file.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2 API 30");

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);

        WebElement viewsOption = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Views\").instance(0))");
        viewsOption.click();

        WebElement listsOptions = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Lists\").instance(0))");
        listsOptions.click();

        WebElement selectionMode = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Selection Mode\").instance(0))");
        selectionMode.click();

    }
}
