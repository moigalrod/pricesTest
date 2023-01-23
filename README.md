## Sring Boot Test

Pasos y configuración para hacer uso del test.

Es un proyecto basado en Spring con Spring Boot, donde se implementado el caso de uso de tarifas requerido en el test, 
además de ha añadido un CRUD básico para el tratamiento de datos en las tablas involucradas (tabla de Precios).

### Características del Proyecto
* Version de java: 11
* Spring Boot: 2.7.0
* Lombok: 1.18.24
* Mapstruct: 1.5.3

### Para iniciar la aplicación:
Asegurate de tener maven instalado.
```bash
mvn clean install
mvn spring-boot:run
```

## Caso de uso: Tarifa de productos
Este caso de uso permite calcular la tarifa a aplicar a un producto en una determinada fecha. Los parámetros de entrada son:

* fecha de aplicación (en formato yyyy-mm-ddTHH:mm:ss)
* identificador de producto (numérico)
* identificador de cadena (numérico)
  
### Cómo usar
Para utilizar este caso de uso, siga los siguientes pasos:

* Inicie la aplicación SpringBoot.
* Enviar una petición HTTP POST con la siguiente estructura:


```bash
    http://localhost:8080/prices/apply
    
    {
      "brandId": 1,
      "applyDate": "2020-06-13T16:00:00",
      "productId": 35455
    }
```

#### La aplicación devuelve los siguientes datos de salida:

* identificador de producto 
* identificador de cadena 
* tarifa a aplicar 
* fechas de inicio y fin de aplicación
* precio final a aplicar


```bash
    {
      "brandId": 1,
      "startDate": "2020-06-15T16:00:00",
      "endDate": "2020-12-31T23:59:59",
      "priceList": 4,
      "productId": 35455,
      "price": 38.95
    }
```

## Test

Se han implementado una serie de test que prueba la casuística del proceso de aplicar una tarifa a un producto.
### Para iniciar la aplicación:
```bash
mvn clean test
```
