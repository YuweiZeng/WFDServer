/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wfd.dao;

import com.wfd.entities.TFavorite;
import com.wfd.entities.TFavoritePK;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
@Stateless
public class TFavoriteDao extends GenericDao<TFavorite,TFavoritePK>{
//    @PersistenceContext(unitName = "WFD_JPA")
    private EntityManager em;
    
    public TFavoriteDao(){
        super(TFavorite.class);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WFD_JPA");
        em = emf.createEntityManager();
    }
    
    @Override
    public EntityManager getEntityManager(){
        return em;
    }
    
}
