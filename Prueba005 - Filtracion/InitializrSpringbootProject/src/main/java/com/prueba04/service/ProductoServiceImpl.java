package com.prueba04.service;

import com.prueba04.entity.ProductoEntity;
import com.prueba04.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // LISTAR TODOS LOS PRODUCTOS
    @Override
    public List<ProductoEntity> ListarProductos() {
        return productoRepository.findAll();
    }
    
    // LISTAR TODOS LOS PRODUCTOS QUE TENGA LA CATEGORIA ID 2
    @Override
    public List<ProductoEntity> ListarProductosPorCategoria2() {
        return productoRepository.findAllByCategoriaID2();
    }
    
    // LISTAR TODOS LOS PRODUCTOS POR UNA CATEGORIA ESPECIFICA
    @Override
    public List<ProductoEntity> listarProductosPorCategoriaEspecifica(Long categoriaId) {
        return productoRepository.findAllByCategoriaIdParam(categoriaId);
    }

    // LISTAR TODOS LOS PRODUCTOS QUE ESTAN EN OFERTA
    @Override
    public List<ProductoEntity> listarProductosEnOferta() {
        return productoRepository.findAllByOfertaTrue();
    }

    // LISTAR TODOS LOS PRODUCTOS QUE COINCIDAN CON EL ID 1, 2 Y 3 DE LA MARCA
    @Override
    public List<ProductoEntity> ListarProductoPorMarca123() {
        return productoRepository.findAllByMarcaID123();
    }

    // LISTAR TODOS LOS PRODUCTOS POR VARIAS MARCAS ESPECIFICAS
    @Override
    public List<ProductoEntity> listarProductosPorVariasMarcasEspecificas(List<Long> marcaIds) {
        return productoRepository.findAllByMarcaIDsParams(marcaIds);
    }

    @Override
    public List<ProductoEntity> listarProductosPorCategoriaEspecificaYVariasMarcasEspecificas(Long categoriaId, List<Long> marcaIds) {
        return productoRepository.findAllByCategoriaIdParamAndMarcaIDsParams(categoriaId, marcaIds);
    }

    @Override
    public List<ProductoEntity> listarProductosEnOfertaYVariasMarcasEspecificas(List<Long> marcaIds) {
        return productoRepository.findAllByOfertaTrueAndMarcaIDsParams(marcaIds);
    }

}


















