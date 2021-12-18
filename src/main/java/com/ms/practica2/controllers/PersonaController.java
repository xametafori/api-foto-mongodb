package com.ms.practica2.controllers;


import com.ms.practica2.model.Persona;
import com.ms.practica2.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/persona/{dni}")
    public Optional<Persona> listaPersonaPorDni(@PathVariable String dni)	{
        return repo.findById(dni);
    }

    @PostMapping("/persona")
    public Persona grabarPersona(@RequestBody Persona curso)	{
        repo.insert(curso);
        return curso;
    }

    @PutMapping("/persona/{dni}")
    public Optional<Persona> updatePersona(@RequestBody Persona oPersona, @PathVariable String dni)
    {
        Optional<Persona> optional = repo.findById(dni);
        if (optional.isPresent()) {
            Persona per = optional.get();
            per.setApellidos(oPersona.getApellidos());
            per.setNombres(oPersona.getNombres());
            per.setEstado(oPersona.getEstado());
            per.setFotobase64(oPersona.getFotobase64());

            repo.save(per);
        }
        return optional;
    }

    @DeleteMapping(value = "/persona/{dni}", produces = "application/json; charset=utf-8")
    public String deleteCurso(@PathVariable String dni) {
        boolean result = repo.existsById(dni);
        if(result){
            repo.deleteById(dni);
        }
        return "{ \"operacionExitosa\" : "+ (result ? "true" : "false") +" }";
    }
}
