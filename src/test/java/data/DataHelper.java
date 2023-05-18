package data;

import lombok.Value;

public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;

    }

    public static AuthInfo getAuthInfo() {

        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCodeFor() {

        return new VerificationCode("12345");
    }

    @Value
    public static class CardsNumberAndMoneyValid {
        private String cardFirstNumber;
        private String moneyFirst;
        private String cardSecondNumber;
        private String moneySecond;
    }

    public static CardsNumberAndMoneyValid getFirstNumberAndMoney() {
        return new CardsNumberAndMoneyValid("5559 0000 0000 0001", "5000",
                "5559 0000 0000 0002", "7000");
    }


    @Value
    public static class CardsID {
        private String cardsNumberID;
    }

    public static CardsID getFirstCardID() {
        return new CardsID("92df3f1c-a033-48e6-8390-206f6b1f56c0");
    }

    public static CardsID getSecondCardID() {
        return new CardsID("0f3f5c2a-249e-4c3d-8287-09f7a039391d");
    }

}
