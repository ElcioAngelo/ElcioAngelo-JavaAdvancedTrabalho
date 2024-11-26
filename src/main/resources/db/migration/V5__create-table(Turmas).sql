create table turmas (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    ano INTEGER,
    semestre INTEGER,
    cursos_id INT,
    FOREIGN KEY (cursos_id) REFERENCES cursos(id)
);

INSERT INTO turmas (ano, semestre, cursos_id) VALUES
(2024, 1, 1),
(2024, 2, 2),
(2024, 1, 3),
(2024, 2, 4),
(2024, 1, 5),
(2024, 2, 6),
(2024, 1, 7),
(2024, 2, 8);