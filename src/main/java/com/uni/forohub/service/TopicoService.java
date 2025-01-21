package com.uni.forohub.service;

import com.uni.forohub.clase.Curso;
import com.uni.forohub.clase.Topico;
import com.uni.forohub.clase.Usuario;
import com.uni.forohub.dto.*;
import com.uni.forohub.repository.CursoRepository;
import com.uni.forohub.repository.TopicoRepository;
import com.uni.forohub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Transactional
    public TopicoRespuestaDTO registrarTopico(TopicoRegistroDTO dto) {

        if (repository.existsByTituloAndMensaje(dto.titulo(), dto.mensaje())) {
            throw new IllegalArgumentException("El tópico con el mismo título y mensaje ya existe.");
        }

        Usuario autor = usuarioRepository.findById(dto.autorId())
                .orElseThrow(() -> new IllegalArgumentException("Autor no encontrado."));

        Curso curso = cursoRepository.findByNombre(dto.nombreCurso())
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado."));

        Topico topico = new Topico(dto, autor, curso);
        Topico topicoGuardado = repository.save(topico);

        return new TopicoRespuestaDTO(
                topicoGuardado.getId(),
                topicoGuardado.getTitulo(),
                topicoGuardado.getMensaje(),
                topicoGuardado.getFechaCreacion()
        );
    }

    public Page<TopicoListadoDTO> listarTopicos(Pageable paginacion) {
        return repository.findAll(paginacion)
                .map(topico -> new TopicoListadoDTO(
                        topico.getId(),
                        topico.getTitulo(),
                        topico.getMensaje(),
                        topico.getAutor().getNombre(),
                        topico.getCurso().getNombre(),
                        topico.getFechaCreacion(),
                        topico.getEstado()
                ));
    }

    public TopicoDetalleDTO obtenerDetalleTopico(Long id) {
        Topico topico = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tópico no encontrado con el ID proporcionado."));

        return new TopicoDetalleDTO(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getEstado(),
                topico.getAutor().getNombre(),
                topico.getCurso().getNombre()
        );
    }

    @Transactional
    public TopicoDetalleDTO actualizarTopico(Long id, TopicoActualizacionDTO dto) {
        Topico topico = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tópico no encontrado con el ID proporcionado."));

        if (dto.titulo() != null && !dto.titulo().isBlank()) {
            topico.setTitulo(dto.titulo());
        }
        if (dto.mensaje() != null && !dto.mensaje().isBlank()) {
            topico.setMensaje(dto.mensaje());
        }
        if (dto.estado() != null) {
            topico.setEstado(dto.estado());
        }

        Topico actualizado = repository.save(topico);

        return new TopicoDetalleDTO(
                actualizado.getId(),
                actualizado.getTitulo(),
                actualizado.getMensaje(),
                actualizado.getFechaCreacion(),
                actualizado.getEstado(),
                actualizado.getAutor().getNombre(),
                actualizado.getCurso().getNombre()
        );
    }

    @Transactional
    public void eliminarTopico(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Tópico no encontrado con el ID proporcionado.");
        }
        repository.deleteById(id);
    }
}
