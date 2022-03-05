package StepDefinitions;
import BaseClass.BaseClass;
import io.cucumber.java.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks extends BaseClass {

    private BaseClass base;

    public Hooks(BaseClass base) {
        this.base = base;
    }

    @Before
    public void initDriver() {
        System.out.println("Open browser");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\david\\Documents\\java-selenium\\driver\\chromedriver.exe");
        base.driver = new ChromeDriver();
        base.driver.manage().window().maximize();
    }

    @After
    public void teardown() {
        System.out.println("Close browser");
        base.driver.close();
        base.driver.quit();
    }
}
