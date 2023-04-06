import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class CoffeeMaker {
//    private int water = 300;
//    private int milk = 200;
//    private int coffee = 100;
    protected Map<String, Integer> resources = new TreeMap<>();

    public CoffeeMaker() {
        this.resources.put("water", 300);
        this.resources.put("milk", 200);
        this.resources.put("coffee", 100);
    }


    public void getResources() {
        System.out.printf("Water remaining: %d ml%n", resources.get("water"));
        System.out.printf("Milk remaining: %d ml%n", resources.get("milk"));
        System.out.printf("Coffee remaining: %d grams%n", resources.get("coffee"));
    }

    public boolean hasSufficientResources(MenuItem drink) {
        boolean canMake = true;
        Iterator<String> it = resources.keySet().iterator();
        while (it.hasNext()) {
            String ingredient = it.next();
            int drinkIngredient = drink.ingredients.get(ingredient);
            int resourceIngredient = resources.get(ingredient);
            if (drinkIngredient > resourceIngredient) {
                System.out.println("Sorry, there is not enough " + ingredient);
                canMake = false;
            }
        }
        return canMake;
    }

    public void makeDrink(MenuItem drink) {
        //deducts from required ingredients in resources
        Iterator<String> it = drink.ingredients.keySet().iterator();
        while (it.hasNext()) {
            String ingredient = it.next();
            int resourcesIngredient = resources.get(ingredient);
            int drinkIngredient = drink.ingredients.get(ingredient);
            resources.replace(ingredient, (resourcesIngredient - drinkIngredient));
        }
        System.out.printf("Here is your %s. Enjoy!%n", drink.name);
    }
}
