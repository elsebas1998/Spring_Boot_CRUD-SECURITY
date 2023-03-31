package com.example.userservice.service;

import com.example.userservice.modelo.TipoHabitacion;
import com.example.userservice.repository.TipoHabitacionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoHabitacionService {

    @Autowired
    private TipoHabitacionRepo tipoHabitacionRepo;

    public List<TipoHabitacion> getAllTipoHab() {
        return tipoHabitacionRepo.findAll();
    }

    public TipoHabitacion getTipoHabById(Long id) {
        return tipoHabitacionRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee Not Found!"));
    }

    public TipoHabitacion createTipoHab(TipoHabitacion tipoHabitacion) {
        return tipoHabitacionRepo.save(tipoHabitacion);
    }

    public void deleteTipoHab(Long id){
        tipoHabitacionRepo.deleteById(id);
    }
}
