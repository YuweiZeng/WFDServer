/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wfd.dao;

import com.wfd.entities.VTopic;
import com.wfd.util.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
public class VTopicDao extends GenericDao<VTopic,Integer>{
//    @PersistenceContext(unitName = "WFD_JPA")
    private EntityManager em;
    
    public VTopicDao(){
        super(VTopic.class);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WFD_JPA");
        em = emf.createEntityManager();
    }
    
    @Override
    public EntityManager getEntityManager(){
        return em;
    }
    
    public List<VTopic> getLatestPost(){
        
        String jpql = "select t from VTopic t order by t.timeT desc";
        Query query = em.createQuery(jpql).setMaxResults(Constants.DEFAULT_PAGE_NUMBER);
        List<VTopic> list = query.getResultList();
        
        if(list.isEmpty()){
            System.out.println("No post in db");
            return null;
        }
        return list;
    }
    
    public List<VTopic> getBestOfPost(){
        
        String jpql = "select t from VTopic t order by t.supportCount desc";
        Query query = em.createQuery(jpql).setMaxResults(Constants.DEFAULT_PAGE_NUMBER);
        List<VTopic> list = query.getResultList();
        
        if(list.isEmpty()){
            System.out.println("No post in db");
            return null;
        }
        return list;
    }
    
    public List<VTopic> getRandomPost(){
        
        List<VTopic> list = this.findAll();
        Collections.shuffle(list);
        if(list.size() > Constants.DEFAULT_PAGE_NUMBER){
            return list.subList(0, Constants.DEFAULT_PAGE_NUMBER);
        }
        return list;
    }
    
    public VTopic getPostByTopicID(int topicID){
        
        String jpql = "select t from VTopic t where t.topicId=?1 order by t.timeT desc";
        Query query = em.createQuery(jpql).setMaxResults(Constants.DEFAULT_PAGE_NUMBER);
        query.setParameter(1, topicID);
        return (VTopic)query.getSingleResult();
        
    }
    
    public List<VTopic> seachTopic(String keyword, String category, String startTime, String endTime){
        
        List<String> search = new ArrayList<String>();
        if(keyword != null){
            search.add("t.content like '%" + keyword + "%'");
        }
        if(category != null){
            search.add("t.category like '%" + category + "%'");
        }
        if(startTime != null && endTime != null){
            search.add("t.timeT between '" + startTime + "' and '" + endTime + "'");
        }
        String jpql = "select t from VTopic t";
        if(!search.isEmpty()){
            jpql += " where " + String.join(" and ", search);
        }
        System.out.println(jpql);
        Query query = em.createQuery(jpql).setMaxResults(Constants.DEFAULT_PAGE_NUMBER);
        List<VTopic> list = query.getResultList();
        return list;
    }
    
}
