package com.ms.practica2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "Persona")
public class Persona {

    @Id
    private String dni;
    private String nombres;
    private String apellidos;
    private Integer estado;
    private String fotobase64;

}