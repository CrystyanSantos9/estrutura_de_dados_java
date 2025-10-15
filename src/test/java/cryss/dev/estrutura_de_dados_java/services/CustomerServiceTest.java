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

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

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
                .phone99 ("1111")
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
                .id (2L)
                .name ("joaleson")
                .phone (null)
                .phone99 ("9999")
                .build ();
        //When
        service.updateCustomerMapperApproach (dto);

        //Then
        var c = repository.findById (2l).orElse (new CustomerEntity ());
        System.out.println (c);
        assertEquals (c.name,"joaleson" );
        assertEquals (c.phone,"123" );
    }

    @Test
    void threads() throws IOException, URISyntaxException {
        String file = "src/test/resources/ParaTestarThread.txt";
        Path path = Paths.get(file);
        BufferedReader reader = Files.newBufferedReader(path);
        String data = reader.lines ().collect(Collectors.joining("\n"));

        String str = "hello";
        FileOutputStream writer = new FileOutputStream (file);
        byte[] strToBytes = str.getBytes();



        Thread t1 = new Thread (()->{
            System.out.println (data);
            try {
                writer.write(strToBytes);
                writer.close ();
            } catch (IOException e) {
                throw new RuntimeException (e);
            }
        });

        Thread t2 = new Thread (()->{
            System.out.println (data);
        });

        t1.start ();
        t2.start ();


        reader.close ();

    }

}

