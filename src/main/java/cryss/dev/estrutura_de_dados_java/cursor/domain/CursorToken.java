package cryss.dev.estrutura_de_dados_java.cursor.domain;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public record CursorToken(Long baseId, Long nonce) {

    //codifica o record em uma string opaca em Base64 que é enviado ao cliente
    public String encode(){
        String raw = baseId + ":" + nonce;
        return Base64
                .getUrlEncoder ()
                .withoutPadding ()
                .encodeToString (raw.getBytes (StandardCharsets.UTF_8));
    }

    //Decodifica a string enviada pelo cliente reconstruindo o cursor
    public static CursorToken decode(String obscureToken){
        try{

            //decodifica
            byte[] decodeBytes = Base64.getUrlDecoder ().decode (obscureToken);
            String raw = new String (decodeBytes, StandardCharsets.UTF_8);
            String[] parts = raw.split (":");
            //recria o objeto de cursor
            return new CursorToken (Long.parseLong (parts[0]), Long.parseLong (parts[1]));
        }catch (Exception e){
            throw new IllegalArgumentException ("Cursor inválido ou corrompido.");
        }
    }

}
