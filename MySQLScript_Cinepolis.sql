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
    nombre VARCHAR(255) NOT NULL UNIQUE,
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
    contraseña VARCHAR(255) NOT NULL,
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
-- Insertar Peliculas
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
    ('La vida de Pi', 'Dirigida por Ang Lee, la película adapta la novela homónima y sigue la aventura épica de un joven indio que sobrevive a un naufragio en el océano Pacífico en compañía de un tigre de Bengala.', 'Estados Unidos','https://www.youtube.com/watch?v=3mMN693-F3U', 127, 'carteles/vidaPi.jpg', 'B'),
	('Bastardos sin gloria', 'Dirigida por Quentin Tarantino, esta película ambientada en la Segunda Guerra Mundial sigue a un grupo de soldados judíos estadounidenses, conocidos como "Los Bastardos", que llevan a cabo una campaña brutal contra los nazis en la Francia ocupada.', 'Estados Unidos', 'https://www.youtube.com/watch?v=KnrRy6kSFF0', 153, 'carteles/BastardosSinGloria.jpg', 'B15'),
    ('Interstellar', 'Dirigida por Christopher Nolan, esta épica de ciencia ficción narra la travesía de un grupo de astronautas que viajan a través de un agujero de gusano en busca de un nuevo hogar para la humanidad, enfrentándose a desafíos cósmicos y emocionales.', 'Estados Unidos', 'https://www.youtube.com/watch?v=zSWdZVtXT7E', 169, 'carteles/interstellar.jpg', 'B'),
    ('Avatar 2', 'Dirigida por James Cameron, esta esperada secuela lleva a los espectadores de regreso a Pandora, donde Jake Sully y Neytiri deben proteger su hogar de nuevas amenazas mientras exploran las profundidades submarinas del planeta.', 'Estados Unidos', 'https://www.youtube.com/watch?v=d9MyW72ELq0', 192, 'carteles/Avatar2.jpg', 'A'),
    ('Valiente', 'Dirigida por Mark Andrews y Brenda Chapman, esta película de animación de Disney y Pixar cuenta la historia de Mérida, una joven princesa escocesa que desafía las tradiciones de su reino para seguir su propio camino y deshacer una terrible maldición.', 'Estados Unidos', 'https://www.youtube.com/watch?v=TEHWDA_6e3M', 93, 'carteles/Valiente.jpg', 'A'),
    ('Cars 3', 'Dirigida por Brian Fee, la tercera entrega de la franquicia de animación de Pixar sigue a Rayo McQueen, quien se enfrenta a una nueva generación de autos de carreras mientras lucha por demostrar que aún tiene lo necesario para ser el mejor en la pista.', 'Estados Unidos', 'https://www.youtube.com/watch?v=2LeOH9AGJQM', 102, 'carteles/Cars3.jpg', 'A');

-- Insertar Pais
INSERT INTO Paises (nombre) VALUES ('México');

-- Insertar Ciudades
INSERT INTO Ciudades (nombre, pais_id) VALUES ('Navojoa', 1);
INSERT INTO Ciudades (nombre, pais_id) VALUES ('Obregón', 1);
INSERT INTO Ciudades (nombre, pais_id) VALUES ('Hermosillo', 1);
INSERT INTO Ciudades (nombre, pais_id) VALUES ('Culiacán', 1);
INSERT INTO Ciudades (nombre, pais_id) VALUES ('Mazatlán', 1);

-- Insertar Sucursales
INSERT INTO Sucursales (nombre, direccion, ubicacion, ciudad_id)
VALUES ('Cinépolis Sendero Obregón', 'Plaza Sendero, C. 300 85180, Franja Comercial 300, 85065, Cdad. Obregón, Son.', POINT(27.478692089159388, -109.91456675730379), (SELECT ciudad_id FROM Ciudades WHERE nombre = 'Obregón')),
('Cinépolis Bella Vista', 'Blvd. Rodolfo Elías Calles 1750, Fuentes del Bosque, 85000 Cdad. Obregón, Son.', POINT(27.488969156057266, -109.9580047508814), (SELECT ciudad_id FROM Ciudades WHERE nombre = 'Obregón')),
('Cinépolis Plaza de Hierro Navojoa', 'Blvd. Centenario 358, Reforma, 85229 Navojoa, Son.', POINT(27.09021094262184, -109.44881426288555), (SELECT ciudad_id FROM Ciudades WHERE nombre = 'Navojoa')),
('Cinépolis Galerías Mall Hermosillo', 'Av Cultura 55, Proyecto Rio Sonora Hermosillo XXI, 83270 Hermosillo, Son.', POINT(29.068465547224747, -110.95136051615307), (SELECT ciudad_id FROM Ciudades WHERE nombre = 'Hermosillo')),
('Cinépolis Hermosillo', 'Blvd. Luis Encinas J. 227-P. B, San Benito, 83190 Hermosillo, Son.', POINT(29.093991653707597, -110.96714639206756), (SELECT ciudad_id FROM Ciudades WHERE nombre = 'Hermosillo')),
('Cinépolis Patio Hermosillo', 'Periférico Ote. 1274, Perisur, 83290 Hermosillo, Son.', POINT(29.039198907378776, -110.94021202877917), (SELECT ciudad_id FROM Ciudades WHERE nombre = 'Hermosillo')),
('Cinépolis Culiacán', 'Boulevard Culiacán 450, Pte. Col Recursos Hidraúlicos, 80100 Culiacán Rosales, Sin.', POINT(24.801520560399602, -107.41284308893044), (SELECT ciudad_id FROM Ciudades WHERE nombre = 'Culiacán')),
('Cinépolis La Ceiba', 'Congreso del Estado, 80100 Culiacán Rosales, Sin.', POINT(24.80218305146663, -107.42266934379363), (SELECT ciudad_id FROM Ciudades WHERE nombre = 'Culiacán')),
('Cinépolis Paseo San Isidro', 'Calz. de las Torres 1787, Lomas de San Isidro, 80197 Culiacán Rosales, Sin.', POINT(24.756319663151086, -107.40176798996296), (SELECT ciudad_id FROM Ciudades WHERE nombre = 'Culiacán')),
('Cinépolis Azahares', 'Calz. Aeropuerto número 7071, Gasolinera del Valle, Bachigualato, 80140 Culiacán Rosales, Sin.', POINT(24.77580496511215, -107.45663668811265), (SELECT ciudad_id FROM Ciudades WHERE nombre = 'Culiacán')),
('Cinépolis Sendero Ganadera Culiacán', 'Boulevard José Limón, México 15 2545, Feria Ganadera, 80059 Culiacán Rosales, Sin.', POINT(24.824499477472386, -107.42668136297435), (SELECT ciudad_id FROM Ciudades WHERE nombre = 'Culiacán')),
('Cinépolis Acaya Mazatlán', 'Av Óscar Pérez Escobosa 8201, El Venadillo, 82124 Mazatlán, Sin.', POINT(23.272084582381495, -106.41886089001662), (SELECT ciudad_id FROM Ciudades WHERE nombre = 'Mazatlán')),
('Cinépolis Gran Plaza Mazatlán', 'Av. Reforma S/N, Alameda, 82123 Mazatlán, Sin.', POINT(23.240335140033825, -106.43675911657577), (SELECT ciudad_id FROM Ciudades WHERE nombre = 'Mazatlán')),
('Cinépolis Santa Rosa', 'Boulevard Luis Donaldo Colosio Murrieta 17301 Int. Cinema Col, Valle Dorado, 82132 Mazatlán, Sin.', POINT(23.258113804421725, -106.40565499186677), (SELECT ciudad_id FROM Ciudades WHERE nombre = 'Mazatlán'));


-- Insertar salas para cada sucursal
INSERT INTO Salas (nombre, num_asientos, duracionLimpieza, sucursal_id)
VALUES 
('Kids', 50, 15, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Sendero Obregón')),
('Sala Tradicional', 100, 10, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Sendero Obregón')),
('Sala Premium', 80, 15, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Sendero Obregón')),
('Sala VIP', 40, 20, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Sendero Obregón')),
('Sala ITSON', 60, 10, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Sendero Obregón')),

('Kids', 50, 15, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Bella Vista')),
('Sala Tradicional', 100, 10, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Bella Vista')),
('Sala Premium', 80, 15, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Bella Vista')),
('Sala VIP', 40, 20, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Bella Vista')),
('Sala ITSON', 60, 10, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Bella Vista')),

('Kids', 50, 15, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Plaza de Hierro Navojoa')),
('Sala Tradicional', 100, 10, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Plaza de Hierro Navojoa')),
('Sala Premium', 80, 15, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Plaza de Hierro Navojoa')),
('Sala VIP', 40, 20, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Plaza de Hierro Navojoa')),
('Sala ITSON', 60, 10, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Plaza de Hierro Navojoa')),

('Kids', 50, 15, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Galerías Mall Hermosillo')),
('Sala Tradicional', 100, 10, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Galerías Mall Hermosillo')),
('Sala Premium', 80, 15, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Galerías Mall Hermosillo')),
('Sala VIP', 40, 20, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Galerías Mall Hermosillo')),
('Sala ITSON', 60, 10, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Galerías Mall Hermosillo')),

('Kids', 50, 15, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Hermosillo')),
('Sala Tradicional', 100, 10, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Hermosillo')),
('Sala Premium', 80, 15, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Hermosillo')),
('Sala VIP', 40, 20, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Hermosillo')),
('Sala ITSON', 60, 10, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Hermosillo')),

('Kids', 50, 15, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Patio Hermosillo')),
('Sala Tradicional', 100, 10, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Patio Hermosillo')),
('Sala Premium', 80, 15, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Patio Hermosillo')),
('Sala VIP', 40, 20, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Patio Hermosillo')),
('Sala ITSON', 60, 10, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Patio Hermosillo')),

('Kids', 50, 15, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Culiacán')),
('Sala Tradicional', 100, 10, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Culiacán')),
('Sala Premium', 80, 15, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Culiacán')),
('Sala VIP', 40, 20, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Culiacán')),
('Sala ITSON', 60, 10, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Culiacán')),

('Kids', 50, 15, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis La Ceiba')),
('Sala Tradicional', 100, 10, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis La Ceiba')),
('Sala Premium', 80, 15, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis La Ceiba')),
('Sala VIP', 40, 20, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis La Ceiba')),
('Sala ITSON', 60, 10, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis La Ceiba')),

('Kids', 50, 15, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Paseo San Isidro')),
('Sala Tradicional', 100, 10, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Paseo San Isidro')),
('Sala Premium', 80, 15, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Paseo San Isidro')),
('Sala VIP', 40, 20, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Paseo San Isidro')),
('Sala ITSON', 60, 10, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Paseo San Isidro')),

('Kids', 50, 15, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Azahares')),
('Sala Tradicional', 100, 10, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Azahares')),
('Sala Premium', 80, 15, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Azahares')),
('Sala VIP', 40, 20, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Azahares')),
('Sala ITSON', 60, 10, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Azahares')),

('Kids', 50, 15, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Sendero Ganadera Culiacán')),
('Sala Tradicional', 100, 10, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Sendero Ganadera Culiacán')),
('Sala Premium', 80, 15, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Sendero Ganadera Culiacán')),
('Sala VIP', 40, 20, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Sendero Ganadera Culiacán')),
('Sala ITSON', 60, 10, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Sendero Ganadera Culiacán')),

('Kids', 50, 15, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Acaya Mazatlán')),
('Sala Tradicional', 100, 10, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Acaya Mazatlán')),
('Sala Premium', 80, 15, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Acaya Mazatlán')),
('Sala VIP', 40, 20, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Acaya Mazatlán')),
('Sala ITSON', 60, 10, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Acaya Mazatlán')),

('Kids', 50, 15, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Gran Plaza Mazatlán')),
('Sala Tradicional', 100, 10, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Gran Plaza Mazatlán')),
('Sala Premium', 80, 15, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Gran Plaza Mazatlán')),
('Sala VIP', 40, 20, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Gran Plaza Mazatlán')),
('Sala ITSON', 60, 10, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Gran Plaza Mazatlán')),

('Kids', 50, 15, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Santa Rosa')),
('Sala Tradicional', 100, 10, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Santa Rosa')),
('Sala Premium', 80, 15, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Santa Rosa')),
('Sala VIP', 40, 20, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Santa Rosa')),
('Sala ITSON', 60, 10, (SELECT sucursal_id FROM Sucursales WHERE nombre = 'Cinépolis Santa Rosa'));



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

CREATE TABLE Pelicula_Sucursal (
    sucursal_id INT,
    pelicula_id INT,
    PRIMARY KEY (pelicula_id, sucursal_id),
    FOREIGN KEY (pelicula_id) REFERENCES Peliculas(pelicula_id),
    FOREIGN KEY (sucursal_id) REFERENCES Sucursales(sucursal_id)
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

CREATE PROCEDURE BuscarSucursalMasCercana(
    IN clienteID INT
)
BEGIN
    SELECT s.sucursal_id, s.nombre, s.direccion, 
           ST_DISTANCE(c.ubicacion, s.ubicacion) AS distancia
    FROM Clientes c
    CROSS JOIN Sucursales s
    WHERE c.cliente_id = clienteID
    ORDER BY distancia
    LIMIT 1;
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
INSERT INTO Funciones (precio, dia, hora, asientos_Disponibles, duracionTotal, sala_id, pelicula_id) VALUES (100.00, 'Lunes', '18:00:00', 50, 150, 1, 1);
INSERT INTO Clientes (nombres, apellidoPA, apellidoMA, correo, contraseña, fechaNacimiento, ubicacion, ciudad_id) VALUES ('Juan Alonso','Perez','Lopez', 'juan@example.com', '123', '1990-01-01', ST_GeomFromText('POINT(19.4326 -99.1332)'), 1);
INSERT INTO Compras (fecha_compra, cantidad_Boletos, cliente_id, funcion_id)
VALUES (CURRENT_DATE(), 2, 1, 1);

-- Actualizar la duración total de las funciones
CALL actualizarDuracionTotal();

-- Insertar Clientes
INSERT INTO Clientes (nombres, apellidoPA, apellidoMA, correo, contraseña, fechaNacimiento, ubicacion, ciudad_id) VALUES
('Ana María', 'García', 'Hernández', 'ana@example.com', 'Password123', '1985-02-15', ST_GeomFromText('POINT(19.4284 -99.1276)'), 1),
('Carlos Eduardo', 'Ramírez', 'Martínez', 'carlos@example.com', 'Qwerty2021', '1978-06-23', ST_GeomFromText('POINT(19.4450 -99.1383)'), 1),
('Laura Beatriz', 'Flores', 'Sánchez', 'laura@example.com', 'SecretPass', '1992-11-30', ST_GeomFromText('POINT(19.4501 -99.1213)'), 1),
('Pedro Antonio', 'Morales', 'Gómez', 'pedro@example.com', 'MyPass2022', '1980-03-14', ST_GeomFromText('POINT(19.4373 -99.1406)'), 1),
('Martha Cecilia', 'Vázquez', 'Díaz', 'martha@example.com', 'Secure1234', '1987-07-07', ST_GeomFromText('POINT(19.4259 -99.1315)'), 1),
('Roberto Andrés', 'Torres', 'Jiménez', 'roberto@example.com', 'HelloWorld', '1991-08-21', ST_GeomFromText('POINT(19.4411 -99.1347)'), 1),
('Patricia Elena', 'Rojas', 'Castro', 'patricia@example.com', 'Password!', '1979-04-05', ST_GeomFromText('POINT(19.4320 -99.1368)'), 1),
('José Luis', 'Hernández', 'Vega', 'jose@example.com', 'SuperSafe', '1982-09-12', ST_GeomFromText('POINT(19.4346 -99.1325)'), 1),
('Verónica Luz', 'Mendoza', 'Ruiz', 'veronica@example.com', 'Pass4321', '1984-12-18', ST_GeomFromText('POINT(19.4367 -99.1378)'), 1),
('Miguel Ángel', 'Santos', 'Ortiz', 'miguel@example.com', 'NewPass123', '1990-05-25', ST_GeomFromText('POINT(19.4299 -99.1294)'), 1),
('Adriana Sofía', 'López', 'Ramírez', 'adriana@example.com', 'PassWord!', '1988-03-17', ST_GeomFromText('POINT(19.4312 -99.1353)'), 1),
('Fernando Javier', 'Silva', 'Núñez', 'fernando@example.com', 'Test1234', '1981-10-10', ST_GeomFromText('POINT(19.4334 -99.1289)'), 1),
('Sofía Renata', 'Gómez', 'Luna', 'sofia@example.com', 'TryMe2021', '1993-02-22', ST_GeomFromText('POINT(19.4301 -99.1318)'), 1),
('Luis Alberto', 'Pérez', 'Figueroa', 'luis@example.com', 'SafePass!', '1989-01-30', ST_GeomFromText('POINT(19.4356 -99.1339)'), 1);


-- Insert 4
INSERT INTO Pelicula_Sucursal (sucursal_id, pelicula_id) VALUES (7, 12);

-- Insert 5
INSERT INTO Pelicula_Sucursal (sucursal_id, pelicula_id) VALUES (4, 9);

-- Insert 6
INSERT INTO Pelicula_Sucursal (sucursal_id, pelicula_id) VALUES (3, 7);

-- Insert 7 (repetición de la sucursal)
INSERT INTO Pelicula_Sucursal (sucursal_id, pelicula_id) VALUES (3, 4);
-- Insert 8
INSERT INTO Pelicula_Sucursal (sucursal_id, pelicula_id) VALUES (12, 15);
