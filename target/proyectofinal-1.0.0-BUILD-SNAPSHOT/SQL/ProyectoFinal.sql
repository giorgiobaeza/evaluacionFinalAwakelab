--DROP PARA ELIMINAR LAS TABLAS
DROP TABLE accidente CASCADE CONSTRAINTS;

DROP TABLE administrativo CASCADE CONSTRAINTS;

DROP TABLE asesoria CASCADE CONSTRAINTS;

DROP TABLE asistentes CASCADE CONSTRAINTS;

DROP TABLE capacitacion CASCADE CONSTRAINTS;

DROP TABLE chequeo CASCADE CONSTRAINTS;

DROP TABLE cliente CASCADE CONSTRAINTS;

DROP TABLE detallechequeo CASCADE CONSTRAINTS;

DROP TABLE mejoras CASCADE CONSTRAINTS;

DROP TABLE pagos CASCADE CONSTRAINTS;

DROP TABLE profesional CASCADE CONSTRAINTS;

DROP TABLE usuario CASCADE CONSTRAINTS;

DROP TABLE visita CASCADE CONSTRAINTS;

--DROP PARA ELIMINAR SECUENCIAS
DROP SEQUENCE proyecto.mejoras_idmejoras_seq; 

DROP SEQUENCE proyecto.pagos_idpagos_seq; 

--SE CREA TABLA ACCIDENTE
CREATE TABLE accidente (
    idaccidente            NUMBER(9) NOT NULL,
    accifecha              VARCHAR2(100),
    accihora               VARCHAR2(100),
    accilugar              VARCHAR2(50) NOT NULL,
    acciorigen             VARCHAR2(100),
    acciconsecuencias      VARCHAR2(100),
    cliente_rutcliente   NUMBER(9) NOT NULL
)
LOGGING;

ALTER TABLE accidente ADD CONSTRAINT accidente_pk PRIMARY KEY ( idaccidente );

--SE CREA TABLA ADMINISTRATIVO Y SU PK
CREATE TABLE administrativo (
    run          NUMBER(9) NOT NULL,
    nombres      VARCHAR2(30) NOT NULL,
    apellidos    VARCHAR2(50) NOT NULL,
    email        VARCHAR2(50) NOT NULL,
    area         VARCHAR2(50) NOT NULL,
    usuario_run  NUMBER(9) NOT NULL
)
LOGGING;

ALTER TABLE administrativo ADD CONSTRAINT administrativo_pk PRIMARY KEY ( run );

--SE CREA TABLA ASESORIA Y SU PK
CREATE TABLE asesoria (
    idasesoria          NUMBER(9) NOT NULL,
    fecha               VARCHAR2(100) NOT NULL,
    motivo              VARCHAR2(100) NOT NULL,
    profesional_run   NUMBER(9) NOT NULL
)
LOGGING;

ALTER TABLE asesoria ADD CONSTRAINT asesoria_pk PRIMARY KEY ( idasesoria );

--SE CREA TABLA ASISTENTES Y SU PK
CREATE TABLE asistentes (
    idasistente                  NUMBER(9) NOT NULL,
    asistnombrecompleto          VARCHAR2(100) NOT NULL,
    asistedad                    NUMBER(3) NOT NULL,
    asistcorreo                  VARCHAR2(70),
    asisttelefono                VARCHAR2(20),
    capacitacion_idcapacitacion  NUMBER(9) NOT NULL
)
LOGGING;

ALTER TABLE asistentes ADD CONSTRAINT asistentes_pk PRIMARY KEY ( idasistente );

--SE CREA TABLA CAPACITACION Y SU PK
CREATE TABLE capacitacion (
    idcapacitacion         NUMBER(9) NOT NULL,
    capfecha               VARCHAR2(100),
    caphora                VARCHAR2(100),
    caplugar               VARCHAR2(50) NOT NULL,
    capduracion            NUMBER(3),
    cliente_rutcliente   NUMBER(9) NOT NULL
)
LOGGING;

ALTER TABLE capacitacion ADD CONSTRAINT capacitacion_pk PRIMARY KEY ( idcapacitacion );

--SE CREA TABLA CHEQUEO Y SU PK
CREATE TABLE chequeo (
    idchequeo      NUMBER(9) NOT NULL,
    nombrechequeo  VARCHAR2(50) NOT NULL
)
LOGGING;

ALTER TABLE chequeo ADD CONSTRAINT chequeo_pk PRIMARY KEY ( idchequeo );

--SE CREA TABLA CLIENTE Y SU PK
CREATE TABLE cliente (
    rutcliente        NUMBER(9) NOT NULL,
    clinombres        VARCHAR2(30) NOT NULL,
    cliapellidos      VARCHAR2(50) NOT NULL,
    clitelefono       VARCHAR2(20) NOT NULL,
    cliafp            VARCHAR2(30),
    clisistemasalud   VARCHAR2(20),
    clidireccion      VARCHAR2(100) NOT NULL,
    clicomuna         VARCHAR2(50) NOT NULL,
    cliedad           NUMBER(3) NOT NULL,
    usuario_run         NUMBER(9) NOT NULL
)
LOGGING;

ALTER TABLE cliente ADD CONSTRAINT cliente_pk PRIMARY KEY ( rutcliente  );

--SE CREA TABLA DETALLE DE CHEQUEO Y SU PK
CREATE TABLE detallechequeo (
    cumple_observaciones  VARCHAR2(120) NOT NULL,
    visita_idvisita       NUMBER(9) NOT NULL,
    chequeo_idchequeo     NUMBER(9) NOT NULL
)
LOGGING;

ALTER TABLE detallechequeo ADD CONSTRAINT detallechequeo_pk PRIMARY KEY ( visita_idvisita,
                                                                          chequeo_idchequeo );
--SE CREA TABLA DE MEJORAS Y SU PK
CREATE TABLE mejoras (
    idmejoras            NUMBER(9) NOT NULL,
    actividad            VARCHAR2(100) NOT NULL,
    descripcion          VARCHAR2(100),
    plazo                NUMBER(4) NOT NULL,
    asesoria_idasesoria  NUMBER(9) NOT NULL
)
LOGGING;

ALTER TABLE mejoras ADD CONSTRAINT mejoras_pk PRIMARY KEY ( idmejoras );

--SE CREA TABLA DE PAGOS Y SU PK
CREATE TABLE pagos (
    idpagos                NUMBER(9) NOT NULL,
    fechapago              VARCHAR2(100) NOT NULL,
    monto                  NUMBER NOT NULL,
    mes                    VARCHAR2(20) NOT NULL,
    anio                    NUMBER(4) NOT NULL,
    cliente_rutcliente   NUMBER(9) NOT NULL
)
LOGGING;

ALTER TABLE pagos ADD CONSTRAINT pagos_pk PRIMARY KEY ( idpagos );

--SE CREA TABLA DE PROFESIONALES Y SU PK
CREATE TABLE profesional (
    run                 NUMBER(9) NOT NULL,
    nombres             VARCHAR2(30) NOT NULL,
    apellidos           VARCHAR2(50) NOT NULL,
    telefono            NUMBER(11) NOT NULL,
    tituloprofesional   VARCHAR2(50) NOT NULL,
    proyecto            VARCHAR2(50) NOT NULL,
    usuario_run           NUMBER(9) NOT NULL
)
LOGGING;

ALTER TABLE profesional ADD CONSTRAINT profesional_pk PRIMARY KEY ( run  );

--SE CREA TABLA DE USUARIOS Y SU PK
CREATE TABLE usuario (
    nombre           VARCHAR2(30) NOT NULL,
    apellido         VARCHAR2(50) NOT NULL,
    fechanacimiento  VARCHAR2(100) NOT NULL,
    run              NUMBER(9) NOT NULL,
    tipousuario      VARCHAR2(20)
)
LOGGING;

ALTER TABLE usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( run );

--SE CREA TABLA VISITA Y SU PK
CREATE TABLE visita (
    idvisita               NUMBER(9) NOT NULL,
    visfecha               VARCHAR2(100) NOT NULL,
    vishora                VARCHAR2(100),
    vislugar               VARCHAR2(50) NOT NULL,
    viscomentarios         VARCHAR2(250) NOT NULL,
    cliente_rutcliente   NUMBER(9) NOT NULL
)
LOGGING;

ALTER TABLE visita ADD CONSTRAINT visita_pk PRIMARY KEY ( idvisita );

--SE ALTERA TABLA ACCIDENTE CON SU FK
ALTER TABLE accidente
    ADD CONSTRAINT accidente_cliente_fk FOREIGN KEY ( cliente_rutcliente  )
        REFERENCES cliente  ( rutcliente  );

--SE ALTERA TABLA ADMINISTRATIVO CON SU FK
ALTER TABLE administrativo
    ADD CONSTRAINT administrativo_usuario_fk FOREIGN KEY ( usuario_run )
        REFERENCES usuario ( run )
    NOT DEFERRABLE;

--SE ALTERA TABLA ASESORIA CON SU FK
ALTER TABLE asesoria
    ADD CONSTRAINT asesoria_profesional_fk FOREIGN KEY ( profesional_run  )
        REFERENCES profesional ( run  )
    NOT DEFERRABLE;

--SE ALTERA TABLA ASISTENTE CON SU FK
ALTER TABLE asistentes
    ADD CONSTRAINT asistentes_capacitacion_fk FOREIGN KEY ( capacitacion_idcapacitacion )
        REFERENCES capacitacion ( idcapacitacion )
    NOT DEFERRABLE;

--SE ALTERA TABLA CAPACITACION CON SU FK
ALTER TABLE capacitacion
    ADD CONSTRAINT capacitacion_cliente_fk FOREIGN KEY ( cliente_rutcliente  )
        REFERENCES cliente ( rutcliente  )
    NOT DEFERRABLE;

--SE ALTERA TABLA CLIENTE CON SU FK
ALTER TABLE cliente
    ADD CONSTRAINT cliente_usuario_fk FOREIGN KEY ( usuario_run )
        REFERENCES usuario ( run )
    NOT DEFERRABLE;

--SE ALTERA TABLA DETALLE DE CHEQUEO CON SUS FK
ALTER TABLE detallechequeo
    ADD CONSTRAINT detallechequeo_chequeo_fk FOREIGN KEY ( chequeo_idchequeo )
        REFERENCES chequeo ( idchequeo )
    NOT DEFERRABLE;
ALTER TABLE detallechequeo
    ADD CONSTRAINT detallechequeo_visita_fk FOREIGN KEY ( visita_idvisita )
        REFERENCES visita ( idvisita )
    NOT DEFERRABLE;

--SE ALTERA TABLA MEJORAS CON SU FK
ALTER TABLE mejoras
    ADD CONSTRAINT mejoras_asesoria_fk FOREIGN KEY ( asesoria_idasesoria )
        REFERENCES asesoria ( idasesoria )
    NOT DEFERRABLE;

--SE ALTERA TABLA PAGOS CON SU FK
ALTER TABLE pagos
    ADD CONSTRAINT pagos_cliente_fk FOREIGN KEY ( cliente_rutcliente  )
        REFERENCES cliente ( rutcliente  )
    NOT DEFERRABLE;

--SE ALTERA TABLA PROFESIONAL CON SU FK 
ALTER TABLE profesional
    ADD CONSTRAINT profesional_usuario_fk FOREIGN KEY ( usuario_run )
        REFERENCES usuario ( run )
    NOT DEFERRABLE;

--SE ALTERA TABLA VISITA CON SU FK
ALTER TABLE visita
    ADD CONSTRAINT visita_cliente_fk FOREIGN KEY ( cliente_rutcliente  )
        REFERENCES cliente ( rutcliente  )
    NOT DEFERRABLE;

--SE CREA SECUENCIA PARA TABLA MEJORAS
CREATE SEQUENCE mejoras_idmejoras_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER mejoras_idmejoras_trg BEFORE
    INSERT ON mejoras
    FOR EACH ROW
    WHEN ( new.idmejoras IS NULL )
BEGIN
    :new.idmejoras := mejoras_idmejoras_seq.nextval;
END;
/
--SE CREA SECUENCIA PARA TABLA PAGOS
CREATE SEQUENCE pagos_idpagos_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER pagos_idpagos_trg BEFORE
    INSERT ON pagos
    FOR EACH ROW
    WHEN ( new.idpagos IS NULL )
BEGIN
    :new.idpagos := pagos_idpagos_seq.nextval;
END;
/

--SE CREAN REGISTROS PARA TABLA USUARIOS
INSERT INTO usuario values ('rosita', 'rosales', '04/11/1967', 123456748, 'cliente');
INSERT INTO usuario values ('juanita', 'flores', '23/01/1987', 129467767, 'cliente');
INSERT INTO usuario values ('emilio', 'perez', '12/03/1993', 456874578, 'cliente');
INSERT INTO usuario values ('joaquin', 'moralez', '07/05/1989', 182345673, 'administrativo');
INSERT INTO usuario values ('manuel', 'lopez', '28/01/1959', 178883994, 'administrativo');
INSERT INTO usuario values ('olga', 'medina', '22/10/1992', 165556732, 'administrativo');
INSERT INTO usuario values ('carlos', 'carmona', '11/04/1981', 912345678, 'profesional');
INSERT INTO usuario values ('alfredo', 'perez', '17/08/1979', 159806431, 'profesional');
INSERT INTO usuario values ('felipe', 'flores', '27/02/1987', 912456778, 'profesional');

--SE CREAN REGISTROS PARA TABLA CLIENTES
INSERT INTO cliente values (123456748, 'rosita', 'rosales', 5555555, 'modelo', 'fonasa', 'calle c', 'colina', 40, 123456748);
INSERT INTO cliente values (129467767, 'juanita', 'flores', 6666666, 'modelo', 'fonasa', 'calle 3', 'colina', 42, 129467767);
INSERT INTO cliente values (456874578, 'emilio', 'perez', 5556663, 'modelo', 'fonasa', 'calle a', 'valparaiso', 46, 456874578);

--SE CREAN REGISTROS PARA TABLA CAPACITACION
INSERT INTO capacitacion values(1, '09/02/2021', '13:30', 'colina', 120, 123456748);
INSERT INTO capacitacion values(2, '23/02/2021', '15:30', 'colina', 60, 129467767);
INSERT INTO capacitacion values(3, '15/03/2021', '18:30', 'colina', 80, 456874578);

--SE CREAN REGISTROS PARA TABLA ASISTENTES
INSERT INTO asistentes values(1, 'Juan Miguel Henriquez Vera', 55, 'jhenriquez@gmail.com', 888777999, 1);
INSERT INTO asistentes values(2, 'Irene Bel�n Garc�a Mena', 45, 'Irene.Ga@gmail.com', 888666633, 2);
INSERT INTO asistentes values(3, 'Daniel Mat�as Correa Ruiz', 35, 'danimati@gmail.com', 888999888, 3);

--SE CREAN REGISTROS PARA TABLA VISITA
INSERT INTO visita values(1, 11/02/2021, '08:30', 'colina', 'muy limpio', 123456748);
INSERT INTO visita values(2, 25/02/2021, '09:00', 'colina', 'no tan limpio', 129467767);
INSERT INTO visita values(3, 17/03/2021, '11:30', 'colina', 'limpio', 456874578);

--SE CREAN REGISTROS PARA TABLA CHEQUEO
INSERT INTO chequeo values(1, 'chequeo 1');
INSERT INTO chequeo values(2, 'chequeo 2');
INSERT INTO chequeo values(3, 'chequeo 3');

--SE CREAN REGISTROS PARA TABLA DETALLE CHEQUEO
INSERT INTO detallechequeo values('si, cumple', 1, 1);
INSERT INTO detallechequeo values('si, cumple', 2, 2);
INSERT INTO detallechequeo values('no, cumple', 3, 3);

--SE CREAN REGISTROS PARA TABLA ACCIDENTE
INSERT INTO accidente values (1, '23/01/2020', '13:30', 'colina', 'laboral', 'leve', 123456748);
INSERT INTO accidente values (2, '24/01/2020', '18:23', 'colina', 'laboral', 'leve', 129467767);
INSERT INTO accidente values (3, '28/01/2020', '11:48', 'colina', 'laboral', 'leve', 456874578);
INSERT INTO accidente values (4, '04/02/2020', '12:45', 'colina', 'laboral', 'leve', 456874578);
INSERT INTO accidente values (5, '15/02/2020', '10:44', 'colina', 'laboral', 'leve', 456874578);

--SE CREAN REGISTROS PARA TABLA PAGOS
INSERT INTO pagos values (1, '25/04/2021', 100000, 'agosto', 2019, 123456748);
INSERT INTO pagos values (2, '15/05/2021', 50000, 'mayo', 2020, 129467767);
INSERT INTO pagos values (3, '30/07/2021', 650000, 'agosto', 2020, 456874578);

--SE CREAN REGISTROS PARA TABLA ADMINISTRATIVO
INSERT INTO administrativo values(182345673, 'joaquin esteban', 'morales abarca', 'joacomorales@gmail.com', 'ventas', 182345673 );
INSERT INTO administrativo values(178883994, 'manuel arturo', 'lopez fuentes', 'arturito@gmail.com', 'RR.HH.', 178883994);
INSERT INTO administrativo values(165556732, 'olga marina', 'medina troncoso', 'olguitamarina@gmail.com', 'finanzas',  165556732);

--SE CREAN REGISTROS PARA TABLA PROFESIONAL
INSERT INTO profesional values (912345678, 'Carlos saul', 'carmona soto', 56987361256, 'ing. comercial', 'construccion vespucio', 912345678);
INSERT INTO profesional values (159806431, 'alfredo alex', 'perez palacio', 56933814912, 'prevencionista de riesgo', 'reparacion matta ', 159806431);
INSERT INTO profesional values (912456778, 'felipe florencio', 'flores feliz', 56944982345, 'administracion de empresa', 'construccion grecia', 912456778);

--SE CREAN REGISTROS PARA TABLA ASESORIA 
INSERT INTO asesoria values (000345987, '13/06/2021', 'mala gestion', 912345678);
INSERT INTO asesoria values (000548791, '15/09/2021', 'mala comunicacion', 159806431);
INSERT INTO asesoria values (000451234, '05/04/2021', 'mala desempe�o laboral', 912456778);

--SE CREAN REGISTROS PARA TABLA MEJORAS
insert into mejoras values (000000023, 'reunion para coordinar mejor la gestion', 'se les solicitara asistir a reunion para mejorar los aspectos', 5, 000345987);
insert into mejoras values (000000345, 'charla para mejorar la comunicacion', 'se les informara el dia y la hora para asistir a la charla', 4, 000548791);
insert into mejoras values (000000456, 'nuevos proedimientos de trabajo', 'se les llamara a reunion para informar nuevos procedimientos de trabajo', 12, 000451234);
--SE REALIZA UN COMMIT PARA CONFIRMAR DATOS
commit;