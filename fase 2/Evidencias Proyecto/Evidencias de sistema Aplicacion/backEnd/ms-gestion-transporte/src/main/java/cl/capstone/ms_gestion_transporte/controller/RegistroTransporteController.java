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

import cl.capstone.ms_gestion_transporte.model.RegistroTransporte;
import cl.capstone.ms_gestion_transporte.model.Response;
import cl.capstone.ms_gestion_transporte.service.IRegistroTransporteService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*") // CORS para todos los endpoints en esta clase
public class RegistroTransporteController {

    @Autowired
    IRegistroTransporteService registroTransporteService;

    @PostMapping("/registrotransporte/crear")
    public ResponseEntity<Response> saveRegistroTransporte(@RequestBody RegistroTransporte registroTransporte) {

        Response response = new Response();
        LocalDateTime currentDate = LocalDateTime.now();

        RegistroTransporte nuevoRegistroTransporte = registroTransporteService
                .saveRegistroTransporte(registroTransporte);

        if (nuevoRegistroTransporte != null) {
            // Si existe el trabajador, procedemos a eliminarlo
            response.setCodigoRetorno(0); // Código de éxito
            response.setGlosaRetorno("Registro creado.");
            response.setResultado(nuevoRegistroTransporte);
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

    @DeleteMapping("/registrotransporte/borrar/{id}")
    public ResponseEntity<Response> deleteRegistroTransporte(@PathVariable Long id) {

        Response response = new Response();
        LocalDateTime currentDate = LocalDateTime.now();

        RegistroTransporte registroTransporte = registroTransporteService.findRegistroTransporte(id);

        if (registroTransporte != null) {
            // Si existe el trabajador, procedemos a eliminarlo
            registroTransporteService.deleteRegistroTransporte(id);
            response.setCodigoRetorno(0); // Código de éxito
            response.setGlosaRetorno("Registro de transporte eliminado.");
            response.setResultado(registroTransporte);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            // Si el trabajador no existe, retornamos un mensaje de error
            response.setCodigoRetorno(-1); // Código de error
            response.setGlosaRetorno("No se encontró el registro.");
            response.setResultado(null);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/registrotransporte/editar/")
    public RegistroTransporte editRegistroTransporte(@RequestBody RegistroTransporte registroTransporte) {
        registroTransporteService.editRegistroTransporte(registroTransporte);

        return registroTransporteService.findRegistroTransporte(registroTransporte.getIdRegistro());
    }

    @GetMapping("/registrotransporte/traer/{id}")
    public ResponseEntity<Response> getRegistroTransporteById(@PathVariable Long id) {

        Response response = new Response();
        LocalDateTime currentDate = LocalDateTime.now();

        RegistroTransporte registroTransporte = registroTransporteService.findRegistroTransporte(id);

        if (registroTransporte == null) {
            response.setCodigoRetorno(-1);
            response.setGlosaRetorno("Registro no encotrado.");
            response.setResultado(registroTransporte);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            response.setCodigoRetorno(0);
            response.setGlosaRetorno("Registro encontrado.");
            response.setResultado(registroTransporte);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/registrotransporte/traer")
    public ResponseEntity<Response> getRegistroTransporte() {

        List<RegistroTransporte> registroTransportes = registroTransporteService.getRegistroTransportes();
        Response response = new Response();
        LocalDateTime currentDate = LocalDateTime.now();

        if (registroTransportes == null || registroTransportes.isEmpty()) {
            response.setCodigoRetorno(-1);
            response.setGlosaRetorno("Registros no encotrados.");
            response.setResultado(registroTransportes);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            response.setCodigoRetorno(0);
            response.setGlosaRetorno("Registros encontrados.");
            response.setResultado(registroTransportes);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    }

}
