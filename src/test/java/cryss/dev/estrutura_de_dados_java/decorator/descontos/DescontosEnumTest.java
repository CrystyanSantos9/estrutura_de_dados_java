package cryss.dev.estrutura_de_dados_java.decorator.descontos;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DescontosEnumTest {

    @Test
    void test(){
        String code = "comum";
        DescontosEnum comum = DescontosEnum.getEnumFromCode (code);

        Produto pBola = Produto.builder()
                .name ("Bola")
                .preco (new BigDecimal ("35.50"))
                .build();

        Order newOrder = Order.
                builder ()
                .quemSolicitou ("gusta")
                .desconto (comum)
                .produto (pBola)
                .qtd (5L)
                .build ();

        DescontosMais descontoComum = new DescontoComum(newOrder);
//        descontoComum.calculaDesconto ();
        //sempre o ultimo desconto é que deve ser chamado
        DescontosMais descontoGirls = new DescontoGirl (descontoComum, newOrder);
        descontoGirls.calculaDesconto ();

        //tem uma maneira mais bonita de trabalhar com decoradores
        //e eles podem desempenhar diversas outras funcionalidades como
        //fazer o log
        //enviar mensagens
        //fazer validações
        System.out.println (newOrder);


    }
}