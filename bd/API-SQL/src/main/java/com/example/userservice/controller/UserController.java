package com.example.userservice.controller;

import com.example.userservice.modelo.Crucero;
import com.example.userservice.modelo.Reserva;
import com.example.userservice.modelo.TipoHabitacion;
import com.example.userservice.modelo.Users;
import com.example.userservice.service.CruceroService;
import com.example.userservice.service.ReservaService;
import com.example.userservice.service.TipoHabitacionService;
import com.example.userservice.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/Prooductor")
public class UserController {
    @Autowired
    private CruceroService cruceroService;

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private TipoHabitacionService tipoHabitacionService;

    @Autowired
    private UsuarioService usuarioService;


//Crucero Controller

    @GetMapping(path = "/crucero")
    public ResponseEntity<List<Crucero>> getCrucero() {
        return ResponseEntity.ok().body(cruceroService.getAllCruceros());
    }

    @PostMapping(path = "/crucero")
    public ResponseEntity<Crucero> createCrucero(@RequestBody Crucero crucero) {
        return new ResponseEntity<>(cruceroService.createCrucero(crucero), HttpStatus.CREATED);
    }

    @GetMapping(path = "/crucero/{id}")
    public ResponseEntity<Crucero> getCruceroById(@RequestBody Long id) {
        return ResponseEntity.ok().body(cruceroService.getCruceroById(id));
    }
    @DeleteMapping(path = "/crucero/{id}")
    public void deleteCrucero(@RequestBody Long id) {
        cruceroService.deleteCrucero(id);
    }

//Reserva Controller

    @GetMapping(path = "/reserva")
    public ResponseEntity<List<Reserva>> getReserva() {
        return ResponseEntity.ok().body(reservaService.getAllReservas());
    }

    @PostMapping(path = "/reserva")
    public ResponseEntity<Reserva> createReserva(@RequestBody Reserva reserva) {
        return new ResponseEntity<>(reservaService.createReserva(reserva), HttpStatus.CREATED);
    }

    @GetMapping(path = "/reserva/{id}")
    public ResponseEntity<Reserva> getReservaById(@RequestBody Long id) {
        return ResponseEntity.ok().body(reservaService.getReservaById(id));
    }
    @DeleteMapping(path = "/reserva/{id}")
    public void deleteReserva(@RequestBody Long id) {
        reservaService.deleteReserva(id);
    }

//Tipo Habitación Controller

    @GetMapping(path = "/tipohab")
    public ResponseEntity<List<TipoHabitacion>> getTipoHab() {
        return ResponseEntity.ok().body(tipoHabitacionService.getAllTipoHab());
    }

    @PostMapping(path = "/tipohab")
    public ResponseEntity<TipoHabitacion> createTipoHab(@RequestBody TipoHabitacion tipoHabitacion) {
        return new ResponseEntity<>(tipoHabitacionService.createTipoHab(tipoHabitacion), HttpStatus.CREATED);
    }

    @GetMapping(path = "/tipohab/{id}")
    public ResponseEntity<TipoHabitacion> getTipoHabById(@RequestBody Long id) {
        return ResponseEntity.ok().body(tipoHabitacionService.getTipoHabById(id));
    }
    @DeleteMapping(path = "/tipohab/{id}")
    public void deleteTipoHab(@RequestBody Long id) {
        tipoHabitacionService.deleteTipoHab(id);
    }

//Usuario Controller

    @GetMapping(path = "/usuario")
    public ResponseEntity<List<Users>> getUser() {
        return ResponseEntity.ok().body(usuarioService.getAllUsers());
    }

    //@PostMapping(path = "/usuario")
    // public ResponseEntity<Users> createUser(@RequestBody Users users) {
    //    return new ResponseEntity<>(usuarioService.createUser(users), HttpStatus.CREATED);
    //}

    @GetMapping(path = "/usuario/{id}")
    public ResponseEntity<Users> getUserById(@RequestBody Long id) {
        return ResponseEntity.ok().body(usuarioService.getUserById(id));
    }
    @DeleteMapping(path = "/usuario/{id}")
    public void deleteUser(@RequestBody Long id) {
        usuarioService.deleteUser(id);
    }
}
