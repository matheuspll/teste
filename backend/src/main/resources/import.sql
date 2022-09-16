INSERT INTO tb_curso (nome) VALUES ('Sistemas de Informação');
INSERT INTO tb_curso (nome) VALUES ('Direito');
INSERT INTO tb_curso (nome) VALUES ('Administração');
INSERT INTO tb_curso (nome) VALUES ('Medicina');
INSERT INTO tb_participante (nome, cpf, email, matricula, telefone, curso_id) VALUES ('Matheus Magalhães', '020.666.666-66', 'matheus.magalha95@gmail.com', '201933322', '999486205', 1L);
INSERT INTO tb_participante (nome, cpf, email, matricula, telefone, curso_id) VALUES ('José Silva', '020.333.555-66', 'jose@gmail.com', '201944444', '999486205', 1L);
INSERT INTO tb_participante (nome, cpf, email, matricula, telefone, curso_id) VALUES ('Luiza Silva', '044.553.555-66', 'luiza@gmail.com', '201230203', '999486205', 2L);
INSERT INTO tb_participante (nome, cpf, email, matricula, telefone, curso_id) VALUES ('Clarissa Silva', '055.323.555-66', 'clarissa@gmail.com', '201230203', '999486205', 2L);
INSERT INTO tb_participante (nome, cpf, email, matricula, telefone, curso_id) VALUES ('Nelio Alves', '111.222.555-66', 'nelio@gmail.com', '201230203', '999486205', 4L);
INSERT INTO tb_categoria (nome) VALUES ('Palestra');
INSERT INTO tb_categoria (nome) VALUES ('Oficina');
INSERT INTO tb_categoria (nome) VALUES ('Seminario');
INSERT INTO tb_organizador (nome) VALUES ('Cleuton');
INSERT INTO tb_organizador (nome) VALUES ('Priscila');
INSERT INTO tb_atividade (titulo, descricao, categoria_id) VALUES ('Inteligência Artificial', 'Estudo sobre como aplicar os comportamentos humanos em maquinas', 1L);
INSERT INTO tb_atividade (titulo, descricao, categoria_id) VALUES ('Programação Funcional', 'Estudo sobre funções e imutabilidade', 1L);
INSERT INTO tb_atividade (titulo, descricao, categoria_id) VALUES ('Python para WEB', 'Como construir aplicações utilizando Django', 2L);
INSERT INTO tb_atividade (titulo, descricao, categoria_id) VALUES ('Microserviços', 'Distribuindo aplicações com microserviços utilizando kfaka e nestjs', 3L);
INSERT INTO tb_periodo (inicio, fim, atividade_id) VALUES ('2022-09-01 19:00', '2022-09-01 20:00', 1L);
INSERT INTO tb_periodo (inicio, fim, atividade_id) VALUES ('2022-05-05 19:00', '2022-05-05 22:00', 2L);
INSERT INTO tb_periodo (inicio, fim, atividade_id) VALUES ('2022-09-08 18:00', '2022-09-08 20:00', 3L);
INSERT INTO tb_periodo (inicio, fim, atividade_id) VALUES ('2022-09-10 15:30', '2022-09-10 18:45', 4L);
INSERT INTO tb_periodo (inicio, fim, atividade_id) VALUES ('2022-09-10 19:30', '2022-09-10 22:45', 4L);
INSERT INTO tb_atividade_participante (atividade_id, participante_id) VALUES (1L, 1L);
INSERT INTO tb_atividade_participante (atividade_id, participante_id) VALUES (1L, 2L);
INSERT INTO tb_atividade_participante (atividade_id, participante_id) VALUES (1L, 4L);
INSERT INTO tb_atividade_participante (atividade_id, participante_id) VALUES (4L, 1L);
INSERT INTO tb_atividade_participante (atividade_id, participante_id) VALUES (2L, 2L);
INSERT INTO tb_atividade_participante (atividade_id, participante_id) VALUES (3L, 3L);


