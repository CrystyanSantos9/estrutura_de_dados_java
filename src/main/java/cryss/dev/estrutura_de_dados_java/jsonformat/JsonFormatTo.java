package cryss.dev.estrutura_de_dados_java.jsonformat;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.log4j.Log4j2;


/*
*  Onde aprender sobre o objectMapper : https://www.baeldung.com/java-json-pretty-print
*  sobre prettyPrint: https://www.baeldung.com/java-json-pretty-print
*
* */
@Log4j2
public class JsonFormatTo {
    private static final ObjectMapper mapper = new ObjectMapper ()
            .registerModule (new JavaTimeModule ());


    private JsonFormatTo() {
    }

    public static <T> String toString(T obj) {
        try {
            return mapper.writerWithDefaultPrettyPrinter ().writeValueAsString (obj);
        } catch (JsonProcessingException e) {
            log.error ("method=toString, message={}", e.getMessage ());
            return "";
        }
    }
}
