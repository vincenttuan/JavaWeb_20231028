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
-- 建立訪客留言表
create table if not exists guestbook(
	id int not null auto_increment,
    username varchar(50) not null,
    message varchar(255) not null,
    createtime timestamp default current_timestamp,
    primary key(id)
);
</pre>
