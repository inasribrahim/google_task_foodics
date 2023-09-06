# Google Automation Framework Task - Foodics

    
1- verify that google search result page two match with page three.

```java
    @Test
    public void verifyThatGoogleSearchResultPageTwoMatchWithPageThree() {
        String keyword =  "Food Management System";
        String keyword_ = "Foodics";
        String keywordSelect = "foodics";

        boolean googleSearchResultIsArabicLanguage = browser.google.googleSearch
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

        assertEquals(searchResultPageTwo, searchResultPageThree);
    }
}
```

2- verify that google suggestion in search result is different.

```java 
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

```
## Running tests through testng xml

    * Create or Select the required google-testng xml -> Right click and select Run

## Running tests through command line  

    * Navigate to project directory and run 'mvn clean install'


## Open Report and Enjoy :)

    * Navigate to project directory and  open 'Report.html' file