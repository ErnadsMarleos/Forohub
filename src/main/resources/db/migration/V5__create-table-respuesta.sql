
CREATE TABLE respuesta (
    id SERIAL PRIMARY KEY,
    mensaje TEXT NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    solucion BOOLEAN DEFAULT FALSE,
    autor_id BIGINT NOT NULL REFERENCES usuario(id),
    topico_id BIGINT NOT NULL REFERENCES topico(id)
);