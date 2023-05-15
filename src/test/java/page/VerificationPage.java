package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

//Проверяем что страница открылась
public class VerificationPage {
    private SelenideElement codeField = $("[data-test-id=code] input");//Строка ввода кода
    private SelenideElement verifyButton = $("[data-test-id=action-verify]");//Кнопка продолжить

    public VerificationPage() {
        codeField.shouldBe(visible);
    }

    public DashboardPage validVerify(DataHelper.VerificationCode verificationCode) {
        codeField.setValue(verificationCode.getCode());
        verifyButton.click();
        return new DashboardPage();
    }
}
