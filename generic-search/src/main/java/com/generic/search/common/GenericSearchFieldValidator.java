package com.generic.search.common;

import java.util.Map;

/**
 * Created by pradip on 6/22/17.
 * Email pradip@drac.com.np
 */
public class GenericSearchFieldValidator {

    public static void validateSearchField(Map<String, String> searchData, Class aClass) {

        for (Map.Entry entry : searchData.entrySet()) {
            checkSearchFieldExistInClass(entry.getKey().toString(), aClass);
        }
    }

    public static void checkSearchFieldExistInClass(String fieldName, Class aClass) {
        try {
            aClass.getDeclaredField(fieldName);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Search Field Not Found!!!");
        }
    }
}
