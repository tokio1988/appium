package utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Helper {
    public static MobileElement scrollToElement(String locator, AndroidDriver<MobileElement> driver)
    {
        String selector = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector()." + locator + ".instance(0))";
        return driver.findElementByAndroidUIAutomator(selector);
    }
}
