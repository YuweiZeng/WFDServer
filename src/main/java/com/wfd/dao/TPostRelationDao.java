/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wfd.dao;

import com.wfd.entities.TPostRelation;
import com.wfd.entities.TPostRelationPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author user
 */
@Stateless
public class TPostRelationDao extends GenericDao<TPostRelation,TPostRelationPK>{
//    @PersistenceContext(unitName = "WFD_JPA")
    private EntityManager em;
    
    public TPostRelationDao(){
        super(TPostRelation.class);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WFD_JPA");
        em = emf.createEntityManager();
    }
    
    @Override
    public EntityManager getEntityManager(){
        return em;
    }
    
    public List<TPostRelation> getChildID(int parentId){
        String jpql = "select t from TPostRelation t where t.tPostRelationPK.parentId=?1";
        Query query = em.createQuery(jpql,TPostRelation.class);
        query.setParameter(1, parentId);
        return query.getResultList();
    }
    
}
