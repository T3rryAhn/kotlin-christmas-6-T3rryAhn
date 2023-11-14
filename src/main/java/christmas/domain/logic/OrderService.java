package christmas.domain.logic;

import christmas.domain.type.Menu;

import java.util.Map;

public class OrderService {

    public int calculateTotalPrice(Map<Menu, Integer> order) {
        int total = 0;

        for (Map.Entry<Menu, Integer> entry : order.entrySet()) {
            Menu menu = entry.getKey();
            int quantity = entry.getValue();
            total += menu.getPrice() * quantity;
        }

        return total;
    }

    public int calculateTotalDiscount() {
        int total = 0;


        return total;
    }


}
