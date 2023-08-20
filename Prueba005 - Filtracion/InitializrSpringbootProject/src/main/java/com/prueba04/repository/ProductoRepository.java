package com.prueba04.repository;

import com.prueba04.entity.ProductoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long>{
    
    // SELECCIONAR PRODUCTOS QUE COINCIDAN CON LA CATEGORIA DEL ID #2
    @Query(value = "SELECT p FROM ProductoEntity p JOIN p.categoriaEntity c "
        + "WHERE p.categoriaEntity.id_categoria = 2")
    List<ProductoEntity> findAllByCategoriaID2();
    
    // SELECCIONAR PRODUCTOS QUE COINCIDAN CON UNA CATEGORIA ESPECÍFICA
    @Query(value = "SELECT p FROM ProductoEntity p JOIN p.categoriaEntity c "
            + "WHERE c.id_categoria = :categoriaId")
    List<ProductoEntity> findAllByCategoriaIdParam(@Param("categoriaId") Long categoriaId);

    // SELECCIONAR PRODUCTOS QUE ESTEN DE OFERTA (EL VALOR DEL ATRIBUTO OFERTA ES TRUE)
    @Query(value = "SELECT p FROM ProductoEntity p WHERE p.oferta = true")
    List<ProductoEntity> findAllByOfertaTrue();
    
    // SELECCIONAR PRODUCTOS QUE COINCIDAN CON LA MARCA DEL ID #1, #2 Y #3
    @Query(value = "SELECT p FROM ProductoEntity p JOIN p.marcaEntity m "
        + "WHERE p.marcaEntity.id_marca IN (1, 2, 3)")
    List<ProductoEntity> findAllByMarcaID123();
    
    // SELECCIONAR PRODUCTOS QUE COINCIDAN CON VARIAS MARCAS ESPECIFICAS
    @Query(value = "SELECT p FROM ProductoEntity p JOIN p.marcaEntity m "
        + "WHERE m.id_marca IN :marcaIds")
    List<ProductoEntity> findAllByMarcaIDsParams(@Param("marcaIds") List<Long> marcaIds);

    
    // SELECCIONAR PRODUCTOS QUE COINCIDAN CON UNA CATEGORIA ESPECÍFICA
    // +
    // SELECCIONAR PRODUCTOS QUE COINCIDAN CON VARIAS MARCAS ESPECIFICAS
    // = 
    // SELECCIONAR PRODUCTOS QUE COINCIDAN CON UNA CATEGORIA ESPECIFICA Y VARIAS MARCAS ESPECIFICAS
    @Query(value = "SELECT p FROM ProductoEntity p JOIN p.categoriaEntity c JOIN p.marcaEntity m "
            + "WHERE c.id_categoria = :categoriaId AND m.id_marca IN :marcaIds")
    List<ProductoEntity> findAllByCategoriaIdParamAndMarcaIDsParams(
            @Param("categoriaId") Long categoriaId, 
            @Param("marcaIds") List<Long> marcaIds);
    
    
    
    // SELECCIONAR PRODUCTOS QUE ESTEN DE OFERTA (EL VALOR DEL ATRIBUTO OFERTA ES TRUE)
    // +
    // SELECCIONAR PRODUCTOS QUE COINCIDAN CON VARIAS MARCAS ESPECIFICAS
    // =
    // SELECCIONAR PRODUCTOS QUE ESTEN DE OFERTA Y COINCIDAN CON VARIAS MARCAS ESPECIFICAS
    @Query(value = "SELECT p FROM ProductoEntity p JOIN p.marcaEntity m "
            + "WHERE p.oferta = true AND m.id_marca IN :marcaIds")
    List<ProductoEntity> findAllByOfertaTrueAndMarcaIDsParams(
            @Param("marcaIds") List<Long> marcaIds);    
    
}




















