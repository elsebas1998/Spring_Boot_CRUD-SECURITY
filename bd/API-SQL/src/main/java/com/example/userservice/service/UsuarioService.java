package com.example.userservice.service;

import com.example.userservice.modelo.Users;
import com.example.userservice.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Users> getAllUsers() {
        return usuarioRepository.findAll();
    }

    public Users getUserById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee Not Found!"));
    }

    public Users createUser(Users users) {
        return usuarioRepository.save(users);
    }

    public void deleteUser(Long id){
        usuarioRepository.deleteById(id);
    }
}
