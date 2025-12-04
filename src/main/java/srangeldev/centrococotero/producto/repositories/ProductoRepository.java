package srangeldev.centrococotero.producto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import srangeldev.centrococotero.producto.models.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,String> {
}
