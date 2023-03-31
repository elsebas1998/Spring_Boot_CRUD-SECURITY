package com.example.userservice.controller;

import com.example.userservice.modelo.*;
import com.example.userservice.repository.ReservaRepository;
import com.example.userservice.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/Consumidor")
public class UserController {
    @Autowired
    private ComidaService comidaService;
    @Autowired
    private BebidaService bebidaService;
    @Autowired
    private RecreacionService recreacionService;
    @Autowired
    private ServicioService servicioService;
    @Autowired
    private TipoHabitacionService tipoHabitacionService;
    @Autowired
    private ReservaService reservaService;

    @RabbitListener(queues="respaldoA")
    private void guardarRespaldoA(Reserva reserva){
        reservaService.guardar(reserva);
        log.info("Message received from reserva",reserva);
    }
    @RabbitListener(queues="respaldoB")
    private void guardarRespaldoB(Reserva reserva){
        reservaService.guardar(reserva);
        log.info("Message received from reserva",reserva);
    }
    @GetMapping(path = "/respaldo")
    public ResponseEntity<List<Reserva>> obtenerRespaldo() {
        log.info("Message received from respaldo",reservaService.getAllReserva());
        return ResponseEntity.ok().body(reservaService.getAllReserva());
    }

    @RabbitListener(queues="reserva")
    private void guardarReserva(Reserva reserva){
        //reservaService.guardar(reserva);
        log.info("Message received from reserva",reserva);
    }
    @GetMapping(path = "/reserva")
    public ResponseEntity<List<Reserva>> obtenerReserva() {
        log.info("Message received from reserva",reservaService.getAllReserva());
        return ResponseEntity.ok().body(reservaService.getAllReserva());
    }
    @RabbitListener(queues="extras.comida")
    private void guardarComida(Comida comida){
        comidaService.guardar(comida);
        log.info("Message received from comida",comida);
    }
    @GetMapping(path = "/comida")
    public ResponseEntity<List<Comida>> obtenerComida() {
        log.info("Message received from comida",comidaService.getAllComida());
        return ResponseEntity.ok().body(comidaService.getAllComida());
    }

    @RabbitListener(queues="extras.bebida")
    private void guardarBebida(Bebida bebida){
        bebidaService.guardar(bebida);
        log.info("Message received from bebida",bebida);
    }
    @GetMapping(path = "/bebida")
    public ResponseEntity<List<Bebida>> obtenerBebida() {
        log.info("Message received from Bebida",bebidaService.getAllBebida());
        return ResponseEntity.ok().body(bebidaService.getAllBebida());
    }
    @RabbitListener(queues="extras.recreacion")
    private void guardarRecreacion(Recreacion recreacion){
        recreacionService.guardar(recreacion);
        log.info("Message received from recreacion",recreacion);
    }
    @GetMapping(path = "/recreacion")
    public ResponseEntity<List<Recreacion>> obtenerRecreacion() {
        log.info("Message received from recreacion",recreacionService.getAllRecreacion());
        return ResponseEntity.ok().body(recreacionService.getAllRecreacion());
    }
    @RabbitListener(queues="extras.servicio")
    private void guardarServicio(Servicio servicio){
        servicioService.guardar(servicio);
        log.info("Message received from servicio",servicio);
    }
    @GetMapping(path = "/servicio")
    public ResponseEntity<List<Servicio>> obtenerServicio() {
        log.info("Message received from servicio",servicioService.getAllServicio());
        return ResponseEntity.ok().body(servicioService.getAllServicio());
    }
    ///
    @RabbitListener(queues="tipoHabitacionSimple")
    private void guardarTipoHabitacionSimple(TipoHabitacion tipoHabitacion){
        tipoHabitacionService.guardar(tipoHabitacion);
        log.info("Message received from tipoHabitacionSimple",tipoHabitacion);
    }
    @RabbitListener(queues="tipoHabitacionDoble")
    private void guardarTipoHabitacionDoble(TipoHabitacion tipoHabitacion){
        tipoHabitacionService.guardar(tipoHabitacion);
        log.info("Message received from tipoHabitacionDoble",tipoHabitacion);
    }
    @GetMapping(path = "/tipoHabitacion")
    public ResponseEntity<List<TipoHabitacion>> obtenerTipoHabitacion() {
        log.info("Message received from comida",tipoHabitacionService.getAllTipoHabitacion());
        return ResponseEntity.ok().body(tipoHabitacionService.getAllTipoHabitacion());
    }
}
