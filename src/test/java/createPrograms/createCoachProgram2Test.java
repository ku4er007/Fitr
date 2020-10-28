package createPrograms;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class createCoachProgram2Test extends forCreatePrograms {
    @BeforeMethod
    public void navigateToUrl() {
        driver.get(loginUrl);
    }


    @Test
    positiveCreateCoachProgramTest(){

    }
}
