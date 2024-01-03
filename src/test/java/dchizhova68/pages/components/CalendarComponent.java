package dchizhova68.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate (String day, String month, String year) {
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $("#dateOfBirth").$$(".react-datepicker__day:not(.react-datepicker__day--outside-month)").findBy(text(day)).click();

    }
}
