package com.google.foodics.tests;


import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class GoogleTest extends BaseTest{
    boolean googleSearchResultIsArabicLanguage  = false ;
    @Test
    public void verifyThatGoogleSearchResultPageTwoMatchWithPageThree(){
        String keyword =  "Food Management System";
        String keyword_ = "Foodics";
        String keywordSelect = "foodics";
        googleSearchResultIsArabicLanguage = browser.google.googleSearch
                        .isGoogleSearchIsSwitchToArabicLanguage();
        browser.google.googleSearch
                        .enterKeywordInSearchBox(keyword)
                        .clearSearchInput()
                        .enterKeywordInSearchBox(keyword_)
                        .clickOnSearchResultByName(keywordSelect);

        browser.google.searchResult.scrollToElement(browser.google.searchResult.getNextPageButton());

        browser.google.searchResult.clickOnNextButton();
        String searchResultPageTwo = browser.google.searchResult
                                    .getNumberOfSearchResult(googleSearchResultIsArabicLanguage);

        browser.google.searchResult.clickOnNextButton();
        String searchResultPageThree = browser.google.searchResult
                                    .getNumberOfSearchResult(googleSearchResultIsArabicLanguage);

        assertEquals(searchResultPageTwo,searchResultPageThree);
    }

    @Test
    public void verifyThatGoogleSuggestionInSearchResultIsDifferent(){
        String keyword =  "Food Management System";
        String keyword_ = "Foodics";
        String keywordSelect = "foodics";
        googleSearchResultIsArabicLanguage = browser.google.googleSearch
                .isGoogleSearchIsSwitchToArabicLanguage();
        browser.google.googleSearch
                .enterKeywordInSearchBox(keyword)
                .clearSearchInput()
                .enterKeywordInSearchBox(keyword_)
                .clickOnSearchResultByName(keywordSelect);

        browser.google.searchResult.scrollDown();

        boolean isRepeated = browser.google.searchResult.isSearchResultIsRepeated();
        assertFalse(isRepeated);
    }

}
