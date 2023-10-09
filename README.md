# Bank Inc Portal Web

Este es el repositorio Backend del proyecto "Bank Inc Portal Web", una plataforma web desarrollada con Java y Spring que permite la administración de tarjetas y transacciones.

## Tabla de Contenidos

- [Tecnologías Utilizadas](#tecnologías)
- [Características](#características)
- [Requisitos](#requisitos)
- [Instalación](#instalación)
- [Uso](#uso)

## Tecnologías Utilizadas

- Java
- Spring Framework (Spring Boot, Spring MVC, Spring Data JPA)
- Hibernate
- MySQL (Base de Datos)


## Características

- Mostrar todos los usarios, tarjetas y transacciones.
- Administración de tarjetas de crédito y débito.
- Permite recarga de tarjetas.
- Consulta de transacciones.
- Anular transacciones exitosas y devolver el saldo a la tarjeta.
- Eliminar transacciones por ID.
- Manejo de excepciones personalizadas y genéricas.

## Requisitos

Antes de comenzar, asegúrate de tener lo siguiente instalado en tu sistema:
- **Java**: Java JDK 17
- **MySQL**: MySQL Server instalado y configurado en tu sistema
- **Maven**: Maven instalado en tu sistema

<br> <!-- Este es un salto de línea -->

### Configuración de la Base de Datos

Antes de ejecutar la API, debes configurar la base de datos MySQL. Sigue estos pasos:
1. Crea la base de datos MySQL para la API `bankinc_db`.
```bash
CREATE DATABASE bankinc_db;
```
2. Abre el archivo de configuración de la base de datos (`application.properties`) y configura las credenciales de acceso a la base de datos:

```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/bankinc_db
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
```
<br> <!-- Este es un salto de línea -->

## Instalación

1. Clona este repositorio en tu máquina local:
```bash
git clone https://github.com/Vex-Alexis/Backend-BankInc.git
```

2. Navega al directorio del proyecto:
```bash
cd Backend-BankInc
```

3. Compila el proyecto y descarga las dependencias utilizando Maven:
```bash
mvn clean install
```

4. Ejecuta la aplicación o usa tu IDE favorito
```bash
mvn spring-boot:run
```
La API de Bank Inc Portal Web debería estar en funcionamiento en http://localhost:8080

<br> <!-- Este es un salto de línea -->

## Uso

A continuación, se proporcionan ejemplos de cómo utilizar la API de Bank Inc para realizar operaciones comunes.

<br> <!-- Este es un salto de línea -->

### Mostrar todos los registros de cada tabla

- GET: http://localhost:8080/v1/bankinc/user
- GET: http://localhost:8080/v1/bankinc/card
- GET: http://localhost:8080/v1/bankinc/transaction

<br> <!-- Este es un salto de línea -->

### Crear una nueva tarjeta

Para crear una nueva tarjeta, envía una solicitud POST a la siguiente URL:

- POST: http://localhost:8080/v1/bankinc/card

Cuerpo de la solicutd

```json
{
    "productId": "515151",
    "cardHolderName": "Alexis Chavarria",
    "cardType": "CREDITO",
    "user": {
        "id": 1
    }
}
```
La API responderá con un status 201 Created y los detalles de la tarjeta recién creada.

<br> <!-- Este es un salto de línea -->

### Recargar tarjeta

Para recargar una nueva tarjeta, envía una solicitud PUT a la siguiente URL:

- PUT: http://localhost:8080/v1/bankinc/card/recharge/1/5000

Reemplaza el "1" con el ID de la tarjeta que deseas recargar y "5000" con el monto que deseas recargar.

<br> <!-- Este es un salto de línea -->

### Anular Transacción

Para anular una transacción, envía una solicitud POST a la siguiente URL:

- POST: http://localhost:8080/v1/bankinc/transaction/annular/1

Reemplaza el "1" con el ID de la transacción que deseas anular. Ten en cuenta que solo puedes anular transacciones EXITOSAS realizadas en las últimas 24 horas.

<br> <!-- Este es un salto de línea -->

### Eliminar Transacción

Para eliminar una transacción, envía una solicitud DELETE a la siguiente URL:

- DELETE: http://localhost:8080/v1/bankinc/transaction/1

Reemplaza el "1" con el ID de la transacción que deseas eliminar.

<br> <!-- Este es un salto de línea -->

---

### **FIN**
El Frontend esta en construcción :(






















