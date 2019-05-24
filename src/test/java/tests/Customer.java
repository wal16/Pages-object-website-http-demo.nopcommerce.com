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

public class Customer {
    private WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;
    private RegisterPage registerPage;

    @Before
    public void setUp() {
    Customer = new customer();
    String firstName = "Waldemar";
    String lastName = "Mozoła";
    String email = "waldemar.mozola@onet.pl";
    String password = "adminps1";
    String confirmPassword = "adminps1";
    loginPage.userLogin("waldemar.mozola@onet.pl", "adminps1");
    registerPage.registerUserForm(Customer customer);
    registerPage.clickOnSubmitButton();
}
