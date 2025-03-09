package cryss.dev.estrutura_de_dados_java.jsonformat.domain;


import java.math.BigDecimal;

public class TestUser {
    public static void main(String[] args) {
        User user1 = new User ("Henrique", "Arroz", BigDecimal.valueOf (300.11), BigDecimal.valueOf (50.00), BigDecimal.ONE);

        user1.calculate (user1.getAmount1 (), user1.getAmount2 ());
        System.out.println (user1);
    }
}
