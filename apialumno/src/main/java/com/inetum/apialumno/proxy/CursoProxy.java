package com.inetum.apialumno.proxy;

import com.inetum.apialumno.entity.Curso;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "apicurso")
public interface CursoProxy {
    @GetMapping("/api/cursos")
    List<Curso> readAll();
}