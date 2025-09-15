package cryss.dev.estrutura_de_dados_java.decorator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.Context;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith (MockitoExtension.class)
class BebidaTest {

    @Test
    @DisplayName ("Deve criar um café escuro com leite e retornar o seu total")
    void costWhenCafeEscuroCreateSuccessfull(){
        Leite leite = new Leite (BigDecimal.TEN);
        CafeEscuro cafeEscuro = new CafeEscuro (BigDecimal.TEN, leite);

        CafeEscuro cafeEscuroDuplo = new CafeEscuro (BigDecimal.TEN, cafeEscuro);

        var costCalculated = BigDecimal.valueOf (20.00).setScale(2, RoundingMode.HALF_UP);;

        assertEquals (costCalculated, cafeEscuro.cost () );
        assertEquals (costCalculated, cafeEscuroDuplo.cost () );
    }

}