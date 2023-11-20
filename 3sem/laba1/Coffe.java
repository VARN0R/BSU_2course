package laba1;

import java.util.Objects;

public class Coffe extends Food {
    private Aroma aroma;

    public void consume() {
        System.out.println(this + " выпито");
    }

    public Coffe(Aroma aroma) {
        super("Кофе");
        this.aroma = aroma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffe coffe = (Coffe) o;
        return aroma == coffe.aroma;
    }

    @Override
    public int hashCode() {
        return Objects.hash(aroma);
    }

    @Override
    public int calcCalories()
    {
        return aroma.getCalories();
    }

    @Override
    public String toString() {
        return super.toString() +
                " аромата " + aroma.toString();
    }
}
