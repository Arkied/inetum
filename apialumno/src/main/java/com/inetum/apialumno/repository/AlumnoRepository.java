package com.inetum.apialumno.repository;

import com.inetum.apialumno.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 Object AlumnoRepository (Esta interface permite el acceso a la BD)
 * @author Celso Calla
 * @version 1.0
 * @since 2023-04-17
 */
@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
