package com.example.userservice.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idReserva;

    String fechaInicio;
    String fechaFin;
    double precio;

    @Column(name = "user_id")
    Long user_id;

    @Column(name = "crucero_id")
    Long crucero_id;

    public Reserva() {

    }
}
