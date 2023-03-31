package com.example.userservice.controller;

import com.example.userservice.model.Extras;
import com.example.userservice.service.ExtrasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/apiNoSQL")
public class UserController {
    @Autowired
    private ExtrasService extrasService;

    @GetMapping(path = "/mostrar")
    public ResponseEntity<List<Extras>> getUsers() {
        return ResponseEntity.ok().body(extrasService.getAllUsers());
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Extras> createActividades(@RequestBody Extras extras) {
        return new ResponseEntity<>(extrasService.createExtras(extras), HttpStatus.CREATED);
    }

}
