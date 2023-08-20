package com.prueba04.controller;

import com.prueba04.entity.CategoriaEntity;
import com.prueba04.service.CategoriaService;
import com.prueba04.service.MarcaService;
import com.prueba04.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private MarcaService marcaService;

    // CONTROLADOR PARA LISTAR TODOS LOS PRODUCTOS POR MARCAS
    @GetMapping
    public String inicio(
            @RequestParam(value = "marcas", required = false) List<Long> marcaIds,
            Model modelo) {
        // SI HAY AL MENOS UNA MARCA SELECCIONADA
        if (marcaIds != null && !marcaIds.isEmpty()) {
            modelo.addAttribute("productos", productoService.listarProductosPorVariasMarcasEspecificas(marcaIds));
        } else {
            // SI NO HAY UNA MARCA SELECCIONADA
            modelo.addAttribute("productos", productoService.ListarProductos());
        }
        modelo.addAttribute("categorias", categoriaService.ListarCategorias());

        // LISTAR MARCAS
        modelo.addAttribute("marcas", marcaService.ListarMarcas());

        return "listaproductos.html";

    }

    /*
    @GetMapping
    public String inicio(Model modelo) {
        modelo.addAttribute("productos", productoService.ListarProductos());
        // modelo.addAttribute("productos", productoService.ListarProductosPorCategoria2());
        modelo.addAttribute("categorias", categoriaService.ListarCategorias());
        return "listaproductos.html";
    }
     */
    // CONTROLADOR DE PRUEBA
    /*
    @GetMapping
    public String inicio(Model modelo) {
        modelo.addAttribute("productos", productoService.ListarProductoPorMarca123());
        // modelo.addAttribute("productos", productoService.ListarProductosPorCategoria2());
        modelo.addAttribute("categorias", categoriaService.ListarCategorias());
        return "listaproductos.html";
    }
     */
 /*
    @GetMapping("/{categoriaId}")
    public String listarProductosPorCategoria(@PathVariable Long categoriaId, Model modelo) {
        CategoriaEntity categoria = categoriaService.obtenerCategoriaPorId(categoriaId);
        if (categoria != null) {
            modelo.addAttribute("productos", productoService.listarProductosPorCategoriaEspecifica(categoriaId));
            modelo.addAttribute("categorias", categoriaService.ListarCategorias());
            // Atributo para listar una sola categoria
            modelo.addAttribute("categoriaunica", categoriaService.obtenerCategoriaPorId(categoriaId));
            return "listaproductos.html";
        } else {
            // Manejar el caso en que la categoría no existe
            return "error.html";
        }
    }
     */
 /*
    @GetMapping("/{categoriaNombre}")
    public String listarProductosPorCategoriaNombre(@PathVariable String categoriaNombre, Model modelo) {
        CategoriaEntity categoria = categoriaService.obtenerCategoriaPorNombre(categoriaNombre);
        if (categoria != null) {
            modelo.addAttribute("productos", productoService.listarProductosPorCategoriaEspecifica(categoria.getId_categoria()));
            modelo.addAttribute("categorias", categoriaService.ListarCategorias());
            modelo.addAttribute("categoriaunica", categoriaService.obtenerCategoriaPorNombre(categoriaNombre));
            return "listaproductoscategoria.html";
        } else {
            // Manejar el caso en que la categoría no existe
            return "error.html";
        }
    }
     */
    @GetMapping("/{categoriaNombre}")
    public String listarProductosPorCategoriaNombreYMarcasEspecificas(
            @PathVariable String categoriaNombre,
            @RequestParam(value = "marcas", required = false) List<Long> marcaIds,
            Model modelo) {

        CategoriaEntity categoria = categoriaService.obtenerCategoriaPorNombre(categoriaNombre);

        // SI LA CATEGORIA NO ES NULA
        if (categoria != null) {
            // Y SI HAY AL MENOS UNA MARCA SELECCIONADA
            if (marcaIds != null && !marcaIds.isEmpty()) {
                // SE VA A LISTAR POR CATEGORIA SELECCIONADA Y MARCAS SELECCIONADAS
                modelo.addAttribute("productos", productoService.listarProductosPorCategoriaEspecificaYVariasMarcasEspecificas(categoria.getId_categoria(), marcaIds));
            } else {
                // SI NO HAY UNA MARCA SELECCIONADA, VA A LISTAR POR CATEGORIA SELECCIONADA
                modelo.addAttribute("productos", productoService.listarProductosPorCategoriaEspecifica(categoria.getId_categoria()));
            }

            // LISTAR CATEGORIA
            modelo.addAttribute("categorias", categoriaService.ListarCategorias());
            // LISTAR EL NOMBRE DE UNA CATEGORIA
            modelo.addAttribute("categoriaunica", categoriaService.obtenerCategoriaPorNombre(categoriaNombre));
            // LISTAR MARCAS
            // modelo.addAttribute("marcas", marcaService.ListarMarcas());
            // LISTAR CADA UNA DE LAS MARCAS QUE PERTENECEN A UN GRUPO DE PRODUCTOS QUE PERTENECEN A LA MISMA CATEGORIA
            modelo.addAttribute("marcas", marcaService.ListarMarcasPresentesPorCategoria(categoriaNombre));
            
            return "listaproductoscategoria.html";
        } else {
            // Manejar el caso en que la categoría no existe
            return "error.html";
        }
    }

    /*
    @GetMapping("/oferta")
    public String listarProductosQueEstanEnOferta(Model modelo) {
        modelo.addAttribute("productos", productoService.listarProductosEnOferta());
        // EN LA PAGINA WEB listaproductos.html SIEMPRE SE VA A DEFINIR EL ATRIBUTO QUE VA A LISTAR TODAS LAS CATEGORIAS PARA QUE EL
        // USUARIO SE PUEDA DESPLAZARSE ENTRE PAGINAS
        modelo.addAttribute("categorias", categoriaService.ListarCategorias());
        // NO SE HA DEFINIDO EL ATRIBUTO categoriaunica...
        return "listaproductosoferta.html";
    }
*/

    @GetMapping("/oferta")
    public String listarProductosQueEstanEnOferta(
            @RequestParam(value = "marcas", required = false) List<Long> marcaIds,
            Model modelo) {
        //SI HAY AL MENOS UNA MARCA SELECCIONADA
        if (marcaIds != null && !marcaIds.isEmpty()) {
            // SE VA A LISTAR POR CATEGORIA SELECCIONADA Y MARCAS SELECCIONADAS
            modelo.addAttribute("productos", productoService.listarProductosEnOfertaYVariasMarcasEspecificas(marcaIds));
        } else {
            // SI NO HAY UNA MARCA SELECCIONADA, VA A LISTAR LOS PRODUCTOS EN OFERTA
        modelo.addAttribute("productos", productoService.listarProductosEnOferta());
        }

        
        // EN LA PAGINA WEB listaproductos.html SIEMPRE SE VA A DEFINIR EL ATRIBUTO QUE VA A LISTAR TODAS LAS CATEGORIAS PARA QUE EL
        // USUARIO SE PUEDA DESPLAZARSE ENTRE PAGINAS
        modelo.addAttribute("categorias", categoriaService.ListarCategorias());
        // LISTAR MARCAS
        modelo.addAttribute("marcas", marcaService.ListarMarcasPresentesPorOferta());

        
        // NO SE HA DEFINIDO EL ATRIBUTO categoriaunica...
        return "listaproductosoferta.html";
    }

    
    
}
