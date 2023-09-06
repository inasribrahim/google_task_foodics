package com.google.foodics.platform;

import com.google.foodics.screen.*;

public class Google {

    public GoogleSearch googleSearch;
    public SearchResult searchResult;

    public Google(){
        googleSearch = new GoogleSearch();
        searchResult = new SearchResult();
    }
}
