package com.Repasando.Java2025.services;

import org.springframework.stereotype.Service;

import com.Repasando.Java2025.domain.models.Persona;

@Service
public class PersonaServices {

    public Persona obtenerPersona(String nombre, Integer edad){
        return new Persona(nombre,edad);
    }

}
