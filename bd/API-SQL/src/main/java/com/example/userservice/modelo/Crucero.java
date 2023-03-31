package com.example.userservice.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
@Table(name = "cruceros")
public class Crucero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCrucero;

    String nombre;
    String descripcion;
    String categoria;
    String placa;
    String modelo;


    @Column(name = "tipoHab_id")
    Long tipoHab_id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "crucero_id", referencedColumnName = "idCrucero")
    Set<Reserva> reservas = new HashSet<>();

    public Crucero() {

    }
}
