package cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.smartfactory.service;

import cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.smartfactory.domain.BrandEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith (SpringExtension.class)
class GetProviderDetailsTest {

    @InjectMocks
    GetProviderDetails service;

    @Mock
    private  ProviderClient client;

    @Mock
    private  ProviderClientStrategy strategy;

    @Test
    void call() {
        //arrange //act
        service.call (BrandEnum.GOOGLE);
    }
}