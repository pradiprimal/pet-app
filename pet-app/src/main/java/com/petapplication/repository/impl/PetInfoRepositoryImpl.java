package com.petapplication.repository.impl;

import com.mysema.query.jpa.impl.JPAQuery;
import com.petapplication.entity.PetInfo;
import com.petapplication.entity.QPetInfo;
import java.util.List;
import javax.persistence.EntityManager;
import com.petapplication.repository.custom.PetInfoRepositoryCustom;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author admin
 */
public class PetInfoRepositoryImpl implements PetInfoRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public List<PetInfo> getAllPetInfos() {
        Query query1=entityManager.createNativeQuery("BEGIN CREATE TABLE test.Persons (PersonID int,LastName varchar(255)) CREATE TABLE test.Animal (PersonID int,LastName varchar(255))");
        query1.executeUpdate();
        JPAQuery query = new JPAQuery(entityManager);
        QPetInfo petInfo = QPetInfo.petInfo;
        return query.from(petInfo).list(petInfo);
    }
}
