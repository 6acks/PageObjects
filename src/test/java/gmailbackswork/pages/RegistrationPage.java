package gmailbackswork.pages;

import com.codeborne.selenide.SelenideElement;
import gmailbackswork.pages.CalendarComponent.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    SelenideElement firstNameInput=$("#firstName"),
                     lastNameInput=$("#lastName"),
                    resultsTable=$(".table-responsive");
    public CalendarComponent calendarComponent = new CalendarComponent();

    public void openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    }

    public void typeFirstName(String value){
        firstNameInput.setValue(value);
    }
    public void typeLastName(String value){
        lastNameInput.setValue(value);
    }

    public  void checkResultsValue(String key, String value){
        resultsTable.$(byText(key))
                .parent().shouldHave(text(value));

    }
}
