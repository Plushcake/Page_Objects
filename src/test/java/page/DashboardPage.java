package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {

    private SelenideElement heading = $("[data-test-id=\"dashboard\"]");
    private ElementsCollection cards = $$(".list_item");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = "р.";

    public DashboardPage() {
    }

    public int getCardBalance() {
        val text = cards.first().text();
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);//indexOf - возвращает позицию, с которой начинается подстрока в строке
        val finish = text.indexOf(balanceFinish);//indexOf - возвращает позицию, с которой начинается подстрока в строке
        val value = text.substring(start + balanceStart.length(), finish);//substring - вырезает подстроку из строки
        return Integer.parseInt(value);
    }
}
