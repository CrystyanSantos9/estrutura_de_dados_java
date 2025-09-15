package cryss.dev.estrutura_de_dados_java.services;

import cryss.dev.estrutura_de_dados_java.infra.CustomerDTO;
import cryss.dev.estrutura_de_dados_java.infra.CustomerEntity;
import cryss.dev.estrutura_de_dados_java.infra.mapper.ProductMapper;
import cryss.dev.estrutura_de_dados_java.infra.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ExtendWith (SpringExtension.class)
@RequiredArgsConstructor
class CustomerServiceTest {

    @Autowired
    private CustomerService service;

    @Autowired
    private CustomerRepository repository;

//    @Autowired
//    private ProductMapper mapper;



//    PRE AND POST CONDITIONS
    @BeforeEach
    public void beforeEach() {
        CustomerEntity c1 = CustomerEntity
                .builder()
                .name ("pedro")
                .build();

        CustomerEntity c2 = CustomerEntity
                .builder()
                .name ("caio")
                .phone ("123")
                .build();


        this.repository.saveAll(Arrays.asList (c1,c2));
    }

    @AfterEach
    public void afterEach() {
        this.repository.deleteAll();
    }
//    PRE AND POST CONDITIONS

//    @Test
//    void updateCustomerLoadAndSaveApproach() {
//        //When
//        service.updateCustomerLoadAndSaveApproach (1l, "1233");
//        //Then
//        var c = repository.findById (1l).orElse (new CustomerEntity ());
//        assertEquals (c.phone,"1233" );
//    }

    @Test
    void updateCustomerMapperApproach() {

        //Given
        var dto = CustomerDTO
                .builder ()
                .name ("joaleson")
                .phone99 ("1111")
                .build ();
        //When
     service.updateCustomerMapperApproach (dto);

        //Then
        var c = repository.findById (2l).orElse (new CustomerEntity ());
        assertEquals (c.name,"joaleson" );
        assertEquals (c.phone,"123" );
    }

}