package com.example.userservice.repository.extras.actividades;

import com.example.userservice.model.extras.actividades.Servicios;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiciosRepository extends MongoRepository<Servicios, String> {
    public Page<Servicios> findAll(Pageable pageable);
}
