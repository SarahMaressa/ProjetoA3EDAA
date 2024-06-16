CREATE DATABASE tbl_filmes;
USE tbl_filmes;
create table if not exists tbl_filmes (
    id_filme smallint auto_increment primary key,
    nome_filme varchar(100) not null, 
    genero_filme varchar(50),
    diretor_filme varchar(50),
    ano_lancamento year,
    filme_assistido boolean,
    filme_favorito boolean,
	avaliacao int not null
); 
select * from tbl_filmes;
ALTER TABLE tbl_filmes DROP avaliacao;
ALTER TABLE tbl_filmes ADD avaliacao int;