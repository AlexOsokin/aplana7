package stepsCucumber;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BeforeAfterClass {


        @Before
        public void beforeEach() {
            Init.initDriver();
            MainPage main = new MainPage();
            IpotekaPage ipotekaPage = new IpotekaPage();

        }

        @After
        public void afterEach() {
            Init.closeDriver();
        }

}
