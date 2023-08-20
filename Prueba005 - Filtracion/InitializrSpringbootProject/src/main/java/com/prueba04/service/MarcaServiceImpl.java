package com.prueba04.service;

import com.prueba04.entity.MarcaEntity;
import com.prueba04.repository.MarcaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarcaServiceImpl implements MarcaService{

    @Autowired
    private MarcaRepository marcaRepository;
    
    @Override
    public List<MarcaEntity> ListarMarcas() {
        return marcaRepository.findAll();
    }

    // LISTAR CADA UNA DE LAS MARCAS QUE SE ENCUENTREN DENTRO DE UN GRUPO DE PRODUCTOS QUE PERTENECEN A LA MISMA CATEGORIA
    @Override
    public List<MarcaEntity> ListarMarcasPresentesPorCategoria(String nombreCategoria) {
        return marcaRepository.findMarcasByCategoria(nombreCategoria);
    }

    // LISTAR CADA UNA DE LAS MARCAS QUE SE ENCUENTREN DENTRO DEL GRUPO DE PRODUCTOS EN OFERTA
    @Override
    public List<MarcaEntity> ListarMarcasPresentesPorOferta() {
        return marcaRepository.findMarcasByOfertaTrue();
    }
    
}


















