package cl.capstone.ms_gestion_transporte.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.capstone.ms_gestion_transporte.model.Response;
import cl.capstone.ms_gestion_transporte.model.TipoTraslado;
import cl.capstone.ms_gestion_transporte.service.ITipoTrasladoService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*") // CORS para todos los endpoints en esta clase
public class TipoTransladoController {

    @Autowired
    ITipoTrasladoService tipoTrasladoService;

    @PostMapping("/tipotraslado/crear")
    public ResponseEntity<Response> saveTipoTraslado(@RequestBody TipoTraslado tipoTraslado) {

        Response response = new Response();
        LocalDateTime currentDate = LocalDateTime.now();

        TipoTraslado nuevoTipoTraslado = tipoTrasladoService.saveTipoTraslado(tipoTraslado);

        if (nuevoTipoTraslado != null) {
            // Si existe el trabajador, procedemos a eliminarlo
            response.setCodigoRetorno(0); // Código de éxito
            response.setGlosaRetorno("Nuevo tipo de traslado creado.");
            response.setResultado(nuevoTipoTraslado);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            // Si el trabajador no existe, retornamos un mensaje de error
            response.setCodigoRetorno(-1); // Código de error
            response.setGlosaRetorno("No se pudo crear el registro.");
            response.setResultado(null);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/tipotraslado/borrar/{id}")
    public ResponseEntity<Response> deleteTipoTraslado(@PathVariable Long id) {

        Response response = new Response();
        LocalDateTime currentDate = LocalDateTime.now();

        TipoTraslado tipoTraslado = tipoTrasladoService.findTipoTraslado(id);

        if (tipoTraslado != null) {
            // Si existe el trabajador, procedemos a eliminarlo
            tipoTrasladoService.deleteTipoTraslado(id);
            response.setCodigoRetorno(0); // Código de éxito
            response.setGlosaRetorno("Tipo de traslado eliminado.");
            response.setResultado(tipoTraslado);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            // Si el trabajador no existe, retornamos un mensaje de error
            response.setCodigoRetorno(-1); // Código de error
            response.setGlosaRetorno("No se encontró el tipo de traslado.");
            response.setResultado(null);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/tipotraslado/editar/")
    public TipoTraslado editTipoTranslado(@RequestBody TipoTraslado tipoTraslado) {
        tipoTrasladoService.editTipoTraslado(tipoTraslado);

        return tipoTrasladoService.findTipoTraslado(tipoTraslado.getIdTraslado());
    }

    @GetMapping("/tipotraslado/traer/{id}")
    public ResponseEntity<Response> getTipoTrasladoById(@PathVariable Long id) {

        Response response = new Response();
        LocalDateTime currentDate = LocalDateTime.now();

        TipoTraslado tipoTraslado = tipoTrasladoService.findTipoTraslado(id);

        if (tipoTraslado == null) {
            response.setCodigoRetorno(-1);
            response.setGlosaRetorno("traslado no encotrado.");
            response.setResultado(tipoTraslado);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            response.setCodigoRetorno(0);
            response.setGlosaRetorno("traslado encontrado.");
            response.setResultado(tipoTraslado);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/tipotraslado/traer")
    public ResponseEntity<Response> getTipoTransporte() {

        List<TipoTraslado> tipoTraslados = tipoTrasladoService.getTipoTraslados();
        Response response = new Response();
        LocalDateTime currentDate = LocalDateTime.now();

        if (tipoTraslados == null || tipoTraslados.isEmpty()) {
            response.setCodigoRetorno(-1);
            response.setGlosaRetorno("Tipos de translados no encotrados.");
            response.setResultado(tipoTraslados);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            response.setCodigoRetorno(0);
            response.setGlosaRetorno("Tipos de translados encontrados.");
            response.setResultado(tipoTraslados);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    }

}
