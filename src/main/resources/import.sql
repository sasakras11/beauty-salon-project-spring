insert into users (username,password,role) VALUES('alex','$2a$10$leUOaKpnUywfz8xPTOs5Z.vruu37D8zEKbadJAASmOi5YOLu8VNWi','ADMIN');
insert into users (username,password,role) VALUES('ivan','$2a$10$ND2sshZjxcPeHgRp3DSI2ulS.FVBy2W5VNltsQrrVRIGEEcbLrAC6','CLIENT');
insert into users (username,password,role) VALUES('sonya','$2a$10$aIUl4AxjPX7tBhljTyiwiuR28BwDvRsW5IGXlQfz6UHZQnUB3KOd6','MASTER');
insert into users (username,password,role) VALUES('dasha','$2a$10$MyCVCjG1vkwqD1n0OFO4gea5JDCPzo4jwveA0sY7D8nFTlz46KAs6','CLIENT');
insert into users (username,password,role) VALUES('ira','$2a$10$G12lJLTROWE0JY5KilHAtOXEh/2qTFvnVlI8/Wov94rIqaFgJUMPi','MASTER');

insert into comments(commentator_id,master_id,comment_text,service_mark,comment_date) values(1,3,'very good service',4,'2020-5-18 15:23:44');
insert into comments(commentator_id,master_id,comment_text,service_mark,comment_date) values(2,3,'ty',4,'2020-5-19 15:23:11');
insert into comments(commentator_id,master_id,comment_text,service_mark,comment_date) values(4,3,'ty for service',4,'2020-5-11 10:12:41');

insert into procedures(name, description, duration_hours) values( 'hair cut','alallaalalal',1);
insert into procedures(name, description, duration_hours) values( 'pilling','alallaalalal',1);
insert into procedures(name, description, duration_hours) values( 'head massage','alallaalalal',1);
insert into procedures(name, description, duration_hours) values( 'leg massage','alallaalalal',1);
insert into procedures(name, description, duration_hours) values( 'hand massage','alallaalalal',1);
insert into procedures(name, description, duration_hours) values( 'back massage','alallaalalal',1);
insert into procedures(name, description, duration_hours) values( 'face massage','alallaalalal',1);
insert into procedures(name, description, duration_hours) values( 'full massage','alallaalalal',2);
insert into procedures(name, description, duration_hours) values( 'color pils','alallaalalal',2);
insert into procedures(name, description, duration_hours) values( 'change hair color','alallaalalal',1);


insert into reservations(start_hour,end_hour,procedure_procedure_id,beauty_master_user_id,client_user_id) values('2020-5-18 15:00:00','2020-5-18 16:00:00',1,3,2);
insert into reservations(start_hour,end_hour,procedure_procedure_id,beauty_master_user_id,client_user_id) values('2020-5-18 14:00:00','2020-5-18 15:00:00',2,3,2);
insert into reservations(start_hour,end_hour,procedure_procedure_id,beauty_master_user_id,client_user_id) values('2020-5-18 9:00:00','2020-5-18 10:00:00',3,3,2);
insert into reservations(start_hour,end_hour,procedure_procedure_id,beauty_master_user_id,client_user_id) values('2020-5-18 14:00:00','2020-5-18 15:00:00',2,5,2);
insert into reservations(start_hour,end_hour,procedure_procedure_id,beauty_master_user_id,client_user_id) values('2020-5-18 9:00:00','2020-5-18 10:00:00',3,3,2);
insert into reservations(start_hour,end_hour,procedure_procedure_id,beauty_master_user_id,client_user_id) values('2020-5-17 10:00:00','2020-5-18 11:00:00',2,3,2);
insert into reservations(start_hour,end_hour,procedure_procedure_id,beauty_master_user_id,client_user_id) values('2020-5-17 12:00:00','2020-5-18 13:00:00',3,3,2);
insert into reservations(start_hour,end_hour,procedure_procedure_id,beauty_master_user_id,client_user_id) values('2020-5-17 15:00:00','2020-5-18 16:00:00',2,3,2);
insert into reservations(start_hour,end_hour,procedure_procedure_id,beauty_master_user_id,client_user_id) values('2020-5-19 10:00:00','2020-5-18 11:00:00',1,3,2);
insert into reservations(start_hour,end_hour,procedure_procedure_id,beauty_master_user_id,client_user_id) values('2020-5-19 11:00:00','2020-5-18 12:00:00',2,3,2);
insert into reservations(start_hour,end_hour,procedure_procedure_id,beauty_master_user_id,client_user_id) values('2020-5-19 13:00:00','2020-5-18 14:00:00',1,3,2);
insert into reservations(start_hour,end_hour,procedure_procedure_id,beauty_master_user_id,client_user_id) values('2020-5-19 15:00:00','2020-5-18 16:00:00',4,3,2);
insert into reservations(start_hour,end_hour,procedure_procedure_id,beauty_master_user_id,client_user_id) values('2020-5-20 11:00:00','2020-5-18 16:00:00',4,5,2);
insert into reservations(start_hour,end_hour,procedure_procedure_id,beauty_master_user_id,client_user_id) values('2020-5-20 12:00:00','2020-5-18 13:00:00',3,5,2);
insert into reservations(start_hour,end_hour,procedure_procedure_id,beauty_master_user_id,client_user_id) values('2020-5-20 14:00:00','2020-5-18 15:00:00',2,5,2);
insert into reservations(start_hour,end_hour,procedure_procedure_id,beauty_master_user_id,client_user_id) values('2020-5-21 11:00:00','2020-5-18 12:00:00',2,5,2);
insert into reservations(start_hour,end_hour,procedure_procedure_id,beauty_master_user_id,client_user_id) values('2020-5-21 13:00:00','2020-5-18 14:00:00',1,5,2);
insert into reservations(start_hour,end_hour,procedure_procedure_id,beauty_master_user_id,client_user_id) values('2020-5-21 15:00:00','2020-5-18 16:00:00',3,5,2);
insert into reservations(start_hour,end_hour,procedure_procedure_id,beauty_master_user_id,client_user_id) values('2020-5-22 17:00:00','2020-5-18 18:00:00',3,5,2);
insert into reservations(start_hour,end_hour,procedure_procedure_id,beauty_master_user_id,client_user_id) values('2020-5-22 10:00:00','2020-5-18 11:00:00',4,5,2);
insert into reservations(start_hour,end_hour,procedure_procedure_id,beauty_master_user_id,client_user_id) values('2020-5-22 9:00:00','2020-5-18 10:00:00',5,5,2);
insert into reservations(start_hour,end_hour,procedure_procedure_id,beauty_master_user_id,client_user_id) values('2020-5-23 15:00:00','2020-5-18 16:00:00',4,5,2);
insert into reservations(start_hour,end_hour,procedure_procedure_id,beauty_master_user_id,client_user_id) values('2020-5-23 12:00:00','2020-5-18 13:00:00',4,5,2);
insert into reservations(start_hour,end_hour,procedure_procedure_id,beauty_master_user_id,client_user_id) values('2020-5-23 11:00:00','2020-5-18 12:00:00',4,5,2);
insert into reservations(start_hour,end_hour,procedure_procedure_id,beauty_master_user_id,client_user_id) values('2020-5-24 15:00:00','2020-5-18 16:00:00',4,5,2);

insert into salons(address) values('Solomona 7');
insert into salons(address) values('Ivana 4');

insert into salons_masters(salon_salon_id,masters_user_id) values(1,3);
insert into salons_masters(salon_salon_id,masters_user_id) values(2,5);
insert into salons_masters(salon_salon_id,masters_user_id) values(1,1);


insert into ratings(rating_mark,master_id) values(3.5,3);
insert into ratings(rating_mark,master_id) values(4.0,5);