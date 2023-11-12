package springfundamentals.springboot.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper( componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping( source = "idCatgoria", target = "categoryId" ),
            @Mapping( source = "idCatgoria", target = "categoryId" )
    })
}
