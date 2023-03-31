package com.example.userservice.modelo;

import lombok.*;
import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comida")
public class Comida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;

    @OneToMany(mappedBy = "comida")
    private List<Reserva> reservas;
    // otros atributos y métodos
}