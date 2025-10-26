# NoteCode API Platform

API desarrollada con **Spring Boot** y **PostgreSQL** para la gestión de snippets de código, usuarios y autenticación mediante JWT.  
Incluye integración con correo electrónico (Gmail App Password) y soporte para entornos locales y en la nube (Supabase).

---

## Requisitos previos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

- **Java 17** o superior
- **Maven** (o usar el wrapper `./mvnw` en Linux/macOS o `mvnw.cmd` en Windows)
- **PostgreSQL** o una base en la nube (por ejemplo, Supabase)
- **Git** (para clonar el repositorio)
- **Cuenta de Gmail** (con una [Contraseña de Aplicación](https://myaccount.google.com/apppasswords))

---

## Configuración del entorno

El proyecto utiliza un archivo `.env` para manejar variables de entorno sensibles.

### Crear el archivo `.env`

Crea un archivo llamado `.env` en la raíz del proyecto con el siguiente contenido:

```env
# Environment Constants
GMAIL_APP_PASSWORD=tu_contraseña_de_aplicacion_gmail
EMAIL_EMITTER=tu_correo_gmail
JWT_SECRET=tu_clave_secreta_para_jwt

# Database Configuration
DB_LOCAL_PASSWORD=tu_contraseña_local_de_postgres
DB_CLOUD_PASSWORD=tu_contraseña_supabase
```

🔒 Nota: Este archivo no debe subirse a GitHub. Por lo tanto, asegúrate de que el archivo .env esté incluido en tu gitignore.

### Variables explicadas

| Variable             | Descripción                                                                |
| -------------------- | -------------------------------------------------------------------------- |
| `GMAIL_APP_PASSWORD` | Contraseña de aplicación generada desde tu cuenta de Gmail.                |
| `EMAIL_EMITTER`      | Dirección de correo que enviará las notificaciones o mensajes del sistema. |
| `JWT_SECRET`         | Clave secreta usada para firmar y validar los tokens JWT.                  |
| `DB_LOCAL_PASSWORD`  | Contraseña del usuario `postgres` para la base de datos local.             |
| `DB_CLOUD_PASSWORD`  | Contraseña del usuario de Supabase o base de datos remota.                 |


## Ejecución del proyecto en Windows

1. Abrir proyecto
    - Abrir `IntelliJ IDEA` → `File` → `Open` y seleccionar la carpeta del proyecto.
    - Esperar a que IDEA importe el proyecto Maven (ver `pom.xml`) y descargue dependencias.

2. Configurar variables de entorno
    - Crear el archivo ` .env ` en la raíz (ver sección "Crear el archivo `.env`" arriba) o configurar variables en la Run Configuration.
    - En IDEA: `Run` → `Edit Configurations...` → `+` → `Spring Boot` (o `Application`) → seleccionar la clase principal con `@SpringBootApplication`.
    - En `Environment variables` añadir:
        - `GMAIL_APP_PASSWORD=...`
        - `EMAIL_EMITTER=...`
        - `JWT_SECRET=...`
        - `DB_LOCAL_PASSWORD=...`
        - `DB_CLOUD_PASSWORD=...`
    - Guardar la configuración.

3. Ejecutar la aplicación
    - Seleccionar la Run Configuration creada y pulsar el botón Run (o Debug).
    - Alternativa por terminal integrado: ejecutar `mvnw.cmd spring-boot:run` (desde la raíz del proyecto).

4. Construir artefacto
    - En terminal: `mvnw.cmd clean package`
    - Ejecutar JAR: `java -jar target/<nombre-del-jar>.jar`


### Acceder a Swagger (UI)
- Una vez la aplicación esté corriendo en local (por defecto `8080`), abrir en el navegador:
    - `http://localhost:8080/swagger-ui.html`
    - o `http://localhost:8080/swagger-ui/index.html`
- Endpoints relacionados con Swagger están permitidos por la configuración de seguridad (ver `WebSecurityConfiguration`).


