/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wfd.services;

import com.wfd.dao.TUsersDao;
import com.wfd.entities.TUsers;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.json.JSONObject;

/**
 *
 * @author user
 */
@Path("/users")
public class UserService {
    
    @EJB
    TUsersDao userDao;
    
    @GET
    @Produces({"application/xml", "application/json"})
    public TUsers getUser(@QueryParam("username") String userName) {
        return userDao.getUserInfo(userName);
    }
    
    @POST
    @Path("/login")
    @Consumes("text/plain")
    @Produces("text/plain")
    public String login(String userInfo){
         
      JSONObject json = new JSONObject(userInfo);
      JSONObject result = new JSONObject();
      String userName = json.getString("username");
      String pwd = json.getString("pwd");
      TUsers user = userDao.check(userName, pwd);
      if(user == null){
          result.put("login", "false");
      }else{
          result.put("login", "true");
          result.put("user_id", user.getUserId().toString());
      }
      return result.toString();
    }
    
    @PUT
    @Path("/new")
    @Consumes("text/plain")
    @Produces("text/plain")
    public String newUser(String userInfo){
         
      JSONObject json = new JSONObject(userInfo);
      JSONObject result = new JSONObject();
      String userName = json.getString("username");
      String pwd = json.getString("pwd");
      String location = json.getString("location");
      TUsers user = new TUsers();
      user.setUsername(userName);
      user.setPassword(pwd);
      user.setLocation(location);
      user = userDao.persist(user);
      result.put("user_id", user.getUserId());
      return result.toString();
    }
    
    
}
