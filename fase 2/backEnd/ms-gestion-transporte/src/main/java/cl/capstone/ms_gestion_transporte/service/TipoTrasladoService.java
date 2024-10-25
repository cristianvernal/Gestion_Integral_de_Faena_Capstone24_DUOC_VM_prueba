package cl.capstone.ms_gestion_transporte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.capstone.ms_gestion_transporte.model.TipoTraslado;
import cl.capstone.ms_gestion_transporte.repository.ITipoTransladoRepository;

@Service
public class TipoTrasladoService implements ITipoTrasladoService {

    @Autowired
    ITipoTransladoRepository tipoTrasladoRepository;

    @Override
    public List<TipoTraslado> getTipoTraslados() {

        List<TipoTraslado> listaTipoTraslados = tipoTrasladoRepository.findAll();
        return listaTipoTraslados;
    }

    @Override
    public void saveTipoTraslado(TipoTraslado tipoTraslado) {

        tipoTrasladoRepository.save(tipoTraslado);
    }

    @Override
    public void deleteTipoTraslado(Long id) {

        tipoTrasladoRepository.deleteById(id);
    }

    @Override
    public TipoTraslado findTipoTraslado(Long id) {

        TipoTraslado tipoTraslado = tipoTrasladoRepository.findById(id).orElse(null);
        return tipoTraslado;
    }

    @Override
    public void editTipoTraslado(TipoTraslado tipoTraslado) {

        this.saveTipoTraslado(tipoTraslado);

    }

}
