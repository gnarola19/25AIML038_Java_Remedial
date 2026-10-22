
import java.util.Scanner;

class item {
    private final String name;
    private final int prices;

    public item(String name, int prices) {
        this.name = name;
        this.prices = prices;
    }

    public String Name() {
        return name;
    }

    public int price() {
        return prices;
    }

    public static item findItem(char code) {
        return switch(code) {
            case 'T' -> new item("Tea", 10);
            case 'C' -> new item("Coffee", 15);
            case 'S' -> new item("Samosa", 12);
            case 'P' -> new item("Puff", 20);
            default -> null;
        };
    }
}

class Order {
    private int tokenNo;
    private item items;
    private int qty;

    private static int nexttoken = 101;
    private static int totalorders = 0;
    private static int totalsales = 0;

    public Order(item items, int qty) {
        this.items = items;
        this.qty = qty;
        this.tokenNo = nexttoken++;

        totalorders++;
        totalsales += getamount();
    }

    public int getamount() {
        return items.price() * qty;
    }

    public static int getTotalOrders() {
        return totalorders;
    }

    public static int getTotalSales() {
        return totalsales;
    }

    @Override
    public String toString() 
    {
        return "Token "+tokenNo+" : "+items.Name() +" x "+ qty +" = "+ getamount();
    }
}

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            char code = sc.next().charAt(0);
            int qty = sc.nextInt();

            item items = item.findItem(code);

            if (items == null || qty <= 0) {
                System.out.println("Invalid order: " + code + " " + qty);
            } else {
                Order order = new Order(items, qty);
                System.out.println(order);
            }
        }

        System.out.println("Total order:- " + Order.getTotalOrders());
        System.out.println("Total sales:- "+ Order.getTotalSales());

        sc.close();
    }
}
