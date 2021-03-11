package createPrograms;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class forCreatePrograms {
    WebDriver driver;
    WebDriverWait wait;

    String loginUrl = "https://dev.fitr.training/onboarding/sign_in";
    By loginPageTitle = By.xpath("//h1");
    By emailInputField = By.xpath("//input[@id='email']");
    By passwordInputField = By.name("current-password");
    By loginToFitrButton = By.xpath("//button");
    String email = "ku4er007+10@gmail.com";
    String password = "Zaq123";
    By programsHeaderElement = By.xpath("//a[@class='nav-link active']");


    @BeforeClass
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
