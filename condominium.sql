DROP SCHEMA IF EXISTS condominium;
create schema condominium;
use CONDOMINIUM;

DROP TABLE IF EXISTS Usuario;
CREATE TABLE Usuario(
	login varchar(50),
    senha varchar(50),
    tipoID int(1)
    )engine = InnoDB;
    
    INSERT INTO USUARIO VALUES ("PEDRO","PEDRO", 1);
    
DROP TABLE IF EXISTS tipoPessoa;
CREATE TABLE tipoPessoa(
	id INT(1) NOT NULL,
	tipo VARCHAR(20) NOT NULL,
	PRIMARY KEY(id)
)engine = InnoDB;

DROP TABLE IF EXISTS Pessoa;
CREATE TABLE Pessoa(
	id int not null,
	nome varchar(50) NOT NULL,
    login varchar(50) NOT NULL,
    senha varchar(50) NOT NULL,
    tipoID int(1) NOT NULL,
    cpf varchar(11) NOT NULL,
    bloco varchar(10) NOT NULL,
    vinculo varchar(20) NOT NULL,
    telefone varchar(20)NOT NULL,
    email varchar(40) NOT NULL,
    primary key (id),
    FOREIGN KEY (tipoID) REFERENCES tipoPessoa(id)
    )engine = InnoDB;
    
DROP TABLE IF EXISTS ListaConvidados;
CREATE TABLE ListaConvidados(
	idLista INT NOT NULL,
	idMorador INT NOT NULL,
    nomeConvidado varchar(50) NOT NULL,
    PRIMARY KEY (idLista),
    FOREIGN KEY (idMorador) REFERENCES Pessoa(id)
    )engine = InnoDB;