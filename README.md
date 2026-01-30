# 📚 Sistema de Biblioteca em Java

Projeto de um Sistema de Biblioteca desenvolvido em Java, utilizando MySQL como banco de dados e arquitetura em camadas (Model, DAO, Service).
O sistema funciona via console e permite o gerenciamento de livros, usuários e empréstimos.

## 🚀 Funcionalidades

✔️ Cadastro de usuários

✔️ Cadastro de livros

✔️ Registro de empréstimos

✔️ Encerramento (devolução) de empréstimos

✔️ Listagem de empréstimos em aberto

✔️ Controle de status do livro (DISPONÍVEL / EMPRESTADO)

## 🛠️ Tecnologias Utilizadas

- Java 17+
- MySQL
- JDBC
- Maven
- IDE: IntelliJ IDEA

## 🧱 Arquitetura do Projeto

O projeto segue o padrão de arquitetura em camadas, facilitando manutenção e escalabilidade:
```
br.com.biblioteca
 ├── dao        # Acesso ao banco de dados
 ├── model      # Entidades do sistema
 ├── service    # Regras de negócio
 ├── enums      # Enumerações de status
 ├── util       # Conexão com o banco
 └── Main.java  # Classe principal (menu)
```
## 📂 Principais Entidades
📘 Livro
- id
- nome
- autor
- status (DISPONÍVEL / EMPRESTADO)

👤 Usuário
- id
- nome
- telefone

🔄 Empréstimo
- id
- livro
- usuário
- data do empréstimo
data de devolução
status (ABERTO / ENCERRADO)
