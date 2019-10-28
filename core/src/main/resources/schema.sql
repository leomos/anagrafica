DROP TABLE IF EXISTS indirizzo;

CREATE TABLE indirizzo (
	id INT AUTO_INCREMENT PRIMARY KEY,
    luogo VARCHAR(255) NOT NULL,
	numero_civico INT NOT NULL,
    citta VARCHAR(255) NOT NULL,
    provincia VARCHAR(255) NOT NULL,
    regione VARCHAR(255) NOT NULL,
    nazione VARCHAR(255) NOT NULL
);