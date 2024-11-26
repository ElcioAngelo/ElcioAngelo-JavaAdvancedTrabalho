create table disciplinas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    codigo VARCHAR(20) UNIQUE,
    curso_id INT,
    professor_id INT,
    FOREIGN KEY (curso_id) REFERENCES cursos(id) ON DELETE CASCADE,
    FOREIGN KEY (professor_id) REFERENCES professores(id) ON DELETE CASCADE
);

INSERT INTO disciplinas (id, nome, codigo, curso_id, professor_id) VALUES
(1, 'Matemática I', 'MAT101', 1, 1),
(2, 'Física Geral', 'FIS101', 1, 2),
(3, 'Química Orgânica', 'QUI101', 1, 3),
(4, 'Algoritmos e Lógica de Programação', 'ALG101', 2, 4),
(5, 'Estruturas de Dados', 'EST102', 2, 5),
(6, 'Banco de Dados', 'DB101', 2, 6),
(7, 'Cálculo Diferencial', 'CAL101', 1, 7),
(8, 'Probabilidade e Estatística', 'PROB101', 1, 8),
(9, 'Desenho Técnico', 'DES101', 3, 1),
(10, 'Gestão de Projetos', 'GP101', 3, 2),
(11, 'Teoria da Computação', 'TC101', 2, 3),
(12, 'Redes de Computadores', 'RC101', 2, 4),
(13, 'Introdução à Economia', 'ECON101', 4, 5),
(14, 'Ética e Responsabilidade Social', 'ERS101', 4, 6),
(15, 'Sistemas Operacionais', 'SO101', 2, 7),
(16, 'Física Moderna', 'FIS102', 1, 8),
(17, 'Análise de Sistemas', 'AS101', 2, 1),
(18, 'Linguagens de Programação', 'LP101', 2, 2),
(19, 'Marketing Digital', 'MD101', 5, 3),
(20, 'Gestão de Pessoas', 'GP102', 5, 4);
