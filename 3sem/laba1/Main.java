package laba1;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Breakfast firstBreakfast = new Breakfast();
        firstBreakfast.add(new Coffe(Aroma.EASTERN));
        firstBreakfast.add(new Cheese());
        firstBreakfast.add(new Apple(SizeApple.BIG));
        firstBreakfast.add(new Apple(SizeApple.SMALL));
        firstBreakfast.add(new Coffe(Aroma.EASTERN));

        firstBreakfast.calc(new Coffe(Aroma.EASTERN));
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-calories")) {
                firstBreakfast.calcAllCalories();
            }
            if (args[i].equals("-sort")) {
                firstBreakfast.sort();
                System.out.println(firstBreakfast);
            }
        }
    }
}