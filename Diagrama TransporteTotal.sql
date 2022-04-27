CREATE TABLE `Vehiculo` (
  `id_vehiculo` int PRIMARY KEY AUTO_INCREMENT,
  `id_carga` int,
  `placa` varchar(255),
  `tipo` varchar(255),
  `modelo` int
);

CREATE TABLE `Viaje` (
  `id_viaje` int PRIMARY KEY AUTO_INCREMENT,
  `origen` varchar(255),
  `destino` varchar(255),
  `costo_viaje` float
);

CREATE TABLE `Gasto` (
  `id_gasto` int PRIMARY KEY AUTO_INCREMENT,
  `id_vehiculo` int,
  `peajes` float,
  `combustible` float,
  `reparaciones_imprevistos` float
);

CREATE TABLE `Carga` (
  `id_carga` int PRIMARY KEY AUTO_INCREMENT,
  `naturaleza` varchar(255),
  `peso_tonelada` float,
  `volumen` float
);

CREATE TABLE `Vehiculo_viaje` (
  `id_viaje` int,
  `id_vehiculo` int
);

ALTER TABLE `Vehiculo_viaje` ADD FOREIGN KEY (`id_vehiculo`) REFERENCES `Vehiculo` (`id_vehiculo`);

ALTER TABLE `Vehiculo_viaje` ADD FOREIGN KEY (`id_viaje`) REFERENCES `Viaje` (`id_viaje`);

ALTER TABLE `Gasto` ADD FOREIGN KEY (`id_vehiculo`) REFERENCES `Vehiculo` (`id_vehiculo`);

ALTER TABLE `Vehiculo` ADD FOREIGN KEY (`id_carga`) REFERENCES `Carga` (`id_carga`);
