create table sr.promocion (
	promocionYear varchar not null,
	nombrePromocion varchar,
	cantidadBachilleres int,
	status varchar,
	createdBy int,
	createdDate timestamp,
	createdTranId int,
	updatedBy int,
	updatedDate timestamp,
	updatedTranId int,
	constraint promocion_pk primary key (promocionYear)
);

create table sr.exalumno (
	exalumnoId int not null,
	nombresExalumno varchar not null,
	apellidosExalumno varchar not null,
	eMail varchar,
	promocionYear varchar,
	paisResidencia varchar,
	ciudadResidencia varchar,
	direccionResidencia varchar,
	bachillerEnColegio varchar,
	status varchar,
	createdBy int,
	createdDate timestamp,
	createdTranId int,
	updatedBy int,
	updatedDate timestamp,
	updatedTranId int,
	constraint student_pk primary key (exalumnoId),
	foreign key (promocionYear) references sr.promocion(promocionYear)
);

create sequence sr.seqExalumno 
	start with 100
	increment by 1
	maxvalue 99999999
	minvalue 1;

--  Estructuras de Control -->
create table sr.transaccion(
	transaccionId int not null,
	tipoTransaccion varchar,
	fechaHora timestamp,
	exalumnoId int,
	datosEntrada varchar,
	datosSalida varchar,
	fechaHoraInicio timestamp,
	fechaHoraFin timestamp,
	status varchar,
	createdBy int,
	createdDate timestamp,
	createdTranId int,
	updatedBy int,
	updatedDate timestamp,
	updatedTranId int,
	constraint transaccion_pk primary key (transaccionId)
);

create sequence sr.seqTransaccion
	start with 100
	increment by 1
	maxvalue 99999999
	minvalue 1;

create table sr.logErrores(
	logId int not null,
	transaccionId int,
	exalumnoId int,
	tipoTransaccion varchar,
	fechaHora timestamp,
	errorCode varchar,
	errorMessage varchar,
	constraint logErrores_pk primary key (logId)
);

create sequence sr.seqLogErrores
	start with 100
	increment by 1
	maxvalue 99999999
	minvalue 1;

create table sr.visita(
	visitaId int not null,
	transaccionId int,
	exalumnoId int,
	tipoTransaccion varchar,
	fechaHora timestamp,
	status varchar,
	createdBy int,
	createdDate timestamp,
	createdTranId int,
	updatedBy int,
	updatedDate timestamp,
	updatedTranId int,
	constraint visita_pk primary key (visitaId)
);

create sequence sr.seqVisita
	start with 100
	increment by 1
	maxvalue 99999999
	minvalue 1;

--  Estructuras de Seguridad  -->
create table sr.usuario (
	usuarioId int not null,
	username varchar,
	password varchar,
	status varchar,
	createdBy int,
	createdDate timestamp,
	createdTranId int,
	updatedBy int,
	updatedDate timestamp,
	updatedTranId int,
	constraint usuario_pk primary key (usuarioId)
);

create sequence sr.seqUsuario
	start with 100
	increment by 1
	maxvalue 99999999
	minvalue 1;

create table sr.rol (
	rolId int not null,
	nombreRol varchar,
	descripcionRol varchar,
	status varchar,
	createdBy int,
	createdDate timestamp,
	createdTranId int,
	updatedBy int,
	updatedDate timestamp,
	updatedTranId int,
	constraint rol_pk primary key (rolId)
);

create sequence sr.seqRol
	start with 100
	increment by 1
	maxvalue 99999999
	minvalue 1;

create table sr.rolUsuario (
	rolUsuarioId int not null,
	rolId int,
	usuarioId int,
	status varchar,
	createdBy int,
	createdDate timestamp,
	createdTranId int,
	updatedBy int,
	updatedDate timestamp,
	updatedTranId int,
	constraint rolUsuario_pk primary key (usuarioId)
);

create sequence sr.seqRolUsuario
	start with 100
	increment by 1
	maxvalue 99999999
	minvalue 1;

create sequence sr.seq_Transaction	
	start with 100
	increment by 1
	maxvalue 99999999
	minvalue 1;
	
-- data
-- Promocion
insert into sr.promocion (promocionYear, nombrePromocion, cantidadBachilleres, status, createdBy, createdDate, createdTranId)
values('1992', 'Panama', 31, 'A', 1, '2016-05-18 10:40:33.430', 1);

-- Exalumno
insert into sr.exalumno(exalumnoId, nombresExalumno, apellidosExalumno, email, promocionYear, ciudadResidencia, paisResidencia, status, createdBy, createdDate, createdTranId)
values (1, 'Juan Fernando', 'Soruco Velasquez', 'jfsoruco@gmail.com', '1992', 'Cochabamba', 'Bolivia', 'A', 1, '2016-05-18 10:40:33.430', 1);