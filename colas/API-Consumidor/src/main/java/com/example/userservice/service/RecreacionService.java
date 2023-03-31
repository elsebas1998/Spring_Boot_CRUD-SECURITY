package com.example.userservice.service;

import com.example.userservice.modelo.Comida;
import com.example.userservice.modelo.Recreacion;
import com.example.userservice.modelo.Servicio;
import com.example.userservice.repository.ComidaRepository;
import com.example.userservice.repository.RecreacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecreacionService {
    @Autowired
    private RecreacionRepository recreacionRepository;
    public Recreacion guardar(Recreacion recreacion) {
        return recreacionRepository.save(recreacion);
    }
    public List<Recreacion> getAllRecreacion() {
        return recreacionRepository.findAll();
    }
}
