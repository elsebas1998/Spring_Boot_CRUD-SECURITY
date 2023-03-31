package com.example.userservice.service;

import com.example.userservice.modelo.Bebida;
import com.example.userservice.modelo.Comida;
import com.example.userservice.repository.BebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BebidaService {
    @Autowired
    private BebidaRepository bebidaRepository;
    public Bebida guardar(Bebida bebida) {
        return bebidaRepository.save(bebida);
    }
    public List<Bebida> getAllBebida() {
        return bebidaRepository.findAll();
    }
}
