import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class lesson_07 {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadTimeout = 100000;
    }

    @Test
    void fillFormTest() {
        String firstName = "Alex";

        open("/automation-practice-form");
        $(".text-center").shouldHave(text("Practice Form"));

        $("#firstName").setValue(firstName);
        $("#lastName").setValue("Petrov");
        $("#userEmail").setValue("qaguru@qa.gu");
        $(".custom-control-label").click();
        $("#userNumber").setValue("555666777888");
//        $("#dateOfBirthInput").sendKeys(Keys.CONTROL + "a");
//        $("#dateOfBirthInput").sendKeys(Keys.BACK_SPACE);
//        $("#dateOfBirthInput").setValue("27 Mar 2000");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(3);
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--027").click();
        $(".subjects-auto-complete__control").click();
        $(".subjects-auto-complete__value-container").click();
        $(".subjects-auto-complete__value-container").setValue("h");
        $(".subjects-auto-complete__value-container").selectOption("Hindi");


//        $("#currentAddress").setValue("Some address 1");
//        $("#permanentAddress").setValue("Other address 1");
//        $("#submit").click();
//
//        $("#output").shouldBe(visible);
//        $("#output").$("#name").shouldHave((text(userName)));
//        $("#output #email").shouldHave((text("qaguru@qa.gu")));
        // todo check addresses
    }
}