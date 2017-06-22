package com.generic.search.service.impl;

import com.generic.search.common.SearchQueryBuilder;
import com.generic.search.common.SearchRequestDto;
import com.generic.search.dao.CollegeDao;
import com.generic.search.entity.College;
import com.generic.search.service.CollegeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pradip on 6/21/17.
 * Email pradip@drac.com.np
 */
@Service
@Transactional
public class CollegeServiceImpl extends SearchQueryBuilder implements CollegeService {
    private final CollegeDao collegeDao;

    public CollegeServiceImpl(CollegeDao collegeDao) {
        this.collegeDao = collegeDao;

    }

    @Override
    public List<College> search(SearchRequestDto searchData, Class className) {
        super.searchQueryParameter = searchData.getSearchOptions();
        super.className = className;
        String query = super.searchQuery();
        System.out.println("query" + query);
        return collegeDao.searchCollege(query);
    }
}
