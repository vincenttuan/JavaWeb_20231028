# JavaWeb_20231028
JavaWeb_20231028
# Jakarta Standard Tag Library Tag Libraries
https://jakarta.ee/specifications/tags/3.0/jakarta-tags-spec-3.0#multiple-tag-libraries
<pre>
&lt;dependency>
  &lt;groupId>jakarta.servlet.jsp.jstl&lt;/groupId>
  &lt;artifactId>jakarta.servlet.jsp.jstl-api&lt;/artifactId>
  &lt;version>3.0.0&lt;/version>
&lt;/dependency>
&lt;dependency>
  &lt;groupId>org.glassfish.web&lt;/groupId>
  &lt;artifactId>jakarta.servlet.jsp.jstl&lt;/artifactId>
  &lt;version>3.0.0&lt;/version>
&lt;/dependency>
</pre>
# 建立訪客留言表(MySQL)
<pre>
-- 刪除訪客留言表
drop table if exists guestbook;

-- 建立訪客留言表
create table if not exists guestbook(
	id int not null auto_increment,
    username varchar(50) not null,
    message varchar(255) not null,
    createtime timestamp default current_timestamp,
    primary key(id)
);

-- 建立訪客留言表預設資料
insert into guestbook(username, message) values('John', 'Hello 1');
insert into guestbook(username, message) values('Mary', 'Welcome 2');
insert into guestbook(username, message) values('海倫', '大家好 3');

-- 分頁 view
USE `demo`;
CREATE  OR REPLACE VIEW `guestbook_page_info` AS

select 10 as records_of_page, 
		count(*) as count, 
        ceil(count(*)/10) as max_page 
from guestbook;
</pre>
