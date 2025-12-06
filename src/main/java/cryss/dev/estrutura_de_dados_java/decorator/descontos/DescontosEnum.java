package cryss.dev.estrutura_de_dados_java.decorator.descontos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Arrays;


@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum DescontosEnum {

    COMUM("comum"),
    QUALITA("qualita"),
    GIRLS("girls");

    public String code;

    DescontosEnum(String code) {
        this.code = code;
    }

    @JsonGetter
    public static DescontosEnum getEnumFromCode(String code){
        return Arrays.stream(DescontosEnum.values ())
                .filter (descontosEnum -> code.equals (descontosEnum.code))
                .findFirst ()
                .orElseThrow (()-> new RuntimeException ("Failed to generate enum for code: " + code));
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        try {
            return JsonUtils.convert (this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException (e);
        }
    }
}
