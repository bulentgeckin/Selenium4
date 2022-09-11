package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import webdriver.TestWebDrivers;

import java.util.List;
import java.util.Map;

public class myDemoSteps {

    public static Logger log = LogManager.getLogger(myDemoSteps.class.getName());

    @Given("print e-mail,username and password to screen")
    public void print_e_mail_username_and_password_to_screen(DataTable dataTable) {

        List<Map<String, String>> userList = dataTable.asMaps();

        for (Map<String, String> myMap : userList) {
            System.out.printf("%-20s %-20s %s %n", myMap.get("email"), myMap.get("username"), myMap.get("password"));
        }
    }

    @Given("print {string}, {string} , {string}")
    public void print(String str1, String str2, String str3) {
        System.out.printf("%-20s %-20s %s %n", str1, str2, str3);
    }


    @Given("^User can start the \"([^\"]*)\"$")
    public void test_browser_and_web_drivers(String browser) throws Exception {

        switch (browser) {

            case ("chrome"):
                TestWebDrivers.testChromeBrowser();
                break;

            case ("firefox"):
                TestWebDrivers.testFireFoxBrowser();
                break;

            case ("edge"):
                TestWebDrivers.testEdgeBrowser();
                break;


            default:
                System.err.println("Browser is not supported, check your parameter");
                System.exit(0);


        }
    }
}
