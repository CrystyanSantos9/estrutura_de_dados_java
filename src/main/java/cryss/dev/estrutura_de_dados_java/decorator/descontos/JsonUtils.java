package cryss.dev.estrutura_de_dados_java.decorator.descontos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


public class JsonUtils {

    private final static ObjectMapper objectMapper = new ObjectMapper ();

    public static String convert(Object object) throws JsonProcessingException {
        objectMapper.findAndRegisterModules ()
                .writerWithDefaultPrettyPrinter ();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        return objectMapper.writeValueAsString (object);
    }
}
