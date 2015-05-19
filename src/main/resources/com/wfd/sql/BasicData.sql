/*prepara basic data for t_users*/
insert into t_users(username, password) values('yzeng','yzeng');
insert into t_users(username, password) values('Kami','111111');
insert into t_users(username, password) values('Aalto','111111');
insert into t_users(username, password) values('Abdie','111111');
insert into t_users(username, password) values('Babbitt','111111');
insert into t_users(username, password) values('Macy','111111');
insert into t_users(username, password) values('Quinn','111111');
insert into t_users(username, password) values('Hall','111111');
insert into t_users(username, password, securityquestion, securityanswer) values('Hall','111111','birthday','901111');
insert into t_users(username, password, securityquestion, securityanswer) values('Hall','111111','father','Paul');

/*prepare basic data for t_post*/
insert into t_post(user_id,content,time_t) values (2,'this is a test content1',CURRENT_TIMESTAMP);
insert into t_post(user_id,content,time_t) values (3,'this is a test content2',CURRENT_TIMESTAMP);
insert into t_post(user_id,content) values (4,'this is a test content3');

/*prepare basic date for t_topic*/
insert into t_topic(post_id,support_count,disagree_count) values (1,100,20);
insert into t_topic(post_id,support_count,disagree_count) values (2,200,20);
insert into t_topic(post_id,support_count,disagree_count) values (3,0,0);



