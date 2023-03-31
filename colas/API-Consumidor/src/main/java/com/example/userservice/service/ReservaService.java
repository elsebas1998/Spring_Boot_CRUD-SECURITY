package com.example.userservice.service;

import com.example.userservice.modelo.Reserva;
import com.example.userservice.modelo.Servicio;
import com.example.userservice.repository.ReservaRepository;
import com.example.userservice.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;
    public Reserva guardar(Reserva reserva) {
        return reservaRepository.save(reserva);
    }
    public List<Reserva> getAllReserva() {
        return reservaRepository.findAll();
    }
}
