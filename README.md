# BancoMicroservicioRabbit
Dar de alta un pedido y comunicarse con los otros microservicios por medio de colas


son 4 microservicios que son los siguientes

### Pre-requisitos 📋
Tener java jdk 8
tener instalado rabbit la ultima version
tener instalado maven y git
Clonar de la rama jahernandez el proyecto BancoMicroservicioRabbit

Importarse los siguientes modulos y ejecutarlos en el siguiente orden

## MSBanco_Cliente : 
Este microservicio tiene la interface hacia el cliente y se compone de una vista para mandar la peticón rest.
Estar posicionado en esta ruta : BancoMicroservicioRabbit\MSBanco_Cliente
Ejecutar los siguientes comandos :
  ```
  mvn clean package
  mvn spring-boot:run
  ``` 
  
  El puerto que levantará sera por el siguiente:
  
   ```
   puerto 9090
   
   ```
  
## MSUsuario : 
Este microservicio tiene un controller donde llega la solicitud, se guarda en base de datos y porteriormente se manda un evento con los datos de la solicitud hacia el modulo de credito.

Estar posicionado en esta ruta : BancoMicroservicioRabbit\MSUsuario
Ejecutar los siguientes comandos : 
  ```
  mvn clean package
  mvn spring-boot:run
  ``` 

  El puerto que levantará sera por el siguiente:
  
   ```
   context-path = /beto_banco_usuario
   puerto 8081
   ```
## MSCredito : 
Tiene como funcionalidad escuchar lo que esta en la cola que viene del modulo de MSUsuario y aqui guardamos el pedido solo de credito y debito.

Estar posicionado en esta ruta : BancoMicroservicioRabbit\MSCredito

Ejecutar los siguientes comandos :
  ```
  mvn clean package
  mvn spring-boot:run
  ``` 

  El puerto que levantará sera por el siguiente:
  
   ```
   puerto 8082
   ```

## MsBancoNotificacion 
Este microservicio se va encarga de mandarle el mensaje al cliente en que estatus fue procesado su cuenta o en su caso de informarle 
si no se pudo.

Estar posicionado en esta ruta : BancoMicroservicioRabbit\MsBancoNotificacion

Ejecutar los siguientes comandos :
 ```
  mvn clean package
  mvn spring-boot:run
  ``` 

  El puerto que levantará sera por el siguiente:
  
   ```
   
   puerto 8083
   ```
   
  ## Proceso de Ejecucion 
  
  
