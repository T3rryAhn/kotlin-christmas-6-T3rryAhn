package christmas.domain.type;

public enum Badge {
    STAR("별", 5_000),
    TREE("트리", 10_000),
    SANTA("산타", 20_000),

    NONE("없음", 0);

    private final String name;
    private final int condition;

    Badge(String name, int condition) {
        this.name = name;
        this.condition = condition;
    }

    public String getName() {
        return name;
    }

    public int getCondition() {
        return condition;
    }

    public static Badge findByTotalDiscount(int totalDiscount) {
        if (totalDiscount >= SANTA.condition) {
            return SANTA;
        }
        if (totalDiscount >= TREE.condition) {
            return TREE;
        }
        if (totalDiscount >= STAR.condition) {
            return STAR;
        }
        return NONE;
    }
}

