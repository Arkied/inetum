package com.inetum.apialumno.controller;

import com.inetum.apialumno.dto.ResposeDto;
import com.inetum.apialumno.entity.Alumno;
import com.inetum.apialumno.service.AlumnoService;
import com.inetum.apialumno.service.exception.ExceptionService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 *
 Class AlumnoController (Esta clase es la capa controlador)
 * @author Celso Calla
 * @version 1.0
 * @since 2023-04-17
 */
@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;

    @ApiOperation(value = "Metodo para crear alumno")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Alumno alumno) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.save(alumno));
    }

    @ApiOperation(value = "Metodo para obtener un alumno")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) {
        Optional<Alumno> oAlumno = alumnoService.findById(id);

        return ResponseEntity.ok(oAlumno);
    }

    @ApiOperation(value = "Metodo para actualizar alumno")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Alumno alumnoDetails, @PathVariable Long id) {
        Optional<Alumno> alumno = alumnoService.findById(id);
        if (!alumno.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        alumno.get().setCodigo(alumnoDetails.getCodigo());
        alumno.get().setApellidos(alumnoDetails.getApellidos());
        alumno.get().setNombres(alumnoDetails.getNombres());
        alumno.get().setSexo(alumnoDetails.getSexo());

        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.save(alumno.get()));
    }

    @ApiOperation(value = "Metodo para eliminar alumno")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!alumnoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        alumnoService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Metodo para listar alumnos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    @GetMapping
    public List<Alumno> readAll() {
        return StreamSupport
                .stream(alumnoService.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Metodo para listar alumnos-cursos (ApiCurso)")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    @GetMapping("/cursos-all")
    @HystrixCommand
    public ResposeDto getCursosAll() throws ExceptionService {
        return alumnoService.getCursosAll();
    }
}
