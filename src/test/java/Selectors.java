import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Selectors {

    public static void main(String[] args) throws MalformedURLException {

        File file = new File("src/test/resources/apps/ApiDemos.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP,file.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2 API 30");

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);

        //poniżej ćwiczenia lokalizowania elementów przez różne lokatory

        //driver.findElementByAccessibilityId("Accessibility");

        //driver.findElement(MobileBy.AccessibilityId("Accessibility"));

        driver.findElementByClassName("android.widget.TextView");
        driver.findElement(MobileBy.className("android.widget.TextView"));

        System.out.println(driver.findElementsByClassName("android.widget.TextView").size());
        System.out.println(driver.findElementsByAccessibilityId("Media").size());

        //by class name śłuży do szukania grupy elementów
        //AccessibilityId służy do szukania pojedyńczych elementów

        System.out.println(driver.findElements(MobileBy.id("android:id/text1")).size());

        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout"));
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout");

        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView"));
        driver.findElement((MobileBy.xpath("//android.widget.ListView")));//skrócony zapis powtższego dzięki //

        //epath z atrybutem

        driver.findElement(MobileBy.xpath("//android.widget.TextView[@content-desc=\"App\"]"));
        driver.findElement(MobileBy.xpath("//android.widget.TextView[@resource-id='android:id/text1']"));
        driver.findElement(MobileBy.xpath("//*[@content-desc=\"App\"]"));//szuka tak samo ByAccessibilityId

        //xpath z tekstem

        driver.findElement(MobileBy.xpath("//*[@text='App']")); //szuka konkretnego tekstu
        driver.findElement((MobileBy.xpath("//android.widget.TextView[contains(@text,'App')]")));//szuka tagu, który zawiera tekst
        driver.findElement((MobileBy.xpath("//*[contains(@text,'App')]")));

        //xpath and or i not

        driver.findElement(MobileBy.xpath("//*[@content-desc='App' and @text='App']"));
        driver.findElement(MobileBy.xpath("//*[@content-desc='App' or @text='App1']"));
        driver.findElement(MobileBy.xpath("//*[@content-desc='App' and not(@text='App1')]"));

        //AndroidUIAUtomator

        driver.findElementByAndroidUIAutomator("text(\"App\")");
        driver.findElementByAndroidUIAutomator("resourceId(\"android:id/text1\")");


    }
}
