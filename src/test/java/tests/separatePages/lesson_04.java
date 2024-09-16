package tests.separatePages;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class lesson_04 {
    @Test
    void successfulEnterprizeTest() {
        open("https://github.com");
        $(".HeaderMenu-item", 1).hover()
                .$("[href=\"/enterprise\"]").click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered"));
    }
}
