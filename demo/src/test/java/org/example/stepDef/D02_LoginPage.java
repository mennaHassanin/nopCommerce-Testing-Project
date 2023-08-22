package org.example.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_Login;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class D02_LoginPage {
    SoftAssert softAssert= new SoftAssert();
    P02_Login p02_login = new P02_Login();
    @Given("user go to login page")
    public void userGoToLoginPage(){
        p02_login.clickOnLogin();

    }

    @When("user login with valid {string} and {string}")
    public void userLoginWithValidAnd(String arg0, String arg1) {
        p02_login.insertEmailAndPassword(arg0,arg1);
    }

    @And("user press on login button")
    public void userPressOnLoginButton() {
        p02_login.clickOnLoginBtn();
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        softAssert.assertTrue(p02_login.verifyLoginSuccessfully());
        softAssert.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
        softAssert.assertAll();
    }

    @When("user login with invalid {string} and {string}")
    public void userLoginWithInvalidAnd(String arg0, String arg1) {
        p02_login.insertEmailAndPassword(arg0,arg1);
    }

    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {
        String text =p02_login.verifyLoginIsFailed().getText();
        softAssert.assertTrue(text.contains("Login was unsuccessful"));
        String color =p02_login.verifyLoginIsFailed().getCssValue("color");
        String hexColor = Color.fromString(color).asHex();
        softAssert.assertEquals(hexColor,"#e4434b");
        softAssert.assertAll();
    }
}
