package cl.capstone.ms_gestion_transporte.service;

import java.util.List;

import cl.capstone.ms_gestion_transporte.model.TipoTraslado;

public interface ITipoTrasladoService {

    public List<TipoTraslado> getTipoTraslados();

    public void saveTipoTraslado(TipoTraslado tipoTraslado);

    public void deleteTipoTraslado(Long id);

    public TipoTraslado findTipoTraslado(Long id);

    public void editTipoTraslado(TipoTraslado tipoTraslado);
}
