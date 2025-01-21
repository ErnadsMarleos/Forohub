INSERT INTO usuario (nombre, correo_electronico, contrasena)
VALUES ('miguel', 'miguel.inocente.c@uni.pe', '$2a$12$PSWBPRo3yOYHhNPzSqKaFOmZtFMzPA/ged8Qa2HzdolKe4ZPJNaAe');

INSERT INTO curso (nombre, categoria) VALUES ('Programación en Java', 'Desarrollo Backend');
INSERT INTO curso (nombre, categoria) VALUES ('HTML y CSS Básico', 'Desarrollo Frontend');
INSERT INTO curso (nombre, categoria) VALUES ('JavaScript Avanzado', 'Desarrollo Frontend');
INSERT INTO curso (nombre, categoria) VALUES ('Python para Ciencia de Datos', 'Ciencia de Datos');
INSERT INTO curso (nombre, categoria) VALUES ('Diseño de Bases de Datos', 'Gestión de Bases de Datos');

INSERT INTO perfil (nombre) VALUES ('Administrador del Foro');
INSERT INTO perfil (nombre) VALUES ('Profesor');
INSERT INTO perfil (nombre) VALUES ('Estudiante Activo');
INSERT INTO perfil (nombre) VALUES ('Estudiante Invitado');
INSERT INTO perfil (nombre) VALUES ('Moderador del Foro');

INSERT INTO usuario_perfil (usuario_id, perfil_id) VALUES (1, 3);