package test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import data.DataHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.LoginPageV1;

import javax.swing.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PageObjectsTest {
    int money = 1000;

    @BeforeEach
    void setup() {
        open("http://localhost:9999");
        Configuration.holdBrowserOpen = true;
        var authInfo = DataHelper.getAuthInfo();
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        new LoginPageV1()
                .validLogin(authInfo)
                .validVerify(verificationCode);
    }

    @Test
    void shouldTransferMoneySecondCard() {
        $("[data-test-id=\"action-deposit\"]").click();
        $("[data-test-id=\"amount\"] input").setValue(String.valueOf(money));
    }
}
    //$("[data-test-id=\"login\"] input").setValue(info.getLogin());
        //$("[data-test-id=\"password\"] input").setValue(info.getPassword());
        //$("[data-test-id=\"action-login\"]").click();
