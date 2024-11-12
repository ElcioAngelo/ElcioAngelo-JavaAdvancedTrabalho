create table turmas (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    ano INTEGER NOT NULL,
    semestre INTEGER NOT NULL,
    cursos_id INT,
    FOREIGN KEY (cursos_id) REFERENCES cursos(id)
);