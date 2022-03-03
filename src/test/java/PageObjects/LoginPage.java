package PageObjects;
import BaseClass.BaseClass;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseClass{

    private final BaseClass base;

    public LoginPage(BaseClass base) {
        this.base = base;
    }

    By loginBtn = By.id("login-button");
    By usernameField = By.cssSelector("[data-test=username]");
    By passwordField = By.cssSelector("[data-test=password]");
    By errorMsgContainer = By.cssSelector("[data-test=error]");
    By menuBtn = By.id("react-burger-menu-btn");
    By loginLogo = By.className("login_logo");


    public void fillUsernameField(String username){
        base.driver.findElement(usernameField).sendKeys(username);
    }

    public void fillPasswordField(String password){
        base.driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginBtn() {
        base.driver.findElement(loginBtn).click();
    }

    public void loginPage() {
        base.driver.get(base.baseURL);
    }

    public void urlContains(String str) {
        String url = base.driver.getCurrentUrl();
        Assertions.assertTrue(url.contains(str));
    }

    public String errorMsg(){
        return base.driver.findElement(errorMsgContainer).getText();
    }

    public void clickBtnSidebarMenu(String name){
        WebDriverWait wait = new WebDriverWait(base.driver, 15);

        By btnSidebarMenu = By.xpath("//a[contains(text(), '" + name + "')]");
        base.driver.findElement(menuBtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnSidebarMenu));
        base.driver.findElement(btnSidebarMenu).click();
    }

    public boolean loginPageOpens(){
        return base.driver.findElement(loginLogo).isDisplayed();
    }

}
