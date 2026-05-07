package com.example.service;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.cuenta;
import com.example.repository.cuentaRepository;

@Service
public class CuentaService {

    @Autowired
    private cuentaRepository cuentaRepository;

    public void depositar(Long origen, Long destino, BigInteger monto) {

        // Buscar cuentas
        cuenta cuentaOrigen = cuentaRepository.findById(origen.intValue())
                .orElseThrow(() -> new RuntimeException("Cuenta origen no encontrada"));

        cuenta cuentaDestino = cuentaRepository.findById(destino.intValue())
                .orElseThrow(() -> new RuntimeException("Cuenta destino no encontrada"));

        // Convertir monto
        BigDecimal montoTransferencia = new BigDecimal(monto);

        // Validar monto mayor a 0
        if (montoTransferencia.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("El monto debe ser mayor a cero");
        }

        // Validar saldo suficiente
        if (cuentaOrigen.getSaldo().compareTo(montoTransferencia) < 0) {
            throw new RuntimeException("Saldo insuficiente");
        }

        // Restar saldo origen
        cuentaOrigen.setSaldo(
                cuentaOrigen.getSaldo().subtract(montoTransferencia));

        // Sumar saldo destino
        cuentaDestino.setSaldo(
                cuentaDestino.getSaldo().add(montoTransferencia));

        // Guardar cambios
        cuentaRepository.save(cuentaOrigen);
        cuentaRepository.save(cuentaDestino);
    }
}