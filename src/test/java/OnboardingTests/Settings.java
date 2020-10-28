package OnboardingTests;

import OnboardingTests.forFitr;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.testng.AssertJUnit.assertEquals;

public class Settings extends forFitr {
    String loginUrl = "https://dev.fitr.training/onboarding/sign_in";
    String generalSettingUrl = "https://dev.fitr.training/coach/profile/info";
    String payoutsSettingUrl = "https://dev.fitr.training/coach/profile/payouts";
    String emailsSettingUrl = "https://dev.fitr.training/coach/profile/settings";
    String passwordSettingUrl = "https://dev.fitr.training/coach/profile/password";
    String email = "ku4er007@gmail.com";
    String password = "vndzqh2sgn";
    String newPassword = "vndzqh2sgn";
    String wrongPassword = "        ";
    By loginPageTitle = By.xpath("//h1");
    By emailInputField = By.xpath("//input[@id='email']");
    By passwordInputField = By.name("current-password");
    By loginToFitrButton = By.xpath("//button");
    By programsHeaderElement = By.xpath("//a[@class='nav-link active']");
    By userAvatarHeaderElement = By.xpath("//div[@class='avatar sm2 circle avatar-empty fit_cover']");
    By settingsButton = By.xpath("//a[@href='/coach/profile/payouts']");
    By generalTab = By.xpath("//a[@href='/coach/profile/info']");
    By payoutsTab = By.xpath("//a[@href='/coach/profile/payouts'][contains(text(),'Payouts')]");
    By emailsTab = By.xpath("//a[@href='/coach/profile/settings'][contains(text(),'Emails')]");
    By passwordTab = By.xpath("//a[@href='/coach/profile/password'][contains(text(),'Password')]");
    By oldPasswordInputField = By.xpath("//input[@class='form-control'][@placeholder='Old Password']");
    By newPasswordInputField = By.xpath("//input[@class='form-control'][@placeholder='New Password']");
    By confirmNewPasswordInputField = By.xpath("//input[@class='form-control'][@placeholder='Repeat New Password']");
    By submitNewPasswordButton = By.xpath("//button[@type='submit']");
    By invalidPasswordText = By.xpath("//div[@class='invalid-feedback']");
    By warningEmptyPasswordFields = By.xpath("//div[@class='custom-template-title']");
    By changePasswordPageTitle = By.xpath("//h3");
    By logOutButton = By.xpath("//button[@class='btn btn-outline-danger']");

    @BeforeMethod
    public void navigateToUrl() {
        driver.get(loginUrl);
//        driver.manage().window().maximize();
    }


    @Test
    public void positiveSwitchBetweenGeneralTest() {
        wait.until(visibilityOfElementLocated(loginPageTitle));
        driver.findElement(emailInputField).sendKeys(email);
        driver.findElement(passwordInputField).sendKeys(password);
        driver.findElement(loginToFitrButton).click();
        wait.until(visibilityOfElementLocated(programsHeaderElement));
        driver.findElement(userAvatarHeaderElement).click();
        driver.findElement(settingsButton).click();
        wait.until(visibilityOfElementLocated(generalTab)).click();
        assertEquals(driver.getCurrentUrl(), generalSettingUrl);
        driver.findElement(payoutsTab).click();
        assertEquals(driver.getCurrentUrl(), payoutsSettingUrl);
        driver.findElement(emailsTab).click();
        assertEquals(driver.getCurrentUrl(), emailsSettingUrl);
        driver.findElement(passwordTab).click();
        assertEquals(driver.getCurrentUrl(), passwordSettingUrl);
        driver.findElement(userAvatarHeaderElement).click();
        driver.findElement(logOutButton).click();
        wait.until(visibilityOfElementLocated(loginPageTitle));
    }

    @Test
    public void positiveChangePasswordTest() {
        wait.until(visibilityOfElementLocated(loginPageTitle));
        driver.findElement(emailInputField).sendKeys(email);
        driver.findElement(passwordInputField).sendKeys(password);
        driver.findElement(loginToFitrButton).click();
        wait.until(visibilityOfElementLocated(programsHeaderElement));
        driver.findElement(userAvatarHeaderElement).click();
        driver.findElement(settingsButton).click();
        wait.until(visibilityOfElementLocated(passwordTab)).click();
        wait.until(visibilityOfElementLocated(changePasswordPageTitle));
        driver.findElement(oldPasswordInputField).sendKeys(password);
        driver.findElement(newPasswordInputField).sendKeys(newPassword);
        driver.findElement(confirmNewPasswordInputField).sendKeys(newPassword);
        driver.findElement(submitNewPasswordButton).click();
        assertEquals(driver.getCurrentUrl(), passwordSettingUrl);
        driver.findElement(userAvatarHeaderElement).click();
        driver.findElement(logOutButton).click();
        wait.until(visibilityOfElementLocated(loginPageTitle));

    }

    @Test
    public void negativeChangeDoNotMatchPasswordTest() {
        wait.until(visibilityOfElementLocated(loginPageTitle));
        driver.findElement(emailInputField).sendKeys(email);
        driver.findElement(passwordInputField).sendKeys(password);
        driver.findElement(loginToFitrButton).click();
        wait.until(visibilityOfElementLocated(programsHeaderElement));
        driver.findElement(userAvatarHeaderElement).click();
        driver.findElement(settingsButton).click();
        wait.until(visibilityOfElementLocated(passwordTab)).click();
        wait.until(visibilityOfElementLocated(changePasswordPageTitle));
        driver.findElement(oldPasswordInputField).sendKeys(password);
        driver.findElement(newPasswordInputField).sendKeys(newPassword);
        driver.findElement(confirmNewPasswordInputField).sendKeys(wrongPassword);
        driver.findElement(submitNewPasswordButton).click();
        wait.until(visibilityOfElementLocated(invalidPasswordText));
        driver.findElement(userAvatarHeaderElement).click();
        driver.findElement(logOutButton).click();
        wait.until(visibilityOfElementLocated(loginPageTitle));
    }
    @Test
    public void negativeChangeWrongPasswordTest() {
        wait.until(visibilityOfElementLocated(loginPageTitle));
        driver.findElement(emailInputField).sendKeys(email);
        driver.findElement(passwordInputField).sendKeys(password);
        driver.findElement(loginToFitrButton).click();
        wait.until(visibilityOfElementLocated(programsHeaderElement));
        driver.findElement(userAvatarHeaderElement).click();
        driver.findElement(settingsButton).click();
        wait.until(visibilityOfElementLocated(passwordTab)).click();
        wait.until(visibilityOfElementLocated(changePasswordPageTitle));
        driver.findElement(oldPasswordInputField).sendKeys(password);
        driver.findElement(newPasswordInputField).sendKeys(wrongPassword);
        driver.findElement(confirmNewPasswordInputField).sendKeys(wrongPassword);
        driver.findElement(submitNewPasswordButton).click();
        wait.until(visibilityOfElementLocated(warningEmptyPasswordFields));
        driver.findElement(userAvatarHeaderElement).click();
        driver.findElement(logOutButton).click();
        wait.until(visibilityOfElementLocated(loginPageTitle));
    }
}