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
@Table(name = "TIPO_TRANSPORTE")
public class TipoTransporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPO_TRANSPORTE", nullable = false)
    private Long idTransporte;

    @Column(name = "TIPO_TRANSPORTE", nullable = false)
    private String tipoTransporte;

    @Column(name = "DESCRIPCION", nullable = false)
    private String descripcion;
}
