package org.example;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ChallengeNotValidTest extends BaseTest {
    private final ChallengePage challengePage = new ChallengePage();

    @Test(description = "Validate First Name field - enter not valid names", dataProvider = "notValidNames")
    public void test1(String name) {
        challengePage.enterFirstName(name);
        challengePage.submitLoginForm();

        // next steps - verify error message or user not logged in with not valid name
    }

    @DataProvider(name = "notValidNames")
    private Object[][] notValidNames() {
        return new Object[][]
                {
                        {"Gheorghe"}, // valid name is 'Gheorghe_'
                        {" Gheorghe_"}, // valid name with space at the beginning
                        {"Gheorghe_ "}, // valid name with space at the end
                        {"$#%[]{}!?_@"}, // special symbols
                        {"12345678"}, // numbers
                        {"html><a>\"test\"</a></html>"}, // html tag
                        {"<script>alert(0)</script>"}, // script
                        {"DROP TABLE test"}, // sql injection
                        {"джордж"}, // diff language
                        {""}, // empty value
                        {" "}, // empty space
                        {RandomStringUtils.randomAlphabetic(31)}, // more the max length
                };
    }
}
