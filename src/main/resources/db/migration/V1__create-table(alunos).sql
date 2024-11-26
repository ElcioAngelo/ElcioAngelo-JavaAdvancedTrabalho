create table alunos (
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    matricula VARCHAR(20) UNIQUE,
    data_nascimento DATE
);

INSERT INTO alunos (nome, email, matricula, data_nascimento) VALUES
('João Silva', 'joao.silva@email.com', '01.001-1', '2000-05-15'),
('Maria Oliveira', 'maria.oliveira@email.com', '01.002-2', '1999-07-22'),
('Pedro Souza', 'pedro.souza@email.com', '01.003-3', '2001-03-10'),
('Ana Santos', 'ana.santos@email.com', '01.004-4', '2000-11-30'),
('Lucas Costa', 'lucas.costa@email.com', '01.005-5', '2002-06-25'),
('Fernanda Pereira', 'fernanda.pereira@email.com', '01.006-6', '1998-01-12'),
('Rafael Almeida', 'rafael.almeida@email.com', '01.007-7', '2000-09-05'),
('Juliana Rocha', 'juliana.rocha@email.com', '01.008-8', '2001-04-17'),
('Bruno Martins', 'bruno.martins@email.com', '01.009-9', '1999-08-29'),
('Larissa Lima', 'larissa.lima@email.com', '01.010-0', '2002-02-03'),
('Gabriel Fernandes', 'gabriel.fernandes@email.com', '01.011-1', '2000-12-18'),
('Carla Mendes', 'carla.mendes@email.com', '01.012-2', '1999-06-25'),
('Marcelo Carvalho', 'marcelo.carvalho@email.com', '01.013-3', '2001-10-08'),
('Paula Costa', 'paula.costa@email.com', '01.014-4', '2002-04-21'),
('Tiago Rocha', 'tiago.rocha@email.com', '01.015-5', '1998-12-14'),
('Isabela Duarte', 'isabela.duarte@email.com', '01.016-6', '2001-01-29'),
('Vinícius Barbosa', 'vinicius.barbosa@email.com', '01.017-7', '2000-02-04'),
('Mariana Gomes', 'mariana.gomes@email.com', '01.018-8', '2002-07-18'),
('Ricardo Silva', 'ricardo.silva@email.com', '01.019-9', '2000-03-13'),
('Sofia Almeida', 'sofia.almeida@email.com', '01.020-0', '2001-08-20');