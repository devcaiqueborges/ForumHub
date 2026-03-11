# ForumHub - API REST 🚀

O **ForumHub** é o back-end de uma plataforma de fórum de discussões, desenvolvido como parte do desafio (challenge) da formação Java da Alura em parceria com o programa Oracle Next Education (ONE). A API gerencia tópicos, usuários e autenticação, seguindo as melhores práticas de desenvolvimento REST e segurança.

## 🛠️ Tecnologias Utilizadas

* **Java 21**: Versão utilizada para aproveitar as novas funcionalidades como Records e Pattern Matching.
* **Spring Boot 3.5.11**: Framework base para a construção da API.
* **Spring Security**: Implementação de autenticação stateless e controle de autorização.
* **Spring Data JPA**: Abstração da camada de persistência de dados.
* **MySQL**: Banco de dados relacional utilizado para armazenamento persistente.
* **Flyway**: Gerenciamento de migrações e versionamento do banco de dados.
* **Lombok**: Biblioteca para reduzir a verbosidade do código Java (Getters, Setters, Constructors).
* **Bean Validation**: Validação rigorosa dos dados de entrada via anotações nos DTOs.
* **Auth0 JWT**: Biblioteca para geração e validação de Tokens JSON Web Token para autenticação.

---

## 📌 Funcionalidades Principais

### **Autenticação (JWT)**
* Login de usuários com verificação de credenciais no banco de dados.
* Criptografia de senhas utilizando o algoritmo de hash BCrypt.
* Emissão de tokens JWT para autorização em rotas protegidas (Bearer Token).

### **Gestão de Tópicos**
* **Cadastro**: Registro de novos tópicos vinculados a autores e cursos existentes.
* **Listagem**: Consulta de tópicos com suporte nativo a paginação e ordenação por data.
* **Detalhamento**: Consulta detalhada de um tópico específico por ID.
* **Atualização**: Edição dinâmica de campos permitidos (Título e Mensagem).
* **Exclusão**: Remoção física de tópicos do banco de dados via requisição DELETE.

---

## 👨‍💻 Desenvolvedor
**Carlos Caique Borges de Sousa** | *Developer Back-End Java/Spring Boot.*