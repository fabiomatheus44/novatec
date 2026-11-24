package com.pruebaTecnica.novatec.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class saludo {
    @GetMapping("/")
    String inicio() {
        return "Hola, bienvenido a la prueba técnica de Novatec! conexion exitoso";
    }

}
