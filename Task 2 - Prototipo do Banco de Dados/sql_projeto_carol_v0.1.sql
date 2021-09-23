-- Remove a database
-- drop database db_projeto_carol;

-- Cria banco de dados
create database db_projeto_carol;

-- Seleciona o banco de dados
use db_projeto_carol;

-- Cria tabela de usuarios
CREATE TABLE `tb_usuario` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`nome` varchar(255) NOT NULL,
	`email` varchar(255) NOT NULL,
	`senha` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

-- Cria tabela de temas
CREATE TABLE `tb_tema` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`nome` varchar(255) NOT NULL,
	`descricao` varchar(2048) NOT NULL,
	`qntd_post` bigint NOT NULL,
	`relevante` int NOT NULL,
	PRIMARY KEY (`id`)
);

-- Cria tabela de postagens
CREATE TABLE `tb_postagem` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`titulo` varchar(255) NOT NULL,
	`texto` TEXT NOT NULL,
	`data` DATETIME NOT NULL,
	`curtidas` int NOT NULL,
	`compartilhamentos` bigint NOT NULL,
	`fk_usuario` bigint NOT NULL,
	`fk_tema` bigint NOT NULL,
	PRIMARY KEY (`id`),
    FOREIGN KEY (fk_usuario) references tb_usuario(id),
    FOREIGN KEY (fk_tema) references tb_tema(id)
);

-- Insere temas
INSERT INTO tb_tema (nome, descricao, qntd_post, relevante)
	VALUES ("empregabilidade", "post relacionados a busca de emprego", 122, 10);
INSERT INTO tb_tema (nome, descricao, qntd_post, relevante)
	VALUES ("experiencias", "experiencias de trabalhos anteriores", 34, 2);
    
-- Insere usuarios
INSERT INTO tb_usuario (nome, email, senha)
	VALUES ("Maria Julia", "maria_julia@gmail.com","1234");
INSERT INTO tb_usuario (nome, email, senha)
	VALUES ("Catarina Cardoso", "catarina_cardoso@gmail.com","1234");
    
-- Insere postagens
INSERT INTO tb_postagem (titulo, texto, `data`, curtidas, compartilhamentos, fk_usuario, fk_tema)
	VALUES (
		"Preciso de ajuda",
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum",
        current_timestamp(),
        10,
        20,
        1,
        1
        );
        
-- Seleciona todos os usuario
-- SELECT * FROM tb_usuario;

-- Seleciona todos as postagens
-- SELECT * FROM tb_postagem;

-- Seleciona todos os temas
-- SELECT * FROM tb_tema;