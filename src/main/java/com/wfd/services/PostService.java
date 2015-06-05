/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wfd.services;

import com.wfd.dao.VTopicDao;
import com.wfd.entities.VTopic;
import com.wfd.util.Constants;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author user
 */
@Path("/posts")
public class PostService {
    @EJB
    VTopicDao topic;
    
    @GET
    @Produces({"application/json"})
    public List<VTopic> getTopics(@QueryParam("orderby") String orderBy) {
        
        if(orderBy.equalsIgnoreCase("latest")){
            return topic.getLatestPost();
        }else if(orderBy.equalsIgnoreCase(Constants.ORDERBY_FAVORITE)){
            return topic.getFavoritePost();
        }else{
            return null;
        }
    }
    
}
