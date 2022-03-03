package StepDefinitions;

import PageObjects.ProductsPage;
import BaseClass.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ProductsSteps extends ProductsPage {


    public ProductsSteps(BaseClass base) {
        super(base);
    }

    @Given("^\"([^\"]*)\" page is open$")
    public void currentPage(String title) {
        Assertions.assertEquals(title, super.currentPage());
    }

    @When("^I filter items by \"([^\"]*)\"$")
    public void filterItems(String filter) {
        super.filterItems(filter);
    }

    @Then("^I verify that items are ordered by \"([^\"]*)\"$")
    public void filter(String filter) {
        switch (filter) {
            case "Name (A to Z)":
                System.out.println(super.filterItemsAtoZ());
                Assertions.assertTrue(super.filterItemsAtoZ());
                break;
            case "Name (Z to A)":
                System.out.println(super.filterItemsZtoA());
                Assertions.assertTrue(super.filterItemsZtoA());
                break;
            case "Price (low to high)":
                System.out.println(super.filterPriceLowToHigh());
                Assertions.assertTrue(super.filterPriceLowToHigh());
                break;
            case "Price (high to low)":
                System.out.println(super.filterPriceHighToLow());
                Assertions.assertTrue(super.filterPriceHighToLow());
                break;
        }
    }

}
