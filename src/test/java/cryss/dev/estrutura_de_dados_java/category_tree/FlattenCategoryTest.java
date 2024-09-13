package cryss.dev.estrutura_de_dados_java.category_tree;

import org.junit.jupiter.api.Test;

import java.util.List;

class FlattenCategoryTest {

    @Test
    void categoryTreeToListFlattenOfCategories(){

        Category root = Category.builder ()
                .name ("Root")
                .build ();

        Category sub1 = Category.builder ()
                .name ("sub1")
                .build ();

        Category sub2 = Category.builder ()
                .name ("sub2")
                .build ();

        Category sub1a = Category.builder ()
                .name ("sub1a")
                .build ();

        Category sub1b = Category.builder ()
                .name ("sub2a")
                .build ();

        root.addSubcategory (sub1);
        root.addSubcategory (sub2);
        sub1.addSubcategory (sub1a);
        sub1.addSubcategory (sub1b);

        System.out.println (root);

        List <CategoryFlat> flatList = FlattenCategory.flattenCategoryTree (root).

                stream()
                .map (CategoryAssembler::buildCategoryFlat)
                .toList ();

        flatList.forEach (System.out::println);


    }

}