package OnboardingTests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.testng.AssertJUnit.assertEquals;

public class OnboardingTestFitr extends forFitr {
    String loginUrl = "https://dev.fitr.training/onboarding/sign_in";
    String signUpUrl = "https://dev.fitr.training/onboarding/role";
    By userAvatarHeaderElement = By.xpath("//div[@class='avatar sm2 circle avatar-empty fit_cover']");
    By logOutButton = By.xpath("//button[@class='btn btn-outline-danger']");
    By loginPageTitle = By.xpath("//h1");
    By signupHyperlink = By.xpath("//a[@href='/onboarding/role']");
    By loginHyperlink = By.xpath("//a[@href='/onboarding/sign_in']");
    By coachButton = By.xpath("//a[@class='onboarding-link onboarding-link_coach']");
    By standaloneCoachButton = By.xpath("//a[@class='onboarding-link' and @id='standalonestart']");
    By firstNameInputFieldLabel = By.xpath("//label[contains(text(),'First Name')]");
    By firstNameInputField = By.xpath("//input[@id='first_name']");
    By lastNameInputField = By.xpath("//input[@id='last_name']");
    By emailInputField = By.xpath("//input[@id='email']");
    By dateOfBirthMenu = By.xpath("//input[@placeholder='DD/MM/YYYY']");
    By calendarSelector = By.xpath("//div[@class='mx-calendar mx-calendar-panel-date']");
    By yearSelector = By.xpath("//button[@class='mx-btn mx-btn-text mx-btn-current-year']");
    By previousYearButton = By.xpath("//button[@class='mx-btn mx-btn-text mx-btn-icon-double-left']");
    By birthYear = By.xpath("//td[@data-year='1992']");
    By birthMonth = By.xpath("//td[@data-month='7']");
    By birthDay = By.xpath("//td[@data-day='23']");
    By passwordInputField = By.xpath("//input[@id='password']");
    By confirmPasswordInputField = By.xpath("//input[@id='confirm_password']");
    By agreeCheckBox = By.xpath("//div[@class='custom-control custom-checkbox']");
    By startTrialButton = By.xpath("//button[@id='coachsignup']");
    By firstAlertDescription = By.xpath("//p[@class='mb-0']");
    By closedAlertButton = By.xpath("//button[@class='close']");
    By programsHeaderElement = By.xpath("//a[@class='nav-link active']");
    String firstName = "Константин";
    String lastName = "Дорошенко";
    String newEmail = "ku4er007+111@gmail.com";
    String newPassword = "Zaq123123!";
    String confirmNewPassword = "Zaq123123!";


    @BeforeMethod
    public void navigateToUrl() {
        driver.get(loginUrl);
//        driver.manage().window().maximize();
    }

    @Test
    public void positiveGoToSignUpAndReturnOnLoginPageTest9() {
        wait.until(visibilityOfElementLocated(loginPageTitle));
        driver.findElement(signupHyperlink).click();
        assertEquals(driver.getCurrentUrl(), signUpUrl);
        wait.until(visibilityOfElementLocated(loginHyperlink)).click();
        wait.until(visibilityOfElementLocated(loginPageTitle));
        assertEquals(driver.getCurrentUrl(), loginUrl);
    }

    @Test
    public void positiveSignUpAsCoachStandaloneCoachTest9() {
        driver.findElement(signupHyperlink).click();
        assertEquals(driver.getCurrentUrl(), signUpUrl);
        wait.until(visibilityOfElementLocated(coachButton));
        driver.findElement(coachButton).click();
        wait.until(visibilityOfElementLocated(standaloneCoachButton)).click();
        wait.until(visibilityOfElementLocated(firstNameInputFieldLabel));
        driver.findElement(firstNameInputField).sendKeys(firstName);
        driver.findElement(lastNameInputField).sendKeys(lastName);
        driver.findElement(emailInputField).sendKeys(newEmail);
        driver.findElement(dateOfBirthMenu).click();
        wait.until(visibilityOfElementLocated(calendarSelector));
        driver.findElement(yearSelector).click();
        wait.until(visibilityOfElementLocated(previousYearButton)).click();
        wait.until(visibilityOfElementLocated(birthYear)).click();
        wait.until(visibilityOfElementLocated(birthMonth)).click();
        wait.until(visibilityOfElementLocated(birthDay)).click();
        driver.findElement(passwordInputField).sendKeys(newPassword);
        driver.findElement(confirmPasswordInputField).sendKeys(confirmNewPassword);
        driver.findElement(agreeCheckBox).click();
        driver.findElement(startTrialButton).click();
        wait.until(visibilityOfElementLocated(firstAlertDescription));
        driver.findElement(closedAlertButton).click();
        wait.until(visibilityOfElementLocated(programsHeaderElement));
        driver.findElement(userAvatarHeaderElement).click();
        driver.findElement(logOutButton).click();
        wait.until(visibilityOfElementLocated(loginPageTitle));

    }
}
