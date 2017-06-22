package com.generic.search.controller;

import com.generic.search.common.DefaultResponse;
import com.generic.search.common.GenericSearchFieldValidator;
import com.generic.search.common.SearchRequestDto;
import com.generic.search.entity.College;
import com.generic.search.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.Collection;

/**
 * Created by pradip on 6/21/17.
 * Email pradip@drac.com.np
 */
@RestController
public class CollegeController {

    private final CollegeService collegeService;

    @Autowired
    public CollegeController(CollegeService collegeService) {
        this.collegeService = collegeService;
    }

    @PostMapping("/search")
    public ResponseEntity<Collection<College>> searchCollege(@RequestBody SearchRequestDto searchRequestDto) {
        GenericSearchFieldValidator.validateSearchField(searchRequestDto.getSearchOptions(), College.class);
        return new ResponseEntity<Collection<College>>(collegeService.search(searchRequestDto, College.class), HttpStatus.OK);
    }
}
