package com.breadfast.qcassigment;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

abstract class QCAssignmentInterface {
    public AppiumDriver<MobileElement> driver;

    public abstract void init();
    public abstract boolean isLanguagePageOpen();
    public abstract void setAppSettings(String Language);
    public abstract void login(String username, String password);
}
