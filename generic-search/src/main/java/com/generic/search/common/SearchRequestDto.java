package com.generic.search.common;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by pradip on 6/22/17.
 * Email pradip@drac.com.np
 */
public class SearchRequestDto implements Serializable {

    private String tabaleName;
    private Map<String, String> searchOptions;

    public String getTabaleName() {
        return tabaleName;
    }

    public void setTabaleName(String tabaleName) {
        this.tabaleName = tabaleName;
    }

    public Map<String, String> getSearchOptions() {
        return searchOptions;
    }

    public void setSearchOptions(Map<String, String> searchOptions) {
        this.searchOptions = searchOptions;
    }

    @Override
    public String toString() {
        return "SearchRequestDto{" +
                "tabaleName='" + tabaleName + '\'' +
                ", searchOptions=" + searchOptions +
                '}';
    }
}
