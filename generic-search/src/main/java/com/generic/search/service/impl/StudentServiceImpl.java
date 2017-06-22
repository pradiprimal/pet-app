package com.generic.search.service.impl;

import com.generic.search.common.SearchQueryBuilder;
import com.generic.search.common.SearchRequestDto;
import com.generic.search.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pradip on 6/21/17.
 * Email pradip@drac.com.np
 */
@Service
@Transactional
public class StudentServiceImpl extends SearchQueryBuilder implements StudentService {
    @Override
    public List search(SearchRequestDto searchData, Class className) {

        return null;
    }
}
