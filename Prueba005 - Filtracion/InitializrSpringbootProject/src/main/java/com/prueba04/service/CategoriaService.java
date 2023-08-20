package com.prueba04.service;

import com.prueba04.entity.CategoriaEntity;
import java.util.List;

public interface CategoriaService {
    
    public List<CategoriaEntity> ListarCategorias();
    public CategoriaEntity obtenerCategoriaPorId(Long id_categoria);
    public CategoriaEntity obtenerCategoriaPorNombre(String nombre);
}
