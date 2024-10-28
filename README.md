# 🎫 pass.in

**pass.in** é uma API para **gestão de participantes em eventos** desenvolvida em **Java** e **Spring Boot**. A ferramenta permite que organizadores criem eventos, abram inscrições e gerenciem a entrada dos participantes via credenciais de check-in.

## 🛠️ Tecnologias Utilizadas

- ☕ **Java**: Linguagem principal utilizada para desenvolver a aplicação.
- 🌱 **Spring Boot**: Framework que facilita o desenvolvimento da aplicação, incluindo suporte a RESTful APIs.
- 🪽 **Flyway**: Ferramenta para versionamento e migração de banco de dados, garantindo que o esquema do banco esteja atualizado.
- 🔧 **Lombok**: Biblioteca que reduz a verbosidade do código.
- 🗃️ **Spring Data JPA**: Abstração que simplifica o acesso a dados, permitindo interações mais fáceis com o banco de dados.
- 🗄️ **HSQLDB**: Banco de dados em memória utilizado para ambiente de desenvolvimento, permitindo testes rápidos e facilidade de configuração.

## ⚙️ Funcionalidades

### Para Organizadores
- 📝 **Cadastro de Evento**: Crie um novo evento.
- 📊 **Visualização de Dados do Evento**: Acesse informações detalhadas de cada evento.
- 📋 **Lista de Participantes**: Consulte a lista de participantes inscritos no evento.
- ✏️ **Edição de Evento**: Edite as informações de um evento.

### Para Participantes
- 🖊️️ **Inscrição no Evento**: Realize a inscrição no evento escolhido.
- 🆔 **Emissão de Credencial**: Visualize e emita o crachá para check-in no evento.
- ✅ **Check-in no Evento**: Realize o check-in do evento.
- ❌ **Cancelar Check-in**: Cancele o check-in do evento.

## ⚙️ Requisitos para Executar o Projeto

- ☕ Java 11 ou superior
- 📦 Maven 3.6+ instalado

## 🚀 Como Rodar o Projeto

📌 **1. Clone o repositório**:

```bash
git clone https://github.com/joschonarth/java-pass-in
```

📌 **2. Entre no diretório do projeto**:

```bash
cd java-pass-in
```

📌 **3. Compile e execute o projeto usando o Maven**:

```bash
mvn spring-boot:run
```

## 🌐 Acesso à API
A API estará disponível em: [http://localhost:8080](http://localhost:8080)


## 🔗 Endpoints

### 🎟️ Para Organizador do Evento

---

### 📝 Cadastro de Evento
- **Descrição**: Cria um novo evento.
- **Método**: `POST`
- **Endpoint**: `/events`

🌐 **Exemplo de Requisição**: `http://localhost:8080/events`

```json
{
  "title": "Rocketseat NLW",
  "details": "Aprenda Java de forma gratuita",
  "maximumAttendees": 500
}
```

📄 **Exemplo de Resposta:**

```json
{
  "eventId": "b88a5a6c-a047-4d2e-a4b9-c362c4c2fe9d"
}
```

### 📊 Visualização de Dados do Evento
- **Descrição**: Retorna os detalhes de um evento específico.
- **Método**: `GET`
- **Endpoint**: `/events/{eventId}`

🌐 **Exemplo de Requisição**: `http://localhost:8080/events/{eventId}`

📄 **Exemplo de Resposta:**

```json
{
  "event": {
    "id": "b88a5a6c-a047-4d2e-a4b9-c362c4c2fe9d",
    "title": "Rocketseat NLW",
    "details": "Aprenda Java de forma gratuita",
    "slug": "rocketseat-nlw",
    "maximumAttendees": 500,
    "attendeesAmount": 0
  }
}
```

### 📋 Lista de Participantes
- **Descrição**: Retorna a lista de participantes de um evento específico.
- **Método**: `GET`
- **Endpoint**: `/events/{eventId}/attendees`

🌐 **Exemplo de Requisição**: `http://localhost:8080/events/{eventId}/attendees`

📄 **Exemplo de Resposta:**

```json
{
  "attendees": [
    {
      "id": "0d6a8bd4-bee1-44b5-ba74-1acc7ad9fa56",
      "name": "Joao Otavio",
      "email": "joschonarth@gmail.com",
      "createdAt": "2024-10-27T19:06:47.820896",
      "checkedInAt": null
    }
  ]
}
```

### ✏️ Edição de Evento
- **Descrição**: Edita as informações de um evento existente.
- **Método**: `PUT`
- **Endpoint**: `/events/{eventId}`

🌐 **Exemplo de Requisição**: `http://localhost:8080/events/{eventId}`

```json
{
    "title": "Rocketseat NLW Unite",
    "details": "Aprenda Java de forma gratuita",
    "maximumAttendees": 1000
}
```

📄 **Exemplo de Resposta:**

```json
{
    "event": {
        "id": "b88a5a6c-a047-4d2e-a4b9-c362c4c2fe9d",
        "title": "Rocketseat NLW Unite",
        "details": "Aprenda Java de forma gratuita",
        "slug": "rocketseat-nlw-unite",
        "maximumAttendees": 1000,
        "attendeesAmount": 1
    }
}
```

### 👤 Para Participante do Evento 

---

### 🖊️ Inscrição no Evento
- **Descrição**: Inscreve um novo participante em um evento.
- **Método**: `POST`
- **Endpoint**: `/events/{eventId}/attendees`

🌐 **Exemplo de Requisição**: `http://localhost:8080/events/{eventId}/attendees`

```json
{
  "name": "Joao Otavio",
  "email": "joschonarth@gmail.com"
}
```

📄 **Exemplo de Resposta:**

```json
{
  "attendeeId": "0d6a8bd4-bee1-44b5-ba74-1acc7ad9fa56"
}
```

### 🆔 Obter Crachá do Participante
- **Descrição**: Retorna o crachá de inscrição de um participante específico.
- **Método**: `GET`
- **Endpoint**: `/attendees/{attendeeId}/badge`

🌐 **Exemplo de Requisição**: `http://localhost:8080/attendees/{attendeeId}/badge`

📄 **Exemplo de Resposta:**

```json
{
    "badge": {
        "name": "Joao Otavio",
        "email": "joschonarth@gmail.com",
        "checkInUrl": "http://localhost:8080/attendees/0d6a8bd4-bee1-44b5-ba74-1acc7ad9fa56/check-in",
        "eventId": "b88a5a6c-a047-4d2e-a4b9-c362c4c2fe9d"
    }
}
```

### ✅ Realizar Check-in do Participante
- **Descrição**: Realiza o check-in de um participante no evento.
- **Método**: `POST`
- **Endpoint**: `/attendees/{attendeeId}/check-in`

🌐 **Exemplo de Requisição**: `http://localhost:8080/attendees/{attendeeId}/check-in`

📄 **Exemplo de Resposta:** 

**Status Code**: `201 Created`

### ❌ Cancelar Check-in do Participante
- **Descrição**: Cancele o check-in de um participante no evento.
- **Método**: `DELETE`
- **Endpoint**: `/attendees/{attendeeId}/check-in`

🌐 **Exemplo de Requisição**: `http://localhost:8080/attendees/{attendeeId}/check-in`

📄 **Exemplo de Resposta:** "Check-in cancelado com sucesso!"

## 🤝 Contribuindo

Se você deseja contribuir com o projeto, fique à vontade para abrir uma pull request ou uma issue.

## 📞 Contato

<div>
    <a href="https://www.linkedin.com/in/joschonarth/" target="_blank"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a>
    <a href="mailto:joschonarth@gmail.com" target="_blank"><img src="https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white" target="_blank"></a>
</div>