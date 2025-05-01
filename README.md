Projeto Usuários - Spring Boot
Este é um projeto simples em Spring Boot para gerenciar usuários via API REST.
Como Executar

Pré-requisitos:

Java 17 ou superior
Maven instalado


Passos:

Descompacte o arquivo ZIP.
Navegue até o diretório do projeto: cd projeto-usuarios.
Compile e execute o projeto com o Maven: mvn spring-boot:run.
A aplicação estará disponível em http://localhost:8080.


Testar os Endpoints:

Use o Postman ou curl para testar.
Criar um usuário: POST http://localhost:8080/api/usuarios com o corpo {"nome": "João Silva", "email": "joao@example.com"}.
Listar todos os usuários: GET http://localhost:8080/api/usuarios.
Buscar um usuário por ID: GET http://localhost:8080/api/usuarios/1.
Atualizar um usuário: PUT http://localhost:8080/api/usuarios/1 com o corpo {"nome": "Maria Silva", "email": "maria@example.com"}.
Deletar um usuário: DELETE http://localhost:8080/api/usuarios/1.



Estrutura do Projeto

UserController.java: Controlador REST para gerenciar usuários.
User.java: Modelo de dados para um usuário.
DemoApplication.java: Classe principal para iniciar a aplicação.
application.properties: Configurações da aplicação.

