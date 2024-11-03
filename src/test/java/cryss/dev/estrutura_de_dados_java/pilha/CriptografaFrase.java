package cryss.dev.estrutura_de_dados_java.pilha;

public class CriptografaFrase {

    public static class WrapperChar {
        private char aChar;

        public WrapperChar(char aChar) {
            this.aChar = aChar;
        }

        public char getaChar() {
            return aChar;
        }
    }
    public static String criptografa(String frase){

        Pilha<WrapperChar> pilhaFrase = new Pilha<> ();

        String reverse = new StringBuffer(frase).reverse ().toString ();
        char[] arrayDaFrase = reverse.toCharArray ();

        for(int i = arrayDaFrase.length -1; i > 0 ; i--){
            //Fazendo wrapper porque generics nao aceita primitivo
            pilhaFrase.inserenotopo (new WrapperChar (arrayDaFrase[i]));
        }

        StringBuilder stringContrario = new StringBuilder ();
        
        while (!pilhaFrase.Isvazia ()){
            stringContrario.append (pilhaFrase.removedotop ().getaChar ());
        }

        return new String (stringContrario);

    }
}
