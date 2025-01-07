package cryss.dev.estrutura_de_dados_java.liskov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {
    @Test
    void testandoBuilderDeCategory(){
        Category category = new Category.Builder ().withName ("Charles").build ();

        assertEquals ("Charles", category.getName ());
    }
}