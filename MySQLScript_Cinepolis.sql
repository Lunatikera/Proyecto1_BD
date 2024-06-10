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
    FOREIGN KEY (pais_id) REFERENCES Paises(pais_id)
);

CREATE TABLE Sucursales (
    sucursal_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    ubicacion POINT NOT NULL,
    ciudad_id INT,
    FOREIGN KEY (ciudad_id) REFERENCES Ciudades(ciudad_id)
);

CREATE TABLE Salas (
    sala_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    num_asientos INT NOT NULL,
    duracionLimpieza INT NOT NULL,
    sucursal_id INT,
    FOREIGN KEY (sucursal_id) REFERENCES Sucursales(sucursal_id)
);

CREATE TABLE Clientes (
    cliente_id INT AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(255) NOT NULL,
	apellidoPA VARCHAR(255) NOT NULL,
    apellidoMA VARCHAR(255) NOT NULL,
    correo VARCHAR(255) NOT NULL,
    contraseña VARCHAR(20) NOT NULL,
    fechaNacimiento DATE NOT NULL,
    ubicacion POINT NOT NULL,
    
    ciudad_id INT,
    FOREIGN KEY (ciudad_id) REFERENCES Ciudades(ciudad_id)
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
    cartel varchar(255), 
    clasificacion enum ('A','B','B15','C','R') NOT NULL
);

INSERT INTO Peliculas (titulo, sinopsis, pais, link_Trailer, duracion, cartel, clasificacion) VALUES
    ('El señor de los anillos: El retorno del Rey', 'La última entrega de la trilogía épica dirigida por Peter Jackson, basada en las novelas de J.R.R. Tolkien, donde la comunidad del anillo se enfrenta a Sauron en la batalla final por la Tierra Media.', 'Nueva Zelanda', 'https://www.youtube.com/watch?v=r5X-hFf6Bwo', 201, 'carteles/ESDLA3.jpg', 'A'),
    ('La La Land', 'Un musical romántico dirigido por Damien Chazelle que narra la historia de amor entre un pianista y una aspirante a actriz en Los Ángeles, mientras luchan por alcanzar sus sueños.', 'Estados Unidos', 'https://www.youtube.com/watch?v=0pdqf4P9MB8', 128, 'carteles/LaLaLand.jpg', 'B'),
    ('Parásitos', 'Un thriller social y comedia negra dirigido por Bong Joon-ho que sigue a una familia pobre que se infiltra en la vida de una rica familia, desencadenando una serie de eventos inesperados.', 'Corea del Sur', 'https://www.youtube.com/watch?v=5xH0HfJHsaY', 132, 'carteles/parasitos.jpg', 'B15'),
    ('La red social', 'Dirigida por David Fincher, la película ofrece una visión dramatizada de los eventos que rodearon la creación de Facebook por parte de Mark Zuckerberg y los conflictos legales que siguieron.', 'Estados Unidos', 'https://www.youtube.com/watch?v=lB95KLmpLR4', 120, 'carteles/redSocial.jpg', 'B'),
    ('Moonlight', 'Dirigida por Barry Jenkins, la película sigue la vida de un joven afroamericano desde la infancia hasta la adultez mientras lucha con su identidad y sexualidad en un barrio difícil de Miami.', 'Estados Unidos', 'https://www.youtube.com/watch?v=9NJj12tJzqc', 111, 'carteles/moonLight.jpg', 'B15'),
    ('El caballero de la noche', 'Dirigida por Christopher Nolan, esta película de superhéroes es el segundo capítulo de la trilogía de Batman de Nolan y presenta al icónico villano Joker enfrentándose al Caballero Oscuro.', 'Estados Unidos', 'https://www.youtube.com/watch?v=EXeTwQWrcwY', 152, 'carteles/CaballeroNoche.jpg', 'B15'),
    ('La forma del agua', 'Dirigida por Guillermo del Toro, esta fábula romántica narra la historia de amor entre una mujer muda y una criatura acuática en un laboratorio gubernamental de alta seguridad.', 'Estados Unidos', 'https://www.youtube.com/watch?v=XFYWazblaUA', 123, 'carteles/formaAgua.jpg', 'B'),
    ('El gran hotel Budapest', 'Una comedia dirigida por Wes Anderson que sigue las aventuras de un conserje y su protegido en un lujoso hotel europeo entre las guerras mundiales.', 'Alemania', 'https://www.youtube.com/watch?v=1Fg5iWmQjwk', 99, 'carteles/BudapestHotel.jpg', 'B15'),
    ('Origen', 'Dirigida por Christopher Nolan, la película explora la manipulación de los sueños como un medio para el robo de ideas, llevando a los espectadores a un viaje mentalmente intrincado.', 'Reino Unido', 'https://www.youtube.com/watch?v=YoHD9XEInc0',148, 'carteles/Origen.jpg', 'B15'),
    ('12 años de esclavitud', 'Dirigida por Steve McQueen, esta película está basada en las memorias de Solomon Northup y cuenta la historia real de un hombre afroamericano libre que es secuestrado y vendido como esclavo en el sur de los Estados Unidos.', 'Estados Unidos', 'https://www.youtube.com/watch?v=z02Ie8wKKRg', 134, 'carteles/12esclavitud.jpg', 'B15'),
    ('Whiplash', 'Dirigida por Damien Chazelle, la película sigue la relación tensa entre un joven baterista y su exigente instructor de música en una prestigiosa escuela de jazz.', 'Estados Unidos', 'https://www.youtube.com/watch?v=7d_jQycdQGo', 106, 'carteles/whiplash.jpg', 'B15'),
    ('La llegada', 'Dirigida por Denis Villeneuve, la película sigue a una lingüista contratada por el gobierno de los Estados Unidos para comunicarse con extraterrestres que han llegado a la Tierra en misteriosas naves espaciales.', 'Estados Unidos', 'https://www.youtube.com/watch?v=tFMo3UJ4B4g', 116, 'carteles/LaLlegada.jpg', 'B'),
    ('Birdman', 'Dirigida por Alejandro González Iñárritu, la película sigue a un actor de cine que intenta revitalizar su carrera actuando en una obra de teatro de Broadway, todo mientras lucha contra su propia percepción de la realidad.', 'Estados Unidos', 'https://www.youtube.com/watch?v=uJfLoE6hanc', 119, 'carteles/Birdman.jpg', 'B15'),
    ('El renacido', 'Dirigida por Alejandro González Iñárritu, la película sigue la odisea de un trampero que busca venganza contra aquellos que lo abandonaron después de un brutal ataque de un oso en el salvaje oeste estadounidense.', 'Estados Unidos','https://www.youtube.com/watch?v=LoebZZ8K5N0', 156, 'carteles/Renacido.jpg', 'B15'),
    ('La vida de Pi', 'Dirigida por Ang Lee, la película adapta la novela homónima y sigue la aventura épica de un joven indio que sobrevive a un naufragio en el océano Pacífico en compañía de un tigre de Bengala.', 'Estados Unidos','https://www.youtube.com/watch?v=3mMN693-F3U', 127, 'carteles/vidaPi.jpg', 'B');

CREATE TABLE Funciones (
    funcion_id INT AUTO_INCREMENT PRIMARY KEY,
    precio DECIMAL(10, 2) NOT NULL,
    dia ENUM('Lunes','Martes','Miercoles','Jueves','Viernes','Sabado','Domingo') NOT NULL,
    hora TIME NOT NULL,
    asientos_Disponibles INT NOT NULL,
    duracionTotal INT NOT NULL,
    sala_id INT,
    pelicula_id INT,
    FOREIGN KEY (sala_id) REFERENCES Salas(sala_id),
    FOREIGN KEY (pelicula_id) REFERENCES Peliculas(pelicula_id)
);

CREATE TABLE Compras (
    compra_id INT AUTO_INCREMENT PRIMARY KEY,
    fecha_compra DATE NOT NULL,
    cantidad_Boletos INT NOT NULL,
    totalCompra DECIMAL(10, 2),
    cliente_id INT,
    funcion_id INT,
    FOREIGN KEY (cliente_id) REFERENCES Clientes(cliente_id),
    FOREIGN KEY (funcion_id) REFERENCES Funciones(funcion_id)
);

CREATE TABLE Pelicula_Genero (
    pelicula_id INT,
    genero_id INT,
    PRIMARY KEY (pelicula_id, genero_id),
    FOREIGN KEY (pelicula_id) REFERENCES Peliculas(pelicula_id),
    FOREIGN KEY (genero_id) REFERENCES Generos(genero_id)
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
INSERT INTO Funciones (precio, dia, hora, asientos_Disponibles, duracionTotal, sala_id, pelicula_id) VALUES (100.00, 'Lunes', '18:00:00', 50, 150, 1, 1);
INSERT INTO Clientes (nombres, apellidoPA, apellidoMA, correo, fechaNacimiento, ubicacion, ciudad_id) VALUES ('Juan Alonso','Perez','Lopez', 'juan@example.com', '1990-01-01', ST_GeomFromText('POINT(19.4326 -99.1332)'), 1);
INSERT INTO Compras (fecha_compra, cantidad_Boletos, cliente_id, funcion_id)
VALUES (CURRENT_DATE(), 2, 1, 1);
-- Actualizar la duración total de las funciones
CALL actualizarDuracionTotal();

