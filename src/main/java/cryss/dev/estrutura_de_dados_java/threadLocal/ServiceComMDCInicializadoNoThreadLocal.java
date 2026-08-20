package cryss.dev.estrutura_de_dados_java.threadLocal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.UUID;

public class ServiceComMDCInicializadoNoThreadLocal {

    //inicializa o logger na minha classe de serviço
    private static final Logger logger = LoggerFactory.getLogger (ServiceComMDCInicializadoNoThreadLocal.class);
    private static final ThreadLocal<String> requestId = new ThreadLocal<> ();

    public void processRequest(){
        //Inicializando a variável thread local
        requestId.set (generateRequestID ());
        //O id dessa configuração no mdc será registrado com o valor da threadLocal
        MDC.put ("requestId", requestId.get ());

        logger.info ("Processando requisição... " + MDC.get ("requestId"));

        //depois de processar limpa o contexto/sessão/momento
        requestId.remove ();
        MDC.clear ();

        /*
        O ID da solicitação é acessado dentro do método
        processRequest() e incluído na mensagem de log gerada por `logger.info()`
        * */
    }

    //um método para gerar um hash único que será utilizado para
    //registrar e recuperar informações dessa solicitação nos diferentes serviços
    //que serão afetados por essa operação
    private String generateRequestID(){
        return UUID.randomUUID ().toString ();
    }

}
