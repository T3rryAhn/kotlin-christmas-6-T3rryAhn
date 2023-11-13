package christmas;

import christmas.domian.type.Menu;

import java.util.Map;

public class TestConstants {
    public static final String ERROR = "[ERROR] ";
    public static final String INVALID_ORDER_MESSAGE = "유효하지 않은 주문입니다. 다시 입력해 주세요.";

    //Case: 올바른 주문
    public static final String ORDER_CORRECT_INPUT1 = "타파스-1,제로콜라-1";
    public static final String ORDER_CORRECT_INPUT2 = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
    public static final String ORDER_CORRECT_INPUT3 = "양송이수프-1,시저샐러드-1,티본스테이크-1,크리스마스파스타-1,초코케이크-1,제로콜라-4,샴페인-1";
    public static final Map<Menu, Integer> ORDER_CORRECT_ORDER1 = Map.of(Menu.TAPAS, 1, Menu.ZERO_COKE, 1);
    public static final Map<Menu, Integer> ORDER_CORRECT_ORDER2 = Map.of(Menu.T_BONE_STEAK, 1, Menu.BBQ_RIBS, 1, Menu.CHOCOLATE_CAKE, 2, Menu.ZERO_COKE, 1);
    public static final Map<Menu, Integer> ORDER_CORRECT_ORDER3 = Map.of(Menu.MUSHROOM_SOUP, 1, Menu.CAESAR_SALAD, 1, Menu.T_BONE_STEAK, 1, Menu.CHRISTMAS_PASTA, 1, Menu.CHOCOLATE_CAKE, 1, Menu.ZERO_COKE, 4, Menu.CHAMPAGNE, 1);

    //Case: 잘못된 주문
    public static final String ORDER_DUPLICATED_INPUT1 = "타파스-1,타파스-1";
    public static final String ORDER_ONLY_BEVERAGE_INPUT1 = "제로콜라-1";
    public static final String ORDER_ONLY_BEVERAGE_INPUT2 = "제로콜라-1,샴페인-2,레드와인-1";
    public static final String ORDER_UNDER_MIN_AMOUNT_INPUT1 = "타파스-0";
    public static final String ORDER_UNDER_MIN_AMOUNT_INPUT2 = "타파스-1,제로콜라-0";
    public static final String ORDER_OVER_MAX_AMOUNT_INPUT1 = "타파스-21";
    public static final String ORDER_OVER_MAX_AMOUNT_INPUT2 = "타파스-20,제로콜라-1";
    public static final String ORDER_NON_EXISTS_MENU_INPUT1 = "과일빙수-1";
    public static final String ORDER_NON_EXISTS_MENU_INPUT2 = "타파스-1,과일빙수-1";
    //잘못된 주문에 대한 Map 정의
    public static final Map<Menu, Integer> ORDER_ONLY_BEVERAGE_ORDER1 = Map.of(Menu.ZERO_COKE, 1);
    public static final Map<Menu, Integer> ORDER_ONLY_BEVERAGE_ORDER2 = Map.of(Menu.ZERO_COKE, 1, Menu.CHAMPAGNE, 2, Menu.RED_WINE, 1);
    public static final Map<Menu, Integer> ORDER_UNDER_MIN_AMOUNT_ORDER1 = Map.of(Menu.TAPAS, 0);
    public static final Map<Menu, Integer> ORDER_UNDER_MIN_AMOUNT_ORDER2 = Map.of(Menu.TAPAS, 1, Menu.ZERO_COKE, 0);
    public static final Map<Menu, Integer> ORDER_OVER_MAX_AMOUNT_ORDER1 = Map.of(Menu.TAPAS, 21);
    public static final Map<Menu, Integer> ORDER_OVER_MAX_AMOUNT_ORDER2 = Map.of(Menu.TAPAS, 20, Menu.ZERO_COKE, 1);



}
