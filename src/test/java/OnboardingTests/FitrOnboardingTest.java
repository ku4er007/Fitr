package OnboardingTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.testng.AssertJUnit.assertEquals;

public class FitrOnboardingTest extends forFitr {
    String loginUrl = "https://dev.fitr.training/onboarding/sign_in";
    String forgotPgaeUrl = "https://dev.fitr.training/onboarding/forgot_password";
    String email = "ku4er007@gmail.com";
    String unexistingEmail = "test@ttttest.com";
    String wrongPassword1 = "zaq 123";
    String wrongPassword2 = ".      ";
    String wrongPassword3 = "       ";
    String password = "vndzqh2sgn";
    By loginPageTitle = By.xpath("//h1");
    By forgotPageTitlt = By.xpath("//h1[contains(text(),'FORGOT PASSWORD')]");
    By emailInputField = By.xpath("//input[@id='email']");
    By passwordInputField = By.name("current-password");
    By loginToFitrButton = By.xpath("//button");
    By closedAlertButton = By.xpath("//div[@class='custom-template-close']");
    By forgotLink = By.xpath("//a[@href='/onboarding/forgot_password']");
    By programsHeaderElement = By.xpath("//a[@class='nav-link active']");
    By userAvatarHeaderElement = By.xpath("//div[@class='avatar sm2 circle avatar-empty fit_cover']");
    By logOutButton = By.xpath("//button[@class='btn btn-outline-danger']");
    By cancelForgotButton = By.xpath("//a[@href='/onboarding/sign_in']");
    By congratsAlert = By.xpath("//div[@class='custom-template-title']");
    By invalidMessage = By.xpath("//div[@class='invalid-feedback']");


    @BeforeMethod
    public void navigateToUrl() {
        driver.get(loginUrl);
//        driver.manage().window().maximize();

    }

    @Test
    public void negativeLoginWrongPassword1Test1() {
        wait.until(visibilityOfElementLocated(loginPageTitle));
        driver.findElement(emailInputField).sendKeys(email);
        driver.findElement(passwordInputField).sendKeys(wrongPassword1);
        driver.findElement(loginToFitrButton).click();
        wait.until(visibilityOfElementLocated(closedAlertButton));
        driver.findElement(closedAlertButton).click();
        assertEquals(driver.getCurrentUrl(), loginUrl);
    }

    @Test
    public void negativeLoginWrongPassword2Test1() {
        wait.until(visibilityOfElementLocated(loginPageTitle));
        driver.findElement(emailInputField).sendKeys(email);
        driver.findElement(passwordInputField).sendKeys(wrongPassword2);
        driver.findElement(loginToFitrButton).click();
        wait.until(visibilityOfElementLocated(closedAlertButton));
        driver.findElement(closedAlertButton).click();
        assertEquals(driver.getCurrentUrl(), loginUrl);
    }

    @Test
    public void negativeLoginEmptyPassword3Test1() {
        wait.until(visibilityOfElementLocated(loginPageTitle));
        driver.findElement(emailInputField).sendKeys(email);
        driver.findElement(passwordInputField).sendKeys(wrongPassword3);
        driver.findElement(invalidMessage);
        assertEquals(driver.getCurrentUrl(), loginUrl);
    }

    @Test
    public void negativeLoginWrongEmailTest2() {
        wait.until(visibilityOfElementLocated(loginPageTitle));
        driver.findElement(emailInputField).sendKeys(unexistingEmail);
        driver.findElement(passwordInputField).sendKeys(password);
        driver.findElement(loginToFitrButton).click();
        wait.until(visibilityOfElementLocated(closedAlertButton));
        driver.findElement(closedAlertButton).click();
        assertEquals(driver.getCurrentUrl(), loginUrl);
    }

    @Test
    public void positiveGoToForgotPasswordPageTest4() {
        wait.until(visibilityOfElementLocated(loginPageTitle));
        driver.findElement(forgotLink).click();
        wait.until(presenceOfElementLocated(forgotPageTitlt));
    }

    @Test
    public void negativeForgotPasswordProcessWrongEmailTest5() {
        wait.until(visibilityOfElementLocated(loginPageTitle));
        driver.findElement(forgotLink).click();
        wait.until(presenceOfElementLocated(forgotPageTitlt));
        driver.findElement(emailInputField).sendKeys(unexistingEmail + Keys.ENTER);
        wait.until(visibilityOfElementLocated(closedAlertButton));
        driver.findElement(closedAlertButton).click();
        assertEquals(driver.getCurrentUrl(), forgotPgaeUrl);
    }

    @Test
    public void negativeForgotPasswordProcessValidEmailTipsTest6() {
        wait.until(visibilityOfElementLocated(loginPageTitle));
        driver.findElement(forgotLink).click();
        wait.until(presenceOfElementLocated(forgotPageTitlt));
        driver.findElement(emailInputField).sendKeys("    / " + Keys.ENTER);
        wait.until(visibilityOfElementLocated(invalidMessage));
    }

    @Test
    public void positiveNavigateOnLoginFromFogotPasswordPageTest7() {
        wait.until(visibilityOfElementLocated(loginPageTitle));
        driver.findElement(forgotLink).click();
        wait.until(presenceOfElementLocated(forgotPageTitlt));
        driver.findElement(cancelForgotButton).click();
        assertEquals(driver.getCurrentUrl(), loginUrl);
    }

    @Test
    public void positiveForgotPasswordProcessTest8() {
        wait.until(visibilityOfElementLocated(loginPageTitle));
        driver.findElement(forgotLink).click();
        wait.until(presenceOfElementLocated(forgotPageTitlt));
        driver.findElement(emailInputField).sendKeys(email + Keys.ENTER);
        wait.until(visibilityOfElementLocated(congratsAlert));
        driver.findElement(closedAlertButton).click();
        assertEquals(driver.getCurrentUrl(), loginUrl);
    }

    @Test
    public void positiveLoginTest3() {
        wait.until(visibilityOfElementLocated(loginPageTitle));
        driver.findElement(emailInputField).sendKeys(email);
        driver.findElement(passwordInputField).sendKeys(password);
        driver.findElement(loginToFitrButton).click();
        wait.until(visibilityOfElementLocated(programsHeaderElement));
        driver.findElement(userAvatarHeaderElement).click();
        wait.until(visibilityOfElementLocated(logOutButton)).click();
        wait.until(visibilityOfElementLocated(loginPageTitle));
    }
}
