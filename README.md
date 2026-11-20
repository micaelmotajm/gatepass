# GatePass API

API RESTful desenvolvida em Java com Spring Boot e MySQL para registro, consulta, atualização e exclusão (CRUD) de visitas.

## Tecnologias Utilizadas

* **Java 25**
* **Spring Boot 3** (Web, Data JPA, Validation)
* **MySQL 8**
* **Lombok**
* **SpringDoc OpenAPI (Swagger UI)**
* **Maven**

## Estrutura do Projeto

```text
src/main/java/com/example/gatepass/
├── controller/   # Endpoints REST e respostas HTTP (/visitas)
├── model/        # Entidade JPA Visita e regras de validação
├── repository/   # Interface Spring Data JPA (VisitaRepository)
├── service/      # Regras de negócio e tratamento de exceções
└── GatePassApplication.java
```

## Endpoints da API

| Método | Rota | Descrição | Status HTTP |
| :--- | :--- | :--- | :--- |
| `POST` | `/visitas` | Cadastra uma nova visita | `201 Created` / `400 Bad Request` |
| `GET` | `/visitas` | Lista todas as visitas registradas | `200 OK` |
| `GET` | `/visitas/{id}` | Busca uma visita específica pelo ID | `200 OK` / `404 Not Found` |
| `PUT` | `/visitas/{id}` | Atualiza os dados de uma visita existente | `200 OK` / `400 Bad Request` / `404 Not Found` |
| `DELETE` | `/visitas/{id}` | Remove uma visita pelo ID | `204 No Content` / `404 Not Found` |

### Exemplo de Payload (`POST` e `PUT`)

```json
{
  "nomeVisitante": "Carlos Eduardo Silva",
  "setorVisitado": "Recursos Humanos",
  "motivoVisita": "Entrega de documentação",
  "dataVisita": "2026-11-20"
}
```

> **Regras de validação:** todos os campos são obrigatórios e `dataVisita` não pode ser uma data futura (`@PastOrPresent`).

## Como Executar Localmente

1. **Pré-requisitos:** Java 25 e MySQL Server em execução na porta `3306` (o banco `gatepass` e a tabela `visitas` são criados automaticamente ao iniciar a aplicação).
2. **Inicie a aplicação:**
   ```bash
   ./mvnw spring-boot:run
   ```
3. **Documentação interativa (Swagger UI):**
   Acesse `http://localhost:8080/swagger-ui/index.html` no navegador ou importe as requisições no **Bruno** apontando para `http://localhost:8080/visitas`.
