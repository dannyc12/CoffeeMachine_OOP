import java.io.Console;
import java.math.BigDecimal;
import java.text.NumberFormat;

public class Main {
    static NumberFormat mf = NumberFormat.getCurrencyInstance();

    public static void main(String[] args) {
        boolean isOn = true;

        Menu menu = new Menu();
        CoffeeMaker maker = new CoffeeMaker();
        MoneyMachine machine = new MoneyMachine();

        menu.getItems();
        machine.report();

        while (isOn) {
            System.out.println("Here are your drink options:");
            menu.getItems();
            System.out.println("What would you like? ");
            String choice = System.console().readLine();
            if (choice.equals("off")) {
                isOn = false;
            } else if (choice.equals("report")) {
                machine.report();
                maker.getResources();
            } else {
                MenuItem drink = menu.findMenuItem(choice);
                BigDecimal cost = new BigDecimal(drink.cost);
                System.out.printf("Ok, a %s costs %s%n", drink.name, mf.format(drink.cost));
                if (maker.hasSufficientResources(drink) && machine.makePayment(cost)) {
                    maker.makeDrink(drink);
                }
            }
        }
    }
}
