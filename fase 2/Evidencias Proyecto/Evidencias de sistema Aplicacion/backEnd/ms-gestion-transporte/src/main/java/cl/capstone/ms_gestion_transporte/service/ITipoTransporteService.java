package cl.capstone.ms_gestion_transporte.service;

import java.util.List;

import cl.capstone.ms_gestion_transporte.model.TipoTransporte;

public interface ITipoTransporteService {

    public List<TipoTransporte> getTipoTransportes();

    public TipoTransporte saveTipoTransporte(TipoTransporte tipoTransporte);

    public void deleteTipoTransporte(Long id);

    public TipoTransporte findTipoTransporte(Long id);

    public void editTipoTransporte(TipoTransporte tipoTransporte);
}
