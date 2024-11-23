package cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.smartfactory.service;

import cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.smartfactory.domain.BrandEnum;
import cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.smartfactory.http.AzureHttpClient;
import cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.smartfactory.http.GoogleHttpClient;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProviderClientStrategy  {


    private final GoogleHttpClient googleHttpClient;
    private final AzureHttpClient azureHttpClient;

    List<String> callFunction(BrandEnum brandEnum) {

        if ("GOOGLE".equals (brandEnum)) {
            return googleHttpClient.getBrandsTypeLeve ();
        } else if ("AZURE".equals (brandEnum)) {
            return azureHttpClient.getBrandsTypeLeve ();
        }
        return null;
    }

}
