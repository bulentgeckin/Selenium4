package practice;

import org.junit.jupiter.api.Test;

import static utils.BaseClass.*;

public class TestBaseClass {


    @Test
    void testWebDriver() {

        initializeWebDriver();
        gotoWebPage("https://www.google.com");
//        gotoWebPage("https://www.dfsggfdsgfdsgfd.com");
//
        closeWebDriver();
    }

}
