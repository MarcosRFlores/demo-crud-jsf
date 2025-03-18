# Proyecto CRUD Sencillo con 3 Tablas (Java JSF)

Este proyecto es un ejemplo sencillo de un CRUD (Create, Read, Update, Delete) que maneja tres tablas en una base de datos PostgreSQL. El proyecto está construido con Maven, utiliza JavaServer Faces (JSF) para la interfaz de usuario y Docker para levantar un contenedor con la base de datos.

---

## Estructura del Proyecto

El proyecto consta de las siguientes tablas:

1. **Usuario**: Almacena información de los usuarios.
2. **Rol**: Almacena los roles que pueden tener los usuarios.
3. **Publicación**: Almacena las publicaciones realizadas por los usuarios.

Cada tabla está representada por una clase en el paquete `com.crud.demo_crud.modelo`:

- **Usuario**: Contiene información como `id`, `nombre`, `contrasena` y una relación con la tabla `Rol`.
- **Rol**: Contiene información como `id` y `nombre`.
- **Publicación**: Contiene información como `id`, `titulo`, `contenido` y una relación con la tabla `Usuario`.

---

## Requisitos Previos

Antes de comenzar, asegúrate de tener instaladas las siguientes herramientas:

- **[Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html)**: Versión 1.8 o superior.
- **[Maven](https://maven.apache.org/download.cgi)**: Versión 3.6 o superior.
- **[Docker](https://www.docker.com/get-started)**: Para levantar la base de datos PostgreSQL.
- **[Docker Compose](https://docs.docker.com/compose/install/)**: Opcional, pero recomendado para gestionar el contenedor de la base de datos.

---

## Configuración de la Base de Datos

El proyecto utiliza una base de datos PostgreSQL. Para levantar la base de datos en un contenedor Docker, sigue estos pasos:

### 1. Crear el archivo `docker-compose.yml`

El archivo `docker-compose.yml` define la configuración del contenedor de PostgreSQL:

```yaml
version: '3.8'

services:
  postgres:
    image: postgres:13
    container_name: postgres_container
    environment:
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres
      POSTGRES_DB: demo_crud_db
    ports:
      - "5432:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data

volumes:
  postgres_data:
```

### 2. Levantar el contenedor de la base de datos
Ejecuta el siguiente comando en la raíz del proyecto donde se encuentra el archivo docker-compose.yml:
```bash
docker-compose up -d
```
Esto levantará un contenedor de PostgreSQL con la base de datos demo_crud_db y las credenciales especificadas.

## Configurar la conexión a la base de datos
Asegúrate de que el archivo persistence.xml (o la configuración equivalente) tenga la configuración correcta para conectarse a la base de datos:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence" version="2.1">
    <persistence-unit name="jsf-crud-unit" transaction-type="JTA">
        <jta-data-source>java:/PostgresDS</jta-data-source>
        <class>com.crud.demo_crud.modelo.Rol</class>
        <class>com.crud.demo_crud.modelo.Usuario</class>
        <class>com.crud.demo_crud.modelo.Publicacion</class>


        <properties>
            <property name="hibernate.dialect" value="org.hibernate.dialect.PostgreSQLDialect"/>
            <property name="hibernate.hbm2ddl.auto" value="update"/>
            <property name="hibernate.show_sql" value="true"/>
            <property name="hibernate.format_sql" value="true"/>
        </properties>
    </persistence-unit>
</persistence>
```

## Compilar el proyecto
```bash
mvn clean install
```

# Ejecutar el Proyecto

Una vez que el proyecto se ha compilado correctamente, puedes desplegarlo en un servidor de aplicaciones como **Apache Tomcat** o **WildFly**. Sigue estos pasos:

## 1. Desplegar en un servidor de aplicaciones
- Copia el archivo WAR generado (`demo_crud-1.0-SNAPSHOT.war`) en la carpeta `webapps` de tu servidor de aplicaciones (por ejemplo, Apache Tomcat).
- Inicia el servidor de aplicaciones.

## 2. Acceder a la aplicación
Una vez desplegado, la aplicación estará disponible en la URL del servidor. Por ejemplo, si estás utilizando **Tomcat** en `localhost:8080`, la aplicación estará en:
[Acceder a la aplicación](http://localhost:8080/demo_crud-1.0-SNAPSHOT/)

# Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal.
- **JavaServer Faces (JSF)**: Framework para la interfaz de usuario web.
- **Maven**: Herramienta para la gestión y construcción del proyecto.
- **PostgreSQL**: Sistema de gestión de bases de datos relacionales.
- **Docker**: Plataforma para levantar contenedores de aplicaciones y servicios.

