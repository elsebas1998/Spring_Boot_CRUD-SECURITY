package com.example.userservice.repository.extras.alimentacion;

import com.example.userservice.model.extras.alimentacion.Bebida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BebidaRepository extends MongoRepository<Bebida, String> {
    public Page<Bebida> findAll(Pageable pageable);
}
