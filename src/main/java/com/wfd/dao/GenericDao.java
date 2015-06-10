/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wfd.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

/**
 *
 * @author user
 */
public abstract class GenericDao <T, ID extends Serializable>{
    
    private Class<T> entityClass;
    protected abstract EntityManager getEntityManager();
    
    public GenericDao(Class<T> entityClass){
        this.entityClass = entityClass;
    }
    
    public T persist(T entity){
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(entity);
        getEntityManager().getTransaction().commit();
        return entity;
    }
    
    public void update(T entity){
        getEntityManager().merge(entity);
    }
    
    public List<T> findAll(){
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(this.entityClass));
        return getEntityManager().createQuery(cq).getResultList();
        
    }
    
    public T find(ID id){
        return getEntityManager().find(this.entityClass, id);
    }
    
}
