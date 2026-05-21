# 👨‍💻 Autor
## **Myller Montesino**
📌 Prueba técnica desarrollada para vacante de **Java Software Engineer Jr**.


# 🚀 Client Service API


Microservicio REST desarrollado con **Spring Boot** para la gestión de clientes y direcciones, implementando **Arquitectura Hexagonal (Clean Architecture)**, persistencia con **Spring Data JPA** y documentación interactiva con **Swagger/OpenAPI**.

---

# ✨ Tecnologías Utilizadas

* ☕ Java 21
* 🌱 Spring Boot 3
* 🗄️ Spring Data JPA
* 💾 H2 Database
* ✅ Spring Validation
* 📊 Spring Boot Actuator
* 📘 Springdoc OpenAPI (Swagger)
* 📦 Maven
* 🐳 Docker
* 🐙 Docker Compose
* ☸️ Kubernetes

---

# 🏗️ Arquitectura del Proyecto

El proyecto implementa una arquitectura limpia basada en **Puertos y Adaptadores (Hexagonal Architecture)**, permitiendo una separación clara entre:

* Lógica de negocio
*  Interfaces
* Persistencia
* Exposición REST

Esto facilita:

* Escalabilidad
* Mantenibilidad
* Bajo acoplamiento
* Facilidad para pruebas unitarias

---

# 📂 Estructura del Proyecto

```text
src/main/java/com/audifarma/client_service
│
├── application
│   ├── dto
│   └── usecase
│
├── domain
│   ├── model
│   └── ports
│
├── infrastructure
│   ├── adapters
│   │   ├── input
│   │   │   └── rest
│   │   └── output
│   │       └── persistence
│   │
│   ├── config
│   └── exception
│
└── ClientServiceApplication.java
```

---

# 📦 Descripción de Paquetes

## 🧠 application

Contiene los **casos de uso** y DTOs de la aplicación.

### 📁 dto

Objetos Request y Response utilizados por la API REST.

### 📁 usecase

Implementación de la lógica de negocio principal.

---

## 💼 domain

Núcleo principal del negocio.

### 📁 model

Entidades del dominio:

* `Client`
* `Address`

### 📁 ports

Interfaces que definen los contratos del dominio.

---

## ⚙️ infrastructure

Implementaciones técnicas y adaptadores externos.

### 📁 adapters/input/rest

Controladores REST.

### 📁 adapters/output/persistence

Persistencia utilizando Spring Data JPA.

### 📁 config

Configuraciones generales:

* Swagger/OpenAPI
* Beans
* Configuración general

### 📁 exception

Manejo global de excepciones.

---

# 🚀 Funcionalidades Implementadas

* Crear clientes
* Listar clientes
* Obtener cliente por ID
* Actualizar clientes
* Eliminar clientes
* Gestión de direcciones
* Validaciones con Jakarta Validation
* Swagger/OpenAPI
* Spring Boot Actuator
* Dockerización
* Kubernetes Ready

---

# 📋 Requisitos Previos

Antes de ejecutar el proyecto, asegúrese de tener instalado:

* ☕ JDK 21
* 📦 Maven 3.9+
* 🐳 Docker Desktop *(opcional)*
* ☸️ kubectl *(opcional)*
* 💻 IntelliJ IDEA o VSCode

---

# ▶️ Ejecución Local con Maven

## 1️⃣ Clonar el proyecto

```bash
https://github.com/MyllerDev/audifarma-client-service-api.git
```

## 2️⃣ Entrar al proyecto

```bash
cd client-service
```

## 3️⃣ Compilar proyecto

```bash
mvn clean install
```

## 4️⃣ Ejecutar aplicación

```bash
mvn spring-boot:run
```

---

# 🌐 URLs Disponibles

| Servicio        | URL                                        |
| --------------- | ------------------------------------------ |
| 📘 Swagger UI   | `http://localhost:8080/swagger-ui/index.html` |
| 📄 OpenAPI JSON | `http://localhost:8080/api-docs`           |
| ❤️ Health Check | `http://localhost:8080/actuator/health`    |
| 🗄️ H2 Console  | `http://localhost:8080/h2-console`         |

---

# 💾 Configuración H2 Database

| Parámetro | Valor                  |
| --------- | ---------------------- |
| JDBC URL  | `jdbc:h2:mem:clientdb` |
| User      | `sa`                   |
| Password  | *(vacío)*              |

---

# 🐳 Docker

## 🔨 Construir imagen

```bash
docker build -t client-service .
```

## ▶️ Ejecutar contenedor

```bash
docker run -p 8080:8080 client-service
```

---

# 🐙 Docker Compose

## Levantar entorno

```bash
docker-compose up --build
```

---

# ☸️ Kubernetes

Los manifiestos Kubernetes se encuentran en:

```text
k8s/
```

## 📄 Archivos incluidos

* `deployment.yaml`
* `service.yaml`

## Desplegar aplicación

```bash
kubectl apply -f k8s/
```

## Verificar pods

```bash
kubectl get pods
```

## Verificar servicios

```bash
kubectl get svc
```

---

#  Health Probes

Se configuraron:

*  Liveness Probe
*  Readiness Probe

Utilizando el endpoint:

```text
/actuator/health
```

---

# 🔌 Endpoints REST

## ➕ Crear Cliente

### POST

```http
/api/clients
```

### Request

```json
{
  "name": "Juan",
  "lastname": "Perez",
  "email": "juan@example.com",
  "phone": "3001234567",
  "addresses": [
    {
      "street": "Street 123",
      "city": "Bogota",
      "state": "Cundinamarca",
      "postalCode": "110111"
    }
  ]
}
```

---

## 📋 Obtener Todos los Clientes

### GET

```http
/api/clients
```

---

## 🔍 Obtener Cliente por ID

### GET

```http
/api/clients/{id}
```

---

## ✏️ Actualizar Cliente

### PUT

```http
/api/clients/{id}
```

---

## ❌ Eliminar Cliente

### DELETE

```http
/api/clients/{id}
```

---

#  Ejemplos CURL

## Crear Cliente

```bash
curl -X POST http://localhost:8080/api/clients \
-H "Content-Type: application/json" \
-d '{
  "name":"Juan",
  "lastname":"Perez",
  "email":"juan@example.com",
  "phone":"3001234567",
  "addresses":[
    {
      "street":"Street 123",
      "city":"Bogota",
      "state":"Cundinamarca",
      "postalCode":"110111"
    }
  ]
}'
```

---

## 📋 Obtener Clientes

```bash
curl http://localhost:8080/api/clients
```

---

# 📊 Spring Boot Actuator

Endpoints habilitados:

```text
/actuator/health
/actuator/info
```

---

# ✅ Validaciones Implementadas

* ✔️ Campos obligatorios
* ✔️ Validación de email
* ✔️ Validación de direcciones
* ✔️ Manejo global de excepciones

---

# 🛠️ Características Técnicas

* 🏗️ Arquitectura Hexagonal
* 📐 Principios SOLID
* 📦 DTO Pattern
* 💉 Dependency Injection
* 🌐 RESTful API
* 🗃️ JPA/Hibernate
* 📘 Swagger/OpenAPI
* 🐳 Docker Ready
* ☸️ Kubernetes Ready

---

# 👨‍💻 Autor

## **Myller Montesino**

📌 Prueba técnica desarrollada para vacante de **Java Software Engineer Jr**.

---

# ⭐ Consideraciones Finales

Este proyecto fue desarrollado siguiendo buenas prácticas de desarrollo backend moderno con Spring Boot, priorizando:

* Código limpio
* Escalabilidad
* Separación de responsabilidades
* Fácil mantenimiento
* Preparación para despliegues empresariales

---
