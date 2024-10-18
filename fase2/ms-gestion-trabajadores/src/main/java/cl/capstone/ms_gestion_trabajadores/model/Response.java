package cl.capstone.ms_gestion_trabajadores.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Response {

    private int codigoRetorno;
    private String glosaRetorno;
    private Object resultado;
    private LocalDateTime timestamp;
}
