package cryss.dev.estrutura_de_dados_java.decorators_new_approach.domain;

import java.util.Map;

public record Request(String ip, Map<String, String> headers) {
}
