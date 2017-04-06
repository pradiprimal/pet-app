package com.petapplication.repository.impl;

import com.mysema.query.jpa.impl.JPAQuery;
import com.petapplication.entity.PetInfo;
import com.petapplication.entity.QPetInfo;
import java.util.List;
import javax.persistence.EntityManager;
import com.petapplication.repository.custom.PetInfoRepositoryCustom;
import javax.persistence.PersistenceContext;

/**
 *
 * @author admin
 */
public class PetInfoRepositoryImpl implements PetInfoRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PetInfo> getAllPetInfos() {
        JPAQuery query = new JPAQuery(entityManager);
        QPetInfo petInfo = QPetInfo.petInfo;
        return query.from(petInfo).list(petInfo);
    }
}
