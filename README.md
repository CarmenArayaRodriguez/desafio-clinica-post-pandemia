# Desafío Clínica Post Pandemia

Este proyecto desarrolla un sistema para gestionar pacientes hospitalizados tras la pandemia, utilizando Spring Boot. El sistema permite operaciones CRUD sobre los datos de los pacientes.

## Características
- Visualización de un listado de pacientes hospitalizados.
- Operaciones CRUD completas: Crear, leer, actualizar y eliminar pacientes.
- Generación de archivo WAR para despliegue en servidores.

## Documentación
Encuentra la evidencia de la generación del archivo WAR en la carpeta `docs`.

## Generación del archivo WAR
Para generar tu propio archivo WAR, sigue los pasos detallados en la sección de compilación de este documento. Esto te permitirá crear una versión desplegable del sistema.

### Compilación
Utiliza Maven para compilar el proyecto y generar el archivo WAR:

```
mvn clean install
```
El archivo WAR generado se ubicará en la carpeta `target` del proyecto.