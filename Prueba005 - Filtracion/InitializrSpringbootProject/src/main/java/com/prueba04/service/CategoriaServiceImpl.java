package com.prueba04.service;

import com.prueba04.entity.CategoriaEntity;
import com.prueba04.repository.CategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService{
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaEntity> ListarCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public CategoriaEntity obtenerCategoriaPorId(Long id_categoria) {
        return categoriaRepository.findById(id_categoria).orElse(null);
    }

    @Override
    public CategoriaEntity obtenerCategoriaPorNombre(String nombre) {
        return categoriaRepository.findByNombre(nombre);
    }
    
}
