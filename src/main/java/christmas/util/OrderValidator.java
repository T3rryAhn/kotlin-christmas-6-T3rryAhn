package christmas.util;

import christmas.domian.type.Menu;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class OrderValidator {
    private static final int MIN_AMOUNT = 1;
    private static final int MAX_AMOUNT = 20;
    private static final String INPUT_PATTERN = "([\\S]+-\\d+)(,[\\S]+-\\d+)*";
    private static final String NEW_LINE = "\n";
    private static final String INVALID_ORDER_MESSAGE = "유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final String BEVERAGE_ONLY_MESSAGE = "음료만 주문할 수 없습니다.";
    private static final String INVALID_ORDER_AMOUNT_MESSAGE = "메뉴는 한 번에 1개이상, 최대 20개까지만 주문할 수 있습니다.";
    private static final String MENU_NOT_EXIST_MESSAGE = "존재하지 않는 메뉴입니다.";
    private static final String DUPLICATED_MENU_ORDER_MESSAGE = "중복된 메뉴 항목이 있습니다.";

    public static void validateInput(String input) {
        checkInputPattern(input);
        List<String> menuNames = parseMenuName(input);
        checkDuplicated(menuNames);
        for (String menuName : menuNames) {
            checkMenu(menuName);
        }
    }

    public static void validateOrder(Map<Menu, Integer> order) {
        checkAmount(order);
        checkBeverageOnly(order);
    }

    private static void checkBeverageOnly(Map<Menu, Integer> order) {
        if (order.keySet()
                .stream()
                .allMatch(menu -> menu.getCategory() == Menu.Category.BEVERAGE)) {
            throw new ValidationException(INVALID_ORDER_MESSAGE + NEW_LINE + BEVERAGE_ONLY_MESSAGE);
        }
    }

    private static void checkAmount(Map<Menu, Integer> order) {
        int totalAmount = order.values()
                .stream()
                .mapToInt(Integer::intValue).sum();

        if (totalAmount < MIN_AMOUNT || totalAmount > MAX_AMOUNT) {
            throw new ValidationException(INVALID_ORDER_MESSAGE + NEW_LINE + INVALID_ORDER_AMOUNT_MESSAGE);
        }

        for (Integer amount : order.values()) {
            if (amount < MIN_AMOUNT) {
                throw new ValidationException(INVALID_ORDER_MESSAGE + NEW_LINE + INVALID_ORDER_AMOUNT_MESSAGE);
            }
        }
    }

    private static void checkMenu(String menuName) {
        boolean menuExists = Arrays.stream(Menu.values()).anyMatch(menu -> menu.getName().equals(menuName));

        if (!menuExists) {
            throw new ValidationException(INVALID_ORDER_MESSAGE + NEW_LINE + MENU_NOT_EXIST_MESSAGE);
        }
    }
    private static void checkDuplicated(List<String> menuNames) {
        Set<String> uniqueMenuNames = new HashSet<>();

        for (String name : menuNames) {
            if (!uniqueMenuNames.add(name)) {
                throw new ValidationException(INVALID_ORDER_MESSAGE + NEW_LINE + DUPLICATED_MENU_ORDER_MESSAGE);
            }
        }
    }

    private static void checkInputPattern(String input) {
        if (input == null || !Pattern.matches(INPUT_PATTERN, input)) {
            throw new ValidationException(INVALID_ORDER_MESSAGE);
        }
    }

    private static List<String> parseMenuName(String input) {
        List<String> menuNames = Arrays.stream(input.split(","))
                .map(order -> order.trim().split("-")[0].trim())
                .collect(Collectors.toList());

        return menuNames;
    }

}
