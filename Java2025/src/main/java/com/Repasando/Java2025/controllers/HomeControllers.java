package com.Repasando.Java2025.controllers;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Repasando.Java2025.config.AppLogger;
import com.Repasando.Java2025.domain.models.Persona;
import com.Repasando.Java2025.services.PersonaServices;


@Controller
@RequestMapping("/principal")
public class HomeControllers {

    //DEBUGE
    //private static final Logger logger = LoggerFactory.getLogger(HomeControllers.class);
    //private String debug = "DEBUG ---- HOMECONTROLLERS: ";
    
    private final PersonaServices personaServices;

    //@Autowired
    public HomeControllers(PersonaServices personaServices){
        this.personaServices= personaServices;
    }

    @GetMapping("/home")
    public String home(@RequestParam(name = "nombre", defaultValue = "Maximiliano Andres Caniullan") String nombre, 
                        @RequestParam(name = "edad", defaultValue = "29") Integer edad, Model model){
                            
        if(nombre.isBlank() || edad != null){
        Persona persona = personaServices.obtenerPersona(nombre,edad);
        model.addAttribute("maxi", persona);
        
        AppLogger.info(persona);
        }
        

        //System.out.println(persona);
        //logger.info("\u001B[36m{} : {}\u001B[0m",debug, persona);
        
        
        //AppLogger.error(persona);

        return "index";
    }

}
