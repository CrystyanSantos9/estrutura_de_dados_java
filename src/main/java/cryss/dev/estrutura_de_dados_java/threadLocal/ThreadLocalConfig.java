package cryss.dev.estrutura_de_dados_java.threadLocal;

import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class ThreadLocalConfig {

    @Bean
    public ServiceComMDCInicializadoNoThreadLocal serviceComMDCInicializadoNoThreadLocal(){
        return new ServiceComMDCInicializadoNoThreadLocal ();
    }
}
