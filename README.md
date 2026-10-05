# 🍷 Adega do Pai — Backend

API REST responsável pelo backend do **Adega do Pai**, uma aplicação desenvolvida para oferecer uma base segura, organizada e escalável para gerenciamento de operações de uma adega.

O projeto foi desenvolvido utilizando **Java + Spring Boot**, com persistência em **PostgreSQL**, autenticação baseada em **JWT**, documentação via **OpenAPI/Swagger**, validação de dados, controle de requisições e integração com o **Mercado Pago** para processamento de pagamentos.

---

## 📌 Visão geral

O **Adega do Pai Backend** funciona como a camada central da aplicação, disponibilizando uma API REST para comunicação com o frontend e integração com serviços externos.

Entre as principais responsabilidades da aplicação estão:
- 🔐 **Autenticação e autorização** utilizando JWT
- 👤 **Gerenciamento de usuários** e acesso protegido
- 🗄️ **Persistência de dados** utilizando PostgreSQL
- 🔄 **Mapeamento objeto-relacional** com Spring Data JPA
- 💳 **Integração com Mercado Pago**
- 🔔 **Recebimento de notificações** de pagamento via Webhook
- 🌐 **Configuração de CORS** para comunicação com o frontend
- 🛡️ **Rate limiting** para proteção da API
- ✅ **Validação de dados** de entrada
- 📚 **Documentação automática** da API com OpenAPI/Swagger
- 📊 **Monitoramento** através do Spring Boot Actuator
- 🧩 **Separação de responsabilidades** através de uma arquitetura em camadas

---

## 🏗️ Arquitetura

A aplicação segue uma arquitetura backend baseada na separação de responsabilidades entre as diferentes camadas da aplicação.

                    ┌───────────────────────┐
                    │       Frontend        │
                    │   Web / Application   │
                    └───────────┬───────────┘
                                │
                                │ HTTP / JSON
                                ▼
                    ┌───────────────────────┐
                    │      REST API         │
                    │    Controllers        │
                    └───────────┬───────────┘
                                │
                                ▼
                    ┌───────────────────────┐
                    │       Services        │
                    │    Regras de negócio  │
                    └───────────┬───────────┘
                                │
                                ▼
                    ┌───────────────────────┐
                    │     Repositories      │
                    │    Spring Data JPA    │
                    └───────────┬───────────┘
                                │
                                ▼
                    ┌───────────────────────┐
                    │      PostgreSQL       │
                    │      Database         │
                    └───────────────────────┘

                         Serviços externos

                    ┌───────────────────────┐
                    │     Mercado Pago      │
                    │       Payments        │
                    └───────────────────────┘

### Fluxo de uma requisição

Cliente
   │
   ▼
Controller
   │
   ▼
Validation / Security
   │
   ▼
Service
   │
   ▼
Repository
   │
   ▼
PostgreSQL
   │
   ▼
Response JSON

Essa organização permite manter a aplicação desacoplada e facilita manutenção, testes e evolução do sistema.

---

## 🛠️ Stack tecnológica

| Tecnologia | Utilização |
| :--- | :--- |
| ☕ **Java 25** | Linguagem principal |
| 🍃 **Spring Boot 4.0.6** | Framework principal |
| 🌐 **Spring MVC** | Construção da API REST |
| 🗃️ **Spring Data JPA** | Persistência e acesso ao banco |
| 🐘 **PostgreSQL** | Banco de dados relacional |
| 🔐 **Spring Security** | Segurança e autenticação |
| 🎫 **JWT** | Autenticação baseada em tokens |
| ✅ **Bean Validation** | Validação de dados |
| 🗺️ **MapStruct** | Mapeamento entre objetos/DTOs |
| 🧰 **Lombok** | Redução de código boilerplate |
| 📚 **SpringDoc OpenAPI** | Documentação Swagger |
| 💳 **Mercado Pago SDK** | Integração de pagamentos |
| 🩺 **Spring Boot Actuator** | Health checks e métricas |
| 🛠️ **Maven** | Build e gerenciamento de dependências |
| 🔄 **Flyway** | Suporte a migrations |

As dependências principais estão declaradas no `pom.xml`.

---

## 📁 Estrutura do projeto

A estrutura principal do projeto está organizada da seguinte forma:

adega--backend/
│
├── .mvn/
│   └── wrapper/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── adegadopaibackend/
│   │   │
│   │   └── resources/
│   │       ├── application.yaml
│   │       └── db/
│   │           └── migration/
│   │
│   └── test/
│       └── java/
│
├── .env.example
├── .gitattributes
├── .gitignore
├── HELP.md
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md

### Principais responsabilidades

| Camada | Responsabilidade |
| :--- | :--- |
| **controller** | Receber requisições HTTP e retornar respostas |
| **service** | Implementar regras de negócio |
| **repository** | Acesso e persistência dos dados |
| **entity / model** | Representação das entidades de domínio |
| **dto** | Objetos de entrada e saída da API |
| **mapper** | Conversão entre entidades e DTOs |
| **security** | Autenticação, JWT e proteção dos endpoints |
| **config** | Configurações da aplicação e integrações |
| **exception** | Tratamento centralizado de erros |

---

## ⚙️ Pré-requisitos

Antes de executar o projeto, certifique-se de possuir:
- **Java 25**
- **Maven** ou Maven Wrapper
- **PostgreSQL**
- **Git**
- Uma conta/configuração do **Mercado Pago** (caso queira testar os pagamentos)

Verifique as versões instaladas:

java -version
./mvnw -version

# No Windows:
.\mvnw.cmd -version

---

## 🚀 Instalação

### 1. Clone o repositório

git clone https://github.com/Mart1nelli/adega--backend.git
cd adega--backend

### 2. Configure o PostgreSQL
Crie um banco de dados PostgreSQL para o projeto.

CREATE DATABASE adega_do_pai;

Crie também um usuário com permissão para acessar o banco:

CREATE USER adega_user WITH PASSWORD 'sua_senha';
GRANT ALL PRIVILEGES ON DATABASE adega_do_pai TO adega_user;

*(Recomenda-se utilizar credenciais diferentes em desenvolvimento, homologação e produção).*

---

## 🔐 Configuração das variáveis de ambiente

O projeto disponibiliza um arquivo `.env.example` contendo as principais configurações necessárias.

Crie uma cópia:

cp .env.example .env

# No Windows:
copy .env.example .env

Depois configure os valores no `.env`:

# ==========================================
# DATABASE
# ==========================================
DB_URL=jdbc:postgresql://localhost:5432/adega_do_pai
DB_USERNAME=adega_user
DB_PASSWORD=sua_senha

# ==========================================
# HIKARI CONNECTION POOL
# ==========================================
DB_POOL_MAX=20
DB_POOL_MIN=5

# ==========================================
# JPA / HIBERNATE
# ==========================================
JPA_DDL_AUTO=update
SHOW_SQL=false

# ==========================================
# JWT
# ==========================================
JWT_SECRET_KEY=uma-chave-secreta-longa-e-segura-com-pelo-menos-32-caracteres

# ==========================================
# RATE LIMITING
# ==========================================
AUTH_RATE_LIMIT_MAX_REQUESTS=10
AUTH_RATE_LIMIT_WINDOW_MS=60000

API_RATE_LIMIT_MAX_REQUESTS=120
API_RATE_LIMIT_WINDOW_MS=60000

# ==========================================
# CORS
# ==========================================
CORS_ALLOWED_ORIGINS=http://localhost:4200

# ==========================================
# MERCADO PAGO
# ==========================================
MERCADOPAGO_ACCESS_TOKEN=seu-access-token
MERCADOPAGO_WEBHOOK_URL=http://localhost:8080/api/v1/payments/webhook
MERCADOPAGO_FRONTEND_SUCCESS_URL=http://localhost:4200/checkout/sucesso
MERCADOPAGO_FRONTEND_FAILURE_URL=http://localhost:4200/checkout/falha
MERCADOPAGO_FRONTEND_PENDING_URL=http://localhost:4200/checkout/pendente
MERCADOPAGO_USE_SANDBOX_CHECKOUT_URL=true

---

## 🗄️ Banco de dados & Migrations

A aplicação utiliza **PostgreSQL** como banco de dados principal. O pool de conexões é gerenciado pelo **HikariCP**.

O projeto possui dependência do **Flyway** para migrations localizadas em `classpath:db/migration`. O padrão de nomenclatura configurado é:

V1__descricao.sql
V2__descricao.sql
V3__descricao.sql

⚠️ **Atenção:** Na configuração atual do projeto, o Flyway está **desabilitado**:

spring:
  flyway:
    enabled: false

Antes de utilizar migrations automaticamente em um ambiente de produção, é importante revisar essa configuração.

---

## ▶️ Executando o projeto

**Linux / macOS (Maven Wrapper):**

./mvnw spring-boot:run

**Windows:**

.\mvnw.cmd spring-boot:run

### 📦 Build

Para gerar o artefato da aplicação (`.jar`):

./mvnw clean package

Execute o pacote gerado:

java -jar target/adegadopaibackend-0.0.1-SNAPSHOT.jar

---

## 🌐 API & Documentação

Por padrão, a aplicação roda na porta `8080` e os endpoints são organizados sob a versão `/api/v1`.

### Swagger / OpenAPI
A aplicação utiliza `springdoc-openapi-starter-webmvc-ui` para geração automática da documentação da API. Com a aplicação em execução, acesse:
- **Swagger UI interativo:** http://localhost:8080/swagger-ui/index.html
- **Especificação OpenAPI:** http://localhost:8080/v3/api-docs

---

## 🔐 Segurança & Autenticação

A API utiliza **Spring Security + JWT** para autenticação. O cliente autenticado deve enviar o token através do header HTTP:

Authorization: Bearer <TOKEN>

### Fluxo de Autenticação

┌──────────────┐
│    Cliente   │
└──────┬───────┘
       │ Login
       ▼
┌──────────────┐
│  Auth API    │
└──────┬───────┘
       │ JWT
       ▼
┌──────────────┐
│    Cliente   │
└──────┬───────┘
       │ Authorization: Bearer TOKEN
       ▼
┌──────────────┐
│ Spring Sec.  │
└──────┬───────┘
       │
       ▼
┌──────────────┐
│ REST API     │
└──────────────┘

### 🛡️ Rate Limiting
A aplicação possui configurações para limitar a quantidade de requisições, evitando *Brute force*, abuso de endpoints e ataques simples de negação de serviço:
- **Auth:** 10 requisições a cada 60 segundos
- **API:** 120 requisições a cada 60 segundos

---

## 💳 Mercado Pago & Webhooks

O backend possui integração com o **Mercado Pago** através do SDK oficial para Java.

**Webhook Endpoint:**

POST /api/v1/payments/webhook

**Fluxo de Pagamento:**

Cliente ──► Backend ──(Criação)──► Mercado Pago
                                        │ (Processamento)
Backend ◄──(Webhook)── Mercado Pago ◄───┘
   │
   ▼
Atualização do estado

---

## 🧪 Testes & 🩺 Monitoramento

Para executar a suíte de testes:

./mvnw test

O projeto utiliza **Spring Boot Actuator** para monitoramento. Endpoints expostos:
- `/actuator/health` (Exemplo de resposta: `{"status": "UP"}`)
- `/actuator/info`
- `/actuator/metrics`

---

## 🧩 Ferramentas Auxiliares

- **MapStruct:** Utilizado para conversão limpa entre entidades de persistência (Entity) e objetos da API (DTOs).
- **Lombok:** Reduz código repetitivo (`@Getter`, `@Setter`, `@Builder`, etc).
- **JPA:** Configurado com `open-in-view: false` para manter o acesso ao banco explícito nas camadas apropriadas.

---

## 🔒 Boas práticas para Produção

Antes de disponibilizar a aplicação em produção, certifique-se de:
1. **JWT:** Utilizar uma chave longa/aleatória e não versionada.
2. **PostgreSQL:** Não usar o usuário raiz (`postgres`), e alterar `JPA_DDL_AUTO=validate`.
3. **CORS:** Configurar domínios estritos (nunca usar `*`).
4. **Mercado Pago:** Nunca versionar o `MERCADOPAGO_ACCESS_TOKEN`.
5. **.env:** Manter fora do controle de versão.

---

## ❗ Tratamento de erros

A API mantém respostas HTTP semanticamente consistentes. Formato de erro padrão:

{
  "status": 400,
  "message": "Dados inválidos"
}

| Status | Significado |
| :--- | :--- |
| **200** | Requisição processada com sucesso |
| **201** | Recurso criado |
| **204** | Operação concluída sem conteúdo |
| **400** | Requisição inválida |
| **401** | Não autenticado |
| **403** | Acesso não permitido |
| **404** | Recurso não encontrado |
| **409** | Conflito de dados |
| **422** | Dados semanticamente inválidos |
| **429** | Limite de requisições excedido |
| **500** | Erro interno |

---

## 🤝 Contribuindo

Contribuições são bem-vindas! Padrão de commits sugerido (Conventional Commits):
- `feat:` adiciona nova funcionalidade
- `fix:` corrige bug
- `refactor:` reorganização de código
- `docs:` atualiza documentação
- `test:` adição/correção de testes
- `chore:` atualiza dependências

Fluxo recomendado:

git checkout -b feature/minha-feature
git commit -m "feat: adiciona minha feature"
git push origin feature/minha-feature

---

## 📋 Checklist para iniciar o projeto

- [ ] Java 25 instalado
- [ ] PostgreSQL executando e banco criado
- [ ] `.env` configurado (DB, JWT, CORS)
- [ ] Credenciais do Mercado Pago configuradas (se necessário)
- [ ] Testes executando (`./mvnw test`)
- [ ] Aplicação rodando e respondendo no `localhost:8080`

---

## 📄 Licença

A licença deve ser definida pelo responsável pelo projeto.

---
*Backend desenvolvido com foco em Java, Spring Boot, PostgreSQL e boas práticas de arquitetura de software.*
