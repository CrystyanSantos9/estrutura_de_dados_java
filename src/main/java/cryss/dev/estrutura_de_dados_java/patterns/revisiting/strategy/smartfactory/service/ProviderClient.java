package cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.smartfactory.service;

import cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.smartfactory.domain.BrandEnum;

import java.util.List;
import java.util.function.Function;

public interface ProviderClient {
    List<String> makeCall(Function<BrandEnum, List<String>> client);

}
