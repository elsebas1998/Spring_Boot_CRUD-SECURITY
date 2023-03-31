package com.example.userservice.modelo;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Servicio {
    private Long id;
    private String nombre;
    private String descripcion;
    private double precio;

}