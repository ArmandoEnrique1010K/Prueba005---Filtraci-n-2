package com.prueba04.repository;

import com.prueba04.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long>{
    CategoriaEntity findByNombre(String nombre);
}
