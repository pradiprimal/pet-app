package com.generic.search.common;

import java.util.List;

/**
 * Created by pradip on 6/21/17.
 * Email pradip@drac.com.np
 */
public interface GenericSearch<T> {

    List<T> search(SearchRequestDto searchData,Class className);
}
