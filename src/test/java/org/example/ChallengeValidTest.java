package org.example;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ChallengeValidTest extends BaseTest {
    private final ChallengePage challengePage = new ChallengePage();

    @Test(description = "Verify first name field, submit button is visible")
    public void test1() {
        challengePage.verifyFirstNameFieldVisible();
        challengePage.verifySubmitButtonVisible();
    }

    @Test(description = "Validate First Name field - is field is 'required'")
    public void test2() {
        challengePage.verifyFirstNameLabel("First Name");
        challengePage.verifyFirstNameRequiredMarkVisible();
    }

    @Test(description = "Validate First Name field - valid names", dataProvider = "validNames", dataProviderClass = ChallengeValidTest.class)
    public void test3(String name) {
        challengePage.enterFirstName(name);
        challengePage.submitLoginForm();

        // next steps - verify that the user logged in
    }

    @DataProvider(name = "validNames")
    private Object[][] validNames() {
        return new Object[][]
                {
                        {"Gheorghe_"}, //valid user name
                        {"Ghe Gheorghe"}, //first name last name
                        {"G"}, // name with min length
                        {RandomStringUtils.randomAlphabetic(29)}, // name with one less than max length
                        {RandomStringUtils.randomAlphabetic(30)}, // name with max length
                };
    }
}
