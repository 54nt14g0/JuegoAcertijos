
-- 1 solo juego

INSERT INTO juego (id, nombre)
VALUES (1, 'juego');
-- 2 usuarios normales y 1 usuario admin


INSERT INTO usuario (id, email, fecha_nacimiento, is_admin, nombre, pass, progreso, juego_id)
VALUES (1,'prueba@gmail.com', '2004-08-15',
        FALSE, 'Juan', 'lol', '', 1);

INSERT INTO usuario (id, email, fecha_nacimiento, is_admin, nombre, pass, progreso, juego_id)
VALUES (2,'prueba2@gmail.com', '2004-08-16',
        FALSE, 'Maria', '123', '', 1);

INSERT INTO usuario (id, email, fecha_nacimiento, is_admin, nombre, pass, progreso, juego_id)
VALUES (3,'prueba3@gmail.com', '2004-08-17',
        TRUE, 'Jesus', 'abc', '', 1);


-- 2 niveles

INSERT INTO nivel (id, cantidad_acertijos, descripcion, dificultad,minima_calificacion_ganar, nombre, requisitos,juego_id)
VALUES (1, 2, 'NIVEL 1 con 2 acertijos de SM y MR',
        'Normal', 0.5, 'NIVEL 1', '', 1);

INSERT INTO nivel (id, cantidad_acertijos, descripcion, dificultad,minima_calificacion_ganar, nombre, requisitos,juego_id)
VALUES (2, 1, 'NIVEL 2 con 1 acertijo escrito',
        'Normal', 1, 'NIVEL 2', '', 1);


-- 3 acerijos en total ========================0

-- el nivel 1 tiene 2 acertijos uno de seleccion múltiple y otro de multiple respuesta
INSERT INTO acertijo (id, cantidad_correctas , cantidad_respuestas, descripcion, nombre, peso, tipo_acertijo, nivel_id)
VALUES (1, 1, 4, '¿Cual es la capital de Colombia?',
        'Acertijo1', 0.5, 'sm', 1);

INSERT INTO acertijo (id, cantidad_correctas , cantidad_respuestas, descripcion, nombre, peso, tipo_acertijo, nivel_id)
VALUES (2, 2, 4, '¿Cuales de estas operaciones son correctas?',
        'Acertijo2', 0.5, 'mr', 1);


-- EL nivel 2 tiene 1 acertijo de escrita

INSERT INTO acertijo (id, cantidad_correctas , cantidad_respuestas, descripcion, nombre, peso, tipo_acertijo, nivel_id)
VALUES (3, 1, 1, '¿Como se llama el astro que nos ilumina y sale en las mañanas?',
        'Acertijo3', 1, 'e', 2);

-- RESPUESTAS ===============

-- el acertijo 1 de SELECCION MULTIPLE debe tener 4 respuestas y 1 que es la correcta

INSERT INTO respuesta (id, descripcion, nombre, respuesta_correcta, acertijo_id)
VALUES (1, 'panama', 'A', 'false', 1);

INSERT INTO respuesta (id, descripcion, nombre, respuesta_correcta, acertijo_id)
VALUES (2, 'bogota', 'B', 'true', 1);

INSERT INTO respuesta (id, descripcion, nombre, respuesta_correcta, acertijo_id)
VALUES (3, 'armenia', 'C', 'false', 1);

INSERT INTO respuesta (id, descripcion, nombre, respuesta_correcta, acertijo_id)
VALUES (4, 'berlín', 'D', 'false', 1);


-- el acertijo 2 de multiple respuesta debe tener 4 respuestas y 2 que son correctas
INSERT INTO respuesta (id, descripcion, nombre, respuesta_correcta, acertijo_id)
VALUES (5, '2+2=4', 'A', 'true', 2);
INSERT INTO respuesta (id, descripcion, nombre, respuesta_correcta, acertijo_id)
VALUES (6, '1+1 = 80', 'B', 'false', 2);
INSERT INTO respuesta (id, descripcion, nombre, respuesta_correcta, acertijo_id)
VALUES (7, '3+3=6', 'C', 'true', 2);
INSERT INTO respuesta (id, descripcion, nombre, respuesta_correcta, acertijo_id)
VALUES (8, '4*1 = 90', 'D', 'false', 2);

-- el acertijo 3 de escrita debe tener una sola respuesta escrita y ya


INSERT INTO respuesta (id, descripcion, nombre, respuesta_correcta, acertijo_id)
VALUES (9, '', 'escriba su respuesta', 'sol', 3);
