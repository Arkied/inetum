package com.inetum.apialumno.dto;

import com.inetum.apialumno.entity.Alumno;
import com.inetum.apialumno.entity.Curso;
import lombok.*;

import java.util.List;

/**
 * @author : Celso Calla
 * @descripción : Class CursosDto (Esta clase contiene metodos y atributos)
 * @fecha_de_creación : 17-04-2023
 * @fecha_de_ultima_actualización : 17-04-2023
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CursosDto {
    private List<Alumno> alumno;
    private List<Curso> curso;
}
