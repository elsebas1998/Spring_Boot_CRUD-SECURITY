package com.example.userservice.modelo;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tipo_habitacion")
public class TipoHabitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private int capacidad;
    private double precio;

    @OneToMany(mappedBy = "tipoHabitacion")
    private List<Reserva> reservas;
    // otros atributos y métodos
}
