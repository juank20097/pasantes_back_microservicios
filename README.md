# ¿Cómo usar el Proyecto?
---
- Descargar el documento back

## **PGADMIN**
- Abrir el archivo docker-compose desde un terminal cmd o linux (Asegurarse de tener instalado docker)
- Editar el archivo docker-compose y en la variable 
  environment:
      - PGADMIN_DEFAULT_EMAIL= "Ingresar su correo"
      - PGADMIN_DEFAULT_PASSWORD= admin
- Abrir Pgadmin desde el navegador (http://localhost:5050/) e ingresar a la interfaz
   donde 
         Usuario: "El correo agregado en el docker compose"
         Password: admin
- Resgistrar un nuevo Server
   Y completar los campos:
      **En General:**
            Nombre: postgres
      **En Conexión:**
            Host name/address: postgres
            Puerto: 5432
            Username: admin
            Password: admin
  - Una vez creado el servidor debemos agregar una base de datos
            Crear Base de datos con el nombre: **devsecops** 
  - Dentro de la base de datos crear un squema con el nombre que se encuentra en la capa entidades del proyecto
---
## **SPRING**
- Abrir el Proyecto en Spring
- En el archivo application.properties del proyecto. 
  *Para la conexión de la base de datos nos aseguramos que el driver de conexión esté bien configurado*
- Una vez bien configurado el archivo application.properties. **Ejectutar el proyecto desde Spring**
---
## **POSTMAN**

### *SIN SEGURIDAD*
- En Postman para poder consumir los servicios se necesita simplemente entrar a
   http://localhost:8081/{servicio} donde {servicio} se reeemplaza por el nombre del servicio
   Por ejemplo:
   El servicio a usarse enviado en la anotación
   @RequestMapping("/empresas") en la capa Controller

### *CON SEGURIDAD*
- Para consumir los servicios desde Postman se necesita abrir el archivo WSO2.postman_collection.json en donde
   estarán las colecciones para consumir los servicios.
- Si se necesita el access token se lo puede obtener desde CMD con el comando
   **curl -k -X POST https://192.168.12.205:9443/oauth2/token -d "grant_type=client_credentials"
   -H"Authorization: Basic Z0tjSDBCS2NVc1JuZTFCRlVhUm1vVFBDR0RFYTpLa0p4UjBMY3g5ajFQWWdmMUd1MFBXdFc2Y1Vh"**
- En Postman:
    En el método Post Obtener Token modificar el Header en la variable
    {{authorization}} por el valor: **Z0tjSDBCS2NVc1JuZTFCRlVhUm1vVFBDR0RFYTpLa0p4UjBMY3g5ajFQWWdmMUd1MFBXdFc2Y1Vh**
- En el archivo WSO2.postman_collection.json para poder consumir los servicios se necesita reemplazar los valores que vienen por defecto:
  *Por Ejemplo:*
          {{server2}}/{{urlEmpleados}} (Valor por Defecto)
  Se lo sustituye por **http:192.168.12.205:8280/iess-ws-devsecops/1.0/{servicio} donde servicio es reemplazado por:
           - departamentos
           - empresas
           - empleados
  Según el servicio a utilizarse
**NOTA: Solo para los métodos obtener por Id la Url cambia a http:192.168.12.205:8280/iess-ws-devsecops/1.0/{servicio}/{id} donde {id} es reemplazado por el id del objeto a buscarse** 
