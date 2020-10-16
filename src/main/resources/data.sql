insert into Blogger (age,name) VALUES (23,'Mate');
insert into Blogger (age,name) VALUES (21,'Edina');
insert into Blogger (age,name) VALUES (23,'Alpar');
insert INTO Blogger (age,name) VALUES(24,'Alma');


insert INTO Stories (title,content,posted,blogger_id) VALUES('Teszt cim','Teszt tartalom','2020-10-14',1);
insert INTO Stories (title,content,posted,blogger_id) VALUES('Teszt1 cim','Teszt1 tartalom',CURRENT_DATE(),(select id from Blogger where name = 'Alpar'));
insert INTO Stories (title,content,posted,blogger_id) VALUES('Teszt2 cim','Teszt2 tartalom',CURRENT_DATE(),(select id from Blogger where name = 'Mate')); 
insert INTO Stories (title,content,posted,blogger_id) VALUES('Szia','Teszt2 tartalom',CURRENT_DATE(),(select id from Blogger where name = 'Mate')); 