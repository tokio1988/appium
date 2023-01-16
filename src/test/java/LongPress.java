import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.Helper;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class LongPress {

    private static AndroidDriver<MobileElement> driver;
    public static void main(String[] args) throws MalformedURLException {
        File file = new File("src/test/resources/apps/ApiDemos.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP,file.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2 API 30");

        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);

        //WebElement viewsOption = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Views\").instance(0))");
        WebElement viewsOption = Helper.scrollToElement("textContains(\"Views\")",driver);
        viewsOption.click();

        //WebElement listsOptions = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Lists\").instance(0))");
        //text(\"Lists\")
        WebElement listsOptions = Helper.scrollToElement("text(\"Lists\")",driver);
        listsOptions.click();


        //WebElement selectionMode = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Selection Mode\").instance(0))");
        //textContains("Selection Mode")
        WebElement selectionMode = Helper.scrollToElement("textContains(\"Selection Mode\")",driver);
        selectionMode.click();

        //WebElement ambertOption = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Ambert\").instance(0))");
        WebElement ambertOption = Helper.scrollToElement("textContains(\"Ambert\")", driver);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(ambertOption))).perform();

    }

}
