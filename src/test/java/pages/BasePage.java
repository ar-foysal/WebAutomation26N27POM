package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.DriverSetup.getDriver;

public class BasePage {
    public WebElement getElement(By locator){
        return getDriver().findElement(locator);
    }

    public void clickOnElement(By locator){
        getElement(locator).click();
    }

    public void writeOnElement(By locator, String text){
        getElement(locator).sendKeys(text);
    }

    public String getLoadedPageUrl(){
       return getDriver().getCurrentUrl();
    }

    public String getLoadedPageTitle(){
        return getDriver().getTitle();
    }


    public void loadAWebPage(String url){
        getDriver().get(url);
    }

    public Boolean is_element_visible(By locator){
        try {
            return getElement(locator).isDisplayed();
        }catch (Exception e){
            return false;
        }

    }
}
