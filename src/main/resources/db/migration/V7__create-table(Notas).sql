CREATE TABLE notas (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    matricula_id INTEGER,
    disciplina_id INTEGER,
    FOREIGN KEY (disciplina_id) REFERENCES disciplinas(id),
    FOREIGN KEY (matricula_id) REFERENCES matriculas(id),
    nota DECIMAL(5,2),
    data_lancamento DATE
);

INSERT INTO notas (id, matricula_id, disciplina_id, nota, data_lancamento)
VALUES
(1, 1, 1, ROUND(RAND() * (10 - 1) + 1, 2), CURDATE()),
(2, 2, 1, ROUND(RAND() * (10 - 1) + 1, 2), CURDATE()),
(3, 3, 2, ROUND(RAND() * (10 - 1) + 1, 2), CURDATE()),
(4, 4, 2, ROUND(RAND() * (10 - 1) + 1, 2), CURDATE()),
(5, 5, 3, ROUND(RAND() * (10 - 1) + 1, 2), CURDATE()),
(6, 6, 3, ROUND(RAND() * (10 - 1) + 1, 2), CURDATE()),
(7, 7, 4, ROUND(RAND() * (10 - 1) + 1, 2), CURDATE()),
(8, 8, 4, ROUND(RAND() * (10 - 1) + 1, 2), CURDATE()),
(9, 9, 5, ROUND(RAND() * (10 - 1) + 1, 2), CURDATE()),
(10, 10, 5, ROUND(RAND() * (10 - 1) + 1, 2), CURDATE()),
(11, 11, 6, ROUND(RAND() * (10 - 1) + 1, 2), CURDATE()),
(12, 12, 6, ROUND(RAND() * (10 - 1) + 1, 2), CURDATE()),
(13, 13, 7, ROUND(RAND() * (10 - 1) + 1, 2), CURDATE()),
(14, 14, 7, ROUND(RAND() * (10 - 1) + 1, 2), CURDATE()),
(15, 15, 8, ROUND(RAND() * (10 - 1) + 1, 2), CURDATE()),
(16, 16, 8, ROUND(RAND() * (10 - 1) + 1, 2), CURDATE()),
(17, 17, 9, ROUND(RAND() * (10 - 1) + 1, 2), CURDATE()),
(18, 18, 9, ROUND(RAND() * (10 - 1) + 1, 2), CURDATE()),
(19, 19, 10, ROUND(RAND() * (10 - 1) + 1, 2), CURDATE()),
(20, 20, 10, ROUND(RAND() * (10 - 1) + 1, 2), CURDATE());
