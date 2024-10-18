package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverSetup;

public class TestLogin extends DriverSetup {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void loadTestPage(){
        loginPage.navigateToLoginPage();
    }

    @Test
    public void testLoginWithValidCredentials(){
        loginPage.writeOnElement(loginPage.email_input_box, "fameloh253@chysir.com");
        loginPage.writeOnElement(loginPage.password_input_box, "Pass&Pass!");
        loginPage.clickOnElement(loginPage.login_btn);
        Assert.assertTrue(homePage.is_element_visible(homePage.logout_btn));
        Assert.assertFalse(loginPage.is_element_visible(loginPage.login_btn));
    }

    @Test
    public void testLoginWithInvalidPassword(){
        loginPage.writeOnElement(loginPage.email_input_box, "fameloh253@chysir.com");
        loginPage.writeOnElement(loginPage.password_input_box, "Pass&Pas");
        loginPage.clickOnElement(loginPage.login_btn);
        Assert.assertEquals(loginPage.getElement(loginPage.error_msg).getText(), "Your email or password is incorrect!");
        Assert.assertTrue(loginPage.is_element_visible(loginPage.login_btn));
    }

    @Test
    public void testLoginWithInvalidEmailAndPassword(){
        loginPage.writeOnElement(loginPage.email_input_box, "fameloh253@chys.com");
        loginPage.writeOnElement(loginPage.password_input_box, "Pass&Pas");
        loginPage.clickOnElement(loginPage.login_btn);
        Assert.assertEquals(loginPage.getElement(loginPage.error_msg).getText(), "Your email or password is incorrect!");
        Assert.assertTrue(loginPage.is_element_visible(loginPage.login_btn));
    }

    @Test
    public void testLoginWithInvalidEmailAndValidPassword(){
        loginPage.writeOnElement(loginPage.email_input_box, "fameloh253@chys.com");
        loginPage.writeOnElement(loginPage.password_input_box, "Pass&Pass!");
        loginPage.clickOnElement(loginPage.login_btn);
        Assert.assertEquals(loginPage.getElement(loginPage.error_msg).getText(), "Your email or password is incorrect!");
        Assert.assertTrue(loginPage.is_element_visible(loginPage.login_btn));
    }

    @Test
    public void testLoginWithoutEmailAndPassword(){
        loginPage.writeOnElement(loginPage.email_input_box, "");
        loginPage.writeOnElement(loginPage.password_input_box, "");
        loginPage.clickOnElement(loginPage.login_btn);
        Assert.assertEquals(loginPage.getElement(loginPage.email_input_box).getAttribute("validationMessage"), "Please fill out this field.");
        Assert.assertTrue(loginPage.is_element_visible(loginPage.login_btn));
    }

    @Test
    public void testLoginEmailAndWithoutPassword(){
        loginPage.writeOnElement(loginPage.email_input_box, "fameloh253@chysir.com");
        loginPage.writeOnElement(loginPage.password_input_box, "");
        loginPage.clickOnElement(loginPage.login_btn);
        Assert.assertEquals(loginPage.getElement(loginPage.password_input_box).getAttribute("validationMessage"), "Please fill out this field.");
        Assert.assertTrue(loginPage.is_element_visible(loginPage.login_btn));
    }

    Object[][] data = {
            {"fameloh253@chysir.com", "Pass&Pas", "Your email or password is incorrect!", ""},
            {"fameloh253@chys.com", "Pass&Pas", "Your email or password is incorrect!", ""},
            {"fameloh253@chys.com", "Pass&Pass!", "Your email or password is incorrect!", ""},
            {"", "", "", "Please fill out this field."},
            {"fameloh253@chysir.com", "", "","Your email or password is incorrect!"}
    };
}
