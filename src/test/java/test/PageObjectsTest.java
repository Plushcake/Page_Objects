package test;

import com.codeborne.selenide.Configuration;
import data.DataHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.LoginPageV1;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PageObjectsTest {
    int money = 1000;

    @BeforeEach
    void setup() {
        open("http://localhost:9999"); //java -jar app-ibank-build-for-testers.jar
        Configuration.holdBrowserOpen = true;
        var authInfo = DataHelper.getAuthInfo();
        var verificationCode = DataHelper.getVerificationCodeFor();
        new LoginPageV1()
                .validLogin(authInfo)
                .validVerify(verificationCode);
    }

    @Test
    void shouldTransferMoneySecondCard() throws InterruptedException {
        $("[data-test-id=\"action-deposit\"]").click();
        Thread.sleep(10000);
//        $("[data-test-id=\"amount\"] input").setValue(String.valueOf(money));

    }
}

