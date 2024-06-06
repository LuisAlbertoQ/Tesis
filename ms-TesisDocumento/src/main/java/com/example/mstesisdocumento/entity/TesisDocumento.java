package com.example.mstesisdocumento.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tesis_documentos")
@Data
public class TesisDocumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDocumento;
    /*@Column(nullable = false)*/
    private Long idProyecto;
    /*@Column(nullable = false)*/
    private String nombreDocumento;
    /*@Column*/
    private String tipoArchivo;
    /*@Column(nullable = false)*/
    private String rutaArchivo;
}
