package cryss.dev.estrutura_de_dados_java.decorators_new_approach.new_approach;

import cryss.dev.estrutura_de_dados_java.decorators_new_approach.domain.Request;

import java.util.Map;
import java.util.Objects;

public class ModernDecorator {
    public static void main(String[] args) {
        //instanciamos no agregador de decoradores
        var processors = new RequestProcessors ();

        //criamos uma funcao vazia para controlarmos a ordem de invocacao dos
        // demais decoradores
        RequestProcessor emptyFunction = __ ->{};

        var processorPipeline = emptyFunction.andThen (processors::loggingProcessor)
                .andThen (processors::validationProcessor)
                .andThen (processors::baseProcessor);

        var headers = Map.of ("Authorization", "Bearer token123");
        var validaRequest = new Request ("123", headers);
        var invalidRequest = new Request ("123", null);

        try{
            processorPipeline.process (validaRequest);
            processorPipeline.process (invalidRequest);
        }catch (Exception e){
            System.out.println (e.getMessage ());
        }
    }
}

@FunctionalInterface
interface RequestProcessor{

    void process(Request request);

    default RequestProcessor andThen(RequestProcessor next){
        return request -> {
            this.process (request);
            next.process (request);
        };
    }

}

class RequestProcessors {
    void loggingProcessor(Request request){
        System.out.println ("Logging " + request);
    }

    void validationProcessor(Request request){
        if(isRequestInvalid(request)){
            throw new IllegalArgumentException ("Missing Authorization header.");
        }
    }

    void baseProcessor(Request request){
        System.out.println ("Request " + request.ip () + " processed!");
    }

    private boolean isRequestInvalid(Request request) {
        return Objects.isNull (request) && !request.headers ().containsKey ("Authorization");
    }
}