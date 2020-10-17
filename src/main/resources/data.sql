insert into Blogger (id,age,name) VALUES (2,23,'Mate');
insert into Blogger (id,age,name) VALUES (3,21,'Edina');
insert into Blogger (id,age,name) VALUES (4,23,'Alpar');
insert INTO Blogger (id,age,name) VALUES (5,24,'Alma');


insert INTO Stories (id,title,content,posted,blogger_id) VALUES (2,'Teszt cim','Teszt tartalom','2020-10-14',1);
insert INTO Stories (id,title,content,posted,blogger_id) VALUES (3,'Teszt1 cim','Teszt1 tartalom','2020-10-13', (select id from Blogger where name = 'Alpar'));
insert INTO Stories (id,title,content,posted,blogger_id) VALUES (4,'Teszt2 cim','Teszt2 tartalom','2020-10-12', (select id from Blogger where name = 'Mate')); 
insert INTO Stories (id,title,content,posted,blogger_id) VALUES (5,'Szia','Teszt2 tartalom','2020-10-11', (select id from Blogger where name = 'Mate')); 