package christmas.domain.type;

public enum Benefit {
    CHRISTMAS_D_DAY("크리스마스 디데이 할인"),
    WEEKDAY("평일 할인"),
    WEEKEND("주말 할인"),
    SPECIAL("특별 할인"),
    GIVEAWAY("증정 이벤트");

    private final String description;

    Benefit(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
