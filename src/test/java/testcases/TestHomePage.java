package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.DriverSetup;

public class TestHomePage extends DriverSetup {

    HomePage homePage = new HomePage();

    @AfterMethod
    public void addScreenshotAfterTest(){
        homePage.addScreenshot();
    }
    @Test
    public void testHomePageURL(){
        getDriver().get(homePage.url);
        Assert.assertEquals(homePage.getLoadedPageUrl(), homePage.url);
    }

    @Test
    public void testHomePageTitle(){
        getDriver().get(homePage.url);
        Assert.assertEquals(homePage.getLoadedPageTitle(), homePage.title);
    }
}
