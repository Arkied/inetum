package com.inetum.apialumno.service;

import com.inetum.apialumno.dto.CursosDto;
import com.inetum.apialumno.entity.Alumno;
import com.inetum.apialumno.entity.Curso;
import com.inetum.apialumno.proxy.CursoProxy;
import com.inetum.apialumno.repository.AlumnoRepository;
import org.glassfish.jersey.internal.guava.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private CursoProxy cursoProxy;

    @Override
    public Iterable<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    @Override
    public Page<Alumno> findAll(Pageable pageable) {
        return alumnoRepository.findAll(pageable);
    }

    @Override
    public Optional<Alumno> findById(Long id) {
        return alumnoRepository.findById(id);
    }

    @Override
    public Alumno save(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public void deleteById(Long id) {
        alumnoRepository.deleteById(id);
    }

    @Override
    public Iterable<CursosDto> getCursosAll() {
        List<Curso> curDto = cursoProxy.readAll();
        List<CursosDto> cursosDtoList = new ArrayList<>();
        for (Curso c : curDto) {
            cursosDtoList.add(CursosDto.builder()
                    .codAlumno(c.getCod_alumno())
                    .descripcion(c.getDescripcion())
                    .build());
        }
        return cursosDtoList;
    }
}
