/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wfd.services;

import com.wfd.entities.TPostRelation;
import com.wfd.entities.TPostRelationPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author user
 */
@Stateless
@Path("com.wfd.entities.tpostrelation")
public class TPostRelationFacadeREST extends AbstractFacade<TPostRelation> {
    @PersistenceContext(unitName = "org.schooltask_WFDServer_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    private TPostRelationPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;parentId=parentIdValue;childId=childIdValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.wfd.entities.TPostRelationPK key = new com.wfd.entities.TPostRelationPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> parentId = map.get("parentId");
        if (parentId != null && !parentId.isEmpty()) {
            key.setParentId(new java.lang.Integer(parentId.get(0)));
        }
        java.util.List<String> childId = map.get("childId");
        if (childId != null && !childId.isEmpty()) {
            key.setChildId(new java.lang.Integer(childId.get(0)));
        }
        return key;
    }

    public TPostRelationFacadeREST() {
        super(TPostRelation.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(TPostRelation entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") PathSegment id, TPostRelation entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        com.wfd.entities.TPostRelationPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public TPostRelation find(@PathParam("id") PathSegment id) {
        com.wfd.entities.TPostRelationPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<TPostRelation> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<TPostRelation> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
