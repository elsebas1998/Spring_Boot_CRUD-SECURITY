package com.example.userservice.modelo;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCliente;
    private String apellidoCliente;
    private String emailCliente;
    private String fechaInicio;
    private String fechaFin;

    @ManyToOne
    @JoinColumn(name = "comida_id")
    private Comida comida;

    @ManyToOne
    @JoinColumn(name = "bebida_id")
    private Bebida bebida;

    @ManyToOne
    @JoinColumn(name = "recreacion_id")
    private Recreacion recreacion;

    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;

    @ManyToOne
    @JoinColumn(name = "tipoHabitacion_id")
    private TipoHabitacion tipoHabitacion;
    // otros atributos y métodos
}

