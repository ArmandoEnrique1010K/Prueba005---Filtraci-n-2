package com.prueba04.service;

import com.prueba04.entity.ProductoEntity;
import java.util.List;

public interface ProductoService {
    // Si no vamos a utilizar DTO, entonces nos vamos con la Entidad
    
    // METODO DE PRUEBA
    public List<ProductoEntity> ListarProductos();
    public List<ProductoEntity> ListarProductosPorCategoria2();
    public List<ProductoEntity> listarProductosPorCategoriaEspecifica(Long categoriaId);
    public List<ProductoEntity> listarProductosEnOferta();
    public List<ProductoEntity> ListarProductoPorMarca123();
    public List<ProductoEntity> listarProductosPorVariasMarcasEspecificas(List<Long> marcaIds);
    
    // 2 EN 1
    public List<ProductoEntity> listarProductosPorCategoriaEspecificaYVariasMarcasEspecificas(Long categoriaId, List<Long> marcaIds);
    public List<ProductoEntity> listarProductosEnOfertaYVariasMarcasEspecificas(List<Long> marcaIds);
}
