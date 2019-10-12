package stepsCucumber;

import cucumber.api.java.ru.Когда;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {
    @FindBy(xpath = "//*[@aria-label='Меню Ипотека']")
    private WebElement ipoteka;

    @FindBy(xpath = "//li[@class='lg-menu__sub-item']/a")
    private List<WebElement> items;

    @Когда("Пользователь зашел на форму заполнения \"(.*)\"")
    public void ipotekaChoice(String item){
        waitForElement(ipoteka);
        ipoteka.click();
        for (WebElement element : items){
            if (element.getText().equals(item)){
                waitForElement(element);
                element.click();
                return;
            }
        }
    }

}
