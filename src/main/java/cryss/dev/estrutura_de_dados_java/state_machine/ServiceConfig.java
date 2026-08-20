package cryss.dev.estrutura_de_dados_java.state_machine;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Bean
    public BackendService backendService(){
        return new BackendService (new StateMachine ());
    }
}
