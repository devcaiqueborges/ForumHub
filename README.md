# 🏛️ ForumHub - Challenge Alura

API REST desenvolvida em **Java com Spring Boot** para o gerenciamento de tópicos de um fórum. Este projeto faz parte do desafio final do programa Alura + Oracle Next Education (ONE), focado em aplicar conceitos avançados de **Clean Code**, **Segurança** e **Persistência de Dados**.

---

## 🛠️ Stack Tecnológica

* **Linguagem:** Java 21
* **Framework:** Spring Boot 3.5.11
* **Segurança:** Spring Security + JWT (JSON Web Token)
* **Persistência:** Spring Data JPA + MySQL
* **Migration:** Flyway
* **Gerenciamento de Dependências:** Maven

---

## 🎯 Objetivo do Challenge

O **ForumHub** simula o funcionamento de um fórum onde usuários podem interagir. A API permite realizar todas as operações de um CRUD (Create, Read, Update, Delete) seguindo as regras de negócio:

1. **Validação de Duplicidade:** O sistema não permite a criação de tópicos com título e mensagem idênticos.
2. **Autenticação Stateless:** As rotas são protegidas e exigem um Token JWT válido gerado via login.
3. **Persistência em Tempo Real:** Todos os dados são salvos de forma segura no banco de dados MySQL.

---

## 📋 Endpoints da API

### 🔐 Autenticação
* **POST /login** - Autentica um usuário e retorna o Token JWT.

### 📝 Tópicos
* **POST /topicos** - Cadastra um novo tópico (Requer Token).
* **GET /topicos** - Lista todos os tópicos de forma paginada (Requer Token).
* **GET /topicos/{id}** - Detalha um tópico específico pelo ID (Requer Token).
* **PUT /topicos/{id}** - Atualiza o título ou a mensagem de um tópico (Requer Token).
* **DELETE /topicos/{id}** - Remove um tópico do sistema (Requer Token).

---

## 🚀 Como Configurar e Rodar

### 1. Configuração do Banco de Dados
Certifique-se de que o MySQL está rodando e crie o banco:
`CREATE DATABASE forumhub;`

### 2. Ajuste de Credenciais
No arquivo `src/main/resources/application.properties`, insira seu usuário e senha do MySQL:
`spring.datasource.username=SEU_USUARIO`
`spring.datasource.password=SUA_SENHA`

### 3. Criação do Usuário Inicial (Seeds)
Para realizar o primeiro login, insira este usuário diretamente no seu banco:
`INSERT INTO usuarios (nome, email, senha) VALUES ('Carlos', 'carlos@email.com', '$2a$10$EsQamQvrqEQ6biQU9mLxC.32bY0n8a0IXVnSO4c0xerqvYrzhMlYO');`
*(A senha para acesso é: 123456)*

---

## 🧪 Como Testar

1. Inicie a aplicação pelo IntelliJ.
2. No **Insomnia**, faça um POST para `localhost:8080/login` com o e-mail e senha.
3. Copie o token retornado.
4. Nas outras rotas, configure o **Bearer Token** na aba de autenticação e cole o valor.

---

### 👨‍💻 Autor
**Carlos Caique Borges de Sousa** *Desenvolvedor Java Backend em formação*

[LinkedIn](https://www.linkedin.com/in/devcaiqueborges) 