create table usuario (
	id_usuario serial primary key,
	nome VARCHAR(45),
	email VARCHAR(45) NOT null,
	senha VARCHAR(45) NOT null
	
);

create table categoria (
    id_categoria serial primary key,
    nome VARCHAR (50),
    descricao VARCHAR (50)
);

create table equipamento (
    id_equipamento SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50),
    id_categoria INTEGER NOT NULL,
    quantidade_disponivel INTEGER NOT NULL DEFAULT 0,
    descricao TEXT,
    FOREIGN KEY (id_categoria) references categoria(id_categoria)
        
);

CREATE TABLE movimentacao (
    id_movimentacao SERIAL PRIMARY KEY,
    id_equipamento INTEGER NOT NULL,
    id_usuario INTEGER NOT NULL,
    data_movimentacao TIMESTAMP NOT NULL,
    observacao TEXT,
	FOREIGN KEY (id_equipamento) references equipamento(id_equipamento),
	FOREIGN KEY (id_usuario) references usuario(id_usuario)
); 


alter table equipamento drop column quantidade_minima;

alter table equipamento rename quantidade_disponivel to estoque;