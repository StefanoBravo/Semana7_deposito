package com.example.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "cuenta")

public class cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_cuenta")
    private Integer id;

    @Column(name = "numero_de_cuenta",nullable = false, length = 50)
    private String n_cuenta;

    @Column(name = "saldo")
    private BigDecimal saldo;

    public cuenta() {
    }

    public cuenta(Integer id, String n_cuenta, BigDecimal saldo) {
        this.id = id;
        this.n_cuenta = n_cuenta;
        this.saldo = saldo;
    }

}
