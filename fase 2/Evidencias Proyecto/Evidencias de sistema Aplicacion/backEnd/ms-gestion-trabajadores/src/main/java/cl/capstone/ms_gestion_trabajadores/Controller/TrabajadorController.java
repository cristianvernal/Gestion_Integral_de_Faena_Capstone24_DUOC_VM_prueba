package cl.capstone.ms_gestion_trabajadores.Controller;

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

import cl.capstone.ms_gestion_trabajadores.dto.TrabajadorDTO;
import cl.capstone.ms_gestion_trabajadores.model.Response;
import cl.capstone.ms_gestion_trabajadores.model.Trabajador;
import cl.capstone.ms_gestion_trabajadores.service.ITrabajadorService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*") // CORS para todos los endpoints en esta clase
public class TrabajadorController {

    @Autowired
    private ITrabajadorService iTrabajadorService;

    @PostMapping("/trabajadores/crear")
    public ResponseEntity<Response> saveTrabajador(@RequestBody Trabajador trabajador) {

        Response response = new Response();
        LocalDateTime currentDate = LocalDateTime.now();

        Trabajador nuevoTrabajador = iTrabajadorService
                .saveTrabajador(trabajador);

        // Verificar si se guardó correctamente
        if (nuevoTrabajador != null) {
            response.setCodigoRetorno(0); // Código de éxito
            response.setGlosaRetorno("Trabajador creado exitosamente.");
            response.setResultado(nuevoTrabajador);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            // En caso de fallo al guardar el TipoCumplimiento
            response.setCodigoRetorno(-1); // Código de error
            response.setGlosaRetorno("Error al crear el usuario.");
            response.setResultado(null);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/trabajadores/borrar/{id}")
    public ResponseEntity<Response> deleteTrabajador(@PathVariable Long id) {

        Response response = new Response();
        LocalDateTime currentDate = LocalDateTime.now();

        Trabajador trabajador = iTrabajadorService.findTrabajador(id);

        if (trabajador != null) {
            // Si existe el trabajador, procedemos a eliminarlo
            iTrabajadorService.deleteTrabajador(id);
            response.setCodigoRetorno(0); // Código de éxito
            response.setGlosaRetorno("Trabajador eliminado.");
            response.setResultado(trabajador);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            // Si el trabajador no existe, retornamos un mensaje de error
            response.setCodigoRetorno(-1); // Código de error
            response.setGlosaRetorno("No se encontró el trabajador.");
            response.setResultado(null);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/trabajadores/editar/")
    public ResponseEntity<Response> editTrabajador(@RequestBody Trabajador trabajador) {

        Response response = new Response();
        LocalDateTime currentDate = LocalDateTime.now();

        Trabajador Encontrartrabajador = iTrabajadorService.findTrabajador(trabajador.getIdTrabajador());

        if (Encontrartrabajador != null) {
            // Si existe el trabajador, procedemos a eliminarlo
            iTrabajadorService.editTrabajador(trabajador);
            response.setCodigoRetorno(0); // Código de éxito
            response.setGlosaRetorno("Trabajador modificado.");
            response.setResultado(Encontrartrabajador);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            // Si el trabajador no existe, retornamos un mensaje de error
            response.setCodigoRetorno(-1); // Código de error
            response.setGlosaRetorno("No se encontró el trabajador.");
            response.setResultado(null);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/trabajadores/traer/{id}")
    public ResponseEntity<Response> trabajador(@PathVariable Long id) {

        Response response = new Response();
        LocalDateTime currentDate = LocalDateTime.now();

        Trabajador trabajador = iTrabajadorService.findTrabajador(id);

        if (trabajador == null) {
            response.setCodigoRetorno(-1);
            response.setGlosaRetorno("Trabajador no encotrado.");
            response.setResultado(trabajador);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            response.setCodigoRetorno(0);
            response.setGlosaRetorno("Trabajador encontrado.");
            response.setResultado(trabajador);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/trabajadores/traer")
    public ResponseEntity<Response> getTrabajadores() {

        List<Trabajador> trabajadores = iTrabajadorService.getTrabajadores();
        Response response = new Response();
        LocalDateTime currentDate = LocalDateTime.now();

        if (trabajadores == null || trabajadores.isEmpty()) {
            response.setCodigoRetorno(-1);
            response.setGlosaRetorno("Trabajadores no encotrados.");
            response.setResultado(trabajadores);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            response.setCodigoRetorno(0);
            response.setGlosaRetorno("Trabajadores encontrados.");
            response.setResultado(trabajadores);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    }

    @GetMapping("/trabajadores/traer/nombre/{nombre}")
    public TrabajadorDTO trabajadorByNombre(String nombre) {

        return iTrabajadorService.findByPrimerNombre(nombre);

    }

    @GetMapping("/trabajadores/traer/apellido/{apellido}")
    public String trabajadorByApellido(String apellido) {

        return iTrabajadorService.findByPrimerApellido(apellido);

    }

    @GetMapping("/trabajadores/traer/{comuna}/{apellido}")
    public Trabajador trabajadorByComunaApellido(String comuna, String apellido) {

        return iTrabajadorService.findByComunaAndPrimerApellido(comuna, apellido);

    }

    @GetMapping("/trabajadores/traer/run/{run}")
    public Trabajador trabajadorByComunaApellido(String run) {

        return iTrabajadorService.findByRun(run);

    }

}
