create table cursos (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100)  UNIQUE,
    codigo VARCHAR(20) UNIQUE,
    carga_horaria INTEGER
);

INSERT INTO cursos (nome, codigo, carga_horaria) VALUES
('Curso de Matemática Básica', 'CUR-001', 80),
('Física Aplicada ao Ensino', 'CUR-002', 120),
('Química Experimental', 'CUR-003', 100),
('Biologia Molecular', 'CUR-004', 150),
('História Contemporânea', 'CUR-005', 60),
('Geografia Global', 'CUR-006', 90),
('Filosofia Moderna', 'CUR-007', 75),
('Literatura Brasileira', 'CUR-008', 110);


