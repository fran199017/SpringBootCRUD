INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Francisco', 'Nicolau', 'fran199017@gmail.com', '2021-08-09', '');

INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Juan', 'Martinez', 'juanMartinez@gmail.com', '2021-08-19', '');


INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Juan', 'Martinez', 'juanMartinez@gmail.com', '2021-08-19', '');

INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Juan', 'Martinez', 'juanMartinez@gmail.com', '2021-08-19', '');

INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Juan', 'Martinez', 'juanMartinez@gmail.com', '2021-08-19', '');

INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Juan', 'Martinez', 'juanMartinez@gmail.com', '2021-08-19', '');

INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Juan', 'Martinez', 'juanMartinez@gmail.com', '2021-08-19', '');

INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Juan', 'Martinez', 'juanMartinez@gmail.com', '2021-08-19', '');

INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Juan', 'Martinez', 'juanMartinez@gmail.com', '2021-08-19', '');


INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Juan', 'Martinez', 'juanMartinez@gmail.com', '2021-08-19', '');

INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Juan', 'Martinez', 'juanMartinez@gmail.com', '2021-08-19', '');

INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Juan', 'Martinez', 'juanMartinez@gmail.com', '2021-08-19', '');

INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Juan', 'Martinez', 'juanMartinez@gmail.com', '2021-08-19', '');

INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Juan', 'Martinez', 'juanMartinez@gmail.com', '2021-08-19', '');

INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Juan', 'Martinez', 'juanMartinez@gmail.com', '2021-08-19', '');

INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Juan', 'Martinez', 'juanMartinez@gmail.com', '2021-08-19', '');

INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES ('Juan', 'Martinez', 'juanMartinez@gmail.com', '2021-08-19', '');



/*Productos*/

INSERT INTO productos (nombre, precio,create_at) VALUES ('Sony Camara digital', '450', NOW());

INSERT INTO productos (nombre, precio,create_at) VALUES ('Apple iPod', '250', NOW());

INSERT INTO productos (nombre, precio,create_at) VALUES ('Sony Notebook', '400', NOW());

INSERT INTO productos (nombre, precio,create_at) VALUES ('Escritorio con cajones', '150', NOW());

INSERT INTO productos (nombre, precio,create_at) VALUES ('Televisor LG 60 pulgadas', '500', NOW());

/*Facturas*/

INSERT INTO facturas (descripcion, observacion,cliente_id, create_at) VALUES ('Factura equipos de oficina', null, 1, NOW());
INSERT INTO facturas_items(cantidad, factura_id, producto_id) VALUES(1,1,1);
INSERT INTO facturas_items(cantidad, factura_id, producto_id) VALUES(2,1,4);
INSERT INTO facturas_items(cantidad, factura_id, producto_id) VALUES(1,1,5);
INSERT INTO facturas_items(cantidad, factura_id, producto_id) VALUES(1,1,2);

INSERT INTO facturas (descripcion, observacion,cliente_id, create_at) VALUES ('Factura personal', 'Nota importante', 1, NOW());
INSERT INTO facturas_items(cantidad, factura_id, producto_id) VALUES(3,2,3);


