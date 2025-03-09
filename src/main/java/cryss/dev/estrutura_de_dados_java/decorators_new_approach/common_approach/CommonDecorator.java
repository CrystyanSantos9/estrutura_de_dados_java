package cryss.dev.estrutura_de_dados_java.decorators_new_approach.common_approach;

import cryss.dev.estrutura_de_dados_java.decorators_new_approach.domain.Request;

import java.util.Map;

public class CommonDecorator {
    public static void main(String[] args) {

        RequestProcessor baseProcessor = new BaseRequestProcessor ();

        RequestProcessor validationProcessor = new ValidationDecorator (baseProcessor);
        RequestProcessor loggingProcessor = new LoggingDecorator (validationProcessor);

        RequestProcessor processorPipeline = loggingProcessor;

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

class BaseRequestProcessor implements RequestProcessor {
    @Override
    public void process(Request request) {
        // Actual processing
        System.out.println ("Request processed successfully");
    }
}

abstract class RequestProcessosDecorator implements RequestProcessor {
    private RequestProcessor wrappedProcessor;

    public RequestProcessosDecorator(RequestProcessor wrappedProcessor) {
        this.wrappedProcessor = wrappedProcessor;
    }

    @Override
    public void process(Request request) {
        wrappedProcessor.process (request);
    }
}

class LoggingDecorator extends RequestProcessosDecorator {

    public LoggingDecorator(RequestProcessor wrappedProcessor) {
        super (wrappedProcessor);
    }

    @Override
    public void process(Request request) {
        System.out.println ("Logging request" + request);
        super.process (request);
    }
}

class ValidationDecorator extends RequestProcessosDecorator {

    public ValidationDecorator(RequestProcessor wrappedProcessor) {
        super (wrappedProcessor);
    }

    @Override
    public void process(Request request) {
        if(isRequestInvalid (request)){
            throw new IllegalArgumentException ("Missing Authorization header");
        }
        super.process (request);
    }

    private boolean isRequestInvalid(Request request) {
        return request.headers () == null || !request.headers ().containsKey ("Authorization");
    }
}