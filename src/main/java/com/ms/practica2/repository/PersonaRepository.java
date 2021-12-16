package com.ms.practica2.repository;

import com.ms.practica2.model.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonaRepository extends MongoRepository<Persona, String>{

}
