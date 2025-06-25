-- Insertar en categorias
INSERT INTO `biblioteca`.`categorias` (`nombre`, `descripcion`) VALUES ('Romance', 'Libros de amor', 'ficción','Fantasía Romance','Terror','Historia','Biografía','Autobiografía'
);

-- Insertar en autores
INSERT INTO `biblioteca`.`autores` (`apellido`, `biografia`, `fecha_nacimiento`, `nacionalidad`, `nombre`) VALUES ('Fernández', 'renacimiento', '1605-01-16', 'España', 'Manuel');
INSERT INTO `biblioteca`.`autores` (`apellido`, `biografia`, `fecha_nacimiento`, `nacionalidad`, `nombre`) VALUES ('Kathleen Rowling', 'Autora de la serie de libros de Harry Potter una de las series de libros más vendidas de la historia', '1965-07-31','Britámica', 'Joanne');
INSERT INTO `biblioteca`.`autores` (`apellido`, `biografia`, `fecha_nacimiento`, `nacionalidad`, `nombre`) VALUES ('Ronald Reuel Tolkien', 'Autor de la serie de libros de El Señor de los Anillos y El Hobbit, considerado uno de los padres de la fantasía moderna', '1892-01-03', 'Británica', 'John');
INSERT INTO `biblioteca`.`autores` (`apellido`, `biografia`, `fecha_nacimiento`, `nacionalidad`, `nombre`) VALUES ('Raymond Richard Martin', 'Autor de la serie de libros de Canción de hielo y fuego, que fue adaptada a la serie de televisión Juego de tronos', '1948-09-20', 'Estadounidense', 'George');
INSERT INTO `biblioteca`.`autores` (`apellido`, `biografia`, `fecha_nacimiento`, `nacionalidad`, `nombre`) VALUES ('Austen', 'Autora de novelas como Orgullo y prejuicio y Sentido y sensibilidad, considerada una de las escritoras más importantes de la literatura inglesa', '1775-12-16', 'Británica', 'Jane');



-- Insertar en libros
INSERT INTO biblioteca.libros (titulo, numero_paginas, disponible, id_autor, id_categoria) VALUES ('Cien Años de Soledad', 417, true, 1, 1);

-- Insertar en socio
INSERT INTO `biblioteca`.`socios` (`direccion`, `email`, `nombre`, `telefono`) VALUES ('Calle granada nº9', 'Inventado@gmail.com', 'Curri', '698175344');

-- Insertar en prestamo
INSERT INTO `biblioteca`.`prestamo` (`fecha_devolucion`, `fecha_entrega`, `libro_id`, `socio_id`) VALUES ('2025-06-18', '2025-06-17', '1', '1');
