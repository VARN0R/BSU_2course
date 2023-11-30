package laba1;

public class Apple extends Food {
    // Новое внутреннее поле данных РАЗМЕР
    private SizeApple size;
    public Apple(SizeApple size) {
// Вызвать конструктор предка, передав ему имя класса
        super("Яблоко");
// Инициализировать размер яблока
        this.size = size;
    }
    // Переопределить способ употребления яблока
    public void consume() {
        System.out.println(this + " съедено");
    }
    // Селектор для доступа к полю данных РАЗМЕР
    public String getAppleSize() {
        return size.getName();
    }

    public int getAppleCalories() {
        return size.getCalories();
    }
    // Модификатор для изменения поля данных РАЗМЕР
    public void setSize(SizeApple size) {
        this.size = size;
    }
    // Переопределенная версия метода equals(), которая при сравнении
// учитывает не только поле name (Шаг 1), но и проверяет совместимость
// типов (Шаг 2) и совпадение размеров (Шаг 3)
    public boolean equals(Object arg0) {
        if (super.equals(arg0)) { // Шаг 1
            if (!(arg0 instanceof Apple)) return false; // Шаг 2
            return size.equals(((Apple)arg0).size); // Шаг 3
        } else
            return false;
    }
    // Переопределенная версия метода toString(), возвращающая не только
// название продукта, но и его размер
    public String toString() {
        return super.toString() + " размера '" + size + "'";
    }

    @Override
    public int calcCalories() {

        return size.getCalories();
    }
}