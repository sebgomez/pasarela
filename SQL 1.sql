CREATE TABLE Transaccion(
id INT NOT NULL,
valor INT NOT NULL,
tarjeta_credito INT REFERENCES CreditCard(id),
marca_tiempo TIMESTAMP, 
PRIMARY KEY(id));
CREATE TABLE CreditCard(
id INT NOT NULL,
owner INT REFERENCES Customer(id),
cvv INT NOT NULL,
fecha_vencimiento DATE,
PRIMARY KEY(id));
CREATE TABLE Customer(
id INT NOT NULL,
nombre VARCHAR(50) NOT NULL,
apellido VARCHAR(50) NOT NULL,
email VARCHAR(50) NOT NULL,
PRIMARY KEY(id));