package com.breadfast.qcassigment;

import java.util.concurrent.TimeUnit;

public class QCAssignment {
    public static void main(String[] args) {
        AndroidQCAssignment QCAssignment = new AndroidQCAssignment();
        QCAssignment.init();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (QCAssignment.isLanguagePageOpen()) { // check if app setting screen is currently shown
            System.out.println("Language Page Open");
            QCAssignment.setAppSettings("English");
        } else {
            System.out.println("Language Page NOT Open");
        }
        QCAssignment.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // check if app login screen is currently shown
        // QCAssignment.login("", "");
        //
    }
}
