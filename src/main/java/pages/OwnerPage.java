package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OwnerPage {

    SelenideElement avatarOnOwnerPage = $("yt-decorated-avatar-view-model");
    SelenideElement subscribeBtn = $("#page-header .yt-spec-touch-feedback-shape__fill");
    SelenideElement signIn = $(By.xpath("//*[@id='button']/yt-button-shape/a/div/span"));

    public OwnerPage isOpened() {
        avatarOnOwnerPage.shouldBe(visible);
        return this;
    }

    public OwnerPage clickSubscribeBtn() {
        subscribeBtn.click();
        return this;
    }

    public void checkSignInText() {
        signIn.shouldHave(text("Sign in"));
    }
}
