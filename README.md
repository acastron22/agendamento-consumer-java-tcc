# Agendamento Consumer — Consumidor de Eventos (Spring Boot + Kafka)

Este repositório contém o microserviço responsável por consumir eventos de agendamento publicados no Apache Kafka.

Ele representa o **serviço consumidor (consumer)** da arquitetura orientada a eventos do projeto.

---

# 🎯 Responsabilidade do serviço

O agendamento-consumer:

- escuta o tópico Kafka de agendamentos
- recebe eventos publicados pelo producer
- desserializa mensagens JSON
- processa os dados recebidos
- executa lógica de consumo (log, processamento, integração futura)

---

# 🧱 Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Kafka
- Maven
- Apache Kafka
- Docker (infraestrutura externa)

---

# 📌 Pré-requisitos

Antes de rodar o serviço:

- Kafka rodando via Docker Compose
---


# ▶️ Como rodar o projeto — IntelliJ (Windows e Mac)
## 1️⃣ Abrir projeto

Open → selecionar pasta agendamento-consumer
Aguardar importação Maven

## 2️⃣ Executar aplicação

Localizar a classe principal:

```bash 
AgendamentoConsumerApplication

```

Executar
```bash
Run → Run Application
```

Ou botão ▶️ ao lado da classe.

## 3️⃣ Porta padrão
```
http://localhost:8081
```

# 📥 Tópico Kafka consumido
```
agendamentos-criados
```

👂 Listener Kafka

O serviço utiliza:
```
@KafkaListener
```

```java
@KafkaListener(
    topics = "agendamentos-criados",
    groupId = "agendamento-group"
)
```

Console do consumer exibirá:

Evento recebido:

ID: ...

Paciente: ...

Medico: ...

# 📦 Estrutura de pacotes
```
consumer → listeners Kafka
model → classes de evento
config → configuração Kafka
```

# 🔁 Fluxo de funcionamento
```
Producer publica evento
↓
Kafka topic
↓
Consumer recebe
↓
Processamento local
```

# ✅ Status esperado

Aplicação funcionando corretamente quando:

inicia sem erro

conecta no Kafka

recebe eventos publicados

exibe dados no console
