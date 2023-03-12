import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {
    @FindBy(css = "[type=text]")
    WebElement txtsearch;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void doSearch(String searchInput){
        txtsearch.sendKeys(searchInput);
        txtsearch.submit();
    }
}
