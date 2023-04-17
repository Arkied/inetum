package com.inetum.apialumno.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author : Celso Calla
 * @descripción : Class Curso (Esta clase contiene metodos y atributos del curso)
 * @fecha_de_creación : 17-04-2023
 * @fecha_de_ultima_actualización : 17-04-2023
 */
@Entity
@Table(name = "curso")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "codigo_c")
    private String codigo;
    @Column(name = "descripcion", length = 50)
    private String descripcion;
    @Column(name = "cod_prof", length = 3)
    private String cod_profesor;
    @Column(name = "codigo_alum", length = 5)
    private String cod_alumno;
}
