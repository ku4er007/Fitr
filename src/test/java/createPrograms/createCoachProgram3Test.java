package createPrograms;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.testng.AssertJUnit.assertEquals;

public class createCoachProgram3Test extends forCreatePrograms{
    By userAvatarHeaderElement = By.xpath("//div[@class='avatar sm2 circle avatar-empty fit_cover']");
    By logOutButton = By.xpath("//button[@class='btn btn-outline-danger']");
    By createBewProgramButton = By.xpath("//a[@href='/coach/programs/create/choose-plan-type'][contains(text(),'Create new Program')]");
    By groupRollingCalendarCreateProgramHeaderButton = By.xpath("//li[@class='nav-item'][3]");
    By groupRollingCalendarCreateProgramButton = By.xpath("//button[@data-gtm-id='coachcreatesonemany']");
    By programTitleInputField = By.xpath("//input[@placeholder='[Edit] Group Calendar Programming']");
    By requiredExperienceSelector = By.xpath("//div[@class='rate']");
    By requiredExperienceSelectorChange = By.xpath("//button[@class='rate__star'][4]"); //number [4] changes the selected value for the account
    By dailyTrainingTimeInputField = By.xpath("//input[@id='average_duration']");
    By daysPerWeekInputField = By.xpath("//input[@id='weeks_duration']");
    By sessionsPerDayInputField = By.xpath("//input[@id='sections_duration']");
    By descriptionProgramInputField = By.xpath("//textarea[@rows='2']");
    By step2Button = By.xpath("//button[@class='tab-link step-link']");
    By gotItAlertButton = By.xpath("//button[@class='btn btn-primary'][contains(text(),'Got It')]");
    By publishTheProgramButton = By.xpath("//button[@class='btn btn-primary'][contains(text(),'Publish the Program')]");
    By publishMyProgramButton = By.xpath("//button[@class='btn btn-primary'][contains(text(),'Publish my Program')]");
    By nextButtonInPublishProcess = By.xpath("//button[@data-gtm-id='coachprogressespastsharing']");
    By startProgrammingButton = By.xpath("//a[@class='btn btn-primary m-auto m-md-0']");


    @BeforeMethod
    public void navigateToUrl() {
        driver.get(loginUrl);
    }

    @Test
    public void positiveCreateCoachProgramTest3(){
        wait.until(visibilityOfElementLocated(loginPageTitle));
        driver.findElement(emailInputField).sendKeys(email);
        driver.findElement(passwordInputField).sendKeys(password);
        driver.findElement(loginToFitrButton).click();
        wait.until(visibilityOfElementLocated(programsHeaderElement));
        wait.until(visibilityOfElementLocated(createBewProgramButton)).click();
        wait.until(visibilityOfElementLocated(groupRollingCalendarCreateProgramHeaderButton)).click();
        wait.until(visibilityOfElementLocated(groupRollingCalendarCreateProgramButton)).click();
        wait.until(visibilityOfElementLocated(programTitleInputField)).click();
        driver.findElement(programTitleInputField).sendKeys("Test Title 888");


        wait.until(visibilityOfElementLocated(requiredExperienceSelector));
        driver.findElement(requiredExperienceSelectorChange).click();
        driver.findElement(dailyTrainingTimeInputField).sendKeys("20");
        driver.findElement(daysPerWeekInputField).sendKeys("7");
        driver.findElement(sessionsPerDayInputField).sendKeys("3");
        driver.findElement(descriptionProgramInputField).sendKeys("test test test");
        driver.findElement(step2Button).click();
        wait.until(visibilityOfElementLocated(gotItAlertButton)).click();

        driver.findElement(publishTheProgramButton).click();
        wait.until(visibilityOfElementLocated(By.xpath("//div[@class='alert alert-fancy']")));
        driver.findElement(publishMyProgramButton).click();
        wait.until(visibilityOfElementLocated(By.xpath("//h4")));
        driver.findElement(nextButtonInPublishProcess).click();
        wait.until(visibilityOfElementLocated(By.xpath("//h4")));
        driver.findElement(startProgrammingButton).click();
        wait.until(visibilityOfElementLocated(gotItAlertButton)).click();


        wait.until(visibilityOfElementLocated(By.xpath("//a[@href='/coach/programs']"))).click();
        wait.until(visibilityOfElementLocated(By.xpath("//h2")));
        assertEquals(driver.getCurrentUrl(), "https://dev.fitr.training/coach/programs/active");
        driver.findElement(userAvatarHeaderElement).click();
        driver.findElement(logOutButton).click();
        wait.until(visibilityOfElementLocated(loginPageTitle));
    }
}
