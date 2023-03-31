package com.example.userservice.service;

import com.example.userservice.modelo.Crucero;
import com.example.userservice.repository.CruceroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CruceroService {


    @Autowired
    private CruceroRepository cruceroRepository;

    public List<Crucero> getAllCruceros() {
        return cruceroRepository.findAll();
    }

    public Crucero getCruceroById(Long id) {
        return cruceroRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee Not Found!"));
    }

    public Crucero createCrucero(Crucero crucero) {
        return cruceroRepository.save(crucero);
    }

    public void deleteCrucero(Long id){
        cruceroRepository.deleteById(id);
    }
}
