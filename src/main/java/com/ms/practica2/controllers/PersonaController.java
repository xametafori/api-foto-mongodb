package com.ms.practica2.controllers;


import com.ms.practica2.model.Persona;
import com.ms.practica2.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class PersonaController {

    @Autowired
    PersonaRepository repo;

    @GetMapping(value = "/healthcheck", produces = "application/json; charset=utf-8")
    public String getHealthCheck()	{
        return "{ \"todoOk\" : true }";
    }

    @GetMapping("/persona")
    public List<Persona> listarPersonas()	{
        return repo.findAll();
    }

    @PostMapping("/persona")
    public Persona grabarCurso(@RequestBody Persona curso)	{
        repo.insert(curso);
        return curso;
    }
}
