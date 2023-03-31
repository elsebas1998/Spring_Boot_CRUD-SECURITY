package com.example.userservice.service;

import com.example.userservice.modelo.Comida;
import com.example.userservice.modelo.TipoHabitacion;
import com.example.userservice.repository.ComidaRepository;
import com.example.userservice.repository.TipoHabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoHabitacionService {
    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;
    public TipoHabitacion guardar(TipoHabitacion tipoHabitacion) {
        return tipoHabitacionRepository.save(tipoHabitacion);
    }


    public List<TipoHabitacion> getAllTipoHabitacion() {
        return tipoHabitacionRepository.findAll();
    }
}
