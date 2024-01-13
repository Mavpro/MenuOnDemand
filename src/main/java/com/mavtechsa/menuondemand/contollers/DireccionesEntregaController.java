package com.mavtechsa.menuondemand.contollers;

import com.mavtechsa.menuondemand.domain.dto.CustomResponse;
import com.mavtechsa.menuondemand.domain.dto.DireccionesEntregaDTO;
import com.mavtechsa.menuondemand.service.DireccionesEntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/direcciones")
public class DireccionesEntregaController {
@Autowired
DireccionesEntregaService direccionesEntregaService;


@GetMapping
    public ResponseEntity<CustomResponse<List<DireccionesEntregaDTO>>> getAllDireccionesCliente (@RequestParam(required = false) Long  idCliente){
    CustomResponse<List<DireccionesEntregaDTO>> response = new CustomResponse<>();
    try{
        List<DireccionesEntregaDTO>  direcciones = new ArrayList<>();
        if(idCliente==null){
            response.setError(true);
            response.setMessage("No se selecciono un cliente para mostrar las direcciones");
            response.setData(null);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }else {
            direcciones=direccionesEntregaService.obtenerTodasLasDireccionesEntregaDeCliente(idCliente);
        }
        if(direcciones.isEmpty()|| direcciones.size()==0){
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
    }catch (Exception e){
        response.setError(true);
        response.setMessage("Error, no se puede lograr la solicitud.");
        response.setData(null);
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}


}
