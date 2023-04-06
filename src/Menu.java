import java.lang.reflect.Array;

public class Menu {
    protected static MenuItem[] menu = {
            new MenuItem("latte", 2.5, 200, 150, 24),
            new MenuItem("espresso", 1.5, 50, 0, 18),
            new MenuItem("cappuccino", 3, 250, 50, 24)
    };

    public void getItems() {
        for (MenuItem item : menu) {
            System.out.printf("%s ", item.name);
        }
        System.out.println();
    }

    public MenuItem findMenuItem(String drink) {
        for (MenuItem item : menu) {
            if (drink.equals(item.name)) {
                return item;
            }
        }
        System.out.println("Sorry, that drink is not available");
        return null;
    }
}


