package dchizhova68.pages;

import com.codeborne.selenide.SelenideElement;
import dchizhova68.pages.components.CalendarComponent;
import dchizhova68.pages.components.TableResponsiveComponent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            stateWrapper = $("#stateCity-wrapper"),
            cityInput = $("#city"),
            cityWrapper = $("#stateCity-wrapper"),
            modalDialogLocator = $(".modal-dialog"),
            submiteLocator = $("#submit");

    CalendarComponent calendar = new CalendarComponent();
    TableResponsiveComponent tableResponsive = new TableResponsiveComponent();

    @Step("Открываем страницу")
    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }
    @Step("Заполняем First Name")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Заполняем Last Name")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }
    @Step("Заполняем Email")
    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }
    @Step("Выбираем Gender")
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }
    @Step("Заполняем Mobile Number")
    public RegistrationPage setNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }
    @Step("Заполняем Date of Birth")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendar.setDate(day, month, year);

        return this;
    }
    @Step("Заполняем Subject")
    public RegistrationPage setSubject(String value) {
        subjectsInput.val(value).pressEnter();

        return this;
    }
    @Step("Выбираем Hobbies")
    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }
    @Step("Добавляем вложение")
    public RegistrationPage uploadFile(String fileName) {
        uploadPictureInput.uploadFromClasspath(fileName);

        return this;
    }
    @Step("Заполняем Current Address")
    public RegistrationPage setAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }
    @Step("Выбираем State")
    public RegistrationPage setState(String value) {
        stateInput.click();
        stateWrapper.$(byText(value)).click();

        return this;
    }
    @Step("Выбираем City")
    public RegistrationPage setCity(String value) {
        cityInput.click();
        cityWrapper.$(byText(value)).click();

        return this;
    }
    @Step("Нажимаем кнопку Submit")
    public RegistrationPage completeRegistration() {
        submiteLocator.click();

        return this;
    }
    @Step("Проверяем, что открыто модальное окно")
    public RegistrationPage checkOpenModalDialog() {
        modalDialogLocator.should(appear);

        return this;
    }
    @Step("Проверяем, что атрибут {key} содержит значение {value}")
    public RegistrationPage checkResult(String key, String value) {
        tableResponsive.checkResult(key, value);

        return this;
    }
    @Step("Проверяем, что модальное окно не открыто")
    public RegistrationPage checkFaildRegistration() {
        modalDialogLocator.should(disappear);
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

}
