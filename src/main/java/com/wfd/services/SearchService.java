/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wfd.services;


import com.wfd.dao.TCommentDao;
import com.wfd.dao.TFavoriteDao;
import com.wfd.dao.TPostDao;
import com.wfd.dao.TPostRelationDao;
import com.wfd.dao.TTopicDao;
import com.wfd.dao.TUsersDao;
import com.wfd.dao.VTopicDao;
import com.wfd.entities.TComment;
import com.wfd.entities.TFavorite;
import com.wfd.entities.TFavoritePK;
import com.wfd.entities.TPost;
import com.wfd.entities.TPostRelation;
import com.wfd.entities.TPostRelationPK;
import com.wfd.entities.TTopic;
import com.wfd.entities.VTopic;
import com.wfd.util.Constants;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.json.JSONObject;


/**
 *
 * @author user
 */

@Path("/search")
public class SearchService {
    @EJB
    VTopicDao vtopicDao;
    
    
    @GET
    @Produces({"application/json"})
    public List<VTopic> getTopics(@QueryParam("keyword") String keyword,
                                   @QueryParam("category") String category,
                                   @QueryParam("time") String time) {
        
        return vtopicDao.seachTopic(keyword, category, time);
    }
    
}