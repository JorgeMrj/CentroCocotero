package srangeldev.centrococotero.producto.services;

import srangeldev.centrococotero.producto.models.Producto;

import java.util.List;

public interface ProductoService {
    List<Producto> getAllProductos();
    Producto getProductoById(String id);
    Producto createProducto(Producto producto);
    Producto updateProducto(String id, Producto producto);
    void deleteProducto(String id);
}
