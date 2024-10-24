package cl.capstone.ms_registro_asistencia.model;

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
@Table(name = "REGISTRO_ASISTENCIA")
public class RegistroAsistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_REGISTRO", nullable = false)
    private Long idRegistro;

    @Column(name = "ID_TRABAJADOR", nullable = false)
    private Long idTrabajador;

    @Column(name = "FECHA_HORA", nullable = false)
    private LocalDateTime fechaHora;

    @Column(name = "ASISTENCIA", nullable = false)
    private Boolean asistencia;

    @ManyToOne
    @JoinColumn(name = "TIPO_REGISTRO", referencedColumnName = "ID_TIPO_REGISTRO")
    private TipoRegistro tipoRegistroJoin;

}
