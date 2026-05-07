package com.example.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.CuentaService;


@RestController
@RequestMapping("/api/cuentas")

public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @PostMapping("/transferir")
    public ResponseEntity<String> transferir(@RequestParam Long origen, 
                                            @RequestParam Long destino, 
                                            @RequestParam BigInteger monto) {
        try {
            cuentaService.depositar(origen, destino, monto);
            return ResponseEntity.ok("Transferencia realizada con éxito");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
