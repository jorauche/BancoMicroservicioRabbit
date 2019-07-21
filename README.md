# BancoMicroservicioRabbit
Dar de alta un pedido y comunicarse con los otros microservicios por medio de colas


son 4 microservicios que son los siguientes

### Pre-requisitos 📋
Tener java jdk 8
tener instalado rabbit la ultima version
tener instalado maven y git

Importarse los siguiente servicios el siguiente orden

MSBanco_Cliente : Este microservicio tiene la interface hacia el cliente y se compone de una vista para mandar la peticón rest.
Estar posicionado en esta ruta : BancoMicroservicioRabbit\MSBanco_Cliente
Ejecutar los siguientes comandos :
  ```
  mvn clean package
  mvn spring-boot:run
  ``` 
_MSUsuario : este microservicio tiene un controller donde llega la solicitud, se guarda en base de datos y porteriormente se manda un evento con los datos de la solicitud hacia el modulo de credito._

Estar posicionado en esta ruta : BancoMicroservicioRabbit\MSUsuario
Ejecutar los siguientes comandos : 
  ```
  mvn clean package
  mvn spring-boot:run
  ``` 

MSCredito : Tiene como funcionalidad escuchar lo que esta en la cola que viene del modulo de MSUsuario y aqui guardamos el pedido solo de credito y debito.

Estar posicionado en esta ruta : BancoMicroservicioRabbit\MSCredito
Ejecutar los siguientes comandos :
  mvn clean package
  mvn spring-boot:run

MsBancoNotificacion 

Estar posicionado en esta ruta : BancoMicroservicioRabbit\MsBancoNotificacion
Ejecutar los siguientes comandos :
  ```
  mvn clean package
  mvn spring-boot:run
  ``` 
