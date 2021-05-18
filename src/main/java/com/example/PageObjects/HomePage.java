package com.example.PageObjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {

    public AndroidDriver<AndroidElement> driver;

    // Constructor
    public HomePage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Búsqueda de elementos
    @AndroidFindBy(id = "io.grainchain.logintest:id/textview_first")
    public MobileElement message;

    // Métodos
    public String getMessage() {
        return message.getText();
    }

}
