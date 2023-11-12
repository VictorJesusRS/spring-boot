package springfundamentals.springboot.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper( componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "idProduto", source = "productId"),
    
}
