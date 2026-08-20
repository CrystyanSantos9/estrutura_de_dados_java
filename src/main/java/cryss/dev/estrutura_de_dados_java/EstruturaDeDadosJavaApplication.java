package cryss.dev.estrutura_de_dados_java;

import cryss.dev.estrutura_de_dados_java.threadLocal.ServiceComMDCInicializadoNoThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
//@SpringBootApplication(scanBasePackages = "cryss.dev.estrutura_de_dados_java" )
public class EstruturaDeDadosJavaApplication implements CommandLineRunner {

	@Autowired
	private ServiceComMDCInicializadoNoThreadLocal serviceComMDCInicializadoNoThreadLocal;;

	public static void main(String[] args) {
		SpringApplication.run(EstruturaDeDadosJavaApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		serviceComMDCInicializadoNoThreadLocal.processRequest ();
	}
}
