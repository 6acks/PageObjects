package gmailbackswork.test;

import com.codeborne.selenide.Configuration;
import gmailbackswork.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFormTestsWithPageObjects {

   RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void setUp(){
        Configuration.baseUrl="https://demoqa.com";
        Configuration.browserSize= "1920x1080";
    }
    @Test
    void fillpracticeFormTests(){
        registrationPage.openPage();
        registrationPage.typeFirstName("Vlad");
        registrationPage.typeLastName("Zhur");

        $("#userEmail").setValue("mail@mail.ru");
        $("#genterWrapper").$(byText("Other")).click();


        $("#userNumber").setValue("8005553535");
        registrationPage.calendarComponent.setDate("30","July","2008");
        $("[id=subjectsInput]").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/hello.png");
        $("[id=currentAddress]").setValue("Tomsk");
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        registrationPage.checkResultsValue("Student Name","Vlad Zhur");
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("mail@mail.ru"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Other"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("8005553535"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("30 July,2008"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Maths"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("hello.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Tomsk"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Noida"));
    }
}
