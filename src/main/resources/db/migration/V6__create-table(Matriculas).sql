create table matriculas (
    id Integer primary key auto_increment,
    aluno_id INT,
    turma_id INT,
    foreign key(aluno_id) references alunos(id),
    foreign key(turma_id) references turmas(id)
);