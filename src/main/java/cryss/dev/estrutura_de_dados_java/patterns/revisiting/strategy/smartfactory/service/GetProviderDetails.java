package cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.smartfactory.service;

import cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.smartfactory.domain.BrandEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
public class GetProviderDetails {

    private final ProviderClient client;
    private final ProviderClientStrategy strategy;

   public void call(BrandEnum brandEnum){
        List<String> response = client.makeCall (strategy::callFunction);
        log.info ("Response {} ", response);
    }

}
