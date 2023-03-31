package com.example.userservice.service.extras;


import com.example.userservice.model.extras.Actividades;
import com.example.userservice.repository.extras.ActividadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActividadesService {
    @Autowired
    private ActividadesRepository actividadesRepository;

    public Actividades createActividades(Actividades actividades) {
        return actividadesRepository.save(actividades);
    }

}
