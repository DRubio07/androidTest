package com.example.PageObjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {

    public AndroidDriver<AndroidElement> driver;

    // Constructor
    public LoginPage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Búsqueda de elementos
    @AndroidFindBy(id = "io.grainchain.logintest:id/username")
    public MobileElement usernameInput;

    @AndroidFindBy(id = "io.grainchain.logintest:id/password")
    public MobileElement passwordInput;

    @AndroidFindBy(id = "io.grainchain.logintest:id/login")
    public MobileElement loginButton;

    // Métodos
    public MobileElement button() {
        return loginButton;
    }

    public void setUsername(String name) {
        usernameInput.sendKeys(name);
    }

    public void setPassword(String name) {
        passwordInput.sendKeys(name);
    }

    public void clicButton() {
        loginButton.click();
    }

}
