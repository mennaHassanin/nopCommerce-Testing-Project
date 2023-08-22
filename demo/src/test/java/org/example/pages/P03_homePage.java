package org.example.pages;

import org.example.stepDef.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class P03_homePage {
    //1-elements
    By currency = By.id("customerCurrency");
    //Select currencyList = new Select(Hooks.driver.findElement(currency))
    By products = By.className("price actual-price");

    //2-actions
    public Select selectCurrency (){
        Select currencyList = new Select(Hooks.driver.findElement(currency));
        return currencyList;
    }
    public List<WebElement> iterateOverProducts(){
        List<WebElement> productsCurrency = Hooks.driver.findElements(products);
        return productsCurrency;
    }

}
