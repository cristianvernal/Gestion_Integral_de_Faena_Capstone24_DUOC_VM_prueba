package cl.capstone.ms_gestion_trabajadores.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.capstone.ms_gestion_trabajadores.model.TipoCumplimiento;

@Repository
public interface ITipoCumplimientoRepository extends JpaRepository<TipoCumplimiento, Long> {

}
