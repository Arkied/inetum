package com.inetum.apialumno.service;

import com.inetum.apialumno.entity.Alumno;
import com.inetum.apialumno.dto.ResposeDto;
import com.inetum.apialumno.service.exception.ExceptionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 *
 Class AlumnoService (Es la interface de Alumno service )
 * @author Celso Calla
 * @version 1.0
 * @since 2023-04-17
 */
public interface AlumnoService {
    public Iterable<Alumno> findAll();
    public Page<Alumno> findAll(Pageable pageable);
    public Optional<Alumno> findById(Long id);
    public Alumno save(Alumno alumno);
    public void deleteById(Long id);
    public ResposeDto getCursosAll() throws ExceptionService;
}
