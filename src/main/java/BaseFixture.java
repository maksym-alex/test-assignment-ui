import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebDriver;
import pages.Pages;

import static com.codeborne.selenide.Selenide.open;

public class BaseFixture {

    public Pages pages = new Pages();

    public void openYouTube() {
        open("https://www.youtube.com/");
        WebDriver driver = Selenide.webdriver().object();
        driver.manage().window().maximize();
    }
}
