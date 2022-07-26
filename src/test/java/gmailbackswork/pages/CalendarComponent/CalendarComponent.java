package gmailbackswork.pages.CalendarComponent;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
//        $(".react-datepicker__day--0"+ day +
//                ":not(.react-datepicker__day--outside-month)").click();
//      $("[aria-label*='"+ month +" "+ day + "th, " + year + "']" ).click();
        String dayLocator = format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", day);
        $(dayLocator).click();
    }
}
