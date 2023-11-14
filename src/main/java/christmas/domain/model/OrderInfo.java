package christmas.domain.model;

import christmas.domain.type.Menu;

import java.util.Map;

public class OrderInfo {
    private final int date;
    private final Map<Menu, Integer> order;
    private final int totalOrderPrice;

    public OrderInfo(int date, Map<Menu, Integer> order) {
        this.date = date;
        this.order = order;
        this.totalOrderPrice = calculateTotalOrderPrice();
    }

    public int getDate() {
        return date;
    }
    public Map<Menu, Integer> getOrder() {
        return order;
    }

    public int getTotalOrderPrice() {
        return totalOrderPrice;
    }

    private int calculateTotalOrderPrice() {
        int totalOrderPrice = 0;

        for (Map.Entry<Menu, Integer> entry : order.entrySet()) {
            Menu menu = entry.getKey();
            int quantity = entry.getValue();

            totalOrderPrice += menu.getPrice() * quantity;
        }

        return totalOrderPrice;
    }
}
