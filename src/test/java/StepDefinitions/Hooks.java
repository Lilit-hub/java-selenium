package StepDefinitions;
import BaseClass.BaseClass;
import io.cucumber.java.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks extends BaseClass {

    private BaseClass base;

    public Hooks(BaseClass base) {
        this.base = base;
    }

    @Before
    public void initDriver() {
        System.out.println("Open browser");
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        base.driver = new ChromeDriver();
        base.driver.manage().window().maximize();
//        base.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void teardown() {
        System.out.println("Close browser");
        base.driver.close();
        base.driver.quit();
    }
}