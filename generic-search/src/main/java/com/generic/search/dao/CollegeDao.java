package com.generic.search.dao;

import com.generic.search.entity.College;

import java.util.List;

/**
 * Created by pradip on 6/21/17.
 * Email pradip@drac.com.np
 */
public interface CollegeDao {
    List<College> searchCollege(String query);
}
