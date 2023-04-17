package com.inetum.apialumno.service;

import com.inetum.apialumno.dto.CursosDto;
import com.inetum.apialumno.dto.ResposeDto;
import com.inetum.apialumno.entity.Alumno;
import com.inetum.apialumno.entity.Curso;
import com.inetum.apialumno.proxy.CursoProxy;
import com.inetum.apialumno.repository.AlumnoRepository;
import com.inetum.apialumno.service.exception.ExceptionService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 Class AlumnoServiceImpl (Esta clase es la capa service que contiene la logica del negocio)
 * @author Celso Calla
 * @version 1.0
 * @since 2023-04-17
 */
@Slf4j
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
    @HystrixCommand
    public ResposeDto getCursosAll() throws ExceptionService {
        try {
            List<Curso> curList = cursoProxy.readAll();
            List<Alumno> aluList = alumnoRepository.findAll();
            return ResposeDto.builder()
                    .codigo("0")
                    .mensaje("Proceso exitoso.")
                    .data(CursosDto.builder()
                            .alumno(aluList)
                            .curso(curList)
                            .build())
                    .build();
        }catch(Exception e){
            log.error(e.getMessage());
            throw new ExceptionService(e);
        }
    }
}
