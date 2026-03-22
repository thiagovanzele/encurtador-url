# 🚀 Encurtador de URL

Aplicação fullstack com:

* Backend: Spring Boot
* Frontend: React (Vite)
* Banco: PostgreSQL
* Orquestração: Docker Compose

---

## 🐳 Como rodar o projeto

### ✅ Pré-requisitos

* Docker instalado
* Docker Compose instalado

---

### ▶️ Rodar a aplicação

```bash
docker compose up --build
```

---

### 🌍 Acessos

* Frontend: http://localhost:5173
* Backend: http://localhost:8080
* Banco: localhost:5433

---

## 🧠 Observações

* O frontend se comunica com o backend via rede Docker (`http://backend:8080`)
* O backend se conecta ao banco via (`postgres:5432`)

---

## 🛑 Parar containers

```bash
docker compose down
```
