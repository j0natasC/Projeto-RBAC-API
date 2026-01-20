# 🔐 RBAC API – Role-Based Access Control com Spring Security

Projeto backend desenvolvido para demonstrar **controle de acesso baseado em papéis (RBAC)** utilizando **Spring Boot 4**, **Spring Security** e **testes automatizados de segurança**.

Este projeto tem foco em **boas práticas de segurança**, **testes de autorização/autenticação** e organização de código voltada para aplicações reais.

---

## 🚀 Tecnologias Utilizadas

* **Java 21**
* **Spring Boot 4.0.1**
* **Spring Security**
* **Spring Data JPA**
* **H2 Database (em memória)**
* **JUnit 5**
* **Spring Security Test**
* **MockMvc**
* **Maven**

---

## 🧠 Conceitos Aplicados

* Autenticação e autorização com Spring Security
* Controle de acesso baseado em roles (RBAC)
* Proteção de endpoints com `@PreAuthorize`
* Testes de segurança simulando diferentes perfis de usuário
* Boas práticas de separação de camadas (Controller, Security, etc.)

---

## 🔐 Regras de Acesso Implementadas

| Endpoint | Role necessária | Resultado esperado |
| -------- | --------------- | ------------------ |
| `/admin` | `ADMIN`         | ✅ 200 OK           |
| `/admin` | `USER`          | ❌ 403 Forbidden    |
| `/admin` | Não autenticado | ❌ 401 Unauthorized |

---

## 🧪 Testes Automatizados

Os testes de segurança validam todos os cenários de acesso usando **MockMvc** e **Spring Security Test**:

* ✔️ Acesso permitido para usuários com role `ADMIN`
* ❌ Acesso negado para usuários com role `USER`
* ❌ Acesso negado para usuários não autenticados

Exemplo de abordagem utilizada:

* `@WithMockUser`
* `@WithAnonymousUser`
* Validação de status HTTP (`200`, `401`, `403`)

---

## ▶️ Como Executar o Projeto

### Pré-requisitos

* Java 21
* Maven

### Passos

```bash
# Clonar o repositório
git clone https://github.com/seu-usuario/rbac-api.git

# Entrar no projeto
cd rbac-api

# Executar a aplicação
mvn spring-boot:run
```

A aplicação será iniciada em:

```
http://localhost:8080
```

---

## 🧪 Como Executar os Testes

```bash
mvn test
```

Os testes de segurança validarão automaticamente os cenários de autenticação e autorização.

---

## 🗄️ Banco de Dados

* Banco em memória **H2**
* Ideal para testes e desenvolvimento
* Console pode ser habilitado via configuração (se necessário)

---

## 📌 Objetivo do Projeto

Este projeto foi desenvolvido com foco em:

* Consolidar conhecimentos em **Spring Security**
* Demonstrar domínio de **testes de segurança backend**
* Servir como **projeto de portfólio** para vagas backend Java

---

## 👤 Autor

**Jonatas Cavalcante**

* GitHub:  https://github.com/seu-usuario)](https://github.com/j0natasC
* LinkedIn: https://www.linkedin.com/in/jonatas-cavalcante/

---

📌 *Sugestões e feedbacks são bem-vindos!*
