# Prices

## Descripción general

En este repositorio se encuentra la solución al ejercicio propuesto.

## Pautas

Para tener el ejercicio disponible para su prueba:
	
	1. Clonar el repositorio.
	
	2. Abrir el proyecto en el IDE preferido. Para el desarrollo se utilizó **IntelliJ IDEA**.

	3. Ejecutar la clase **Main** localizada en src/main/java/com/prices/Main.java.

	El microservicio que expone el endpoint deseado está en marcha. Bastará con hacer una petición al mismo para probarlo. 
	Por ejemplo, usando **Postman** podemos utilizar la siguiente petición.

	```
		http://localhost:8080/prices/getPrices?application_date=2020-06-14T17:00:00&product_id=1&brand_id=1
	```

## Estructura del proyecto

Para el diseño de la arquitectura se ha utilizado el patrón de **arquitectura hexagonal**. En este tipo de arquitectura distinguimos tres partes troncales:

	**Dominio**: Encargada de albergar la lógica de negocio. En nuestro caso, contiene la entidad *Prices*. Esta clase contiene los atributos de un precio y las especificaciones necesarias para que se cree una tabla con los mismos en la base de datos.

	**Aplicación**: Encargada de definir el caso de uso. Implementa un servicio *PricesService* que contiene la llamada al método que nos retorna el precio deseado y una inicialización de la base de datos con los registros del ejemplo, dado que al terminar la ejecución de nuestro microservicio se borra el contenido de la base de datos y debe crearse en cada ejecución.
	Dicha inicialización se hace con la anotación *@PostConstruct* después de crear el servicio. También se define un repositorio *PricesRepository* con la definición de los métodos que se implementarán en la capa de infraestructura.

	**Infraestructura**: Encargada de implementar las conexiones con la base de datos, las peticiones externas y la gestión de excepciones. Separada en dos paquetes: *in* y *out*.
	*in* Contiene el controlador **PricesController**, que define el endpoint que recibe la petición y gestiona la respuesta, incluyendo las posibles excepciones. Se ha definido una excepción específica para cuando no se encuentre ningún precio que cumpla con los parámetros de la petición, llamada **PriceNotFoundException**. Se maneja con la clase **GlobalExceptionHandler**. Para crear objetos de respuesta que cumplan los parámetros establecidos, se utiliza el DTO **PriceResponseDTO**
	*out* contiene la conexión con la base de datos, definida en la clase de repositorio **PricesJPARepository**. Aquí, mediante la anotación @Query, se crea la consulta que buscará el precio deseado, teniendo en cuenta la prioridad. Se apoya en un adaptador **PricesJPAAdapter** que hace de puente entre este repositorio y la interfaz definida en la capa de servicio.
	

## Pruebas

### Código

	Se han realizado 3 tests principales:
	
	**Test Unitario** contenido en la clase **PricesServiceTest**. Prueba que se retorne un precio correcto cuando se hace la llamada al repositorio desde la capa de aplicación.

	**Test de Integración** contenido en la clase **PricesJPAAdapterTest**. Prueba que la llamada directa desde el adaptador al repositorio que conecta con la base de datos funciona correctamente.

	**Test Funcional** contenido en la clase **PricesControllerTest**. Prueba que el controlador devuelve respuestas válidas. Implementa los 5 tests que se incluyen en el ejercicio, uno genérico y otro para la cobertura de la excepción personalizada. Requiere inicializar la base de datos con el método *setUpDatabase*

### Funcionalidad

	Se han hecho con Postman apuntando directamente al endpoint creado. Las peticiones creadas son:

	```
		http://localhost:8080/prices/getPrices?application_date=2020-06-14T10:00:00&product_id=1&brand_id=1
	```

	```
		http://localhost:8080/prices/getPrices?application_date=2020-06-14T16:00:00&product_id=1&brand_id=1
	```

	```
		http://localhost:8080/prices/getPrices?application_date=2020-06-14T21:00:00&product_id=1&brand_id=1
	```

	```
		http://localhost:8080/prices/getPrices?application_date=2020-06-15T10:00:00&product_id=1&brand_id=1
	```

	```
		http://localhost:8080/prices/getPrices?application_date=2020-06-16T21:00:00&product_id=1&brand_id=1
	```

Un ejemplo del resultado de la primera petición es:

![alt text](https://github.com/jgalvaro/Prices/blob/main/assets/postman.png?raw=true)


	