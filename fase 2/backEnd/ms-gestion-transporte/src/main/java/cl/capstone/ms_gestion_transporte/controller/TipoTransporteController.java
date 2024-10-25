package cl.capstone.ms_gestion_transporte.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.capstone.ms_gestion_transporte.model.Response;
import cl.capstone.ms_gestion_transporte.model.TipoTransporte;
import cl.capstone.ms_gestion_transporte.service.ITipoTransporteService;

@RestController
public class TipoTransporteController {

    @Autowired
    ITipoTransporteService tipoTransporteService;

    @PostMapping("/tipotransporte/crear")
    public String saveTipoTransporte(@RequestBody TipoTransporte tipoTransporte) {

        // Response response = new Response();
        // LocalDateTime currentDate = LocalDateTime.now();

        tipoTransporteService.saveTipoTransporte(tipoTransporte);
        return "Tipo de transporte creado";
    }

    @DeleteMapping("/tipotransporte/borrar/{id}")
    public ResponseEntity<Response> deleteTipoTransporte(@PathVariable Long id) {

        Response response = new Response();
        LocalDateTime currentDate = LocalDateTime.now();

        TipoTransporte tipoTransporte = tipoTransporteService.findTipoTransporte(id);

        if (tipoTransporte != null) {
            // Si existe el trabajador, procedemos a eliminarlo
            tipoTransporteService.deleteTipoTransporte(id);
            response.setCodigoRetorno(0); // Código de éxito
            response.setGlosaRetorno("Tipo de transporte eliminado.");
            response.setResultado(tipoTransporte);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            // Si el trabajador no existe, retornamos un mensaje de error
            response.setCodigoRetorno(-1); // Código de error
            response.setGlosaRetorno("No se encontró el tipo de transporte.");
            response.setResultado(null);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/tipotransporte/editar/")
    public TipoTransporte editTipoTransporte(@RequestBody TipoTransporte tipoTransporte) {
        tipoTransporteService.editTipoTransporte(tipoTransporte);

        return tipoTransporteService.findTipoTransporte(tipoTransporte.getIdTransporte());
    }

    @GetMapping("/tipotransporte/traer/{id}")
    public ResponseEntity<Response> getTipoTransporteById(@PathVariable Long id) {

        Response response = new Response();
        LocalDateTime currentDate = LocalDateTime.now();

        TipoTransporte tipoTransporte = tipoTransporteService.findTipoTransporte(id);

        if (tipoTransporte == null) {
            response.setCodigoRetorno(-1);
            response.setGlosaRetorno("Transporte no encotrado.");
            response.setResultado(tipoTransporte);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            response.setCodigoRetorno(0);
            response.setGlosaRetorno("Transporte encontrado.");
            response.setResultado(tipoTransporte);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/tipotransporte/traer")
    public ResponseEntity<Response> getTipoTransporte() {

        List<TipoTransporte> tipoTransportes = tipoTransporteService.getTipoTransportes();
        Response response = new Response();
        LocalDateTime currentDate = LocalDateTime.now();

        if (tipoTransportes == null || tipoTransportes.isEmpty()) {
            response.setCodigoRetorno(-1);
            response.setGlosaRetorno("Tipos de transporte no encotrados.");
            response.setResultado(tipoTransportes);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            response.setCodigoRetorno(0);
            response.setGlosaRetorno("Tipos de transportes encontrados.");
            response.setResultado(tipoTransportes);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    }

}
