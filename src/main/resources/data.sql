-- Insertar en categorias
INSERT INTO `biblioteca`.`categorias` (`nombre`, `descripcion`) VALUES ('Romance', 'Libros de amor', 'ficción','Fantasía Romance','Terror','Historia','Biografía','Autobiografía'
);

-- Insertar en autores
INSERT INTO `biblioteca`.`autores` (`apellido`, `biografia`, `fecha_nacimiento`, `nacionalidad`, `nombre`) VALUES ('Fernández', 'renacimiento', '1605-01-16', 'España', 'Manuel');
INSERT INTO `biblioteca`.`autores` (`apellido`, `biografia`, `fecha_nacimiento`, `nacionalidad`, `nombre`) VALUES ('Kathleen Rowling', 'Autora de la serie de libros de Harry Potter una de las series de libros más vendidas de la historia', '1965-07-31','Britámica', 'Joanne');
INSERT INTO `biblioteca`.`autores` (`apellido`, `biografia`, `fecha_nacimiento`, `nacionalidad`, `nombre`) VALUES ('Ronald Reuel Tolkien', 'Autor de la serie de libros de El Señor de los Anillos y El Hobbit, considerado uno de los padres de la fantasía moderna', '1892-01-03', 'Británica', 'John');
INSERT INTO `biblioteca`.`autores` (`apellido`, `biografia`, `fecha_nacimiento`, `nacionalidad`, `nombre`) VALUES ('Raymond Richard Martin', 'Autor de la serie de libros de Canción de hielo y fuego, que fue adaptada a la serie de televisión Juego de tronos', '1948-09-20', 'Estadounidense', 'George');
INSERT INTO `biblioteca`.`autores` (`apellido`, `biografia`, `fecha_nacimiento`, `nacionalidad`, `nombre`) VALUES ('Austen', 'Autora de novelas como Orgullo y prejuicio y Sentido y sensibilidad, considerada una de las escritoras más importantes de la literatura inglesa', '1775-12-16', 'Británica', 'Jane');
INSERT INTO `biblioteca`,`autores` (`apellido`, `biografia`, `fecha_nacimiento`, `nacionalidad`, `nombre`) VALUES ('Rowling', 'Autora de la serie de libros de Harry Potter', '1965-07-31', 'Reino Unido', 'J.K.');
INSERT INTO `biblioteca`,`autores` (`apellido`, `biografia`, `fecha_nacimiento`, `nacionalidad`, `nombre`) VALUES ('Martin', 'Autor de la serie de libros de Canción de hielo y fuego', '1948-09-20', 'Estados Unidos', 'George R.R.');
INSERT INTO `biblioteca`,`autores` (`apellido`, `biografia`, `fecha_nacimiento`, `nacionalidad`, `nombre`) VALUES ('King', 'Autor de novelas de terror y suspense', '1947-09-21', 'Estados Unidos', 'Stephen');*
INSERT INTO `biblioteca`,`autores` (`apellido`, `biografia`, `fecha_nacimiento`, `nacionalidad`, `nombre`) VALUES ('Brown', 'Autor de novelas de suspense y misterio', '1964-06-29', 'Estados Unidos', 'Dan');*
INSERT INTO `biblioteca`,`autores` (`apellido`, `biografia`, `fecha_nacimiento`, `nacionalidad`, `nombre`) VALUES ('Tolkien', 'Autor de la serie de libros de El Señor de los Anillos', '1892-01-03', 'Reino Unido', 'J.R.R.');


-- Insertar en libros
INSERT INTO biblioteca.libros (titulo, numero_paginas, disponible, id_autor, id_categoria) VALUES ('Cien Años de Soledad', 417, true, 1, 1);
INSERT INTO biblioteca.libros (titulo, numero_paginas, disponible, id_autor, id_categoria) VALUES ('El Señor de los Anillos', 1178, true, 2, 2);
INSERT INTO biblioteca.libros (titulo, numero_paginas, disponible, id_autor, id_categoria) VALUES ('Harry Potter y la Piedra Filosofal', 320, true, 3, 1);
INSERT INTO biblioteca.libros (titulo, numero_paginas, disponible, id_autor, id_categoria) VALUES ('Orgullo y Prejuicio', 416, true, 4, 3);
INSERT INTO biblioteca.libros (titulo, numero_paginas, disponible, id_autor, id_categoria) VALUES ('El Alquimista', 160, true, 5, 4);
INSERT INTO biblioteca.libros (titulo, numero_paginas, disponible, id_autor, id_categoria) VALUES ('La Sombra del Viento', 565, true, 6, 5);
INSERT INTO biblioteca.libros (titulo, numero_paginas, disponible, id_autor, id_categoria) VALUES ('El Código Da Vinci', 454, true, 7, 6);
INSERT INTO biblioteca.libros (titulo, numero_paginas, disponible, id_autor, id_categoria) VALUES ('La Casa de los Espíritus', 560, true, 8, 7);
INSERT INTO biblioteca.libros (titulo, numero_paginas, disponible, id_autor, id_categoria) VALUES ('El Amor en los Tiempos del Cólera', 400, true, 9, 8);
INSERT INTO biblioteca.libros (titulo, numero_paginas, disponible, id_autor, id_categoria) VALUES ('La Odisea', 416, true, 10, 9);
INSERT INTO biblioteca.libros (titulo, numero_paginas, disponible, id_autor, id_categoria) VALUES ('Don Quijote de la Mancha', 864, true, 11, 10);

-- Insertar en socio
INSERT INTO `biblioteca`.`socios` (`direccion`, `email`, `nombre`, `telefono`) VALUES ('Calle granada nº9', 'Inventado@gmail.com', 'Curri', '698175344');
INSERT INTO `biblioteca`.`socios` (`direccion`, `email`, `nombre`, `telefono`) VALUES ('Calle Madrid nº15', 'juanperez@gmail.com', 'Juan Pérez', '612345678');
INSERT INTO `biblioteca`.`socios` (`direccion`, `email`, `nombre`, `telefono`) VALUES ('Avenida Libertad nº32', 'mariarodriguez@gmail.com', 'María Rodríguez', '678901234');
INSERT INTO `biblioteca`.`socios` (`direccion`, `email`, `nombre`, `telefono`) VALUES ('Calle Barcelona nº4', 'carlosgomez@gmail.com', 'Carlos Gómez', '645678901');
INSERT INTO `biblioteca`.`socios` (`direccion`, `email`, `nombre`, `telefono`) VALUES ('Paseo Marítimo nº21', 'luciamartinez@gmail.com', 'Lucía Martínez', '623456789');
INSERT INTO `biblioteca`.`socios` (`direccion`, `email`, `nombre`, `telefono`) VALUES ('Calle Valencia nº11', 'antoniohernandez@gmail.com', 'Antonio Hernández', '691234567');
INSERT INTO `biblioteca`.`socios` (`direccion`, `email`, `nombre`, `telefono`) VALUES ('Avenida Andalucía nº25', 'anamariafernandez@gmail.com', 'Ana María Fernández', '612098765');
INSERT INTO `biblioteca`.`socios` (`direccion`, `email`, `nombre`, `telefono`) VALUES ('Calle Sevilla nº6', 'manuelgarcia@gmail.com', 'Manuel García', '645123456');
-- Insertar en prestamo
INSERT INTO `biblioteca`.`prestamo` (`fecha_devolucion`, `fecha_entrega`, `libro_id`, `socio_id`) VALUES ('2025-06-18', '2025-06-17', '1', '1');
INSERT INTO `biblioteca`.`prestamo` (`fecha_devolucion`, `fecha_entrega`, `libro_id`, `socio_id`) VALUES ('2025-06-25', '2025-06-20', '2', '3');*
INSERT INTO `biblioteca`.`prestamo` (`fecha_devolucion`, `fecha_entrega`, `libro_id`, `socio_id`) VALUES ('2025-07-01', '2025-06-25', '5', '2');*
INSERT INTO `biblioteca`.`prestamo` (`fecha_devolucion`, `fecha_entrega`, `libro_id`, `socio_id`) VALUES ('2025-06-22', '2025-06-17', '8', '1');*
INSERT INTO `biblioteca`.`prestamo` (`fecha_devolucion`, `fecha_entrega`, `libro_id`, `socio_id`) VALUES ('2025-07-08', '2025-07-01', '10', '4');*
INSERT INTO `biblioteca`.`prestamo` (`fecha_devolucion`, `fecha_entrega`, `libro_id`, `socio_id`) VALUES ('2025-06-29', '2025-06-24', '3', '5');*
