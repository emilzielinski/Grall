INSERT INTO Categories
SELECT * FROM CSVREAD('classpath:db/categories.csv',
'id_Categories,categories_Name');

-- INSERT INTO Article
-- SELECT * FROM CSVREAD('classpath:db/article.csv',
-- 'id_Article,Article_title,Article_content,Article_date,Article_author,id_Categories,Article_image');
--
-- INSERT INTO Comments
-- SELECT * FROM CSVREAD('classpath:db/comments.csv',
-- 'id_Comments,comments_Content,comments_Date,id_Article,comments_User');
--
-- INSERT INTO Score
-- SELECT * FROM CSVREAD('classpath:db/score.csv',
-- 'id_Score,score_Number,id_Article');

INSERT INTO users(username,password,email,enabled)
VALUES ('admin','admin','test@test.pl', true);
INSERT INTO users(username,password,email,enabled)
VALUES ('user','user','test@test.pl', true);

INSERT INTO user_roles (username, role)
VALUES ('user', 'ROLE_USER');
INSERT INTO user_roles (username, role)
VALUES ('admin', 'ROLE_ADMIN');
