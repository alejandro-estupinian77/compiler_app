package com.compiler.compiler_app.Controller;


import com.compiler.compiler_app.Model.*;
import com.compiler.compiler_app.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class AnalizadorController {

    @Autowired
    private AnalizadorService analizadorService;

    @PostMapping("/analizar")
    public ResultadoAnalisis analizarCodigo(@RequestBody String codigo){
        return analizadorService.getAnalisis(codigo);
    }

    @PostMapping("/evaluar")
    public ResponseEntity<?> evaluarExpresion(@RequestBody String input){
       
        try{
            Map<String, Double> resultado = analizadorService.evaluarExpresion(input);
            return ResponseEntity.ok(resultado);
        }catch(RuntimeException e){
            return ResponseEntity
                .badRequest()
                .body(Map.of("error", e.getMessage()));
        }
    }

    @PostMapping("/arbol")
    public Map<String, Object> generarArbol(@RequestBody String input){
        return analizadorService.obtenerArbol(input);
    }
}
