CREATE DATABASE IF NOT EXISTS cinepolis;
USE cinepolis;

-- Creación de tablas

CREATE TABLE Paises (
    pais_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

CREATE TABLE Ciudades (
    ciudad_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    pais_id INT,
    FOREIGN KEY (pais_id) REFERENCES Pais(pais_id)
);

CREATE TABLE Sucursales (
    sucursal_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    ubicacion POINT NOT NULL,
    ciudad_id INT,
    FOREIGN KEY (ciudad_id) REFERENCES Ciudad(ciudad_id)
);

CREATE TABLE Salas (
    sala_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    num_asientos INT NOT NULL,
    duracionLimpieza INT NOT NULL,
    sucursal_id INT,
    FOREIGN KEY (sucursal_id) REFERENCES Sucursal(sucursal_id)
);

CREATE TABLE Clientes (
    cliente_id INT AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(255) NOT NULL,
	apellidoPA VARCHAR(255) NOT NULL,
    apellidoMA VARCHAR(255) NOT NULL,
    correo VARCHAR(255) NOT NULL,
    fechaNacimiento DATE NOT NULL,
    ubicacion POINT NOT NULL,
    
    ciudad_id INT,
    FOREIGN KEY (ciudad_id) REFERENCES Ciudad(ciudad_id)
);

CREATE TABLE Generos (
    genero_id INT AUTO_INCREMENT PRIMARY KEY,
    nombreGenero VARCHAR(255) NOT NULL
);

CREATE TABLE Peliculas (
    pelicula_id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    sinopsis TEXT NOT NULL,
    pais VARCHAR(255) NOT NULL,
    link_Trailer VARCHAR(255),
    duracion INT NOT NULL,
    cartel BLOB, 
    clasificacion VARCHAR(10) NOT NULL
);

CREATE TABLE Funciones (
    funcion_id INT AUTO_INCREMENT PRIMARY KEY,
    precio DECIMAL(10, 2) NOT NULL,
    dia ENUM('Lunes','Martes','Miercoles','Jueves','Viernes','Sabado','Domingo') NOT NULL,
    hora TIME NOT NULL,
    asientos_Disponibles INT NOT NULL,
    duracionTotal INT NOT NULL,
    sala_id INT,
    pelicula_id INT,
    FOREIGN KEY (sala_id) REFERENCES Sala(sala_id),
    FOREIGN KEY (pelicula_id) REFERENCES Pelicula(pelicula_id)
);

CREATE TABLE Compras (
    compra_id INT AUTO_INCREMENT PRIMARY KEY,
    fecha_compra DATE NOT NULL,
    cantidad_Boletos INT NOT NULL,
    totalCompra DECIMAL(10, 2),
    cliente_id INT,
    funcion_id INT,
    FOREIGN KEY (cliente_id) REFERENCES Cliente(cliente_id),
    FOREIGN KEY (funcion_id) REFERENCES Funcion(funcion_id)
);

CREATE TABLE Pelicula_Genero (
    pelicula_id INT,
    genero_id INT,
    PRIMARY KEY (pelicula_id, genero_id),
    FOREIGN KEY (pelicula_id) REFERENCES Pelicula(pelicula_id),
    FOREIGN KEY (genero_id) REFERENCES Genero(genero_id)
);

DELIMITER $$

CREATE TRIGGER actualizar_asientos
AFTER INSERT ON Compras
FOR EACH ROW
BEGIN
    DECLARE asientos_actuales INT;

    -- Obtener los asientos disponibles de la función correspondiente
    SELECT asientos_Disponibles
    INTO asientos_actuales
    FROM Funciones
    WHERE funcion_id = NEW.funcion_id;
	UPDATE Funciones
	SET asientos_Disponibles = asientos_Disponibles - NEW.cantidad_Boletos
	WHERE funcion_id = NEW.funcion_id;
END $$

CREATE TRIGGER calcular_total_compra
BEFORE INSERT ON Compras
FOR EACH ROW
BEGIN
    DECLARE precio_funcion DECIMAL(10, 2);
    -- Obtener el precio de la función correspondiente
    SELECT precio INTO precio_funcion
    FROM Funciones
    WHERE funcion_id = NEW.funcion_id;

    -- Calcular el total de la compra
    SET NEW.totalCompra = precio_funcion * NEW.cantidad_Boletos;
END $$

CREATE PROCEDURE actualizarDuracionTotal()
BEGIN
    UPDATE Funciones f
    JOIN Salas s ON f.sala_id = s.sala_id
    JOIN Peliculas p ON f.pelicula_id = p.pelicula_id
    SET f.duracionTotal = s.duracionLimpieza + p.duracion;
END $$

DELIMITER ;

-- Insertar datos de prueba
INSERT INTO Paises (nombre) VALUES ('México');
INSERT INTO Ciudades (nombre, pais_id) VALUES ('CDMX', 1);
INSERT INTO Sucursales (nombre, direccion, ubicacion, ciudad_id) VALUES ('Sucursal Centro', 'Av. Reforma', ST_GeomFromText('POINT(19.4326 -99.1332)'), 1);
INSERT INTO Salas (nombre, num_asientos, duracionLimpieza, sucursal_id) VALUES ('Sala 1', 50, 30, 1);
INSERT INTO Peliculas (titulo, sinopsis, pais, duracion, clasificacion) VALUES ('Pelicula 1', 'Sinopsis de Pelicula 1', 'México', 120, 'A');
INSERT INTO Funcions (precio, dia, hora, asientos_Disponibles, duracionTotal, sala_id, pelicula_id) VALUES (100.00, 'Lunes', '18:00:00', 50, 150, 1, 1);
INSERT INTO Clientes (nombres, apellidoPA, apellidoMA, correo, fechaNacimiento, ubicacion, ciudad_id) VALUES ('Juan Alonso','Perez','Lopez', 'juan@example.com', '1990-01-01', ST_GeomFromText('POINT(19.4326 -99.1332)'), 1);
INSERT INTO Compras (fecha_compra, cantidad_Boletos, cliente_id, funcion_id)
VALUES (CURRENT_DATE(), 2, 1, 1);
-- Actualizar la duración total de las funciones
CALL actualizarDuracionTotal();

