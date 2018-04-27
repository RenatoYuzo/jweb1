# CRUD

# Criação da tabela cliente
create table cliente (
    id int primary key auto_increment,
    nome varchar(200),
    email varchar(200),
    cpf varchar(11)
);

# Buscar todos os dados de todos os clientes
select * from cliente;

# Inserção de cliente
insert into cliente (nome,email,cpf) values('Zé da Silva','ze@gmail.com','777777');

# Update de cliente
update cliente set email='jao.silva@gmail.com' where id=1;

# Deletar cliente
delete from cliente where id=3;

# Bucar cliente por CPF
select * from cliente where nome like '%da%';

# Buscar quantos clientes estão cadastrados
select count(*) from cliente where id > 1;
