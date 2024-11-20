package cl.capstone.ms_gestion_trabajadores.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TrabajadorFaenaDTO {
    private Long idFaena;
    private Long runTrabajador;
    private int tipoCumplimiento = 2;
}
