package laba1;

public enum Aroma {
    SATURATED(1),
    BITTER(2),
    EASTERN(3);

    private int calories;

    Aroma(int calories){
        this.calories = calories;
    }
    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
