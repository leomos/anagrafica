insert into indirizzo(luogo, numero_civico, citta, provincia, regione, nazione)
values ('Via Marrone', 2, 'Milano', 'MI', 'Lombardia', 'Italia');

insert into cliente(nome, cognome, sesso, cf, data_di_nascita, luogo_di_nascita, mail, telefono)
values('Leonardo', 'Mosciatti', 'M', 'ABCDEF123CIAO', '1996-1-1', 'Siena', 'leonardo@leonardo.com', '+393334455221');

insert into indirizzo_cliente values (1,1,'residenza');
insert into indirizzo_cliente values (1,1,'domicilio');
insert into cliente(nome, cognome, sesso, cf, data_di_nascita, luogo_di_nascita, mail, telefono,visibile)
values('ALeonardo', 'AMosciatti', 'M', 'CDKDOFI768KDO', '1996-2-1', 'ASiena', 'AAleonardo@leonardo.com', '+393334455221');
insert into cliente(nome, cognome, sesso, cf, data_di_nascita, luogo_di_nascita, mail, telefono,visibile)
values('Leonardsdfo', 'Moscidsdsfatti', 'F', 'CKDOALQOO987DKDO', '1996-1-2', 'Sieeena', 'leondsdsardo@leonardo.com', '+393334455221');

insert into indirizzo(luogo, numero_civico, citta, provincia, regione, nazione)
values ('Via Roma', 27, 'Napoli', 'NA', 'Campania', 'Italia');

insert into indirizzo(luogo, numero_civico, citta, provincia, regione, nazione)
values ('Via Ivrea', 227, 'Torino', 'TO', 'Piemonte', 'Italia');
insert into indirizzo(luogo, numero_civico, citta, provincia, regione, nazione)
values ('Piazza Unità', 27, 'Gubbio', 'PE', 'Umbria', 'Italia');


insert into indirizzo_cliente values (2,1,'residenza');
insert into indirizzo_cliente values (3,2,'residenza');

insert into indirizzo_cliente values (2,3,'domicilio');
insert into indirizzo_cliente values (4,4,'domicilio');