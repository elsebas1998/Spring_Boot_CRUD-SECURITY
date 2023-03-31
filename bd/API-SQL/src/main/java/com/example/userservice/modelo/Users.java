package com.example.userservice.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idUser;

    String username;
    String password;
    String email;
    String nombre;
    String apellido;
    String direccion;
    String cedula;
    String edad;
    String telefono;

    @OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "idUser")
    Set<Reserva> reservas = new HashSet<>();


    public Users() {
    }
}
