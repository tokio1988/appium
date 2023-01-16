import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Helper;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebContexTest {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        File file = new File("src/test/resources/apps/ApiDemos.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP,file.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2 API 30");

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);

        //driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

        Wait wait = new WebDriverWait(driver,60l);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Apppss")));


        WebElement viewsOption = Helper.scrollToElement("textContains(\"Views\")",driver);
        viewsOption.click();

        driver.getContextHandles().forEach(System.out::println);

        WebElement WebViewOption = Helper.scrollToElement("textContains(\"WebView\")",driver);
        WebViewOption.click();

        //driver.getContextHandles().forEach(System.out::println);

        //Thread.sleep(5000);

        driver.context("WEBVIEW_io.appium.android.apis");


        driver.findElementByXPath("//a").click();
    }
}
