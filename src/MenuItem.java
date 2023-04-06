import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuItem {
    protected String name;
    protected double cost;
    private int water;
    private int milk;
    private int coffee;
    protected Map<String, Integer> ingredients;

    public MenuItem(String name, double cost, int water, int milk, int coffee) {
        this.name = name;
        this.cost = cost;
        this.ingredients = new HashMap();
        ingredients.put("water", water);
        ingredients.put("milk", milk);
        ingredients.put("coffee", coffee);
    }
}

