package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.Data.Constants;
import com.example.PageObjects.HomePage;
import com.example.PageObjects.LoginPage;
import org.testng.annotations.*;

public class testLogin extends baseTest {

    @Test
    public void validateLoginFieldsTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.setUsername(Constants.username.replaceAll("[@]*", ""));
        loginPage.setPassword(Constants.password);

        // El campo username debería tener formato 'email', se detecta que pasa aunque
        // no lleve el '@' y se habilita el botón 'sign in or register'
        assertFalse("Not a valid username", loginPage.button().isEnabled());

    }

    @Test
    public void validateLengthPasswordTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.setUsername(Constants.username);

        for (int i = 0; i < Constants.password.length() - 1; i++) {
            loginPage.setPassword(Constants.password.substring(0, i + 1));
            assertFalse("Not a valid username length 5", loginPage.button().isEnabled());
        }

        loginPage.setPassword(Constants.password);
        assertTrue("Not a valid username", loginPage.button().isEnabled());
    }

    @Test
    public void testPasswordLength() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.setUsername(Constants.username);
        loginPage.setPassword(Constants.password);
        loginPage.clicButton();
        assertEquals("Hello " + Constants.username, homePage.getMessage());
    }
}
