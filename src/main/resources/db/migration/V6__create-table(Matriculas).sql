create table matriculas (
    id Integer primary key auto_increment,
    aluno_id INT,
    turma_id INT,
    foreign key(aluno_id) references alunos(id),
    foreign key(turma_id) references turmas(id)
);

INSERT INTO matriculas (id, aluno_id, turma_id) VALUES
(1, 1, 1),
(2, 2, 1),
(3, 3, 2),
(4, 4, 2),
(5, 5, 3),
(6, 6, 3),
(7, 7, 4),
(8, 8, 4),
(9, 9, 5),
(10, 10, 5),
(11, 11, 6),
(12, 12, 6),
(13, 13, 7),
(14, 14, 7),
(15, 15, 8),
(16, 16, 8),
(17, 17, 1),
(18, 18, 2),
(19, 19, 3),
(20, 20, 4);
