# **INDRA: Prueba de ingreso** 
La aplicación utiliza las tecnologías:

Java 17, gradle, sprint boot, webflux, Resilience4j, mongodb, drools, lombok, circuit breaker, Junit, arquitectura hexagonal.

## **Drools: Aplicación de reglas de negocio**
Si el producto es de la clase Vehiculo, tiene 10% de descuento.

Si el producto es de otras clases, tiene 20% de descuento.

## **Puerto de la aplicación**
Puerto: 8081

## **Servicios**
End point 
1. Obtiene todos los productos:

	Método: GET

	Url: http://localhost:8081/products


2. Crea un nuevo producto:

	Método: POST

	Url: http://localhost:8081/products
	
	Body: Opción1
	```
	{
		"name": "Arroz",
		"price": 5,
		"clase": "Consumo"
	}
	```
	Body: Opción2
	```
	{
		"name": "Moto Yamaha",
		"price": 12000,
		"clase": "Vehiculo"
	}
	```

3. Obtiene un producto por el id:

	Método: GET

	Url: http://localhost:8081/products/id


4. Elimina un producto por el id:

	Método: DELETE

	Url: http://localhost:8081/products/id


5. Modifica un producto por el id:

	Método: PUT

	Url: http://localhost:8081/products/id
	
	Body
	```
	{
		"name": "Arroz",
		"price": 4,
		"clase": "Consumo"
	}
	```
## **Base de datos mongodb**
Usuario: fevece

Pasword: fevece

BD: bdprueba

Puerto: 27017

URI: mongodb://fevece:fevece@localhost:27017/bdprueba

Collecion: products

---------------------------------
Para levantar la BD:
Con MongoDB Compass, con el usuario admin(por defecto), dar clic en "Open Mongodb Shell" y ejecutar

// Conéctate a la base de datos 'bdprueba'
use bdprueba

// Crea el usuario 'fevece' con la contraseña 'fevece'
db.createUser({
  user: "fevece",
  pwd: "fevece",
  roles: [
    { role: "readWrite", db: "bdprueba" } // Otorga permisos de lectura y escritura en la base de datos 'bdprueba'
  ]
})

// Verifica que el usuario ha sido creado
db.getUsers()
-------------------------------------

## **Circuit Breaker**
Verificación de Circuit Breaker:

- Mostrar estado cerrado:

	URL: http://localhost:8081/actuator/circuitbreakers

- Mostrar mensaje del servicio de circuit breaker:

  Si el internet está habilitado, se mostrará el mensaje "Carga correcta de Atlas MongoDB".

  URL: http://localhost:8081/serviciosexternos/processAtlasMongoDB
  
  
  Si se desconecta el internet, el estado del circuitbreaker, pasa a abierto y muestra el mensaje:
  
  Lo sentimos, actualmente estamos experimentando dificultades técnicas para procesar pagos en línea. Por favor, inténtalo de nuevo más tarde. Agradecemos tu paciencia y comprensión.

  
