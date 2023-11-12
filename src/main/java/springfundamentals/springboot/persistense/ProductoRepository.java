package springfundamentals.springboot.persistense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springfundamentals.springboot.domain.Product;
import springfundamentals.springboot.domain.repository.ProductRepository;
import springfundamentals.springboot.persistense.crud.ProductoCrudRepository;
import springfundamentals.springboot.persistense.entity.Producto;
import springfundamentals.springboot.persistense.mapper.ProductMapper;

import java.util.List;
import java.util.Optional;

// @Repository: indica que esta clase es un repositorio y se encarga de la
// interacción con la base de datos
@Repository
public class ProductoRepository implements ProductRepository {

    //@Autowired: Dictate to Spring to create instances of the class in the property
    //This to make dependency injection
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;

    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc( categoryId );
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado( quantity, true);
        return productos.map( prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map( prod -> mapper.toProduct(prod));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct( productoCrudRepository.save(producto)  );
    }

    @Override
    public void delete ( int productId ) {
        productoCrudRepository.deleteById(productId);
    }
 }
