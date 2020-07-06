use paoloweb;

insert into blogPost (link, content, title, date) 
values ('this-is-a-test', '<h3>My first blog post<br><br><p>This is my the first of many blog posts</p><br>', 
'This is a test', sysdate());

insert into blogPost (link, content, title, date) 
values ('second-post-live', '<h3>My Second blog post<br><br><p>This is my the second of many blog posts</p><br>', 
'What a time to be live gentleman', sysdate());

commit;

delete from blogPost where idblogPost = 1;

select * from blogPost;

