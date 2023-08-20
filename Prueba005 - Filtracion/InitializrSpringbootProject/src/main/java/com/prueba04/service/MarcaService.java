package com.prueba04.service;

import com.prueba04.entity.MarcaEntity;
import java.util.List;

public interface MarcaService {
    
    public List<MarcaEntity> ListarMarcas();
    public List<MarcaEntity> ListarMarcasPresentesPorCategoria(String nombreCategoria);
    public List<MarcaEntity> ListarMarcasPresentesPorOferta();
}
