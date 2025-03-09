package cryss.dev.estrutura_de_dados_java.jsonformat.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import cryss.dev.estrutura_de_dados_java.jsonformat.JsonFormatTo;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape;

/*
 Onde estuadar: https://www.baeldung.com/jackson-jsonformat

Para terminar de testar: https://stackoverflow.com/questions/74956508/serialise-bigdecimal-value-with-customised-scale-per-class-field

* */

@Getter
@Setter
// @JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES) --> aceita que a propriedades venham com maiúsculo e minúsculos
class User {
    private String firstName;
    private String lastName;

//    @MyAccuracy(0)
    @JsonFormat(pattern = "#.00")
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal amount1;

    @JsonFormat(pattern = "#.00")
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal amount2;

    @JsonFormat(pattern = "#.000")
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal amount3;

    public void calculate(BigDecimal amount1, BigDecimal amount2){
        this.amount2 = amount1.multiply (amount2.divide (BigDecimal.valueOf (100), MathContext.DECIMAL128));
    }



    /*
    *  shape => tipo do formato retornado, NUMBER, STRING
    *  pattern = Format da string de saída SimpleDateFormat
    * */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
    private Date createdDate = new Date ();

    public User(String firstName, String lastName, BigDecimal amount1, BigDecimal amount2, BigDecimal amount3) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.amount1 = amount1;
        this.amount2 = amount2;
        this.amount3 = amount3;
    }

    @Override
    public String toString() {
       return JsonFormatTo.toString (this);
    }
}

class MoneySerializer extends StdSerializer<BigDecimal> implements ContextualSerializer {

    private static final MoneySerializer INSTANCE = new MoneySerializer();

    private final NumberFormat formatter;
    private final Shape shape;

public MoneySerializer(){
    this(DecimalFormat.getInstance (), Shape.STRING);
}

protected MoneySerializer(NumberFormat formatter, Shape shape){
    super(BigDecimal.class);
    this.formatter = Objects.requireNonNull (formatter);
    this.shape = Objects.requireNonNull (shape);
}

    @Override
    public void serialize(BigDecimal value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if(Objects.isNull (value)){
            jsonGenerator.writeNull ();
        }else {
            switch (shape){
                case NUMBER, NUMBER_FLOAT, NATURAL -> jsonGenerator.writeNumber (value.setScale (formatter.getMaximumFractionDigits (), RoundingMode.HALF_DOWN));
                case NUMBER_INT -> jsonGenerator.writeNumber (value.intValue ());
                default -> jsonGenerator.writeString (formatter.format (value));
            }
        }
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider provider, BeanProperty property){
        JsonFormat jsonFormat = property.getAnnotation (JsonFormat.class);
        if(Objects.isNull (jsonFormat)){
            return INSTANCE;
        }
        return new MoneySerializer(new DecimalFormat(jsonFormat.pattern()), jsonFormat.shape());
    }
}