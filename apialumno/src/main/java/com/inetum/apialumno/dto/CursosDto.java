package com.inetum.apialumno.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CursosDto {
    private String codAlumno;
    private String nombres;
    private String apellidos;
    private String codCurso;
    private String descripcion;
}
