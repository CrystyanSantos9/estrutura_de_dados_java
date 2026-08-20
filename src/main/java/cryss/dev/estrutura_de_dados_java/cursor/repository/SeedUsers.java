package cryss.dev.estrutura_de_dados_java.cursor.repository;

import cryss.dev.estrutura_de_dados_java.cursor.domain.UserCursor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SeedUsers implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println ("Executando a inclusão de dados iniciais");

        for(int i=0; i<100; i++){
            UserCursor userCursor = new UserCursor (null, "name" + i);
            userRepository.save (userCursor);
        }

        System.out.println ("Finalizando a inclusão de dados iniciais");
    }
}
