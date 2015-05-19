
select t_post.* from t_post, t_topic  where t_post.POST_ID=t_topic.POST_ID order by t_post.time_t fetch first 1 rows only;

