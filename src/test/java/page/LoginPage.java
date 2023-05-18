package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public SelenideElement login = $("[data-test-id=login] input");
    public SelenideElement password = $("[data-test-id=password] input");
    public SelenideElement clickButton = $("[data-test-id=action-login]");
    public SelenideElement checkText1 = $("h2.heading");
    public SelenideElement checkText2 = $("p.paragraph");

    public LoginPage() {
        checkText1.shouldHave(text("Интернет Банк"));
        checkText2.shouldHave(text("Мы гарантируем безопасность ваших данных"));
        login.shouldBe(visible);
        password.shouldBe(visible);
        clickButton.shouldBe(visible);
    }

    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        login.setValue(info.getLogin());
        password.setValue(info.getPassword());
        clickButton.click();
        return new VerificationPage();
    }

}
