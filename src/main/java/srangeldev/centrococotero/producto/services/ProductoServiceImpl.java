package srangeldev.centrococotero.producto.services;

import org.springframework.stereotype.Service;
import srangeldev.centrococotero.producto.exceptions.ProductoException;
import srangeldev.centrococotero.producto.models.Producto;
import srangeldev.centrococotero.producto.repositories.ProductoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProductoServiceImpl implements ProductoService {

    ProductoRepository productoRepository;

    @Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> getAllProductos() {
        try {
            return productoRepository.findAll();
        } catch (Exception e) {
            throw new ProductoException("Error al obtener todos los producto: " + e.getMessage());
        }
    }

    @Override
    public Producto getProductoById(String id) {
        try {
            return productoRepository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new ProductoException("Error al obtener el producto por ID: " + e.getMessage());
        }
    }

    @Override
    public Producto createProducto(Producto producto) {
        try {
            return productoRepository.save(producto);
        } catch (Exception e) {
            throw new ProductoException("Error al crear el producto: " + e.getMessage());
        }
    }

    @Override
    public Producto updateProducto(String id, Producto producto) {
        try {
            Producto existingProducto = productoRepository.findById(id).orElse(null);
            if (existingProducto == null) {
                throw new ProductoException("Producto no encontrado con ID: " + id);
            }
            // Actualizar los campos del producto existente
            existingProducto.setNombre(producto.getNombre());
            existingProducto.setPrecio(producto.getPrecio());
            existingProducto.setDescripcion(producto.getDescripcion());
            existingProducto.setStock(producto.getStock());
            existingProducto.setCategoria(producto.getCategoria());
            existingProducto.setImagenes(producto.getImagenes());
            // Guardar los cambios
            return productoRepository.save(existingProducto);
        } catch (Exception e) {
            throw new ProductoException("Error al actualizar el producto: " + e.getMessage());
        }
    }

    @Override
    public void deleteProducto(String id) {
        try {
            productoRepository.deleteById(id);
        } catch (Exception e) {
            throw new ProductoException("Error al eliminar el producto: " + e.getMessage());
        }
    }
}
