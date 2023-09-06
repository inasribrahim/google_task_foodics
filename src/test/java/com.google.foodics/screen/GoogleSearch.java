package com.google.foodics.screen;

import org.openqa.selenium.By;

public class GoogleSearch extends BaseScreen{
    private final By searchInputField = By.id("APjFqb");
    public GoogleSearch enterKeywordInSearchBox(String keyword){
        waitUtils.waitUntilElementIsPresence(searchInputField).sendKeys(keyword);
        return this;
    }
    public GoogleSearch clearSearchInput(){
        waitUtils.waitUntilElementIsPresence(searchInputField).clear();
        return this;
    }

    public void clickOnSearchResultByName(String resultName){
        String xpath = "//*[text()='" + resultName + "']";
        By resultNameFound = By.xpath(constructXpath(xpath, resultName));
        waitUtils.waitUntilElementUntilIsClickable(resultNameFound).click();
    }

}
