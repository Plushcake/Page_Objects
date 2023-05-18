package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

//Проверяем что страница открылась
public class VerificationPage {
    private SelenideElement codeInput = $("[data-test-id=code] input");//Строка ввода кода
    private SelenideElement clickButton = $("[data-test-id=action-verify]");//Кнопка продолжить
    private SelenideElement checkText = $("p.paragraph");

    public VerificationPage() {
        checkText.shouldHave(text("Необходимо подтверждение"));
        codeInput.shouldBe(visible);
        clickButton.shouldBe(visible);
    }

    public DashboardPage validVerification(DataHelper.VerificationCode verificationCode) {
        codeInput.setValue(verificationCode.getCode());
        clickButton.click();
        return new DashboardPage();
    }
}
