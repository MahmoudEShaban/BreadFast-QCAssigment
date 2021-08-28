package com.breadfast.qcassigment;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

class AndroidQCAssignment extends QCAssignmentInterface {
    public AppiumDriver<MobileElement> driver;

    @Override
    public void init() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName","Seif's Galaxy Z Fold2 5G");
        cap.setCapability("udid","R3CNC00969F");
        cap.setCapability("platformName","Android");
        cap.setCapability("platformVersion","11");
        // cap.setCapability("automationName", "UiAutomator2");

        cap.setCapability("appPackage","com.breadfast");
        cap.setCapability("appActivity","com.breadfast.MainActivity");

        try {
            URL url = new URL("http://0.0.0.0:4723/wd/hub");
            this.driver = new AppiumDriver<MobileElement>(url, cap);
            System.out.println("Application Started");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isLanguagePageOpen() {
        try {
            By enButton = new By.ByXPath("//android.view.ViewGroup[@content-desc=\"en\"]");
            return this.driver.findElement(enButton) != null;
        } catch (Exception ex) {
            return false;
        }
        /**
         * (new TouchAction(driver)).tap(727, 1517).perform()
         * (new TouchAction(driver)).tap(877, 1742).perform()
         * (new TouchAction(driver)).tap(1658, 229).perform()
         * (new TouchAction(driver)).tap(1230, 1772).perform()
         * (new TouchAction(driver)).tap(935, 1742).perform()
         * (new TouchAction(driver)).tap(1085, 1891).perform()
         */
    }

    @Override
    public void setAppSettings(String language) {
        MobileElement languageButton;
        if (language.equals("English")) {
            By enButton = new By.ByXPath("//android.view.ViewGroup[@content-desc=\"en\"]");
            languageButton = this.driver.findElement(enButton);
        } else { // Arabic
            By arButton = new By.ByXPath("//android.view.ViewGroup[@content-desc=\"ar\"]");
            languageButton = this.driver.findElement(arButton);
        }
        languageButton.click();
        MobileElement continueButton = this.driver.findElement(new By.ByXPath("//android.view.ViewGroup[@content-desc=\"Continue\"]/android.view.ViewGroup"));
        continueButton.click();

        // Click on SKIP Button
        // MobileElement skipButton = this.driver.findElement(new MobileBy.ById("737a28ec-bf77-43ec-874d-8a35444c49bb"));
        // skipButton.click();

        // Click on the next button
    }

    @Override
    public void login(String username, String password) {

    }
}
