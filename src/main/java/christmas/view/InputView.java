package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domian.type.Menu;
import christmas.util.DateValidator;
import christmas.util.OrderValidator;
import christmas.util.ValidationException;

import java.util.HashMap;
import java.util.Map;

public class InputView {
    private static final String ASK_DATE_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String ASK_ORDER_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    public int readDate() {
        while (true) {
            try {
                System.out.println(ASK_DATE_MESSAGE);
                String input = Console.readLine();
                DateValidator.validateInput(input);
                int date = Integer.parseInt(input);
                return date;
            } catch (ValidationException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Map<Menu, Integer> readOrder() {
        while (true) {
            try {
                System.out.println(ASK_ORDER_MESSAGE);
                String input = Console.readLine();
                OrderValidator.validateInput(input);
                Map<Menu, Integer> order = parseOrder(input);
                OrderValidator.validateOrder(order);

                return order;
            } catch (ValidationException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Map<Menu, Integer> parseOrder(String input) {
        Map<Menu, Integer> order = new HashMap<>();

        String[] items = input.split(",");
        for (String item : items) {
            String[] parts = item.trim()
                    .split("-");
            String menuName = parts[0].trim();
            int amount = Integer.parseInt(parts[1].trim());

            Menu menu = Menu.findByName(menuName);
            order.put(menu, amount);
        }
        return order;
    }
}
