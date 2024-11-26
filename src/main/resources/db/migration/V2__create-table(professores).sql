CREATE TABLE professores (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) ,
    email VARCHAR(100)  unique,
    telefone VARCHAR(15) unique,
    especialidade VARCHAR(100)
);

INSERT INTO professores (nome, email, telefone, especialidade) VALUES
('Carlos Almeida', 'carlos.almeida@email.com', '(11) 98765-4321', 'Matemática'),
('Patrícia Silva', 'patricia.silva@email.com', '(21) 99876-5432', 'Física'),
('João Pereira', 'joao.pereira@email.com', '(31) 93456-7890', 'Química'),
('Ana Costa', 'ana.costa@email.com', '(41) 92222-1111', 'Biologia'),
('Ricardo Santos', 'ricardo.santos@email.com', '(51) 93123-4567', 'História'),
('Mariana Rocha', 'mariana.rocha@email.com', '(61) 94567-8901', 'Geografia'),
('Fernanda Gomes', 'fernanda.gomes@email.com', '(71) 91234-5678', 'Filosofia'),
('Eduardo Oliveira', 'eduardo.oliveira@email.com', '(81) 98345-6789', 'Literatura');
