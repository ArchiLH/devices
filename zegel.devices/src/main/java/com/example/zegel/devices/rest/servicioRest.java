package com.example.zegel.devices.rest;

import com.example.zegel.devices.entidades.Seguridad.User;
import com.example.zegel.devices.entidades.Dispositivo;
import com.example.zegel.devices.negocio.DispositivoNegocio;
import com.example.zegel.devices.negocio.UserNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class servicioRest {

    @Autowired
    private DispositivoNegocio dispositivoNegocio;

    @Autowired
    private UserNegocio userNegocio;

    // Dispositivo Endpoints

    @PostMapping("/device")
    public Dispositivo grabar(@RequestBody Dispositivo dispositivo) {
        return dispositivoNegocio.grabar(dispositivo);
    }

    @GetMapping("/devices")
    public List<Dispositivo> obtenerProductos() {
        try {
            return dispositivoNegocio.obtenerDispositivos();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado nada");
        }
    }

    @PutMapping("/actualizar")
    public Dispositivo actualizar(@RequestBody Dispositivo dispositivo) {
        try {
            return dispositivoNegocio.actualizar(dispositivo);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible obtener los resultados");
        }
    }

    @DeleteMapping("/device/{idClaim}")
    public Dispositivo borrarDispositivo(@PathVariable(value = "idClaim") Long idClaim) {
        return dispositivoNegocio.borrarDispositivo(idClaim);
    }

    // User Endpoints

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        User newUser = userNegocio.grabar(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully with id: " + newUser.getId());
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userNegocio.obtenerUsuarios();
        return ResponseEntity.ok(users);
    }
}
