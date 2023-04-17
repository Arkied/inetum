package com.inetum.apialumno.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author : Celso Calla
 * @descripción : Class Alumno (Esta clase contiene metodos y atributos del alumno)
 * @fecha_de_creación : 17-04-2023
 * @fecha_de_ultima_actualización : 17-04-2023
 */
@Entity
@Table(name = "alumno")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alumno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "codigo_alu")
    private String codigo;
    @Column(name = "apellidos", length = 50)
    private String apellidos;
    @Column(name = "nombres", length = 50)
    private String nombres;
    @Column(name = "sexo", length = 1)
    private String sexo;

}
