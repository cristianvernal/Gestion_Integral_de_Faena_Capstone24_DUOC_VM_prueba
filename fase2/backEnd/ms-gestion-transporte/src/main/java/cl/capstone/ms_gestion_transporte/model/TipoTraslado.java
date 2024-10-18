package cl.capstone.ms_gestion_transporte.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name = "TIPO_TRASLADO")
public class TipoTraslado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPO_TRASLADO", nullable = false)
    private Long idTraslado;

    @Column(name = "TIPO_TRASLADO", nullable = false)
    private String tipoTraslado;

    @Column(name = "DESCRIPCION", nullable = false)
    private String descripcion;

}
