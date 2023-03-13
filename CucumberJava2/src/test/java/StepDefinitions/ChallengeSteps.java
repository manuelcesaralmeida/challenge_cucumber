package StepDefinitions;

import Business.businessPrice;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.homePage;

import java.util.HashMap;
import java.util.Map;

public class ChallengeSteps {

    WebDriver driver = null;
    homePage home = null;
    businessPrice business = null;

    HashMap<String, String> mapRangePrices = new HashMap<String, String>();




    @Given("prepared setup")
    public void prepared_setup() {
        System.out.println("Inside Step - prepared setup");

        String sProjectPath = System.getProperty("user.dir");
        System.out.println("sProjectPath"+sProjectPath);

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        String device = "Samsung Galaxy S8+";
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", device);

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--remote-allow-origins=*");
        options.setExperimentalOption("mobileEmulation", mobileEmulation);

        driver = new ChromeDriver(options);//this will open Chrome in mobile mode


        driver.manage().window().maximize();

    }

    @And("user go to the home page")
    public void user_go_to_the_home_page() {
        System.out.println("Inside Step - user go to the home page");

         driver.manage().deleteAllCookies();
    }

    @When("hits english language")
    public void hits_english_language() throws InterruptedException {
        System.out.println("Inside Step - hits english language");

        home = new homePage(driver);
        driver.navigate().to("https://www.bolttech.co.th/en/ptgroup/device-protection?utm_source=ptgroup&utm_customer=123123123123132");
        home.clickAcceptAllCookies();
        Thread.sleep(5000);
    }

    @And("validate list of prices in the range")
    public void validate_list_of_prices_in_the_range() throws InterruptedException {
        System.out.println("Inside Step - validate list of prices in the range");

        boolean bRes = false;

        business = new businessPrice(driver);

        for(int i = 2; i <= 8;i++){

            bRes = business.validatePrices(i);
        }

        Assert.assertTrue(bRes);


    }

    @And("choose a random range price")
    public void choose_a_random_range_price() throws InterruptedException {
        System.out.println("Inside Step - choose a random range price");

        boolean bRes = false;
        int min = 2;
        int max = 8;

        int i = (int)(Math.random()*(max-min+1)+min);
        System.out.println(i);

        bRes = business.validatePrices(i);

        Assert.assertTrue(bRes);

    }


    @And("users chooses the follow (.*)$")
    public void users_chooses_the_follow_range_price(String range_price) throws InterruptedException {
        System.out.println("Inside Step - And users chooses the follow range_price -> " + range_price);

        business = new businessPrice(driver);

        boolean bRes = false;
        for(int i = 2; i <= 8;i++){

            bRes = business.validatePrices(i,range_price);

            if(bRes)
            {
                break;
            }
        }

        Assert.assertTrue(bRes);


    }


}
