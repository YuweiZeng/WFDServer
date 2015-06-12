/*prepara basic data for 14 t_users*/
insert into t_users(username, password,location) values('yzeng','yzeng','Ontario');
insert into t_users(username, password,location) values(' MandyO','111111', 'California');
insert into t_users(username, password,location) values('Aalto','111111','Ontario');
insert into t_users(username, password,location) values('Abdie','111111', 'Montana');
insert into t_users(username, password,location) values('Babbitt','111111', 'California');
insert into t_users(username, password,location) values('Macy','111111','Ontario');
insert into t_users(username, password,location) values('Quinn','111111', 'Montana');
insert into t_users(username, password,location) values('Hall','111111', 'California');
insert into t_users(username, password,location) values('Bigbaby','111111', 'Harrow');
insert into t_users(username, password,location) values('what','111111', 'Alberta');
insert into t_users(username, password,location) values('varunet2004','111111', 'Harrow');
insert into t_users(username, password,location) values('awkward','111111', 'California');
insert into t_users(username, password, securityquestion, securityanswer,location) values('Reider022','111111','birthday','901111', 'Alberta');
insert into t_users(username, password, securityquestion, securityanswer,location) values('cwowm','111111','father','Paul','Ontario');

/*prepare basic data for t_post*/
insert into t_post(user_id,content,time_t) values (1,'Today, I had to use the bathroom really badly in a drug store. After I did a #2, just as I realized the handle on the toilet was broken, a knock came at the door. I tried fixing it for ten minutes, before slipping out the door, to come face to face with two employees coming to fix the toilet.','2013-01-01 18:18:01');
/*comments for post 1*/
insert into t_post(user_id,content,time_t) values (2,'At least you will never have to see those employees ever again.','2014-04-01 18:18:01');
insert into t_post(user_id,content,time_t) values (2,'Their problem for not putting a sign on the door, either that or you picked out some good drugs.','2014-05-01 18:18:01');
insert into t_post(user_id,content,time_t) values (3,'It was still a shitty situation to be in.','2014-04-02 18:18:01');
insert into t_post(user_id,content,time_t) values (1,'Take your shitty pun and flush it down the toilet... Oh wait.','2014-04-07 18:18:01');
insert into t_post(user_id,content,time_t) values (2,'Let us get it out of they way. That is a pretty shitty situation.','2014-04-08 18:18:01');
insert into t_post(user_id,content,time_t) values (4,'This happened to my ex-roommate once, except it was my gramps fixing the toilet.','2014-04-09 18:18:01');
insert into t_post(user_id,content,time_t) values (5,'What are the odds?','2014-04-11 18:18:01');
insert into t_post(user_id,content,time_t) values (9,'Shit happens.',CURRENT_TIMESTAMP);
insert into t_post(user_id,content,time_t) values (8,"That first sentence you decided to type out is just as bad as the puns.",CURRENT_TIMESTAMP);
insert into t_post(user_id,content,time_t) values (2,'That must have been awkward..',CURRENT_TIMESTAMP);
/*relation 1*/
insert into t_post_relation(parent_id,child_id) values(1,2);
insert into t_post_relation(parent_id,child_id) values(1,3);
insert into t_post_relation(parent_id,child_id) values(1,4);
insert into t_post_relation(parent_id,child_id) values(1,5);
insert into t_post_relation(parent_id,child_id) values(1,6);
insert into t_post_relation(parent_id,child_id) values(1,7);
insert into t_post_relation(parent_id,child_id) values(1,8);insert into t_post_relation(parent_id,child_id) values(1,9);
insert into t_post_relation(parent_id,child_id) values(1,10);
insert into t_post_relation(parent_id,child_id) values(1,11);

/*topic 2*/
insert into t_post(user_id,content,time_t) values (8,"Today, a customer yelled at me because the cherry pie he bought had cherries in it, and he wanted a refund",'2013-01-01 18:18:01');
/*comments for post 2*/
insert into t_post(user_id,content,time_t) values (8,"That first sentence you decided to type out is just as bad as the puns.",CURRENT_TIMESTAMP);
insert into t_post(user_id,content,time_t) values (2,'That must have been awkward..',CURRENT_TIMESTAMP);
/*relation 2*/
insert into t_post_relation(parent_id,child_id) values(12,13);
insert into t_post_relation(parent_id,child_id) values(12,14);

/*topic 3*/
insert into t_post(user_id,content) values (9,"Today, the man who stole my laptop at the train station yesterday used the contact information I had written on it to call me and ask for the password.");
/*comments for post 3*/
insert into t_post(user_id,content,time_t) values (8,"Good",CURRENT_TIMESTAMP);
insert into t_post(user_id,content,time_t) values (2,'That must have been awkward..',CURRENT_TIMESTAMP);
/*relation 3*/
insert into t_post_relation(parent_id,child_id) values(15,16);
insert into t_post_relation(parent_id,child_id) values(15,17);

/*topic 4*/
insert into t_post(user_id,content,time_t) values (3,"Today, I was talking to an old man I met at a store. He just wanted to know a few things, and he asked about my day. I explained a few bad things thatd happened, then I thanked him for listening. He then asked, So, how are we gonna do this? He thought we were gonna fuck. ",'2003-01-01 18:18:01');
/*comments for post 4*/
insert into t_post(user_id,content,time_t) values (8,"That first sentence you decided to type out is just as bad as the puns.",CURRENT_TIMESTAMP);
insert into t_post(user_id,content,time_t) values (2,'That must have been awkward..',CURRENT_TIMESTAMP);
/*relation 4*/
insert into t_post_relation(parent_id,child_id) values(18,19);
insert into t_post_relation(parent_id,child_id) values(18,20);

insert into t_post(user_id,content) values (8,"Today, I walked in on my husband going down on another woman. Instead of speaking, he looked at me, got up, and slammed the door.");
insert into t_post(user_id,content,time_t) values (11,"Today, I confronted my boss for his inadequate contribution in our work. He accepted his inadequacy and apologized for not doing enough. He now expects me to work on everything singlehandedly since he has already clarified his inadequacy.",'2003-01-01 18:18:01');
insert into t_post(user_id,content) values (12,"Today, I had to endure the most mortifying ambulance ride of my life after my fiancs cock ring got stuck on my tongue piercing. As I was trying not to choke or vomit, he actually high-fived one of the EMTs and tried to get him to take a picture on his phone. ");
insert into t_post(user_id,content,time_t) values (13,"Today, the main file and backups of the book I have been writing for 2 and a half years mysteriously vanished. It turned out my mum decided that me spending so much time in my room must mean I am watching porn, and so she trashed everything. ",'2010-11-11 18:18:01');
insert into t_post(user_id,content) values (5,"Today, my boyfriend and I were downtown when he pointed to a girl and said he wished I dressed more like she did. She was obviously a hooker.");
insert into t_post(user_id,content,time_t) values (6,"Today, I walked in on my husband going down on another woman. Instead of speaking, he looked at me, got up, and slammed the door. ",'2013-07-02 18:18:01');
insert into t_post(user_id,content) values (7,"Today, the main file and backups of the book I have been writing for 2 and a half years mysteriously vanished. It turned out my mum decided that me spending so much time in my room must mean I am watching porn, and so she trashed everything. ");
insert into t_post(user_id,content,time_t) values (3,"Today, my boyfriend and I were downtown when he pointed to a girl and said he wished I dressed more like she did. She was obviously a hooker.",'2013-09-05 18:18:01');
insert into t_post(user_id,content) values (2,"Today, while showering, I found eternal bliss, I finally managed to scratch the hell out of that hard-to-reach spot on my back. Then my wife came in and saw the scratch marks on my back. Now I am sleeping on the couch.");
insert into t_post(user_id,content,time_t) values (3,"Today, I have food poisoning. My boss told me that if I did not come into work, I jad be fired. Not 30 minutes after sitting down, I sneezed and shat my pants. My boss still will not let me leave.",'2009-01-21 18:18:01');
insert into t_post(user_id,content) values (4,"Today, I moved in with my boyfriend because my parents kicked me out. He said that if I ever touch his fucking apple jacks my nipples off and feed them to the dog.");
insert into t_post(user_id,content,time_t) values (3,"Today, I lost all of my male friends at work. Why? The new girl has my same interests and a prettier face. ",'2013-03-01 18:18:01');
insert into t_post(user_id,content,time_t) values (4,"Today, as I was putting stuff into the back of my car, a man walked by and said I looked super fine.When I looked up to look him in the face ",'2014-09-15 18:18:01');
insert into t_post(user_id,content,time_t) values (3,"Today, a customer yelled at me because the cherry pie he bought had cherries in it, and he wanted a refund.",'2014-04-01 18:18:01');
insert into t_post(user_id,content) values (2,"Today, while showering, I found eternal bliss, I finally managed to scratch the hell out of that hard-to-reach spot on my back. Then my wife came in and saw the scratch marks on my back. Now I am sleeping on the couch.");
insert into t_post(user_id,content,time_t) values (3,"Today, I have food poisoning. My boss told me that if I did not come into work, I had be fired. Not 30 minutes after sitting down, I sneezed and shat my pants. My boss still will not let me leave.",'2009-01-21 18:18:01');
insert into t_post(user_id,content) values (4,"Today, I moved in with my boyfriend because my parents kicked me out. He said that if I ever touch his fucking apple jacks he will chop my nipples off and feed them to the dog.");
insert into t_post(user_id,content,time_t) values (3,"Today, I lost all of my male friends at work. Why? The new girl has my same interests and a prettier face. ",'2013-03-01 18:18:01');
insert into t_post(user_id,content,time_t) values (4,"Today, as I was putting stuff into the back of my car, a man walked by and said I looked super fine.When I looked up to look him in the face, he immediately looked disgusted and basically ran away.",'2014-09-15 18:18:01');
insert into t_post(user_id,content,time_t) values (3,"Today, a customer yelled at me because the cherry pie he bought had cherries in it, and he wanted a refund.",'2014-04-01 18:18:01');

/*prepare basic date for t_topic*/
insert into t_topic(post_id,support_count,disagree_count,category) values (1,1100,20,"work");
insert into t_topic(post_id,support_count,disagree_count,category) values (12,200,20,"animal");
insert into t_topic(post_id,support_count,disagree_count,category) values (15,212,21,"health");
insert into t_topic(post_id,support_count,disagree_count,category) values (18,341,321,"animal");
insert into t_topic(post_id,support_count,disagree_count,category) values (21,200,20,"money");
insert into t_topic(post_id,support_count,disagree_count,category) values (22,1100,120,"work");
insert into t_topic(post_id,support_count,disagree_count,category) values (23,100,145,"animal");
insert into t_topic(post_id,support_count,disagree_count,category) values (24,200,20,"work");
insert into t_topic(post_id,support_count,disagree_count,category) values (25,0,0,"money");
insert into t_topic(post_id,support_count,disagree_count,category) values (26,100,20,"animal");
insert into t_topic(post_id,support_count,disagree_count,category) values (27,341,321,"money");
insert into t_topic(post_id,support_count,disagree_count,category) values (28,672,126,"animal");
insert into t_topic(post_id,support_count,disagree_count,category) values (29,100,20,"health");
insert into t_topic(post_id,support_count,disagree_count,category) values (30,200,145,"love");
insert into t_topic(post_id,support_count,disagree_count,category) values (31,0,0,"money");
insert into t_topic(post_id,support_count,disagree_count,category) values (32,100,20,"love");
insert into t_topic(post_id,support_count,disagree_count,category) values (33,672,321,"work");
insert into t_topic(post_id,support_count,disagree_count,category) values (34,341,0,"love");



