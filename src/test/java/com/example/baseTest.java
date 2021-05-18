package com.example;

import java.net.URL;

import com.example.Data.Constants;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class baseTest {

    public AndroidDriver<AndroidElement> driver;

    // Configuración
    @BeforeTest
    public void launchApp() {
        DesiredCapabilities capability = DesiredCapabilities.android();
        capability.setCapability("platformName", "Android");
        capability.setCapability("version", 11);
        capability.setCapability("deviceName", "SM-G975F");
        capability.setCapability("appWaitActivity", "io.grainchain.logintest");

        try {
            URL url = new URL(Constants.url);
            driver = new AndroidDriver<>(url, capability);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @AfterClass
    public void closeSession() {
        driver.quit();
    }
}
