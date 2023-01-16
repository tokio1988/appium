import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class KeyboardTest {
    public static void main(String[] args) throws MalformedURLException {
        File file = new File("src/test/resources/apps/ApiDemos.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP,file.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2 API 30");

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
        WebElement preferenceElement = driver.findElementByAccessibilityId("Preference");
        preferenceElement.click();

        driver.findElementByAccessibilityId("4. Default values").click();
        driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Edit text preference']")).click();
        driver.findElement(MobileBy.id("android:id/edit")).clear();
        driver.findElement(MobileBy.id("android:id/edit")).click();

        driver.pressKey(new KeyEvent(AndroidKey.R));
        driver.pressKey(new KeyEvent(AndroidKey.A));
        driver.pressKey(new KeyEvent(AndroidKey.N));
        driver.pressKey(new KeyEvent(AndroidKey.D));
        driver.pressKey(new KeyEvent(AndroidKey.O));
        driver.pressKey(new KeyEvent(AndroidKey.M));
    }
}
