CREATE TABLE autor (
    id Integer AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE frase (
    id Integer AUTO_INCREMENT PRIMARY KEY,
    texto VARCHAR(255) NOT NULL,
    autor_id Integer,
    FOREIGN KEY (autor_id) REFERENCES autor(id)
);
