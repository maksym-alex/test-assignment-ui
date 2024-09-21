package pages;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import java.util.Random;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class YouTubePage {

    Random random = new Random();
    OwnerPage ownerPage = new OwnerPage();

    SelenideElement ownerAvatar = $(By.xpath("//*[@id='owner']/ytd-video-owner-renderer/a"));
    SelenideElement input = $(By.xpath("//input[@id='search']"));
    ElementsCollection videos = $$("ytd-video-renderer");
    ElementsCollection dropdownItems = $$x("//li[@class='sbsb_c gsfs']");

    public YouTubePage isOpened() {
        webdriver().shouldHave(url("https://www.youtube.com/"));
        checkTabText();
        return this;
    }

    public void checkTabText() {
        Assert.assertEquals(title(), "YouTube");
    }

    public YouTubePage enterRandomNumbersInSearch() {
        String randomNumbers = String.valueOf(random.nextInt(10, 20));
        input.shouldBe(visible).click();
        input.sendKeys(randomNumbers);
        return this;
    }

    public YouTubePage selectDropdownItem(int selectItem) {
        dropdownItems.first().shouldBe(visible);
        SelenideElement selectedItem = dropdownItems.get(selectItem);
        selectedItem.click();
        return this;
    }

    public YouTubePage clickOnVideo(int selectedNumber) {
        videos.shouldBe(sizeGreaterThan(0));
        SelenideElement video = videos.get(selectedNumber);
        video.shouldBe(visible)
                .hover()
                .click();
        return this;
    }

    public YouTubePage checkVideoIsOpened() {
        webdriver().shouldHave(urlContaining("watch"));
        return this;
    }

    public OwnerPage clickOnOwnerAvatar() {
        ownerAvatar.click();
        return ownerPage;
    }
}
