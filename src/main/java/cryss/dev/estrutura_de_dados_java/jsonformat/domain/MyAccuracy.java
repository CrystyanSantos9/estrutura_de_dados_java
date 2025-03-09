package cryss.dev.estrutura_de_dados_java.jsonformat.domain;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target (ElementType.FIELD)
@Retention (RetentionPolicy.RUNTIME)
public @interface MyAccuracy {
    int value() default 0;
}
