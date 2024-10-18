package cl.capstone.ms_gestion_transporte.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name = "REGISTRO_TRANSLADOS")
public class RegistroTransporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_REGISTRO", nullable = false)
    private Long idRegistro;

    @Column(name = "TRABAJADOR_ID", nullable = false)
    private Long idTrabajador;

    @Column(name = "INICIO_FECHA_TRANSLADO", nullable = false)
    private LocalDateTime inicioFechaTranslado;

    @Column(name = "TERMINO_FECHA_TRANSLADO", nullable = false)
    private LocalDateTime terminoFechaTranslado;

    @Column(name = "TRANSLADO_DESDE", nullable = false)
    private String transladoDesde;

    @Column(name = "TRANSLADO_HASTA", nullable = false)
    private String transladoHasta;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_TRANSPORTE", referencedColumnName = "ID_TIPO_TRANSPORTE")
    private TipoTransporte tipoTransporteJoin;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_TRASLADO", referencedColumnName = "ID_TIPO_TRASLADO")
    private TipoTraslado tipoTrasladoJoin;
}
