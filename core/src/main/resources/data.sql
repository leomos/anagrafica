insert into indirizzo(luogo, numero_civico, citta, provincia, regione, nazione)
values ("Via Marrone", 2, "Milano", "MI", "Lombardia", "Italia");

insert into cliente(nome, cognome, sesso, cf, data_di_nascita, luogo_di_nascita, mail, telefono)
values("Leonardo", "Mosciatti", "M", "ABCDEF123CIAO", "1996-1-1", "Siena", "leonardo@leonardo.com", "+393334455221");

insert into indirizzo_cliente values (1,1,"residenza");