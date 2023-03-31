package com.example.userservice.repository;

import com.example.userservice.modelo.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Users, Long> {
}
