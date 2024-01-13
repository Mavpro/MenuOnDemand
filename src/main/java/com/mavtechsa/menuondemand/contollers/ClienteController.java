package com.mavtechsa.menuondemand.contollers;

import com.mavtechsa.menuondemand.domain.dto.ClienteDTO;
import com.mavtechsa.menuondemand.domain.dto.CustomResponse;

import com.mavtechsa.menuondemand.mapper.ClienteMapper;
import com.mavtechsa.menuondemand.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    ClienteService clienteService;
    ClienteMapper clienteMapper;


    @GetMapping
    public ResponseEntity<CustomResponse<List<ClienteDTO>>> getAllClientes(@RequestParam(required = false) String nombreYapellido ) {
        CustomResponse<List<ClienteDTO>> response = new CustomResponse<>();
        try {
            List<ClienteDTO> clientes = new ArrayList<>();
            if (nombreYapellido == null) {
                clientes.addAll(clienteService.obtenerTodosLosClientes()); // si no puso el nombre y el apellido deberia listar todos clientes
            } else {
                clienteService.obtenerClientesPorNombreYapellido(nombreYapellido).forEach(clientes::add); //aca te pone los clientes
            }
            //ahora evaluamos que pasa con el listado
            if (clientes.isEmpty() || clientes.size() == 0) {//bien no coincide con la busqueda o esta vacio aun sin poner parametros y traer todos los clientes
                response.setError(true);
                response.setMessage("No hay clientes para mostrar");
                response.setData(clientes);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
            else{
                response.setError(false);
                response.setMessage("Listado de clientes Exitoso");
                response.setData(clientes);
                return new ResponseEntity<>(response,HttpStatus.OK);
            }

        } catch (Exception e) {
            response.setError(true);
            response.setMessage("Error, no se puede lograr la solicitud.");
            response.setData(null);
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<CustomResponse<ClienteDTO>> save (@RequestBody ClienteDTO body){
       CustomResponse<ClienteDTO> response = new CustomResponse<>();
      try {
          if (clienteService.existByNombreYapellido(body.getNombreYapellido())) {
              response.setMessage("El nombre ya existe");
              response.setError(true);
              return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
          }
          if (clienteService.existByCorreo(body.getCorreo())) {
              response.setMessage("El correo ya existe");
              response.setError(true);
              response.setData(null);
              return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
          }

          //si el ClienteDTO body no esta registrado entonces lo guarda
          ClienteDTO persistClient = clienteService.crearCliente(body);
          response.setMessage("Cliente registrado correctamente");
          response.setError(false);
          response.setData(persistClient);
          return new ResponseEntity(response, HttpStatus.OK);

      }catch (Exception e){ // en caso de que algo falló
          response.setMessage("Fallo la creacion del usuario: " + e.getMessage());
          response.setError(true);
          response.setData(null);
          return new ResponseEntity(response, HttpStatus.BAD_REQUEST);

      }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomResponse<ClienteDTO>> update (@RequestBody ClienteDTO body,@PathVariable Long id ){
    CustomResponse<ClienteDTO> response = new CustomResponse<>();

    try{
        Optional<ClienteDTO> entity = clienteService.obtenerClientePorId(id);
        if(entity.isPresent()){
            body.setId_cliente(id);
            ClienteDTO persist = clienteService.actualizarCliente(id,body);
            response.setData(persist);
            response.setError(false);
            response.setMessage("Cliente actualizado correctamente");
        }else {
            response.setMessage("Cliente no encontrado");
            response.setError(true);
            response.setData(null);
        }
        return new ResponseEntity(response,HttpStatus.OK);


    }catch (Exception e){
        response.setData(null);
        response.setError(true);
        response.setMessage("Cliente no se actualizó.");
        return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
    }

    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<ClienteDTO>> findById (@PathVariable("id") Long id) {
        CustomResponse<ClienteDTO> response = new CustomResponse<>();
        try {
            Optional<ClienteDTO> entity = clienteService.obtenerClientePorId(id);
            System.out.println(entity.get().getCorreo());
            if(entity.isPresent()) {
            response.setMessage("Cliente encontrado");
            response.setError(false);
            response.setData(entity.get());
            return new ResponseEntity(response,HttpStatus.OK);

            }else {
                response.setData(null);
                response.setMessage("Cliente no encontrado");
                response.setError(true);
                return new ResponseEntity(response,HttpStatus.OK);
            }
        } catch (Exception e) {
            response.setData(null);
            response.setMessage("Solicitud no pudo realizarse");
            response.setError(true);
            return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
        }




}

}




