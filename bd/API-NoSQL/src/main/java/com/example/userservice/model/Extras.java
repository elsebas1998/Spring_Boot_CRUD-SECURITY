package com.example.userservice.model;

import com.example.userservice.model.extras.Actividades;
import com.example.userservice.model.extras.Alimentacion;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Embedded;
import java.time.LocalDateTime;
import java.util.List;
//Gracias a la libreria lombok con la etiqueta @Data nos ayudara a generar por nosotros los getter y setters y constructores
//solo con anotaciones
@Data
@AllArgsConstructor
@Document(collection = "extras")
public class Extras {
    @Id
    private String id;
    private int codExtras;
    private double subtotalActividades;
    private double subtotalAlimentacion;
    private double precioTotal;
    @CreatedDate
    private LocalDateTime created;
    @LastModifiedDate
    private LocalDateTime modified;
    @Embedded
    private List<Actividades> actividadesList;
    @Embedded
    private List<Alimentacion> alimentacionList;
}
