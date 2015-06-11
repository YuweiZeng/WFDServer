/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wfd.services;


import com.wfd.dao.TCommentDao;
import com.wfd.dao.TFavoriteDao;
import com.wfd.dao.TPostDao;
import com.wfd.dao.TTopicDao;
import com.wfd.dao.TUsersDao;
import com.wfd.dao.VTopicDao;
import com.wfd.entities.TComment;
import com.wfd.entities.TFavorite;
import com.wfd.entities.TFavoritePK;
import com.wfd.entities.TPost;
import com.wfd.entities.TTopic;
import com.wfd.entities.VTopic;
import com.wfd.util.Constants;
import com.wfd.util.DateUtil;
import com.wfd.util.FileUtil;
import java.io.File;
import java.io.InputStream;
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
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;


/**
 *
 * @author user
 */

@Path("/topic")
public class TopicService {
    @EJB
    VTopicDao vtopicDao;
    @EJB
    TUsersDao usersDao;
    @EJB
    TPostDao postDao;
    @EJB
    TTopicDao topicDao;
    @EJB
    TFavoriteDao favoriteDao;
    @EJB
    TCommentDao commentDao;
    
    
    @GET
    @Produces({"application/json"})
    public List<VTopic> getTopics(@QueryParam("orderby") String orderBy) {
        
        if(orderBy.equalsIgnoreCase(Constants.ORDERBY_LATEST)){
            return vtopicDao.getLatestPost();
        }else if(orderBy.equalsIgnoreCase(Constants.ORDERBY_FAVORITE)){
            return vtopicDao.getFavoritePost();
        }else{
            return null;
        }
    }

    @POST
    @Path("{id}/newcomment")
    @Consumes("text/plain")
    public void addComment(@PathParam("id") int topicID, @QueryParam("user_id") int userID, String content) {
        // Initial post table
        TPost post = new TPost();
        post.setContent(content);
        post.setUserId(usersDao.find(userID));
        post = postDao.persist(post);
        System.out.println("end: " + post.getPostId());
        
         // Initial comment table
        TComment comment = new TComment();
        comment.setPostId(post);
        commentDao.persist(comment);
        System.out.println("Success");
        
    }
    
    @PUT
    @Path("/new")
    @Consumes("text/plain")
    public void newTopic(@QueryParam("user_id") int userID, String content) {
        // Initial post table
        TPost post = new TPost();
        post.setContent(content);
        post.setUserId(usersDao.find(userID));
        post = postDao.persist(post);
        System.out.println("end: " + post.getPostId());
        
         // Initial topic table
        TTopic topic = new TTopic();
        topic.setPostId(post);
        topicDao.persist(topic);
        System.out.println("Success");
        
    }
    
    //disable the image upload
//    @PUT
//    @Path("/new")
//    @Consumes({MediaType.MULTIPART_FORM_DATA})
//    public void newTopics(@FormDataParam("content") String content,
//                            @FormDataParam("user_id") Integer userID,
//                            @FormDataParam("image") InputStream fileInputStream,
//                            @FormDataParam("image") FormDataContentDisposition chd){
//        String imagePath = Constants.IMAGE_STORAGE_PATH + userID + File.separator + DateUtil.getCurrentDateString() + chd.getFileName();
//        FileUtil.writeToFile(fileInputStream, imagePath);
//        // Initial post table
//        TPost post = new TPost();
//        post.setContent(content);
//        post.setUserId(usersDao.find(userID));
//        post = postDao.persist(post);
//        System.out.println("end: " + post.getPostId());
//        // Initial topic table
//        TTopic topic = new TTopic();
//        topic.setPostId(post);
//        topicDao.persist(topic);
//        System.out.println("Success");
//    }
    
    
    @POST
    @Path("{id}/follows")
    public void follows(@PathParam("id") int topicID, @QueryParam("type") String type) {
        
        if(type.equalsIgnoreCase(Constants.DISAGREE)){
            topicDao.disagree(topicID);
        }else if(type.equalsIgnoreCase(Constants.AGREE)){
            topicDao.agree(topicID);
        }
    }
    
    @POST
    @Path("{id}/favorite")
    public void addFavorite(@PathParam("id") int topicID, @QueryParam("user_id") int userID) {
        
        TFavoritePK pk = new TFavoritePK();
        pk.setUserId(userID);
        pk.setTopicId(topicID);
        TFavorite favorite = new TFavorite();
        favorite.setTFavoritePK(pk);
        favoriteDao.update(favorite);
    }
    
}
