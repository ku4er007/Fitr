package createPrograms;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.testng.AssertJUnit.assertEquals;

public class createCoachProgram1Test extends forCreatePrograms {
    By userAvatarHeaderElement = By.xpath("//div[@class='avatar sm2 circle avatar-empty fit_cover']");
    By logOutButton = By.xpath("//button[@class='btn btn-outline-danger']");

    @BeforeMethod
    public void navigateToUrl() {
        driver.get(loginUrl);
    }

    @Test
    public void positiveCreateCoachProgramTest(){
        wait.until(visibilityOfElementLocated(loginPageTitle));
        driver.findElement(emailInputField).sendKeys(email);
        driver.findElement(passwordInputField).sendKeys(password);
        driver.findElement(loginToFitrButton).click();
        wait.until(visibilityOfElementLocated(programsHeaderElement));
        wait.until(visibilityOfElementLocated(By.xpath("//a[@href='/coach/programs/create/choose-plan-type'][contains(text(),'Create new Program')]"))).click();
        wait.until(visibilityOfElementLocated(By.xpath("//a[@class='nav-link active']")));
        driver.findElement(By.xpath("//button[@data-gtm-id='coachcreatesbespoke']")).click();

        wait.until(visibilityOfElementLocated(By.xpath("//h5")));
        driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(),'Yes, continue')]")).click();
        wait.until(visibilityOfElementLocated(By.xpath("//input[@placeholder='[Edit] Individualised Programming']"))).click();
        driver.findElement(By.xpath("//input[@placeholder='[Edit] Individualised Programming']")).sendKeys("Test Title");
        wait.until(visibilityOfElementLocated(By.xpath("//div[@class='rate']")));
        driver.findElement(By.xpath("//button[@class='rate__star'][4]")).click();
        driver.findElement(By.xpath("//input[@id='average_duration']")).sendKeys("20");
        driver.findElement(By.xpath("//input[@id='weeks_duration']")).sendKeys("7");
        driver.findElement(By.xpath("//input[@id='sections_duration']")).sendKeys("3");
        driver.findElement(By.xpath("//textarea[@rows='2']")).sendKeys("test test test");
        driver.findElement(By.xpath("//button[@class='tab-link step-link']")).click();

        wait.until(visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary'][contains(text(),'Got It')]"))).click();
        wait.until(visibilityOfElementLocated(By.xpath("//div[@id='step-title']")));


        driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(),'Publish the Program')]")).click();

//        assertEquals(driver.switchTo().alert().getText(), "This is a preview of how prospective clients will view your programming before signing up");
//        driver.switchTo().alert().dismiss();

        wait.until(visibilityOfElementLocated(By.xpath("//div[@class='alert alert-fancy']")));
        driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(),'Publish my Program')]")).click();
        wait.until(visibilityOfElementLocated(By.xpath("//h4")));
        driver.findElement(By.xpath("//button[@data-gtm-id='coachprogressespastsharing']")).click();
        wait.until(visibilityOfElementLocated(By.xpath("//h4")));
        driver.findElement(By.xpath("//a[@class='btn btn-primary m-auto m-md-0']")).click();
        wait.until(visibilityOfElementLocated(By.xpath("//button[@class='close']"))).click();
        wait.until(visibilityOfElementLocated(By.xpath("//a[@href='/coach/programs']"))).click();
        wait.until(visibilityOfElementLocated(By.xpath("//h2")));
        assertEquals(driver.getCurrentUrl(), "https://dev.fitr.training/coach/programs/active");
        driver.findElement(userAvatarHeaderElement).click();
        driver.findElement(logOutButton).click();
        wait.until(visibilityOfElementLocated(loginPageTitle));
    }
}
