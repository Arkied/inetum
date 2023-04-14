package com.inetum.apialumno.controller;

import com.inetum.apialumno.entity.Alumno;
import com.inetum.apialumno.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Alumno alumno) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.save(alumno));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) {
        Optional<Alumno> oAlumno = alumnoService.findById(id);
        if (!oAlumno.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oAlumno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Alumno alumnoDetails, @PathVariable Long id) {
        Optional<Alumno> alumno = alumnoService.findById(id);
        if (!alumno.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        alumno.get().setApellidos(alumnoDetails.getApellidos());
        alumno.get().setNombres(alumnoDetails.getNombres());
        alumno.get().setSexo(alumnoDetails.getSexo());

        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.save(alumno.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!alumnoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        alumnoService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Alumno> readAll() {
        return StreamSupport
                .stream(alumnoService.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
