import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchTests {
    @Test
    void successfulSearchTest() {
        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
     //   $("#search").shouldHave(text("https://selenide.org"));
        $$(".yuRUbf div.notranslate div.GTRloc div.byrV5b cite.tjvcx.GvPZzd.cHaqb").first().shouldHave(text("https://ru.selenide.org"));

    }
}
