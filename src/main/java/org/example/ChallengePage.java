package org.example;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ChallengePage {
    private final By firstNameField = By.xpath("//input[@id='firstname']");
    private final By submitButton = By.xpath("//input[@name='formSubmit']");
    private final By firstNameFieldLabel = By.xpath("//input[@id='firstname']/../span[@class='block_label']");
    private final By firstNameFieldRequiredMark = By.xpath("//input[@id='firstname']/..//span[@class='req']");

    public void enterFirstName(String firstName) {
        $(firstNameField).shouldBe(Condition.visible).setValue(firstName);
    }

    public void submitLoginForm() {
        $(submitButton).shouldBe(Condition.visible).click();
    }

    public void verifyFirstNameFieldVisible() {
        $(firstNameField).shouldBe(Condition.visible);
    }

    public void verifySubmitButtonVisible() {
        $(submitButton).shouldBe(Condition.visible);
    }

    public void verifyFirstNameLabel(String label) {
        $(firstNameFieldLabel).shouldHave(Condition.exactOwnText(label));
    }

    public void verifyFirstNameRequiredMarkVisible() {
        $(firstNameFieldRequiredMark).shouldBe(Condition.visible);
    }
}
