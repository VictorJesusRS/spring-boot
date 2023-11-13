package springfundamentals.springboot.persistense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springfundamentals.springboot.domain.Purchase;
import springfundamentals.springboot.domain.repository.PurchaseRepository;
import springfundamentals.springboot.persistense.crud.CompraCrudRepository;
import springfundamentals.springboot.persistense.entity.Compra;
import springfundamentals.springboot.persistense.mapper.PurchaseMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

    @Autowired
    private CompraCrudRepository compraCrudRepository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.getByIdCliente(clientId)
                .map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getProductos().forEach( comprasProducto -> comprasProducto.setCompra(compra));
        return mapper.toPurchase(compraCrudRepository.save(compra));
    }
}
