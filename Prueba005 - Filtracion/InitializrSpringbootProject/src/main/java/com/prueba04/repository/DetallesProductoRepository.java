package com.prueba04.repository;

import com.prueba04.entity.DetallesProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallesProductoRepository extends JpaRepository<DetallesProductoEntity, Long>{
    
}

