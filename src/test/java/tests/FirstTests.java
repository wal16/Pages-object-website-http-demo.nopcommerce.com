package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegisterPage;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class FirstTests {
    private WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;
    private RegisterPage registerPage;


    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1600, 900));

        mainPage = PageFactory.initElements(driver, MainPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        registerPage = PageFactory.initElements(driver, RegisterPage.class);


    }

    @Test
    public void loginTest() {
        driver.get("http://demo.nopcommerce.com/login");
        String email = "waldemar.mozola@onet.pl";
        String password = "adminps1";
        loginPage.userLogin(email, password);

        assertTrue("User is logged in", mainPage.isUserIsLoggedIn());
    }

    @Test
    public void registerTest() {
        driver.get("http://demo.nopcommerce.com/register");



        assertNotEquals("User was not register correctly", driver.getCurrentUrl(), "http://demo.nopcommerce" + " .com/register");

    }

    @Test
    public void findAndClickMainPageElements() {
        driver.get("http://demo.nopcommerce.com/");
        assertTrue(mainPage.areLinkElementClickable());

    }

    @After
    public void tearDown() {
        driver.close();


    }


}
