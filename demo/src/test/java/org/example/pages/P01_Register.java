package org.example.pages;

import org.example.stepDef.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class P01_Register {

    //1-Elements
    By registerLink = By.cssSelector("a[href=\"/register?returnUrl=%2F\"]");
    //Gender
    By maleGenderRadioBtn = By.className("male");
    //Name
    By firstNameField = By.id("FirstName");
    By lastNameField = By.id("LastName");
    //DOB
    By dateOfBirthDayField = By.name("DateOfBirthDay");

    By dateOfBirthMonthField = By.name("DateOfBirthMonth");
    By dateOfBirthYearField = By.name("DateOfBirthYear");
    //Email
    By emailField = By.id("Email");
    // Password
    By passwordField = By.id("Password");
    By confirmPassField = By.id("ConfirmPassword");
    // Register
    By registerBtn = By.id("register-button");
    By registerMsg = By.className("result");
    //2-Actions


    public void clickOnRegister() {
        Hooks.driver.findElement(registerLink).click();
    }
    public void selectGender() {
        Hooks.driver.findElement(maleGenderRadioBtn).click();
    }

    public void insertUserName(String firstName, String lastName) {
        Hooks.driver.findElement(firstNameField).sendKeys(firstName);
        Hooks.driver.findElement(lastNameField).sendKeys(lastName);
    }
    public void insertUserEmail(String email) {
        Hooks.driver.findElement(emailField).sendKeys(email);
    }

    public void insertDateOfBirth() {
        Select day = new Select(Hooks.driver.findElement(dateOfBirthDayField));
        day.selectByIndex(3);
        Select month = new Select(Hooks.driver.findElement(dateOfBirthMonthField));
        month.selectByIndex(5);
        Select year = new Select(Hooks.driver.findElement(dateOfBirthYearField));
        year.selectByIndex(10);
    }

    public void insertPassword(String password, String confirmPass) {
        Hooks.driver.findElement(passwordField).sendKeys(password);
        Hooks.driver.findElement(confirmPassField).sendKeys(confirmPass);
    }

    public void clickOnRegisterBtn() {
        Hooks.driver.findElement(registerBtn).click();
    }
    public WebElement checkRegistrationMsg(){

        return Hooks.driver.findElement(registerMsg) ;
    }
}
