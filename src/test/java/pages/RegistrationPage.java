package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final String TITLE_TEXT = "Student Registration Form";
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            state = $("#state"),
            stateCity = $("#stateCity-wrapper"),
            city = $("#city"),
            submit = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage clearLastName() {
        lastNameInput.clear();

        return this;
    }

    public RegistrationPage setEmail(String value) {
        $("#userEmail").setValue(value); // todo move to Selenide elements

        return this;
    }

    public RegistrationPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click(); // todo move to Selenide elements

        return this;
    }

    public RegistrationPage setPhone(String value) {
        $("#userNumber").setValue(value); // todo move to Selenide elements

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String value) {
        $("#subjectsInput").setValue(value).pressEnter(); // todo move to Selenide elements

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        state.click();
        stateCity.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        city.click();
        stateCity.$(byText(value)).click();

        return this;
    }

    public RegistrationPage clickSubmit() {
        submit.click();

        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }
    /*
    *** SELENIUM
    @FindBy(how = How.XPATH, xpath = ".//*[@class='submit']")
    public Button logoutBtn;

    *** SELENIDE
    public SelenideElement logoutBtn = $x(".//*[@class='submit]");
    public SelenideElement logoutBtn = $(".submit");
     */

}
