package com.example.userservice.repository;

import com.example.userservice.modelo.TipoHabitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoHabitacionRepo extends JpaRepository<TipoHabitacion, Long> {
}
