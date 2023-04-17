package com.inetum.apialumno.proxy.fallback;

import com.google.common.collect.Lists;
import com.inetum.apialumno.entity.Curso;
import com.inetum.apialumno.proxy.CursoProxy;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 Class CursoHystrixFallbackFactory (Esta clase permite el Fallback)
 * @author Celso Calla
 * @version 1.0
 * @since 2023-04-17
 */
@Component
public class CursoHystrixFallbackFactory implements CursoProxy {

	@Override
	public List<Curso> readAll() {
		List<Curso> c = Lists.newArrayList();
		Curso cur = Curso.builder()
				.codigo("No asignado")
				.descripcion("Sin nombre")
				.cod_alumno("Sin nombre")
				.cod_profesor("No asignado")
				.build();
		c.add(cur);
		return c;
	}

}
