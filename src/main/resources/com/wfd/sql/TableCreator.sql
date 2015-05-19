CREATE TABLE t_users(
user_id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
username VARCHAR(255) NOT NULL,
password VARCHAR(255) NOT NULL,
securityquestion VARCHAR(255) DEFAULT '',
securityanswer VARCHAR(255) DEFAULT '',
CONSTRAINT pk_user_id PRIMARY KEY (user_id)
);
CREATE TABLE t_post(
post_id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
user_id INTEGER,
content VARCHAR(2000),
deleted BOOLEAN DEFAULT FALSE,
time_t TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
CONSTRAINT pk_post_id PRIMARY KEY (post_id),
CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES t_users(user_id)
);

/*Create topic infomation table*/
CREATE TABLE t_topic(
topic_id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
post_id INTEGER,
support_count INTEGER,
disagree_count INTEGER,
CONSTRAINT pk_topic_id PRIMARY KEY (topic_id),
CONSTRAINT fk_topic_post FOREIGN KEY (post_id) REFERENCES t_post(post_id)
);

/*Create comment information table*/
CREATE TABLE t_comment(
comment_id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
post_id INTEGER,
CONSTRAINT pk_comment_id PRIMARY KEY (comment_id),
CONSTRAINT fk_comment_post FOREIGN KEY (post_id) REFERENCES t_post(post_id)
);

/*Create comment information table*/
CREATE TABLE t_post_relation(
parent_id INTEGER,
child_id INTEGER,
CONSTRAINT pk_relation_id PRIMARY KEY (parent_id,child_id)
);

 

