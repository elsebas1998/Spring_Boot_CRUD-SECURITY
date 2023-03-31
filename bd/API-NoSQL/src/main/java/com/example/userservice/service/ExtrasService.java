package com.example.userservice.service;

import com.example.userservice.model.Extras;
import com.example.userservice.repository.ExtraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtrasService {
    @Autowired
    private ExtraRepository extraRepository;

    public List<Extras> getAllUsers() {
        return extraRepository.findAll();
    }
    public Extras createExtras(Extras extras) {
        return extraRepository.save(extras);
    }
}
