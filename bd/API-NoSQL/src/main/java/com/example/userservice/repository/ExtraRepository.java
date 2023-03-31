package com.example.userservice.repository;

import com.example.userservice.model.Extras;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtraRepository extends MongoRepository<Extras, String> {

}
