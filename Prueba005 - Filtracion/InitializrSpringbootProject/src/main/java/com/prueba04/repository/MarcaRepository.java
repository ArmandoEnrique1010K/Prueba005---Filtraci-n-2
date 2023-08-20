package com.prueba04.repository;

import com.prueba04.entity.MarcaEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<MarcaEntity, Long>{
    
    // LISTAR CADA UNA DE LAS MARCAS QUE SE ENCUENTREN DENTRO DE UN GRUPO DE PRODUCTOS QUE PERTENECEN A LA MISMA CATEGORIA
    @Query("SELECT DISTINCT m FROM MarcaEntity m JOIN m.productoentity p JOIN p.categoriaEntity c WHERE c.nombre = :nombreCategoria")
    List<MarcaEntity> findMarcasByCategoria(@Param("nombreCategoria") String nombreCategoria);
    
    // LISTAR CADA UNA DE LAS MARCAS QUE SE ENCUENTREN DENTRO DEL GRUPO DE PRODUCTOS QUE ESTAN DE OFERTA
    @Query("SELECT DISTINCT m FROM MarcaEntity m JOIN m.productoentity p WHERE p.oferta = true")
    List<MarcaEntity> findMarcasByOfertaTrue();

}
