package christmas.view;

import christmas.domain.type.Menu;

import java.util.Map;

public class OutputView {
    private static final String INTRO_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String RESULT_HEAD_ORDERED_MENU = "<주문 메뉴>";
    private static final String RESULT_HEAD_TOTAL_PRICE = "<할인 전 총주문 금액>";
    private static final String RESULT_HEAD_GIVEAWAY_MENU = "<증정 메뉴>";
    private static final String RESULT_HEAD_BENEFIT_DETAILS = "<혜택 내역>";
    private static final String RESULT_HEAD_TOTAL_BENEFIT_PRICE = "<총혜택 금액>";
    private static final String RESULT_HEAD_DISCOUNTED_TOTAL_PRICE = "<할인 후 예상 결제 금액>";
    private static final String RESULT_HEAD_BADGE = "<12월 이벤트 배지>";

    public void printAll(int date, Map<Menu, Integer> order) {
        printIntro(date);
        printOrder(order);
        printTotalPrice();
        printGiveawayMenu();
        printBenefitDetails();
        printTotalBenefitPrice();
        printDiscountedPrice();
        printBadge();
    }

    public void printIntro(int date) {
        System.out.printf("\n" + INTRO_MESSAGE + "\n", date);
    }

    public void printOrder(Map<Menu, Integer> order) {
        System.out.println("\n" + RESULT_HEAD_ORDERED_MENU);

        for (Map.Entry<Menu, Integer> entry : order.entrySet()) {
            Menu menu = entry.getKey();
            int quantity = entry.getValue();

            System.out.println(menu.getName() + " " + quantity+"개");
        }
    }

    public void printTotalPrice() {
        System.out.println("\n" + RESULT_HEAD_TOTAL_PRICE);


    }

    public void printGiveawayMenu() {
        System.out.println("\n" + RESULT_HEAD_GIVEAWAY_MENU);

    }

    public void printBenefitDetails() {
        System.out.println("\n" + RESULT_HEAD_BENEFIT_DETAILS);

    }

    public void printTotalBenefitPrice() {
        System.out.println("\n" + RESULT_HEAD_TOTAL_BENEFIT_PRICE);

    }

    public void printDiscountedPrice() {
        System.out.println("\n" + RESULT_HEAD_DISCOUNTED_TOTAL_PRICE);

    }

    public void printBadge() {
        System.out.println("\n" + RESULT_HEAD_BADGE);

    }
}
