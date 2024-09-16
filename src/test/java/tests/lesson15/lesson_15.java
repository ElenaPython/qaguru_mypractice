package tests.lesson15;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;


public class lesson_15 {
    private static final String REPOSITORY = "ElenaPython/qaguru_mypractice";

    @Test
    void testIssueSearch() {
        open("https://github.com");
        SelenideLogger.addListener("allure", new AllureSelenide()); //добавляем шаги в аллюр отчет

        $(".octicon.octicon-search").click();
        $("#query-builder-test").sendKeys("qaguru_mypractice");
        $("#query-builder-test").submit();

        $(linkText("ElenaPython/qaguru_mypractice")).click();
        $("#issues-tab").click();
    }

    @Test
    void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide()); //добавляем шаги в аллюр отчет

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });

        step("Ищем репозиторий" + REPOSITORY, () -> {
            $(".octicon.octicon-search").click();
            $("#query-builder-test").sendKeys(REPOSITORY);
            $("#query-builder-test").submit();
        });
        step("Кликаем по ссылке репозитория" + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();
        });
    }

    @Test
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
    }
}
