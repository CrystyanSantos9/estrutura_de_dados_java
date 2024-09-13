package cryss.dev.estrutura_de_dados_java.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JSONSerializer {
    public static <R, T> R toString(T object) throws JsonProcessingException {
        return (R) new ObjectMapper ()
                .registerModule (new JavaTimeModule ())
                .writerWithDefaultPrettyPrinter ()
                .writeValueAsString (object);
    }
}
