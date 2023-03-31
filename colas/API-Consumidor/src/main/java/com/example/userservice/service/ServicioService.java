package com.example.userservice.service;

import com.example.userservice.modelo.Comida;
import com.example.userservice.modelo.Recreacion;
import com.example.userservice.modelo.Servicio;
import com.example.userservice.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioService {
    @Autowired
    private ServicioRepository servicioRepository;
    public Servicio guardar(Servicio servicio) {
        return servicioRepository.save(servicio);
    }
    public List<Servicio> getAllServicio() {
        return servicioRepository.findAll();
    }
}
