# Smart Fridge API

Uma API RESTful desenvolvida com **Spring Boot** e **Java**, que simula o gerenciamento inteligente de alimentos em uma geladeira.

## 🚀 Funcionalidades

- CRUD de alimentos (nome, quantidade, categoria)
- Validações de negócio
- Persistência com banco de dados relacional
- Testes automatizados com **JUnit**
- Containerização com **Docker** e **Docker Compose**

## ⚙️ Tecnologias

- Java 17+
- Spring Boot 3
- Spring Data JPA
- H2 Database (ambiente local)
- JUnit 5
- Docker & Docker Compose

## 🧠 Próximos Passos

Integrar com **Spring AI** para detectar alimentos em falta na geladeira e gerar recomendações automáticas ao usuário.

## 🐳 Rodando com Docker

1. Gere o `.jar` do projeto com:
```bash
./mvnw clean package
```
Suba os containers:

```bash
docker-compose up --build
```
Acesse em:
```bash
http://localhost:8080
```
🧪 Testes
Execute os testes com:

```bash
./mvnw test
```

## Projeto feito para estudo --
