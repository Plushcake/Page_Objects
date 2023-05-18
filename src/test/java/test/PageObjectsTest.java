package test;

import com.codeborne.selenide.Configuration;
import data.DataHelper;
import lombok.val;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import page.DashboardPage;
import page.LoginPage;
import page.MoneyTransferPage;


import static com.codeborne.selenide.Selenide.open;

public class PageObjectsTest {

    @BeforeEach
    void setup() {
        open("http://localhost:9999"); //java -jar app-ibank-build-for-testers.jar
        Configuration.holdBrowserOpen = true;
        val authInfo = DataHelper.getAuthInfo();
        val verificationCode = DataHelper.getVerificationCodeFor();
        new LoginPage()
                .validLogin(authInfo)
                .validVerification(verificationCode);
    }

    @Test
    void shouldTransferMoneySecondCard() {
        val dashboardPage = new DashboardPage();
//        val balanceFirstCard = dashboardPage.getFirstCardBalance();
//        val balanceSecondCard = dashboardPage.getSecondCardBalance();
        val moneyTransfer = dashboardPage.secondCartButton();
        val infoMoney = DataHelper.getFirstNumberAndMoney();
        new MoneyTransferPage()
                .fillingAmountForm(infoMoney);



    }
}

