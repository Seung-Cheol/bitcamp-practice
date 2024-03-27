--게시글 상세페이지
select
p.post_no,
p.title,
p.content,
f.file_no,
f.name,
f.path,
(select count(*) from likes as l where p.post_no = l.post_no),
c.user_no,
c.comment_no,
c.content,
c.created_at
from posts as p 
left outer join comments as c on p.post_no = c.post_no
left outer join files as f on p.post_no = f.post_no
inner join school_users as s on c.user_no = s.user_no 
where p.post_no = 3 and p.category_no=4 order by c.created_at asc;

--약속 상세페이지
select * from classes as c left outer join 
class_users as u on c.class_no = u.class_no where c.class_no=2;


