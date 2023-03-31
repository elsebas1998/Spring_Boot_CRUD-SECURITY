package com.example.userservice.service;

import com.example.userservice.modelo.Comida;
import com.example.userservice.repository.ComidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComidaService {
    @Autowired
    private ComidaRepository comidaRepository;
    public Comida guardar(Comida comida) {
            return comidaRepository.save(comida);
    }
    public List<Comida> getAllComida() {
        return comidaRepository.findAll();
    }
}
