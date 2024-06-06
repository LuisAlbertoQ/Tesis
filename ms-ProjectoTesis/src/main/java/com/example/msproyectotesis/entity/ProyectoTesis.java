package com.example.msproyectotesis.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class ProyectoTesis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idProjecto;
    private String idTesista;
    private String Titulo;
    private String Descripcion;

    @Temporal(TemporalType.DATE)
    private Date fechainicio;

    @Temporal(TemporalType.DATE)
    private Date fechafin;

    /*@Enumerated(EnumType.STRING)*/
    private String estado;
}

/*enum EstadoProyecto {
    EN_PROGRESO, COMPLETADO, PENDIENTE, CANCELADO
}*/
