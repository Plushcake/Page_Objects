package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MoneyTransferPage {

    private SelenideElement checkText = $("h1.heading");

    private SelenideElement inputAmount = $("[data-test-id=amount] input"); //Сумма

    private SelenideElement inputFrom = $("[data-test-id=from] input"); //Откуда
    private SelenideElement inputTo = $("[data-test-id=to] input"); //Куда
    private SelenideElement clickButtonContinue = $("[data-test-id=action-transfer]"); //Продолжить
    private SelenideElement clickButtonCancel = $("[data-test-id=action-cancel]"); //Отмена
    private SelenideElement messageError = $("[data-test-id=error-notification]");

    public MoneyTransferPage() {
        checkText.shouldHave(text("Пополнение карты")).shouldBe(visible);
        clickButtonContinue.shouldBe(visible);
        clickButtonCancel.shouldBe(visible);
    }

    public DashboardPage fillingAmountForm(DataHelper.CardsNumberAndMoneyValid cardsNumberAndMoneyValid) {
        inputAmount.setValue(cardsNumberAndMoneyValid.getMoneyFirst());
        inputFrom.setValue(cardsNumberAndMoneyValid.getCardFirstNumber());
        inputTo.setValue(cardsNumberAndMoneyValid.getCardSecondNumber());//Не вводится значение. Остановился тут.

        return new DashboardPage();
    }

}
