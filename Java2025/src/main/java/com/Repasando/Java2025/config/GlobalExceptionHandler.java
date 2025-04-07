package com.Repasando.Java2025.config;

import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

//@ControllerAdvice
public class GlobalExceptionHandler {
     // ⚠️ Error genérico
    @ExceptionHandler(Exception.class)
    public String handleGenericException(Exception ex, Model model) {
        AppLogger.error("Excepcion general capturada: " + ex.getMessage());
        model.addAttribute("errorMessage", "Ha ocurrido un error inesperado.");
        return "error/500";
    }

    // ❌ Error 404
    @ExceptionHandler(NoHandlerFoundException.class)
    public String handleNotFound(NoHandlerFoundException ex, Model model) {
        AppLogger.info("Ruta no encontrada: " + ex.getRequestURL());
        model.addAttribute("errorMessage", "Página no encontrada (404)");
        return "error/404";
    }
}
