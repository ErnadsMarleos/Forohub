
CREATE TABLE usuario_perfil (
    usuario_id BIGINT NOT NULL REFERENCES usuario(id),
    perfil_id BIGINT NOT NULL REFERENCES perfil(id),
    PRIMARY KEY (usuario_id, perfil_id)
);
