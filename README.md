# 🎫 pass.in

**pass.in** é uma API para **gestão de participantes em eventos** desenvolvida em **Java** e **Spring Boot**. A ferramenta permite que organizadores criem eventos, abram inscrições e gerenciem a entrada dos participantes via credenciais de check-in.

## 🛠️ Tecnologias Utilizadas

- ☕ **Java 17**: Linguagem principal utilizada para desenvolver a aplicação.
- 🌱 **Spring Boot**: Framework que facilita o desenvolvimento da aplicação, incluindo suporte a RESTful APIs.
- 📜 **Flyway**: Ferramenta para versionamento e migração de banco de dados, garantindo que o esquema do banco esteja atualizado.
- 🔧 **Lombok**: Biblioteca que reduz a verbosidade do código, gerando automaticamente getters, setters e outros métodos úteis.
- 🗃️ **Spring Data JPA**: Abstração que simplifica o acesso a dados, permitindo interações mais fáceis com o banco de dados.
- 🗄️ **HSQLDB**: Banco de dados em memória utilizado para ambiente de desenvolvimento, permitindo testes rápidos e facilidade de configuração.

## ⚙️ Funcionalidades

### Para Organizadores
- 📝 **Cadastro de Evento**: Crie um novo evento para disponibilizar inscrições.
- 📊 **Visualização de Dados do Evento**: Acesse informações detalhadas de cada evento.
- 📋 **Lista de Participantes**: Consulte a lista de participantes inscritos no evento.

### Para Participantes
- ✏️ **Inscrição no Evento**: Realize a inscrição diretamente na página pública do evento.
- 🆔 **Emissão de Credencial**: Visualize e emita o crachá para check-in no evento.
- ✅ **Check-in no Evento**: Realize o check-in no dia do evento através de escaneamento da credencial.

## ⚙️ Requisitos para Executar o Projeto

- ☕ Java 11 ou superior
- 📦 Maven 3.6+ instalado

## 🔗 Endpoints

### 🎟️ Organizador do Evento

### 📝 Cadastro de Evento
- **Descrição**: Cria um novo evento.
- **Método**: `POST`
- **Endpoint**: `/events`

🌐 **Exemplo de Requisição**: `http://localhost:8080/events`

```json

```

📄 **Exemplo de Resposta:**

```json

```

### 📊 Visualização de Dados do Evento
- **Descrição**: Retorna os detalhes de um evento específico.
- **Método**: `GET`
- **Endpoint**: `/events/{eventId}`

🌐 **Exemplo de Requisição**: `http://localhost:8080/events/{eventId}`

📄 **Exemplo de Resposta:**

```json

```

### 📋 Lista de Participantes
- **Descrição**: Retorna a lista de participantes de um evento específico.
- **Método**: `GET`
- **Endpoint**: `/events/{eventId}/attendees`

🌐 **Exemplo de Requisição**: `http://localhost:8080/events/{eventId}/attendees`

📄 **Exemplo de Resposta:**

```json

```

### 👤 Para Participante do Evento 

### ✏️ Inscrição no Evento
- **Descrição**: Inscreve um novo participante em um evento.
- **Método**: `POST`
- **Endpoint**: `/events/{eventId}/attendees`

🌐 **Exemplo de Requisição**: `http://localhost:8080/events/{eventId}/attendees`

```json

```

📄 **Exemplo de Resposta:**

```json

```

### 🆔 Obter Crachá do Participante
- **Descrição**: Retorna o crachá de inscrição de um participante específico.
- **Método**: `GET`
- **Endpoint**: `/attendees/{attendeeId}/badge`

🌐 **Exemplo de Requisição**: `http://localhost:8080/attendees/{attendeeId}/badge`

📄 **Exemplo de Resposta:**

```json

```

### ✅ Realizar Check-in do Participante
- **Descrição**: Realiza o check-in de um participante no evento.
- **Método**: `POST`
- **Endpoint**: `/attendees/{attendeeId}/check-in`

🌐 **Exemplo de Requisição**: `http://localhost:8080/attendees/{attendeeId}/check-in`

```json

```

📄 **Exemplo de Resposta:**

```json

```