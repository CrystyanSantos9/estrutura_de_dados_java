package cryss.dev.estrutura_de_dados_java.services;

import cryss.dev.estrutura_de_dados_java.infra.CustomerDTO;
import cryss.dev.estrutura_de_dados_java.infra.CustomerEntity;
import cryss.dev.estrutura_de_dados_java.infra.mapper.ProductMapper;
import cryss.dev.estrutura_de_dados_java.infra.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final ProductMapper mapper;

    public void addCustomer(String name){
        CustomerEntity customerEntity = CustomerEntity
                .builder ()
                .name (name)
                .build ();
        customerEntity.name = name;
        repository.save (customerEntity);
    }

    public void updateCustomerLoadAndSaveApproach(Long id, String phone){
        CustomerEntity c = repository.findById (id).orElseThrow (()-> new RuntimeException (String.format ("User %s not found.", id)));
        c.phone = phone;
        repository.save (c);
    }

    public void updateCustomerMapperApproach(CustomerDTO dto){
        CustomerEntity c = repository.findById (dto.id).orElseThrow (()-> new RuntimeException (String.format ("User %s not found.", dto.id)));
        //alimenta na entidade, somente os campos diferentes de null em dto
        mapper.updateCustomerFromDto (dto,c);
        repository.save (c);
    }
}
