/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wfd.util;

/**
 *
 * @author user
 */
public class SqlConstant {
    
    public static String POST_LASTEST = "select t_post.* from t_post,t_topic " + 
            "where t_post.POST_ID=t_topic.POST_ID order by t_post.time_t limit " + Constants.DEFAULT_PAGE_NUMBER;
    
    public static String POST_BEST = "select t_post from t_post, t_topic " + 
            "where t_post.POST_ID=t_topic.POST_ID order by t_topic.supoort_count desc " + Constants.DEFAULT_PAGE_NUMBER;
    
}
