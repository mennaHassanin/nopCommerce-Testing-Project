package org.example.stepDef;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_Register;
import org.testng.asserts.SoftAssert;


public class D01_RegisterPage{
    P01_Register p01_register = new P01_Register();
    SoftAssert softAssert = new SoftAssert();
    @Given("user go to register page")
    public void userGoTop01_register(){
        p01_register.clickOnRegister();
    }

    @When("user select gender type")
    public void userChooseHisGender() {
        p01_register.selectGender();
    }

    @And("user enter first name {string} and last name {string}")
    public void userEnterFirstNameAndLastName(String arg0, String arg1) {
        p01_register.insertUserName(arg0,arg1);
    }
    @And("user enter date of birth")
    public void userEnterDateOfBirth() {
        p01_register.insertDateOfBirth();
    }

    @And("user enter email {string} field")
    public void userEnterEmailField(String arg0) {p01_register.insertUserEmail(arg0);}

    @And("user fills Password fields {string} {string}")
    public void userFillsPasswordFields(String arg0, String arg1) {
        p01_register.insertPassword(arg0,arg1);
    }

    @And("user clicks on register button")
    public void userClicksOnRegisterButton() {
        p01_register.clickOnRegisterBtn();
    }

    @Then("success message is displayed")
    public void successMessageIsDisplayed() {
        softAssert.assertEquals(p01_register.checkRegistrationMsg().getText(),"Your registration completed");
        softAssert.assertEquals(p01_register.checkRegistrationMsg().getCssValue("color"),"rgba(76, 177, 124, 1)");
        softAssert.assertAll();
    }
}