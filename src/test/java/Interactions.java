import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class Interactions {
    public static void main(String[] args) throws MalformedURLException {

        File file = new File("src/test/resources/apps/ApiDemos.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP,file.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2 API 30");

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);

        //tapnięcie w element, wersja dłuższa

        //TouchAction touchAction = new TouchAction(driver);
        //touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(driver.findElementByAccessibilityId("Preference")))).perform();

        //skrócony zapis powyższego
        WebElement preferenceElement = driver.findElementByAccessibilityId("Preference");
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(tapOptions().withElement(element(preferenceElement))).perform();

        //driver.findElementByAccessibilityId("Accessibility").click();
        //MobileElement accessibility = driver.findElementByAccessibilityId("Accessibility");
        //accessibility.click();

        //klikanie elementu i przesyłanie tekstu
        //driver.findElementByAccessibilityId("Preference").click();
        driver.findElementByAccessibilityId("4. Default values").click();
        driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Edit text preference']")).click();
        String oldValue = driver.findElement(MobileBy.id("android:id/edit")).getText();
        driver.findElement(MobileBy.id("android:id/edit")).clear();
        driver.findElement(MobileBy.id("android:id/edit")).sendKeys("Orka");
        driver.findElement(MobileBy.id("android:id/button1")).click();

        //Zaznaczenie checkboxa
        System.out.println("Checkbox is checked: " + driver.findElement(MobileBy.id("android:id/checkbox")).getAttribute("checked"));

        driver.findElement(MobileBy.id("android:id/checkbox")).click();
        System.out.println("Checkbox is checked: " + driver.findElement(MobileBy.id("android:id/checkbox")).getAttribute("checked"));
        driver.findElement(MobileBy.id("android:id/title")).click();

        driver.findElement(MobileBy.xpath("//*[@text='List preference']")).click();
        driver.findElement(MobileBy.xpath("//*[@text='Beta Option 02']")).click();

        //POBRANIE wartości tekstowej
        driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Edit text preference']")).click();
        String newValue = driver.findElement(MobileBy.id("android:id/edit")).getText();
        System.out.println("Old value: " + oldValue);
        System.out.println("New Value: " + newValue);
        System.out.println("Are values equel? " + oldValue.equals(newValue));

        //puknięcie / tapnięcie


    }
}
