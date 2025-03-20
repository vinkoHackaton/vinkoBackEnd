# Aplicación de Gestión de Actividades para Personas Mayores

Este es un proyecto Spring Boot que gestiona actividades, compañeros, usuarios mayores, reseñas, notificaciones y solicitudes de contacto. La aplicación sigue los principios SOLID y está organizada en capas (controladores, servicios, repositorios y modelos).

---

## **Tabla de Contenidos**
1. [Requisitos](#requisitos)
2. [Instalación](#instalación)
3. [Estructura del Proyecto](#estructura-del-proyecto)
4. [Endpoints de la API](#endpoints-de-la-api)
5. [Ejecución](#ejecución)
6. [Contribución](#contribución)
7. [Licencia](#licencia)

---

## **Requisitos**

- Java 17 o superior.
- Maven 3.x.
- Base de datos H2 (incluida para desarrollo) o MySQL/PostgreSQL (para producción).
- Spring Boot 3.x.

---

## **Instalación**

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu-usuario/tu-repositorio.git
   cd tu-repositorio

Para desarrollo, la aplicación utiliza H2 (no se requiere configuración adicional).

Para producción, configura application.properties con las credenciales de tu base de datos (MySQL o PostgreSQL).

Compila el proyecto:

bash
Copy
mvn clean install
Estructura del Proyecto
El proyecto está organizado en los siguientes paquetes:

Copy
src/main/java/com/example/demo/
├── config/                # Configuraciones de la aplicación
├── controller/            # Controladores (REST API)
├── service/               # Lógica de negocio (Servicios)
├── repository/            # Acceso a datos (Repositorios)
├── model/                 # Entidades (Modelos de datos)
├── dto/                   # Objetos de Transferencia de Datos (DTOs)
└── exception/             # Manejo de excepciones personalizadas
Endpoints de la API
Actividades (/api/activities)
GET /api/activities - Obtener todas las actividades.

GET /api/activities/{id} - Obtener una actividad por ID.

POST /api/activities - Crear una nueva actividad.

PUT /api/activities/{id} - Actualizar una actividad existente.

DELETE /api/activities/{id} - Eliminar una actividad.

Compañeros (/api/companions)
GET /api/companions - Obtener todos los compañeros.

GET /api/companions/{id} - Obtener un compañero por ID.

POST /api/companions - Crear un nuevo compañero.

PUT /api/companions/{id} - Actualizar un compañero existente.

DELETE /api/companions/{id} - Eliminar un compañero.

Usuarios Mayores (/api/elderly-users)
GET /api/elderly-users - Obtener todos los usuarios mayores.

GET /api/elderly-users/{id} - Obtener un usuario mayor por ID.

POST /api/elderly-users - Crear un nuevo usuario mayor.

PUT /api/elderly-users/{id} - Actualizar un usuario mayor existente.

DELETE /api/elderly-users/{id} - Eliminar un usuario mayor.

Reseñas (/api/reviews)
GET /api/reviews - Obtener todas las reseñas.

GET /api/reviews/{id} - Obtener una reseña por ID.

POST /api/reviews - Crear una nueva reseña.

PUT /api/reviews/{id} - Actualizar una reseña existente.

DELETE /api/reviews/{id} - Eliminar una reseña.

Notificaciones (/api/notifications)
GET /api/notifications - Obtener todas las notificaciones.

GET /api/notifications/{id} - Obtener una notificación por ID.

POST /api/notifications - Crear una nueva notificación.

PUT /api/notifications/{id} - Actualizar una notificación existente.

DELETE /api/notifications/{id} - Eliminar una notificación.

Solicitudes de Contacto (/api/contact-requests)
GET /api/contact-requests - Obtener todas las solicitudes de contacto.

GET /api/contact-requests/{id} - Obtener una solicitud de contacto por ID.

POST /api/contact-requests - Crear una nueva solicitud de contacto.

PUT /api/contact-requests/{id} - Actualizar una solicitud de contacto existente.

DELETE /api/contact-requests/{id} - Eliminar una solicitud de contacto.

Ejecución
Ejecuta la aplicación:

bash
Copy
mvn spring-boot:run
Accede a la API en:

Copy
http://localhost:8080/api
Para acceder a la consola de H2 (solo en desarrollo):

Copy
http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb

Usuario: sa

Contraseña: (deja en blanco)

Contribución
Haz un fork del proyecto.

Crea una rama para tu feature (git checkout -b feature/nueva-funcionalidad).

Realiza tus cambios y haz commit (git commit -m 'Añadir nueva funcionalidad').

Haz push a la rama (git push origin feature/nueva-funcionalidad).

Abre un Pull Request.

Licencia
Este proyecto está bajo la licencia MIT. Consulta el archivo LICENSE para más detalles.

Contacto
Si tienes alguna pregunta o sugerencia, no dudes en contactarme:

Nombre: [Vinko]








   
