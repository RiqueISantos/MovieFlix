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

src/main/java/br/com/movieflix/
├── config/ # Configurações do Spring e Security
├── controller/ # Controllers REST
├── entity/ # Entidades JPA
├── exception/ # Exceções customizadas
├── mapper/ # Conversão entre DTOs e entidades
├── repository/ # Repositórios Spring Data
├── service/ # Regras de negócio
└── MovieflixApplication.java # Classe principal

src/main/resources/
├── db.migration/ # Migrations do Flyway
└── application.yaml # Configurações da aplicação

---

## ⚙️ Tecnologias Utilizadas

### Backend
- **Java 17**: Versão LTS com recursos modernos da linguagem  
- **Spring Boot 3**: Framework para desenvolvimento ágil  
- **Spring Security**: Segurança e autenticação  
- **Spring Data JPA**: Persistência de dados  
- **JWT**: Tokens para autenticação stateless  
- **Lombok**: Redução de boilerplate code  
- **Bean Validation**: Validação de dados  

### Banco de Dados
- **PostgreSQL 15**: Banco de dados relacional robusto  
- **Flyway**: Migrations para controle do schema  

### Ferramentas de Desenvolvimento
- **Maven**: Gerenciamento de dependências e build  
- **JUnit 5**: Testes unitários  
- **Mockito**: Mocking para testes  
- **Swagger/OpenAPI**: Documentação da API  

---

## 🚀 Funcionalidades

### 🔐 Autenticação e Autorização
- Sistema de registro e login de usuários  
- Autenticação via JWT  
- Proteção de rotas por perfil de usuário  

### 🎬 Gerenciamento de Categorias
- CRUD completo de categorias de filmes  
- Validação de dados  
- Tratamento de dependências  

### 📺 Serviços de Streaming
- Cadastro e gestão de provedores  
- Associação com filmes  
- Validações de integridade  

### 🎥 Catálogo de Filmes
- Cadastro detalhado de filmes  
- Busca por múltiplos critérios  
- Associação com categorias e serviços  
- Sistema de avaliação  

---

## 📂 Pré-requisitos

- **Java 17+**  
- **PostgreSQL 15+**  
- **Maven 3.8+**  
- **Curl** (para testes via scripts)  

---

## ▶️ Como Executar

O projeto inclui scripts para facilitar o build e a execução:

### Scripts Disponíveis
- `build.sh`: Compila o projeto e gera o arquivo JAR  
- `start.sh`: Inicia a aplicação usando o JAR gerado  

### Passo a Passo
```bash
# Clone o repositório
git clone [url-do-repositorio]

# Configure o banco de dados no application.yaml
spring.datasource.url=jdbc:postgresql://localhost:5432/movieflix
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

# Execute o build
./build.sh

# Inicie a aplicação
./start.sh

Alternativamente, você pode executar manualmente:
# Build manual
mvn clean package

# Execução manual
mvn spring-boot:run

📖 Documentação da API
Endpoints
🔐 Autenticação

POST /auth/register → Registrar novo usuário

POST /auth/login → Login de usuário

📂 Categorias

POST /movieflix/category → Criar categoria

GET /movieflix/category → Listar categorias

GET /movieflix/category/{id} → Buscar categoria por ID

DELETE /movieflix/category/{id} → Deletar categoria

📺 Serviços de Streaming

POST /movieflix/stream-service → Criar serviço

GET /movieflix/stream-service → Listar serviços

GET /movieflix/stream-service/{id} → Buscar serviço por ID

DELETE /movieflix/stream-service/{id} → Deletar serviço

🎥 Filmes

POST /movieflix/movie → Criar filme

GET /movieflix/movie → Listar filmes

GET /movieflix/movie/{id} → Buscar filme por ID

GET /movieflix/movie/search?category={id} → Buscar filmes por categoria

PUT /movieflix/movie → Atualizar filme

DELETE /movieflix/movie/{id} → Deletar filme

🤝 Contribuindo

Faça um fork do projeto

Crie uma branch para sua feature (git checkout -b feature/AmazingFeature)

Commit suas mudanças (git commit -m 'Add some AmazingFeature')

Push para a branch (git push origin feature/AmazingFeature)

Abra um Pull Request

📌 Versionamento

Usamos SemVer para versionamento.
Para as versões disponíveis, veja as tags neste repositório.

👨‍💻 Autor

Henrique Santos – Desenvolvedor do projeto

📜 Licença

Este projeto está sob a licença MIT – veja o arquivo LICENSE para detalhes.
