package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.model.cuenta;

@Repository

public interface cuentaRepository extends JpaRepository<cuenta, Integer> {
    
}
