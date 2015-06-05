/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wfd.dao;

import com.wfd.entities.TUsers;
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
public class TUsersDao extends GenericDao<TUsers, Integer>{
//    @PersistenceContext(unitName="WFD_JPA")
    private EntityManager em;
    
    public TUsersDao(){
        super(TUsers.class);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WFD_JPA");
        em = emf.createEntityManager(); 
    }
    
    @Override
    public EntityManager getEntityManager(){
        return em;
    }
    
    public TUsers getUserInfo(String userName){
        
       String jpql = "select t from TUsers t where t.username=?1";
       Query query = em.createQuery(jpql,TUsers.class);
       query.setParameter(1, userName);
       return (TUsers)query.getSingleResult();
       
    }
}
