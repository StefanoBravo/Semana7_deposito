package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.cuenta;

public interface cuentaRepository extends JpaRepository<cuenta, Integer> {

}