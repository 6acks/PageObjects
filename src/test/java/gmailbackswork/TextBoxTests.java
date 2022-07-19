package gmailbackswork;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

   @BeforeAll
   static void beforeAll(){
       Configuration.browserSize= "1920x1080";
   }


    @Test
    void successTest() {
        open("https://demoqa.com/text-box");

        $("#userName").setValue("Alex");
        $("#userEmail").setValue("email@mail.com");
        $("#currentAddress").setValue("someAddress");
        $("#permanentAddress").setValue("AnotherAddress");
        // userName
        //userEmail
        //currentAddress
        //permanentAddress
        $("#submit").click();

        $("#output").shouldBe(visible);


        //name
        //email
        $("#name").shouldHave(text("Alex"));
        $("#email").shouldHave(text("email@mail.com"));
        $("#output #currentAddress").shouldHave(text("someAddress"));
        $("#output #permanentAddress").shouldHave(text("AnotherAddress"));
    }
}
