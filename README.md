# 🧴 Micro SaaS - Sistema de Agendamentos para Clínica de Estética

Estou desenvolvendo esseprojeto simples de **API REST** desenvolvido com **Java + Spring Boot**, que simula um sistema de agendamento para clínicas de estética.  

---

## ✨ Funcionalidades

- Cadastro de clientes
- Cadastro de serviços (como limpeza de pele, massagem, etc.)
- Agendamentos com data e hora
- Listagem de clientes, serviços e agendamentos
- Banco de dados em memória (H2)

---

## 🛠 Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Banco de dados H2 (em memória)
- Maven
- Lombok

---

## 🚀 Como executar o projeto

### Pré-requisitos

- Java JDK 17+
- Maven
- IDE como VS Code ou IntelliJ

### Passos para rodar o projeto
1. Clone este repositório:
bash
git clone https://github.com/seu-usuario/nome-do-projeto.git

3. Navegue até o diretório do projeto:
 cd nome-do-projeto

3.Rode o projeto:
./mvnw spring-boot:run


Ou, se preferir, abra o projeto na IDE e execute a classe principal:
MicroSaasEsteticaApplication.java

📬 Endpoints da API
Clientes
POST /clientes → Cadastrar cliente

GET /clientes → Listar clientes

Serviços
POST /servicos → Cadastrar serviço

GET /servicos → Listar serviços

Agendamentos
POST /agendamentos → Criar agendamento

GET /agendamentos → Listar agendamentos



