package cryss.dev.estrutura_de_dados_java.patterns.old.decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BebidaTest {
@Test
    void criaCafeMineiroComLeite(){

    Bebida cafeMineiro = new CafeMineiro ();
    Bebida comLeite = new Leite (cafeMineiro);
    Bebida comDescontoCartao = new DescontoCartao(comLeite);

    System.out.println (comDescontoCartao.getDescription ());
    System.out.println (comDescontoCartao.cost ());

}
}