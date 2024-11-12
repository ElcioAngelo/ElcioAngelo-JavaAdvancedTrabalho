CREATE TABLE professores (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) not null,
    email VARCHAR(100) not null unique,
    telefone VARCHAR(15) not null unique,
    especialidade VARCHAR(100) not null
);