package cl.capstone.ms_gestion_transporte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.capstone.ms_gestion_transporte.model.TipoTransporte;
import cl.capstone.ms_gestion_transporte.repository.ITipoTransporteRepository;

@Service
public class TipoTransporteService implements ITipoTransporteService {

    @Autowired
    ITipoTransporteRepository tipoTransporteRepository;

    @Override
    public List<TipoTransporte> getTipoTransportes() {

        List<TipoTransporte> listaTransportes = tipoTransporteRepository.findAll();
        return listaTransportes;
    }

    @Override
    public void saveTipoTransporte(TipoTransporte tipoTransporte) {

        tipoTransporteRepository.save(tipoTransporte);

    }

    @Override
    public void deleteTipoTransporte(Long id) {

        tipoTransporteRepository.deleteById(id);

    }

    @Override
    public TipoTransporte findTipoTransporte(Long id) {

        TipoTransporte tipoTransporte = tipoTransporteRepository.findById(id).orElse(null);
        return tipoTransporte;
    }

    @Override
    public void editTipoTransporte(TipoTransporte tipoTransporte) {

        this.saveTipoTransporte(tipoTransporte);

    }

}
