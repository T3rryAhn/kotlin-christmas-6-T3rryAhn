package christmas.util;

import christmas.domain.type.Benefit;
import christmas.domain.type.Menu;

import java.util.Map;

public class MapToStringConverter {
    private static final String MENU_AND_QUANTITY = "%s %d개";
    private static final String BENEFIT_AND_PRICE = "%s: -%,d원";

    public static String orderToString(Map<Menu, Integer> menuAndQuantity) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<Menu, Integer> entry : menuAndQuantity.entrySet()) {
            Menu menu = entry.getKey();
            int quantity = entry.getValue();
            String formattedString = String.format(MENU_AND_QUANTITY, menu.getName(), quantity);

            stringBuilder.append(formattedString)
                    .append("\n");
        }

        return stringBuilder.toString();
    }

    public static String benefitToString(Map<Benefit, Integer> benefitAndPrice) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<Benefit, Integer> entry : benefitAndPrice.entrySet()) {
            Benefit benefit = entry.getKey();
            int price = entry.getValue();
            String formattedString = String.format(BENEFIT_AND_PRICE, benefit.getDescription(), price);

            stringBuilder.append(formattedString)
                    .append("\n");
        }

        return stringBuilder.toString();
    }
}
