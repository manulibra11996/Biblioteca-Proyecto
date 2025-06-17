-- Insertar en categorias
INSERT INTO `biblioteca`.`categorias` (`descripcion`, `nombre`) VALUES ('Romance', 'Libros de amor');

-- Insertar en autores
INSERT INTO `biblioteca`.`autores` (`apellido`, `biografia`, `fecha_nacimiento`, `nacionalidad`, `nombre`) VALUES ('Fernández', 'renacimiento', '1605-01-16', 'España', 'Manuel');


-- Insertar en libros
INSERT INTO biblioteca.libros (titulo, numero_paginas, disponible, id_autor, id_categoria) VALUES ('Cien Años de Soledad', 417, true, 1, 1);

-- Insertar en socio
INSERT INTO `biblioteca`.`socios` (`direccion`, `email`, `nombre`, `telefono`) VALUES ('Calle granada nº9', 'Inventado@gmail.com', 'Curri', '698175344');

-- Insertar en prestamo
INSERT INTO `biblioteca`.`prestamo` (`fecha_devolucion`, `fecha_entrega`, `libro_id`, `socio_id`) VALUES ('2025-06-18', '2025-06-17', '1', '1');
