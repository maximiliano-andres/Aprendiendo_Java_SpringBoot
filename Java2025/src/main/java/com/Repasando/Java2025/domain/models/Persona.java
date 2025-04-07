package com.Repasando.Java2025.domain.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Persona {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 50, message = "el nombre tiene un minimo de 2 letras y un maximo de 50")
    private String nombre;

    @NotNull(message = "La edad es obligatoria")
    @Min(value = 0, message = "La edad no puede ser negativa")
    private Integer edad;

    public Persona(String nombre, Integer edad){
        setNombre(nombre);
        setEdad(edad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty() || nombre.isBlank()){
            throw new IllegalArgumentException("no hay nombre");
        }
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        if(edad == null){
            throw new IllegalArgumentException("no hay edad");
        }
        this.edad = edad;
    }

    public String toString(){
        return String.format("El nombre es : {%s} y la edad {%d}", nombre, edad);
    }

}
