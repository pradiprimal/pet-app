package com.generic.search.dao.impl;

import com.generic.search.dao.CollegeDao;
import com.generic.search.entity.College;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by pradip on 6/21/17.
 * Email pradip@drac.com.np
 */
@Repository
public class CollegeDaoImpl implements CollegeDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<College> searchCollege(String query) {
        return entityManager.createQuery(query).getResultList();
    }


}
