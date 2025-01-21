
CREATE TABLE topico (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensaje TEXT NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado VARCHAR(50) NOT NULL,
    autor_id BIGINT NOT NULL REFERENCES usuario(id),
    curso_id BIGINT NOT NULL REFERENCES curso(id)
);