

drop table if exists indirizzo_cliente;
drop table if exists cliente;
drop table if exists indirizzo;


CREATE TABLE indirizzo (
	id INT AUTO_INCREMENT PRIMARY KEY,
    luogo VARCHAR(255) NOT NULL,
	numero_civico INT NOT NULL,
    citta VARCHAR(255) NOT NULL,
    provincia VARCHAR(255) NOT NULL,
    regione VARCHAR(255) NOT NULL,
    nazione VARCHAR(255) NOT NULL
   
); 


create table cliente (
	id integer auto_increment primary key,
	nome varchar(30) NOT NULL,
	cognome varchar(50) NOT NULL,
	sesso char(1),
	cf char(16) unique not null ,
	data_di_nascita date NOT NULL,
	luogo_di_nascita varchar(30) NOT NULL,
	mail varchar(30) NOT NULL,
	telefono varchar(30) NOT NULL,
    visibile boolean default true
); 


 
create table indirizzo_cliente(
	id_indirizzo integer,
	foreign key (id_indirizzo) REFERENCES indirizzo(id),
	id_cliente int,
	FOREIGN KEY (id_cliente) REFERENCES cliente(id),
	tipo varchar(30) NOT NULL,

	primary key(id_indirizzo, id_cliente, tipo),
	constraint cliente_tipo unique(id_cliente, tipo) 
);