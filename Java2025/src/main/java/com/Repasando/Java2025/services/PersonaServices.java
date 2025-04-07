package com.Repasando.Java2025.services;

import org.springframework.stereotype.Service;

import com.Repasando.Java2025.domain.models.Persona;

@Service
public class PersonaServices {

    public Persona obtenerPersona(){
        return new Persona("Maximiliano Andres Caniullan", 29);
    }

}
