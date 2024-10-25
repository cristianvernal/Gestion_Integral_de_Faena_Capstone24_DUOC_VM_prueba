package cl.capstone.ms_gestion_transporte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.capstone.ms_gestion_transporte.model.RegistroTransporte;
import cl.capstone.ms_gestion_transporte.repository.IRegistroTransporteRepository;

@Service
public class RegistroTransporteService implements IRegistroTransporteService {

    @Autowired
    IRegistroTransporteRepository registroTransporteRepository;

    @Override
    public List<RegistroTransporte> getRegistroTransportes() {

        List<RegistroTransporte> listaRegistros = registroTransporteRepository.findAll();
        return listaRegistros;
    }

    @Override
    public void saveRegistroTransporte(RegistroTransporte registroTransporte) {

        registroTransporteRepository.save(registroTransporte);

    }

    @Override
    public void deleteRegistroTransporte(Long id) {

        registroTransporteRepository.deleteById(id);

    }

    @Override
    public RegistroTransporte findRegistroTransporte(Long id) {

        RegistroTransporte registroTransporte = registroTransporteRepository.findById(id).orElse(null);
        return registroTransporte;
    }

    @Override
    public void editRegistroTransporte(RegistroTransporte registroTransporte) {

        this.saveRegistroTransporte(registroTransporte);
    }

}
