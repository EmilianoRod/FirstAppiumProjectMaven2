import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CreateDriverSession {

    public static AppiumDriver initializeDriver(String platformName) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", platformName);
        caps.setCapability("newCommandTimeout", 300);

        URL url = new URL("http://127.0.0.1:4723/");

        switch (platformName) {
            case "Android":
                caps.setCapability("deviceName", "pixel_xl");
                caps.setCapability("automationName", "uiautomator2");
                caps.setCapability("udid", "emulator-5554");
//              caps.setCapability("avd", "Pixel_XL_API_30");
//              caps.setCapability("avdLaunchTimeout", 180000);
                caps.setCapability("appPackage", "io.appium.android.apis");
                caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
                caps.setCapability("app",
                        "/Users/erodriguez/Desktop/appium/lessons/lesson40/ApiDemos-debug.apk");
                return new AndroidDriver(url, caps);

            case "iOS":
                caps.setCapability("deviceName", "iPhone 15");
                caps.setCapability("automationName", "XCUITest");
                caps.setCapability("udid", "A947527B-A8FA-4882-A24E-E9F0390D43DD");
                //  caps.setCapability("app","/Users/erodriguez/Downloads/ios-uicatalog-master/UIKitCatalog/build/Release-iphonesimulator/UIKitCatalog-iphonesimulator.app");
                caps.setCapability("simulatorStartupTimeout", 180000);
                caps.setCapability("bundleId", "com.example.apple-samplecode.UICatalog");
                // caps.setCapability("xcodeOrgId", "F44N5MSDA3");
                // caps.setCapability("xcodeSigningId", "iPhone Developer");
                return new IOSDriver(url, caps);

            default:
                throw new Exception("invalid platform");
        }
    }
}
