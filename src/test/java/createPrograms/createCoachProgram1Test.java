package createPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.testng.AssertJUnit.assertEquals;

public class createCoachProgram1Test extends forCreatePrograms {
//    Actions actions = new Actions(driver);

    By userAvatarHeaderElement = By.xpath("//div[@class='avatar sm2 circle avatar-empty fit_cover']");
    By logOutButton = By.xpath("//button[@class='btn btn-outline-danger']");
    By createNewProgramButton = By.xpath("//a[@href='/coach/programs/create/choose-plan-type'][contains(text(),'Create new Program')]");
    By customCreateProgramButton = By.xpath("//button[@data-gtm-id='coachcreatesbespoke']");
    By yesContinueAlertButton = By.xpath("//button[@class='btn btn-primary'][contains(text(),'Yes, continue')]");
    By programTitleInputField = By.xpath("//input[@placeholder='[Edit] Individualised Programming']");
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
        driver.manage().window().maximize();

    }


    @Test
    public void positiveCreateCoachProgramTest() {
        wait.until(visibilityOfElementLocated(loginPageTitle));
        driver.findElement(emailInputField).sendKeys(email);
        driver.findElement(passwordInputField).sendKeys(password);
        driver.findElement(loginToFitrButton).click();
        wait.until(visibilityOfElementLocated(programsHeaderElement));
        wait.until(visibilityOfElementLocated(createNewProgramButton)).click();
        wait.until(visibilityOfElementLocated(programsHeaderElement));
        driver.findElement(customCreateProgramButton).click();

        wait.until(visibilityOfElementLocated(By.xpath("//h5")));
        driver.findElement(yesContinueAlertButton).click();

        //scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)", "");
        wait.until(visibilityOfElementLocated(programTitleInputField)).click();
        driver.findElement(programTitleInputField).sendKeys("Test Title");
        //scroll


        wait.until(visibilityOfElementLocated(requiredExperienceSelector));
        driver.findElement(requiredExperienceSelectorChange).click();
        driver.findElement(dailyTrainingTimeInputField).sendKeys("20");
        driver.findElement(daysPerWeekInputField).sendKeys("7");
        driver.findElement(sessionsPerDayInputField).sendKeys("3");
        driver.findElement(descriptionProgramInputField).sendKeys("test test test");
        driver.findElement(step2Button).click();
//
//        wait.until(visibilityOfElementLocated(By.xpath("//iframe[@name='intercom-tour-frame']")));
//        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='intercom-tour-frame']")));
//        driver.findElement(By.xpath("//span[@aria-label='Close']")).click();
//        driver.switchTo().parentFrame();

        wait.until(visibilityOfElementLocated(gotItAlertButton)).click();
//        wait.until(visibilityOfElementLocated(By.xpath("//iframe[@name='intercom-tour-frame']")));

//        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='intercom-tour-frame']")));
//        driver.findElement(By.xpath("//span[@aria-label='Close']")).click();
//        driver.switchTo().parentFrame();
//        wait.until(visibilityOfElementLocated(By.xpath("//div[@id='step-title']")));
//        driver.findElement(By.xpath("//span[@aria-label='Close']")).click();
        //scroll
        js.executeScript("window.scrollBy(0,700)", "");

        driver.findElement(publishTheProgramButton).click();
        wait.until(visibilityOfElementLocated(By.xpath("//div[@class='alert alert-fancy']")));
////
        wait.until(visibilityOfElementLocated(By.xpath("//iframe[@name='intercom-tour-frame']")));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='intercom-tour-frame']")));
        driver.findElement(By.xpath("//span[@aria-label='Close']")).click();
        driver.switchTo().parentFrame();
        //////
        driver.findElement(publishMyProgramButton).click();
        wait.until(visibilityOfElementLocated(By.xpath("//h4")));
        driver.findElement(nextButtonInPublishProcess).click();
        wait.until(visibilityOfElementLocated(By.xpath("//h4")));
        driver.findElement(startProgrammingButton).click();
        wait.until(visibilityOfElementLocated(By.xpath("//button[@class='close']"))).click();
        wait.until(visibilityOfElementLocated(programsHeaderElement)).click();
        wait.until(visibilityOfElementLocated(By.xpath("//h2")));
        assertEquals(driver.getCurrentUrl(), "https://dev.fitr.training/coach/programs/active");
        driver.findElement(userAvatarHeaderElement).click();
        driver.findElement(logOutButton).click();
        wait.until(visibilityOfElementLocated(loginPageTitle));
    }
}
