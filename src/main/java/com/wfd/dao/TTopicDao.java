/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wfd.dao;

import com.wfd.entities.TTopic;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
@Stateless
public class TTopicDao extends GenericDao<TTopic,Integer>{
//    @PersistenceContext(unitName = "WFD_JPA")
    private EntityManager em;
    
    public TTopicDao(){
        super(TTopic.class);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WFD_JPA");
        em = emf.createEntityManager();
    }
    
    @Override
    public EntityManager getEntityManager(){
        return em;
    }
    
    public void disagree(int id){
        em.getTransaction().begin();
        TTopic topic = this.find(id);
        topic.setDisagreeCount(topic.getDisagreeCount() + 1);
//        em.flush();
        em.getTransaction().commit();
    }
    
    public void agree(int id){
        em.getTransaction().begin();
        TTopic topic = this.find(id);
        topic.setSupportCount(topic.getSupportCount() + 1);
//        em.flush();
        em.getTransaction().commit();
    }
    
    public int getTopicID(int postID){
//        String jpql = "select t from TTopic t where t.username=?1";
//        Query query = em.createQuery(jpql,TUsers.class);
//        query.setParameter(1, userName);
//        return (TUsers)query.getSingleResult();
        return 1;
        
    }
    
}
