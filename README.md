# Panama92
Panama92 Encuentro de exalumnos de Juan XXIII

Herramientas:
 
Como herramientas de trabajo se tienen las siguientes rutas:
 
Trello: Tablero de control
https://trello.com/b/gzbKAvWd/panama-92
 
Correo electronico del evento:
panama92.juan23@gmail.com
 
DropBox: Repositorio de archivos:
https://www.dropbox.com/home/Panama%2092%20Team%20Folder
 
Versionamiento de codigo:
https://github.com/jfsoruco/Panama92
 
IDE de implementacion para Backend: Eclipse
Java v 8

IDE para Frontend: Brackets

GIT para versionamiento


Framework de Desarrollo.
 
Backend: Proyecto Maven en Java usando Spring, servicios REST.
FrontEnd: Angular
BD: PostgresSQL
 
Diseño de BD:
 
Estructuras registro
Promocion (periodo nombre nro_promocion)
Exalumno (id nombres apellidos email direccion promocion bachiller)
Familiar (id nombres apellidos exalumno parentezco)
Producto (id nombre foto precio_base)
Descuento (id nombre vigencia)
Descuento_producto (id descuento producto porcentaje)
Campaña (id nombre_campaña vigencia tipo_campaña estado)
Campaña_Producto (id campaña descuento_producto)
Campaña_mensaje (id campaña mensaje_tipo fecha_programada mensaje)
Campaña_exalumno (id campaña exalumno estado)
Mensaje_tipo (id nombre asunto mensaje)
Mensaje (id fecha email mensaje)
Reserva (id fecha exalumno campaña cantidad_reserva)
Detalle_reserva (id reserva producto valor)
Estructuras control
Transaccion (id tipo_transaccion fecha exalumno input output inicio fin)
Log_errores (id clase metodo excepcion mensaje fecha)
Visita (id fecha exalumno ip motivo canal)
Estructuras seguridad
Usuario (id username password exalumno status)
Rol (id rol descripcion estado)
Usuario_rol (id id_rol id_usuario status)
 
Servicios REST
 
Por cada entidad de BD se debe tener una clase Entity para tener todos los atributos de la entidad y una clase de Repository en la que se implementen los métodos CRUD.
Sobre esos métodos CRUD, se deben implementar los siguientes servicios REST:
 
·Consultar todos los registros: 
[GET] /rest/exalumnos
·Consultar 1 registro: 
[GET] /rest/exalumnos/{exalumnoId}
·Crear exalumno(id desconocido):
[POST] /rest/exalumnos/
·Crear exalumno(id conocido):
[PUT] /rest/exalumnos/{newExalumnoId}
·Modificar Exalumno: 
[PUT] /rest/exalumnos/{exalumnoId}
·Dar de baja: 
[DELETE] /rest/exalumnos/{exalumnoId}
