package com.inetum.apialumno.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

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
