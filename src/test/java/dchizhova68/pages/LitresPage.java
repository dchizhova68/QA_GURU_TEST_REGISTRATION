package dchizhova68.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
public class LitresPage {
    private SelenideElement
            searchInput = $(byAttribute("data-test-id","header__search-input--desktop")),

            linkDetailFormBook = $(byAttribute("data-test-id", "art__cover--desktop")).$("a"),
            addToCartButton = $(byAttribute("data-test-id","book__addToCartButton--desktop")),
            closeModalButton = $(byAttribute("data-test-id","modal-book-label__wrapper")).$("use"),
            tabBasket = $(byAttribute("data-test-id","tab-basket")).$("a"),
            breadcrumbsSelector = $("#breadcrumbs:last-child");

    private ElementsCollection
            bookTitleTag = $$(byAttribute("data-test-id","art__title--desktop")),
            bookCardTitle = $$(byAttribute("data-test-id","cart__bookCardTitle--wrapper"));


    @Step("Открываем главную страницу")
    public LitresPage openPage() {
        open("https://www.litres.ru");
        return this;
    }

    @Step("Вводим в поисковую строку {author}")
    public LitresPage setSearchValue(String author) {
        searchInput.setValue(author).pressEnter();

        return this;
    }

    @Step()
    public LitresPage checkSearchResultHavePopularBookByAuthor(String bookTitle) {
        bookTitleTag.shouldHave(itemWithText(bookTitle));;

        return this;
    }

    @Step("Переходим в детальную форм просмотра первой книги из списка")
    public LitresPage openDetailFormBook(String bookTitle) {
        linkDetailFormBook.click();

        return this;
    }

    @Step("Закрываем модальное окно")
    public LitresPage closeModalWindow() {
        closeModalButton.click();

        return this;
    }

    @Step("Добавляем книгу в корзину")
    public LitresPage addToBasket() {
        addToCartButton.click();

        return this;
    }

    @Step("Переходим в корзину")
    public LitresPage openBasket() {
        tabBasket.click();

        return this;
    }

    @Step("Проверяем, что в корзине есть книга{bookTitle}")
    public LitresPage checkBasketContainsAddedBook(String bookTitle) {
        bookCardTitle.shouldHave(itemWithText(bookTitle));

        return this;
    }

    @Step()
    public LitresPage openPageByName(String pageName) {
        $(byTagAndText("div", pageName)).click();

        return this;
    }

    @Step()
    public LitresPage checkBreadCrumbs(String pageName) {
        breadcrumbsSelector.shouldHave(text(pageName));

        return this;
    }

}
