package com.inetum.apialumno.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Celso Calla
 * @descripción : Class ResposeDto (Esta clase contiene el Body Response del api)
 * @fecha_de_creación : 17-04-2023
 * @fecha_de_ultima_actualización : 17-04-2023
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResposeDto {

    private String codigo;
    private String mensaje;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

}
