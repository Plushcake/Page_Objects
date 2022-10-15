package test;

import data.DataHelper;
import org.junit.jupiter.api.Test;
import page.LoginPageV1;

import static com.codeborne.selenide.Selenide.open;

public class PageObjectsTest {
    @Test
    void shouldTransferMoneyTest() {
        open("http://localhost:9999");
        var authInfo = DataHelper.getAuthInfo();
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        new LoginPageV1()
                .validLogin(authInfo)
                .validVerify(verificationCode);
    }

}
