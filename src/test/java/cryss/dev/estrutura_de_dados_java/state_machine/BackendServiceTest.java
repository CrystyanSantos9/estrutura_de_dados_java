package cryss.dev.estrutura_de_dados_java.state_machine;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


//@ExtendWith (SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
//@EnableAutoConfiguration
//@ComponentScan(basePackages = {"cryss.dev.estrutura_de_dados_java.state_machine"})
class BackendServiceTest {

    @Autowired
    private BackendService backendService;


    @Test
    void testaEstados(){
        backendService.iniciProcessamento ();
        backendService.validandoObrigatorios ();
        backendService.enviandoIntegracao ();
        backendService.finalizando();
//        backendService.falha();
    }
}