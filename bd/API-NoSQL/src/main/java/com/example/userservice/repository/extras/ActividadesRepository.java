package com.example.userservice.repository.extras;

import com.example.userservice.model.extras.Actividades;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActividadesRepository extends MongoRepository<Actividades, String> {
    public Page<Actividades> findAll(Pageable pageable);
}
