package org.example.stepDef;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class D03_currenciesStepDef {
    P03_homePage p03_homePage = new P03_homePage();
    Select currencyList = new Select(Hooks.driver.findElement(By.id("customerCurrency")));
    @When("user select euro currency")
    public void userSelectEuroCurrency() {
        currencyList.selectByIndex(1);

    }

    @Then("euro symbol is shown on the four products displayed in Home page")
    public void euroSymbolIsShownOnTheFourProductsDisplayedInHomePage() {
        for (int i = 0 ; i < p03_homePage.iterateOverProducts().size(); i++){
            String currencyChecker = p03_homePage.iterateOverProducts().get(i).getText();
            Assert.assertTrue(currencyChecker.contains("€"));
        }
    }
}
