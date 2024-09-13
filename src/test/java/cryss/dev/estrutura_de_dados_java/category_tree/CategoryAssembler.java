package cryss.dev.estrutura_de_dados_java.category_tree;

public class CategoryAssembler {
    public static CategoryFlat buildCategoryFlat(Category category){
        return CategoryFlat.builder ()
                .name (category.getName ())
                .build ();
    }
}
