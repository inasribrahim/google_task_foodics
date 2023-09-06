package com.google.foodics.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByAll;

import java.util.ArrayList;
import java.util.List;

public class SearchResult extends BaseScreen{
    private final By searchResult  = By.id("result-stats");
    private List<String> resultList = new ArrayList<>() ;

    private final By nextPageButton = new ByAll(
            By.linkText("التالية"), By.linkText("Next")
    );
    private final By suggestionsContainerResult = By.className("y6Uyqe");

    public String getSearchResult() {
        return getElementText(searchResult);
    }

    public List<WebElement> getSuggestionsResult() {
        return waitUtils.waitUntilElementIsPresence(suggestionsContainerResult).findElements(By.tagName("b"));
    }

    public By getNextPageButton() {
        return nextPageButton;
    }
    public String getNumberOfSearchResult(boolean isArabicLanguage) {
        if(isArabicLanguage) {
            return getSearchResult().split("حوالي ")[1].split(" ")[0];
        }
        else {
            return getSearchResult().split("About ")[1].split(" ")[0];
        }
    }

    public void clickOnNextButton(){
        waitUtils.waitUntilElementUntilIsClickable(nextPageButton).click();
    }

    public boolean isSearchResultIsRepeated(){
        for(WebElement searchResult:getSuggestionsResult())
        {
            resultList.add(searchResult.getText());
        }

        boolean isRepeatedFlag = false;
        for(int i=0;i< resultList.size();i++) {
            String currentResult = resultList.get(i);
            for(int j = i+1; j < resultList.size();j++) {
                if (currentResult.equals(resultList.get(j))) {
                    isRepeatedFlag = true;
                    break;
                }
            }
        }
        return isRepeatedFlag;
    }

}
