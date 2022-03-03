package PageObjects;

//import StepDefinitions.Hooks;
import BaseClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BaseClass{

    private final BaseClass base;

    public ProductsPage(BaseClass base) {
        this.base = base;
    }

    By filterBy = By.cssSelector("[data-test=product_sort_container]");
    By itemNames = By.className("inventory_item_name");
    By itemPrices = By.className("inventory_item_price");
    By pageTitle = By.className("title");

    public void filterItems(String filter) {
        Select filters = new Select(base.driver.findElement(filterBy));
        filters.selectByVisibleText(filter);
    }

    public String currentPage() {
        return base.driver.findElement(pageTitle).getText();
    }

    public boolean filterItemsAtoZ() {
        List<WebElement> elems = base.driver.findElements(itemNames);
        List<String> titles = new ArrayList<>();
        for (final WebElement elem : elems) {
            titles.add(elem.getText());
        }
        String previous = "";
        for (String current : titles) {
            if (current.compareTo(previous) < 0) {
                return false;
            }
            previous = current;
        }
        return true;
    }

    public boolean filterItemsZtoA() {
        List<WebElement> elems = base.driver.findElements(itemNames);
        List<String> titles = new ArrayList<>();
        for (final WebElement elem : elems) {
            titles.add(elem.getText());
        }
        String previous = "z";
        for (String current : titles) {
            if (current.compareTo(previous) > 0) {
                return false;
            }
            previous = current;
        }
        return true;
    }

    public boolean filterPriceLowToHigh() {
        List<WebElement> elems = base.driver.findElements(itemPrices);
        List<Double> prices = new ArrayList<>();
        for (final WebElement elem : elems) {
            String price = elem.getText().substring(1);
            prices.add(Double.parseDouble(price));
        }
        int i;
        for (i = 1; i < prices.size(); i++) {
            if (prices.get(i) < prices.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean filterPriceHighToLow() {
        List<WebElement> elems = base.driver.findElements(itemPrices);
        List<Double> prices = new ArrayList<>();
        for (final WebElement elem : elems) {
            String price = elem.getText().substring(1);
            prices.add(Double.parseDouble(price));
        }
        int i;
        for (i = 1; i < prices.size(); i++) {
            if (prices.get(i) > prices.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

}
