package com.example.userservice.repository;

import com.example.userservice.modelo.Crucero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CruceroRepository extends JpaRepository<Crucero, Long> {
}
