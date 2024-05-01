# PROJETO - SISTEMA DE GERENCIAMENTO DE BIBLIOTECA
Trata-se de exercicio para criação de um Sistema de Gerenciamento de Bibliotecas o qual administra cadastros de livros através de CRUD e administra, também, empréstimo e devolução deste.

Utilizou-se como referência o código que encontra-se na pasta **"referencias__pesquisa"**, localizado, também, neste [repositório](https://github.com/davi-brazcubas) (obrigado, prof. Davi!). 

O projeto seguiu as seguintes diretrizes:
- Implementar um Sistema simples que apresenta via CLI um menu de Biblioteca com as opções:
  - Cadastrar Livro
  - Listar Livros
  - Emprestar Livro
  - Devolver Livro
- Sistema deverá persistir os dados em um Banco de Dados
- Sistema não poderá utilizar nenhuma biblioteca externa para salvar os dados
- Sistema deverá ser feito com a arquitetura MVC
- Projeto deverá ser salvo em um repositório do GitHub

Conceitos importantes estudados:
- Arquitetura MVC
- API JDBC do Java
- Maven
- Spring CLI
  - Referencia das pesquisas realizadas encontra-se na pasta **"referencias__pesquisa"**

## REGRA DE NEGOCIO
Para simplificar, utilizei o controle de empréstimo de um Livro através das tabelas “livro” e “livroemprestado” com relação unária e controle de membro (que pega emprestado) e funcionario (que cadastrou o emprestimo) através de input no CLI.
### Opções futuras
Uma atualização mais robusta para versões futuras seria administrar a quantidade de livros (quantidade emprestado, quantos em estoque e afins), além de Membro e Funcionarios (extendendo de Pessoas) como classes e tabelas também.

## PERSISTENCIA DE DADOS
Banco dedados PostgreSQL: PostgreSQL localhost
User: “postgres”
Senha: “admin”
DatabaseName: “db_libMgmtSys”