package com.mavtechsa.menuondemand.contollers;

import com.mavtechsa.menuondemand.domain.dto.ClienteDTO;
import com.mavtechsa.menuondemand.domain.dto.CustomResponse;
import com.mavtechsa.menuondemand.domain.dto.DireccionesEntregaDTO;
import com.mavtechsa.menuondemand.service.ClienteService;
import com.mavtechsa.menuondemand.service.DireccionesEntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/api/direcciones")
public class DireccionesEntregaController {
    @Autowired
    DireccionesEntregaService direccionesEntregaService;
    @Autowired

    ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<List<DireccionesEntregaDTO>>> getAllDireccionesClientebyId(@PathVariable("id") Long id_cliente) {
        CustomResponse<List<DireccionesEntregaDTO>> response = new CustomResponse<>();
        try {
            if (clienteService.obtenerClientePorId(id_cliente).isEmpty()|| clienteService.obtenerClientePorId(id_cliente).get().isEliminado()) {

                response.setError(true);
                response.setMessage("El cliente no existe");
                response.setData(null);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            List<DireccionesEntregaDTO> direcciones = new ArrayList<>();
            direcciones=direccionesEntregaService.obtenerTodasLasDireccionesEntregaDeCliente(id_cliente);
            if (direcciones.isEmpty()){
                response.setError(true);
                response.setMessage("El cliente no tiene direcciones asignadas");
                response.setData(null);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }else {
                response.setError(false);
                response.setMessage("Listado de direcciones exitoso");
                response.setData(direcciones);
                return new ResponseEntity<>(response,HttpStatus.OK);
            }

        } catch (Exception e) {
            response.setError(true);
            response.setMessage("Error, no se puede lograr la solicitud.");
            response.setData(null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }







    @PostMapping
    public ResponseEntity<CustomResponse<DireccionesEntregaDTO>> save (@RequestBody DireccionesEntregaDTO body){
        CustomResponse<DireccionesEntregaDTO> response = new CustomResponse<>();
        try {
            if (direccionesEntregaService.existByDireccion(body.getDireccion())) {
                response.setMessage("La direccion ya existe");
                response.setError(true);
                return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
            }
            //si el ClienteDTO body no esta registrado entonces lo guarda
            DireccionesEntregaDTO persistDireccion = direccionesEntregaService.crearDireccionEntrega(body);
            response.setMessage("Direccion registrada correctamente");
            response.setError(false);
            response.setData(persistDireccion);
            return new ResponseEntity(response, HttpStatus.OK);

        }catch (Exception e){ // en caso de que algo falló
            response.setMessage("Fallo la creacion de la direccion: " + e.getMessage());
            response.setError(true);
            response.setData(null);
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);

        }
    }




}
