package laba3;

import javax.swing.table.AbstractTableModel;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GornerTableModel extends AbstractTableModel {
    private final Double from;
    private final Double to;
    private final Double step;
    private final Double[] coeff;

    private final Double[] coeffReversed;
    private final Object[][] table;
    private final int numberOfRows;

    public GornerTableModel(Double from,
                            Double to,
                            Double step,
                            Double[] coefficients
    ) {
        this.from = from;
        this.to = to;
        this.step = step;
        numberOfRows = (int) Math.ceil((to - from)/step) + 1;
        coeff = coefficients;
        coeffReversed = new Double[coeff.length];
        for (int i = 0; i < coefficients.length; i++) {
            coeffReversed[coefficients.length - i - 1] = coefficients[i];
        }

        table = new Object[numberOfRows][3];

        precalculate();
    }

    public Double getFrom() {
        return from;
    }

    public Double getTo() {
        return to;
    }

    public Double getStep() {
        return step;
    }

    public int getColumnCount() {
// В данной модели два столбца
        return 3;
    }

    public int getRowCount() {
// Вычислить количество точек между началом и концом отрезка
// исходя из шага табулирования
        return Double.valueOf(numberOfRows).intValue();
    }

    public Object getValueAt(int row, int col) {
// Вычислить значение X как НАЧАЛО_ОТРЕЗКА + ШАГ*НОМЕР_СТРОКИ
        return table[row][col];
    }

    public String getColumnName(int col) {
        return switch (col) {
            case 0 -> "Значение X";
            case 1 -> "Значение многочлена";
            case 2 -> "Простое число?";
            default -> "";
        };
    }

    public Class<?> getColumnClass(int col) {
        return Double.class;
    }

    private double calculate(double x, Double[] coeff) {

        Double[] gornerElems = new Double[coeff.length];
        gornerElems[0] = coeff[0];
        for (int i = 1; i < gornerElems.length; i++) {
            gornerElems[i] = gornerElems[i-1] * x + coeff[i];
        }
        return gornerElems[gornerElems.length - 1];
    }

    private void precalculate() {
        for (int i = 0; i < numberOfRows; i++) {
            table[i][0] = from + step * i;
            table[i][1] = calculate((double)table[i][0], coeff);

            table[i][2] = isPrime((double)table[i][1]);

        }
    }
    private boolean isPrime(double number) {
        int roundedNumber = (int)Math.floor(number);
        for (int i = 2; i < roundedNumber; i++){
            if( roundedNumber % i == 0){
                return false;
            }
        }
        return true;
    }
}