package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationWithPageObjectsTests extends TestBase {

    @Test
    void successfulRegistrationTest() {

        registrationPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.userEmail)
                .setGender("Other")
                .setPhone("1234567890")
                .setBirthDate("30", "July", "2008")
                .setSubject("Math")
                .setHobbies("Sports")
                .uploadPicture("img/1.jpg")
                .setAddress(data.address)
                .setState("NCR")
                .setCity("Delhi")
                .clickSubmit();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", data.firstName + " " + data.lastName)
                .verifyResult("Student Email", data.userEmail)
                .verifyResult("Gender", "Other")
                .verifyResult("Mobile", "1234567890")
                .verifyResult("Date of Birth", "30 July,2008");
//        registrationPage.registrationResultsModal.verifyResult("Student Name", userName + " Egorov");
    }

    @Test
    void successfulRegistration1Test() {
        String userName = "Alex";

        registrationPage.openPage();

        registrationPage.setFirstName(data.firstName);
        registrationPage.setLastName(data.lastName);
        registrationPage.setEmail(data.userEmail);
        registrationPage.setGender("Other");
        registrationPage.setPhone("1234567890");


        $("#dateOfBirthInput").click();
        // ...
    }

}
