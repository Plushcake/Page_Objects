package page;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;
import lombok.val;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class DashboardPage {

    private SelenideElement checkText1 = $("[data-test-id=dashboard]");
    private SelenideElement checkText2 = $("h1.heading");
    private ElementsCollection firstCards = $$(".list__item");
    private ElementsCollection secondCards = $$(".list__item");
    private ElementsCollection buttonContinueFirst = $$("[data-test-id=action-deposit]");
    private ElementsCollection buttonContinueSecond = $$("[data-test-id=action-deposit]");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = "р.";

    public DashboardPage() {
        checkText1.shouldHave(text("Личный кабинет")).shouldBe(visible);
        checkText2.shouldHave(text("Ваши карты")).shouldBe(visible);
    }

    //First Card.
    public MoneyTransferPage firstCartButton () {
        buttonContinueFirst.first().click();
        return new MoneyTransferPage();
    }

    public int getFirstCardBalance() {
        val text = firstCards.first().text();
        return extractFirstBalance(text);
    }

    private int extractFirstBalance(String text) {
        val start = text.indexOf(balanceStart);//indexOf - возвращает позицию, с которой начинается подстрока в строке
        val finish = text.indexOf(balanceFinish);//indexOf - возвращает позицию, с которой начинается подстрока в строке
        val value = text.substring(start + balanceStart.length(), finish);//substring - вырезает подстроку из строки
        return Integer.parseInt(value);
    }

    //Second Card.
    public MoneyTransferPage secondCartButton() {
        buttonContinueSecond.last().click();
        return new MoneyTransferPage();
    }

    public int getSecondCardBalance() {
        val text = secondCards.first().text();
        return extractSecondBalance(text);
    }

    private int extractSecondBalance(String text) {
        val start = text.indexOf(balanceStart);//indexOf - возвращает позицию, с которой начинается подстрока в строке
        val finish = text.indexOf(balanceFinish);//indexOf - возвращает позицию, с которой начинается подстрока в строке
        val value = text.substring(start + balanceStart.length(), finish);//substring - вырезает подстроку из строки
        return Integer.parseInt(value);
    }
}
