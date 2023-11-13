package springfundamentals.springboot.persistense.crud;

import org.springframework.data.repository.CrudRepository;
import springfundamentals.springboot.persistense.entity.Compra;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer> {
     Optional<List<Compra>> getByIdCliente (String idCliente);
}
