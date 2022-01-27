package org.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass(description = "Setup browser")
    public void beforeClass() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "0x0";
        Configuration.savePageSource = false;

        Selenide.open("http://testingchallenges.thetestingmap.org/index.php");
    }
}
