package springfundamentals.springboot.domain.repository;

import org.springframework.data.repository.CrudRepository;
import springfundamentals.springboot.persistense.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    // Define a query to get a list of products by name in ascending order
    // De structure of the function name define the query itself
    // the argument has to be the same as the column name in the database
    List<Producto> findByIdCategoriaOrderByNombreAsc ( int idCategoria );

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado (int cantidadStock, boolean estado);
}
