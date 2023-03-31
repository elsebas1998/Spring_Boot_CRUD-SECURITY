package com.example.userservice.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor
@Entity
@Table(name = "tipohabitaciones")
public class TipoHabitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idTipo;

    String nombre;
    String descripcion;
    String capacidad;
    double precio;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tipoHab_id", referencedColumnName = "idTipo")
    Set<Crucero> cruceros = new HashSet<>();

    public TipoHabitacion() {

    }
}
