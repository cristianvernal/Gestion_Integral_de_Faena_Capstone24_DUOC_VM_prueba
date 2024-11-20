package cl.capstone.ms_gestion_trabajadores.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.capstone.ms_gestion_trabajadores.Repository.ITrabajadorFaenaRepository;
import cl.capstone.ms_gestion_trabajadores.model.Trabajador;
import cl.capstone.ms_gestion_trabajadores.model.TrabajadorFaena;

@Service
public class TrabajadorFaenaService implements ITrabajadorFaenaService {

    @Autowired
    ITrabajadorFaenaRepository trabajadorFaenaRepository;

    @Override
    public List<TrabajadorFaena> getRegistros() {
        List<TrabajadorFaena> listaRegistros = trabajadorFaenaRepository.findAll();
        return listaRegistros;
    }

    @Override
    public TrabajadorFaena saveRegistro(TrabajadorFaena trabajadorFaena) {

        trabajadorFaenaRepository.save(trabajadorFaena);
        return trabajadorFaena;
    }

    @Override
    public void deleteRegistro(Long id) {

        trabajadorFaenaRepository.deleteById(id);
    }

    @Override
    public TrabajadorFaena findRegistro(Long id) {

        TrabajadorFaena registro = trabajadorFaenaRepository.findById(id).orElse(null);
        return registro;
    }

    @Override
    public void editCargo(TrabajadorFaena trabajadorFaena) {

        this.saveRegistro(trabajadorFaena);
    }

}
