//import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class SberTest {

    @Ignore
    @Before
    public void setUp(){
        Init.initDriver();
    }

    @Ignore
    @After
    public void close() {

        //Init.closeDriver();
    }

    @Ignore
    @Test
    //@DisplayName("Sber ipoteka test")
    public void mainTest() {
        MainPage main = new MainPage();
        main.ipotekaChoice("Ипотека на готовое жильё");


        IpotekaPage ipotekaPage = new IpotekaPage();
        IpotekaParametrs ipotekaParametrs = new IpotekaParametrs("5180000", "3058000", "30");
        ipotekaPage.inputParametrs(ipotekaParametrs.getCost(), ipotekaParametrs.getFee(), ipotekaParametrs.getTerm());

        IpotekaResults ipotekaResults = new IpotekaResults("2 122 000 \u20BD", "17 998 \u20BD", "29 997 \u20BD", "9,6 %");
        ipotekaPage.getSideBarCredit(ipotekaResults.getCredit());
        ipotekaPage.getSidePaymant(ipotekaResults.getPaymant());
        ipotekaPage.getSideBarIncome(ipotekaResults.getIncome());
        ipotekaPage.getSideBarRate(ipotekaResults.getRate());
        //ipotekaPage.getSideBar( "2 122 000 \u20BD", "17 998 \u20BD", "29 997 \u20BD", "9,6 %");//9,6
    }
}
