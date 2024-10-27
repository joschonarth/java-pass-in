# 🎫 pass.in

**pass.in** é uma API desenvolvida em **Java** e **Spring Boot** para **gestão de participantes em eventos**. A ferramenta permite que organizadores criem eventos, abram inscrições e gerenciem a entrada dos participantes via credenciais de check-in.

## 🛠️ Tecnologias Utilizadas

- ☕ **Java**
- 🌱 **Spring Boot**
- 📜 **Flyway** - para migrações de banco de dados
- 📦 **Lombok** - para simplificar o código
- 💽 **Spring Data JPA** - para manipulação de dados
- 🗄️ **HSQLDB** - banco de dados em memória para ambiente de desenvolvimento

## ⚙️ Funcionalidades

### Para Organizadores
- 📝 **Cadastro de Evento**: Crie um novo evento para disponibilizar inscrições.
- 📊 **Visualização de Dados do Evento**: Acesse informações detalhadas de cada evento.
- 📋 **Lista de Participantes**: Consulte a lista de participantes inscritos.

### Para Participantes
- 🖊️ **Inscrição no Evento**: Realize a inscrição diretamente na página pública do evento.
- 🆔 **Emissão de Credencial**: Visualize e emita o crachá para check-in no evento.
- ✅ **Check-in no Evento**: Realize o check-in no dia do evento através de escaneamento da credencial.

## ⚙️ Requisitos para Executar o Projeto

- ☕ Java 11 ou superior
- 📦 Maven 3.6+ instalado