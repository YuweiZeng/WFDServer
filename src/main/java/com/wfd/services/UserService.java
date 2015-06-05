/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wfd.services;

import com.wfd.dao.TUsersDao;
import com.wfd.entities.TUsers;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author user
 */
@Path("/users")
public class UserService {
    
    @EJB
    TUsersDao users;
    
    @GET
    @Produces({"application/xml", "application/json"})
    public TUsers getUser(@QueryParam("username") String userName) {
        return users.getUserInfo(userName);
    }
    
}
