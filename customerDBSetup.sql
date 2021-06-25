Create database customerDB;
Use customerDB;

Create table customer(
id integer NOT NULL PRIMARY KEY,
firstname varchar (255),
lastname varchar (255),
username varchar (255),
membership varchar (255)
);

Insert into customer (id,firstname, lastname, username, membership)
values (1,'Maria', 'Clarke', 'mclark','RPEMIUM'),
(2,'Terrence', 'Walker', 'twalker', 'STANDARD'),
(3,'Charles', 'Bing','cbing','FREE'),
(4,'Ray', 'Smiths', 'rsmiths', 'FREE'),
(5,'Rhonda', 'Clarke', 'rclarke', 'PREMIUM');
