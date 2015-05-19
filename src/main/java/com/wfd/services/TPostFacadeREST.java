/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wfd.services;

import com.wfd.entities.TPost;
import com.wfd.util.SqlConstant;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author user
 */
@Stateless
@Path("/wfd_post")
public class TPostFacadeREST extends AbstractFacade<TPost> {
    @PersistenceContext(unitName = "org.schooltask_WFDServer_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public TPostFacadeREST() {
        super(TPost.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(TPost entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, TPost entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public TPost find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Path("/latestpost")
    @Produces({"application/json"})
    public List<TPost> getLatestPost() {
        System.out.println(SqlConstant.POST_LASTEST);
        Query query =  em.createNativeQuery(SqlConstant.POST_LASTEST,TPost.class);
        List<TPost> posts = query.getResultList();
        return posts;
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<TPost> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<TPost> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
