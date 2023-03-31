package com.example.userservice.repository.extras;

import com.example.userservice.model.extras.Alimentacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlimentacionRepository  extends MongoRepository<Alimentacion, String> {
    public Page<Alimentacion> findAll(Pageable pageable);
}
