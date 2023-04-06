import javax.swing.text.NumberFormatter;
import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.io.Console;
import java.util.TreeMap;

public class MoneyMachine {
    protected final NumberFormat mf = NumberFormat.getCurrencyInstance();
    protected double profit = 0.0;
    protected double moneyReceived = 0.00;
    protected Map<String, BigDecimal> coins = new TreeMap();

    public MoneyMachine() {
        coins.put("quarters", new BigDecimal(.25));
        coins.put("dimes", new BigDecimal(.1));
        coins.put("nickles", new BigDecimal(.05));
        coins.put("pennies", new BigDecimal(.01));
    }

    public void report() {
        System.out.printf("Money: %s%n", mf.format(profit));
    }

    public String processCoins() {
        Iterator<String> it = coins.keySet().iterator();
        System.out.println("Please insert coins.");
        while (it.hasNext()) {
            String coin = it.next();
//            System.out.println(coin);
//            System.out.println(coins.get(coin));
            String userResponse = System.console().readLine("Insert number of %s: %n", coin);
            Integer userResponseInt = Integer.parseInt(userResponse);
            BigDecimal payment = new BigDecimal(userResponseInt).multiply(coins.get(coin));
            this.moneyReceived += payment.doubleValue();
            System.out.println(mf.format(this.moneyReceived));
        }
        return mf.format(this.moneyReceived);
    }

    public boolean makePayment(BigDecimal cost) {
        this.processCoins();
        BigDecimal money = new BigDecimal(this.moneyReceived);
        if (money.compareTo(cost) >= 0) {
            BigDecimal change = money.subtract(cost);
            System.out.printf("Here is %s in change%n", mf.format(change));
            this.profit += cost.doubleValue();
            this.moneyReceived = 0;
            return true;
        } else {
            System.out.println("Sorry, that's not enough money. Money refunded");
            this.moneyReceived = 0;
            return false;
        }
    }
}

