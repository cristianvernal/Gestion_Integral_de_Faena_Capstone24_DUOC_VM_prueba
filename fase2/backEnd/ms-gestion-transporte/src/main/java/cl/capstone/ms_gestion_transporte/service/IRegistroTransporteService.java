package cl.capstone.ms_gestion_transporte.service;

import java.util.List;

import cl.capstone.ms_gestion_transporte.model.RegistroTransporte;

public interface IRegistroTransporteService {

    public List<RegistroTransporte> getRegistroTransportes();

    public void saveRegistroTransporte(RegistroTransporte registroTransporte);

    public void deleteRegistroTransporte(Long id);

    public RegistroTransporte findRegistroTransporte(Long id);

    public void editRegistroTransporte(RegistroTransporte registroTransporte);
}
