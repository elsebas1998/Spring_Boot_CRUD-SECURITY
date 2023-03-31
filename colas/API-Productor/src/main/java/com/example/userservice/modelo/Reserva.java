package com.example.userservice.modelo;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {
    private Long id;
    private String nombreCliente;
    private String apellidoCliente;
    private String emailCliente;
    private String fechaInicio;
    private String fechaFin;


    // otros atributos y métodos
}

