package com.google.foodics.screen;


import com.google.foodics.driver.DriverManager;
import com.google.foodics.waits.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class BaseScreen {

    Actions actions;
    WaitUtils waitUtils = new WaitUtils();

    protected String constructXpath(String xpath , String replacingStr){
        return String.format(xpath,replacingStr);
    }
    protected WebElement getWebElement(By by){
      return waitUtils.waitUntilElementUntilIsVisible(by);
    }

    public void scrollToElement(By selector) {
        WebElement element = getWebElement(selector);
        actions = new Actions(DriverManager.getWebDriver());
        ((JavascriptExecutor) DriverManager.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void scrollDown() {
        ((JavascriptExecutor) DriverManager.getWebDriver()).executeScript("window.scrollBy(0, document.body.scrollHeight)");
    }

    public boolean elementIsExisted(By by) {
        return !DriverManager.getWebDriver().findElements(by).isEmpty();
    }

    public String getElementText(By by){
        return waitUtils.waitUntilElementIsPresence(by).getText();
    }

    public String getCurrentUrl(){
        return DriverManager.getWebDriver().getCurrentUrl();
    }

    public void back() throws InterruptedException {
        DriverManager.getWebDriver().navigate().back();
        waitUtils.sleep(8000);
    }
    public boolean isGoogleSearchIsSwitchToArabicLanguage() {
        return !DriverManager.getWebDriver().findElements(By.xpath("//span[contains(text(),'تسجيل الدخول')]")).isEmpty();
    }
}
