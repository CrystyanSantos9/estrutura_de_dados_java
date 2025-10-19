package cryss.dev.estrutura_de_dados_java.infra.mapper;


import cryss.dev.estrutura_de_dados_java.infra.CustomerDTO;
import cryss.dev.estrutura_de_dados_java.infra.CustomerEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface ProductMapper {

    @BeanMapping(nullValuePropertyMappingStrategy =
            NullValuePropertyMappingStrategy.IGNORE)
    @Mapping (target = "phone99", source = "phone99", ignore = true)
    void updateCustomerFromDto(CustomerDTO dto, @MappingTarget CustomerEntity entity);

}
