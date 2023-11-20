package laba1;

public enum SizeApple {
    SMALL(20, "Маленький"), BIG(1000, "Большой");
    private int calories;
    private String name;
    SizeApple(int calories, String name){
        this.calories = calories;
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }
}
