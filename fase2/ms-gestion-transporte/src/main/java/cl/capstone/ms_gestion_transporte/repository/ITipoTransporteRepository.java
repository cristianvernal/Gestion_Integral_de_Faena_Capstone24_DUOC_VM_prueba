package cl.capstone.ms_gestion_transporte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.capstone.ms_gestion_transporte.model.TipoTransporte;

@Repository
public interface ITipoTransporteRepository extends JpaRepository<TipoTransporte, Long> {

}
