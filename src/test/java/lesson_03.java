import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class lesson_03 {
    @Test
    void successfulSoftAssertionTest() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $$(".internal").findBy(text("Soft assertions")).click();
        $("#user-content-3-using-junit5-extend-test-class").ancestor(".markdown-heading").shouldHave(text("JUnit5"));
    }
}
