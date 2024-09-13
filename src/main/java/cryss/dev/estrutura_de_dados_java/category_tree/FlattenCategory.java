package cryss.dev.estrutura_de_dados_java.category_tree;

import org.apache.commons.lang3.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

public class FlattenCategory {
    public static List<Category> flattenCategoryTree(Category root){
        List<Category> flatList = new ArrayList<> ();
        flattenHelper(root, flatList);
        return flatList;
    }

    private static void flattenHelper(Category category, List<Category> flatList){
        flatList.add(category);
        for (Category subcategory : category.getSubcategories()) {
            flattenHelper(subcategory, flatList);
        }
    }
}
