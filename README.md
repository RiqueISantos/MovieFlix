# 🎬 API Flix

API REST para gerenciamento de catálogo de filmes e serviços de streaming, desenvolvida com **Spring Boot** e arquitetura moderna.

---

## 📌 Sobre o Projeto

O **Flix** é uma plataforma que permite aos usuários descobrir filmes disponíveis em diferentes serviços de streaming.  
O projeto foi desenvolvido com foco em:

- **Organização de Conteúdo:** Categorização eficiente de filmes  
- **Múltiplos Serviços:** Integração com diversos serviços de streaming  
- **Segurança:** Autenticação JWT para proteção dos endpoints  
- **Performance:** Queries otimizadas e cache para melhor desempenho  
- **Escalabilidade:** Arquitetura preparada para crescimento  

---

## 🏗 Arquitetura

O projeto segue uma arquitetura em camadas:

```bash
src/main/java/br/com/movieflix/
├── config/          # Configurações do Spring e Security
├── controller/      # Controllers REST
├── entity/          # Entidades JPA
├── exception/       # Exceções customizadas
├── mapper/          # Conversão entre DTOs e entidades
├── repository/      # Repositórios Spring Data
├── service/         # Regras de negócio
└── MovieflixApplication.java  # Classe principal

src/main/resources/
├── db.migration/    # Migrations do Flyway
└── application.yaml # Configurações da aplicação

⚙️ Tecnologias Utilizadas
Backend

Java 17

Spring Boot 3

Spring Security

Spring Data JPA

JWT

Lombok

Bean Validation

Banco de Dados

PostgreSQL 15

Flyway

Ferramentas

Maven

JUnit 5

Mockito

Swagger/OpenAPI

🚀 Funcionalidades
🔐 Autenticação e Autorização

Registro e login de usuários

Autenticação via JWT

Proteção de rotas por perfil

🎬 Categorias

CRUD completo

Validação e tratamento de dependências

📺 Serviços de Streaming

Cadastro e gestão de provedores

Associação com filmes

🎥 Catálogo de Filmes

Cadastro detalhado

Busca por múltiplos critérios

Associação com categorias e serviços

Sistema de avaliação

📂 Pré-requisitos

Java 17+

PostgreSQL 15+

Maven 3.8+

▶️ Como Executar

Scripts disponíveis:

build.sh: Compila o projeto e gera o JAR

start.sh: Inicia a aplicação

Passo a passo
# Clone o repositório
git clone [url-do-repositorio]

# Configure o banco de dados no application.yaml
spring.datasource.url=jdbc:postgresql://localhost:5432/movieflix
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

# Build
./build.sh

# Start
./start.sh

# Alternativa manual
mvn clean package
mvn spring-boot:run

📖 Documentação da API
🔐 Autenticação
POST /auth/register   → Registrar novo usuário  
POST /auth/login      → Login de usuário

📂 Categorias
POST   /movieflix/category        → Criar categoria  
GET    /movieflix/category        → Listar categorias  
GET    /movieflix/category/{id}   → Buscar categoria por ID  
DELETE /movieflix/category/{id}   → Deletar categoria

📺 Serviços de Streaming
POST   /movieflix/stream-service        → Criar serviço  
GET    /movieflix/stream-service        → Listar serviços  
GET    /movieflix/stream-service/{id}   → Buscar serviço por ID  
DELETE /movieflix/stream-service/{id}   → Deletar serviço

🎥 Filmes
POST   /movieflix/movie                  → Criar filme  
GET    /movieflix/movie                  → Listar filmes  
GET    /movieflix/movie/{id}             → Buscar filme por ID  
GET    /movieflix/movie/search?category={id} → Buscar filmes por categoria  
PUT    /movieflix/movie                  → Atualizar filme  
DELETE /movieflix/movie/{id}             → Deletar filme

🤝 Contribuindo

Faça um fork do projeto

Crie uma branch (git checkout -b feature/NomeDaFeature)

Commit suas mudanças (git commit -m 'Add feature X')

Push para a branch (git push origin feature/NomeDaFeature)

Abra um Pull Request

👨‍💻 Autor

Henrique Santos – Desenvolvedor do projeto
