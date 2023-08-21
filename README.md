# pasantes_back_microservicios

1. Descargar el documento back
2. Abrir el docker-compose desde un terminal cmd o linux (Asegurarse de tener instalado docker)
3. Editar el archivo docker-compose y en la variable 
  environment:
      - PGADMIN_DEFAULT_EMAIL= "Ingresar su correo"
      - PGADMIN_DEFAULT_PASSWORD= admin
4. Abrir Pgadmin desde el navegador (http://localhost:5050/) e ingresar a la interfaz
   donde 
         Usuario: "El correo agregado en el docker compose"
         Password: admin
5. Crear un squema en Pgadmin con el nombre que se encuentra en la capa entidades del proyecto
6. Ejectutar el proyecto desde Spring
7. En Postman para poder consumir los servicios (sin seguridad) se necesita simplemente entrar a
   http://localhost:8081/{servicio} donde {servicio} se reeemplaza por el nombre del servicio
   Por ejemplo:
   El servicio a usarse enviado en la anotación
   @RequestMapping("/empresas") en la capa Controller
8. Para consumir los servicios desde Postman (con seguridad) se necesita abrir el archivo WSO2.postman_collection.json en donde
   estarán las colecciones para consumir los servicios.
9. Si se necesita el access token se lo puede obtener desde
   curl -k -X POST https://localhost:9443/oauth2/token -d "grant_type=client_credentials"
   -H"Authorization: Basic Z0tjSDBCS2NVc1JuZTFCRlVhUm1vVFBDR0RFYTpLa0p4UjBMY3g5ajFQWWdmMUd1MFBXdFc2Y1Vh"
10. En Postman:
    En el método Post Obtener Token modificar el Header en la variable
    {{authorization}} con el valor: Z0tjSDBCS2NVc1JuZTFCRlVhUm1vVFBDR0RFYTpLa0p4UjBMY3g5ajFQWWdmMUd1MFBXdFc2Y1Vh
