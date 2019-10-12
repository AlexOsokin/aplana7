import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IpotekaPage extends BasePage {
    @FindBy(xpath = "//input[@id='estateCost']")
    private WebElement estateCost;

    @FindBy(xpath = "//input[@id='initialFee']")
    private WebElement initialFee;

    @FindBy(xpath = "//input[@id='creditTerm']")
    private WebElement creditTerm;

    @FindBy(xpath = "//div[@class='product-teaser-full-width__button']/a")
    private WebElement open;

    @FindBy(xpath = "//span[@data-test-id='monthlyPayment']")
    private WebElement monthlyPayment;

    @FindBy(xpath = "//span[@data-test-id='amountOfCredit']")
    private WebElement amountOfCredit;

    @FindBy(xpath = "//span[@data-test-id='requiredIncome']")
    private WebElement requiredIncome;

    @FindBy(xpath = "//span[@data-test-id='rate']")
    private WebElement webRate;

    @FindBy(xpath = "//input[@data-test-id='paidToCard']/parent::label")
    private WebElement paidToCard;

    @FindBy(xpath = "//div[text()='Есть возможность подтвердить доход справкой']")
    private WebElement reference;

    @FindBy(xpath = "//input[@data-test-id='youngFamilyDiscount']/parent::label")
    private WebElement youngFamilyDiscount;

    @Step("Input Parametrs: {cost} / {fee} / {term}")
    public void inputParametrs(String cost, String fee, String term){
        scrollAndClick(open);
        String price = monthlyPayment.getText();

        waitForElement(estateCost);
        estateCost.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), cost);
        price = waitMonthlyPayment(price);

        waitForElement(initialFee);

        initialFee.clear();
        initialFee.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), fee);
        price = waitMonthlyPayment(price);

        waitForElement(creditTerm);
        creditTerm.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), term);
        price = waitMonthlyPayment(price);

        paidToCard.click();
        price = waitMonthlyPayment(price);
        try {
            waitForElement(reference);
            System.out.println("Элемент:  \"Есть возможность подтвердить доход справкой\" появился");
        }catch (TimeoutException e){
            System.out.println("Элемент:  \"Есть возможность подтвердить доход справкой\" не появился");
        }

        waitForElement(youngFamilyDiscount);
        youngFamilyDiscount.click();
        waitMonthlyPayment(price);

    }
    private String waitMonthlyPayment(String price){
        waitForElement(monthlyPayment);
        invisibleMonthlyPayment(price);
        monthlyPayment.click();
        price = monthlyPayment.getText();
        int i = 0;
        while (true){
            if (monthlyPayment.getText().equals(price)){
                    break;
            }
            price = monthlyPayment.getText();
        }
        System.out.println("Ежемесячный плятеж: " + price);
        return price;
    }
    private void invisibleMonthlyPayment(String text){
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//div[@class='product-teaser-full-width__button']/a"), text));
    }

    public void getSideBar(String credit, String paymant, String income, String rate){
        System.out.println("Сумма кредита: " + waitTextInElement(amountOfCredit, credit));
        System.out.println("Ежемесячный платеж: " + waitTextInElement(monthlyPayment, paymant));
        System.out.println("Необходимый доход: " + waitTextInElement(requiredIncome, income));
        System.out.println("Процентная ставка: " + waitTextInElement(webRate, rate));

    }
    @Step("Input Credit: {credit}")
    public void getSideBarCredit(String credit){
        System.out.println("Сумма кредита: " + waitTextInElement(amountOfCredit, credit));
    }
    @Step("Input Paymant: {paymant}")
    public void getSidePaymant(String paymant){
        System.out.println("Ежемесячный платеж: " + waitTextInElement(monthlyPayment, paymant));;
    }
    @Step("Input Income: {income}")
    public void getSideBarIncome(String income){
        System.out.println("Необходимый доход: " + waitTextInElement(requiredIncome, income));
    }
    @Step("Input Rate: {rate}")
    public void getSideBarRate(String rate){
        System.out.println("Процентная ставка: " + waitTextInElement(webRate, rate));
    }

}
