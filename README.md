
<div class="container mt-5">
<h1 class="text-center">Projeto Usuários - Spring Boot</h1>
<p class="lead text-center">Este é um projeto simples em Spring Boot para gerenciar usuários via API REST.</p>

<h2>Como Executar</h2>
<h3>Pré-requisitos:</h3>
<ul>
<li>Java 17 ou superior</li>
<li>Maven instalado</li>
</ul>

<h3>Passos:</h3>
<ol>
<li>Descompacte o arquivo ZIP.</li>
<li>Navegue até o diretório do projeto:
<pre><code>cd UserController-java</code></pre>
</li>
<li>Compile e execute o projeto com o Maven:
<pre><code>mvn spring-boot:run</code></pre>
</li>
<li>A aplicação estará disponível em <strong>http://localhost:8080</strong>.</li>
</ol>

<h2>Testar os Endpoints</h2>
<p>Use o Postman ou curl para testar.</p>

<h3>Endpoints:</h3>
<ul>
<li>Criar um usuário: <strong>POST</strong> <code>http://localhost:8080/api/usuarios</code> com o corpo:
<pre><code>{"nome": "João Silva", "email": "joao@example.com"}</code></pre>
</li>
<li>Listar todos os usuários: <strong>GET</strong> <code>http://localhost:8080/api/usuarios</code></li>
<li>Buscar um usuário por ID: <strong>GET</strong> <code>http://localhost:8080/api/usuarios/1</code></li>
<li>Atualizar um usuário: <strong>PUT</strong> <code>http://localhost:8080/api/usuarios/1</code> com o corpo:
<pre><code>{"nome": "Maria Silva", "email": "maria@example.com"}</code></pre>
</li>
<li>Deletar um usuário: <strong>DELETE</strong> <code>http://localhost:8080/api/usuarios/1</code></li>
</ul>

<h2>Estrutura do Projeto</h2>
<ul>
<li><strong>UserController.java</strong>: Controlador REST para gerenciar usuários.</li>
<li><strong>User.java</strong>: Modelo de dados para um usuário.</li>
<li><strong>DemoApplication.java</strong>: Classe principal para iniciar a aplicação.</li>
<li><strong>application.properties</strong>: Configurações da aplicação.</li>
</ul>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.0/js/bootstrap.bundle.min.js"></script>

