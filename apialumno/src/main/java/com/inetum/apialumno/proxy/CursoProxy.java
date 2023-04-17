package com.inetum.apialumno.proxy;

import com.inetum.apialumno.entity.Curso;
import com.inetum.apialumno.proxy.fallback.CursoHystrixFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 *
 Class CursoProxy (Esta interface permite el consumo de otra api)
 * @author Celso Calla
 * @version 1.0
 * @since 2023-04-17
 */
@FeignClient(name = "apicurso", fallback = CursoHystrixFallbackFactory.class, url = "http://localhost:8088")
public interface CursoProxy {
    @GetMapping("/api/cursos")
    List<Curso> readAll();
}