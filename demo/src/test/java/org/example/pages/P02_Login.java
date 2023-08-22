package org.example.pages;

import org.example.stepDef.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P02_Login {
    //1-Elements
    By loginLink = By.cssSelector("a[href=\"/login?returnUrl=%2F\"]");
    By emailField = By.id("Email");
    By passwordField = By.id("Password");
    By loginBtn = By.cssSelector("[class*=\"login-button\"]");
    By myAccountTab = By.cssSelector("div [class=\"header-links\"] a[href=\"/customer/info\"]");

    By loginMsg = By.cssSelector("[class*=\"message-error\"]");

    //2-Actions
    public void clickOnLogin() {
        Hooks.driver.findElement(loginLink).click();
    }
    public void insertEmailAndPassword(String email , String password){
        Hooks.driver.findElement(emailField).sendKeys(email);
        Hooks.driver.findElement(passwordField).sendKeys(password);
    }
    public void clickOnLoginBtn(){
        Hooks.driver.findElement(loginBtn).click();
    }
    public boolean verifyLoginSuccessfully(){
        return Hooks.driver.findElement(myAccountTab).isDisplayed();
    }
    public WebElement verifyLoginIsFailed(){
        return Hooks.driver.findElement(loginMsg);
    }
}
