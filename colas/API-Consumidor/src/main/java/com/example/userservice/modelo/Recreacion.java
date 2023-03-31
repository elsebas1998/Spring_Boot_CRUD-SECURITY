package com.example.userservice.modelo;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recreacion")
public class Recreacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private double precio;

    @OneToMany(mappedBy = "recreacion")
    private List<Reserva> reservas;
    // otros atributos y métodos
}
