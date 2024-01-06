package laba2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Math.*;

@SuppressWarnings("serial")

public class MainFrame extends JFrame {
    // Размеры окна приложения в виде констант
    private static final int WIDTH = 400;
    private static final int HEIGHT = 320;
    // Текстовые поля для считывания значений переменных,
// как компоненты, совместно используемые в различных методах
    private JTextField textFieldX;
    private JTextField textFieldY;

    private JTextField textFieldZ;
    // Текстовое поле для отображения результата,
// как компонент, совместно используемый в различных методах
    private JTextField textFieldResult;
    // Группа радио-кнопок для обеспечения уникальности выделения в группе
    private ButtonGroup radioButtons = new ButtonGroup();
    private ButtonGroup radioButtons2 = new ButtonGroup();

    // Контейнер для отображения радио-кнопок
    private Box hboxFormulaType = Box.createHorizontalBox();
    private int formulaId = 1;

    private int memId = 1;

    private double mem1;
    private double mem2;
    private double mem3;

    // Формула №1 для рассчѐта
    public Double calculate1(Double x, Double y, Double z) {
        return pow(cos(exp(y)) + exp(pow(y, 2)) + sqrt(1 / x), 1.0 / 4)
                / pow(cos(PI * pow(z, 3)) + log(pow(1 + z, 2)), sin(y));
    }


    // Формула №2 для рассчѐта
    public Double calculate2(Double x, Double y, Double z) {
        return (1 + pow(x, z) + log(pow(y, 2)) * (1 - sin(y * z))) /
                sqrt(pow(x, 3) + 1);
    }

    // Вспомогательный метод для добавления кнопок на панель
    private void addRadioButton(String buttonName, final int formulaId) {
        JRadioButton button = new JRadioButton(buttonName);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                MainFrame.this.formulaId = formulaId;
            }
        });
        radioButtons.add(button);
        hboxFormulaType.add(button);
    }

    private void addRadioButtonMem(String buttonName, final int memId) {
        JRadioButton button = new JRadioButton(buttonName);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                MainFrame.this.memId = memId;
            }
        });
        radioButtons2.add(button);
        hboxFormulaType.add(button);
    }


    // Конструктор класса
    public MainFrame() {
        super("Вычисление формулы");
        setSize(WIDTH, HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();
// Отцентрировать окно приложения на экране
        setLocation((kit.getScreenSize().width - WIDTH) / 2,
                (kit.getScreenSize().height - HEIGHT) / 2);
        hboxFormulaType.add(Box.createHorizontalGlue());
        addRadioButton("Формула 1", 1);
        addRadioButton("Формула 2", 2);
        addRadioButtonMem("Переменная 1", 1);
        addRadioButtonMem("Переменная 2", 2);
        addRadioButtonMem("Переменная 3", 3);
        radioButtons.setSelected(
                radioButtons.getElements().nextElement().getModel(), true);
        radioButtons2.setSelected(
                radioButtons2.getElements().nextElement().getModel(), true);
        hboxFormulaType.add(Box.createHorizontalGlue());
        hboxFormulaType.setBorder(
                BorderFactory.createLineBorder(Color.YELLOW));


        // Создать область с полями ввода для X и Y
        JLabel labelForX = new JLabel("X:");
        textFieldX = new JTextField("0", 10);
        textFieldX.setMaximumSize(textFieldX.getPreferredSize());
        JLabel labelForY = new JLabel("Y:");
        textFieldY = new JTextField("0", 10);
        textFieldY.setMaximumSize(textFieldY.getPreferredSize());
        JLabel labelForZ = new JLabel("Z:");
        textFieldZ = new JTextField("0", 10);
        textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());
        Box hboxVariables = Box.createHorizontalBox();
        hboxVariables.setBorder(
                BorderFactory.createLineBorder(Color.RED));
        hboxVariables.add(Box.createHorizontalGlue());
        hboxVariables.add(labelForX);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldX);
        hboxVariables.add(Box.createHorizontalStrut(100));
        hboxVariables.add(labelForY);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldY);
        hboxVariables.add(Box.createHorizontalStrut(100));
        hboxVariables.add(labelForZ);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldZ);
        hboxVariables.add(Box.createHorizontalGlue());

// Создать область для вывода результата
        JLabel labelForResult = new JLabel("Результат:");
//labelResult = new JLabel("0");
        textFieldResult = new JTextField("0", 10);
        textFieldResult.setMaximumSize(
                textFieldResult.getPreferredSize());
        Box hboxResult = Box.createHorizontalBox();
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.add(labelForResult);
        hboxResult.add(Box.createHorizontalStrut(10));
        hboxResult.add(textFieldResult);
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.setBorder(BorderFactory.createLineBorder(Color.BLUE));
// Создать область для кнопок
        JButton buttonCalc = new JButton("Вычислить");
        buttonCalc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    Double x = Double.parseDouble(textFieldX.getText());
                    Double y = Double.parseDouble(textFieldY.getText());
                    Double z = Double.parseDouble(textFieldZ.getText());
                    Double result;
                    if (formulaId == 1)
                        result = calculate1(x, y, z);
                    else
                        result = calculate2(x, y, z);
                    textFieldResult.setText(result.toString());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        JButton buttonM = new JButton("M+");
        buttonM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                Double res = Double.parseDouble(textFieldResult.getText());
                try {
                    switch (memId) {
                        case 1 -> {
                            mem1 += res;
                            textFieldResult.setText(String.valueOf(mem1));
                        }
                        case 2 -> {
                            mem2 += res;
                            textFieldResult.setText(String.valueOf(mem2));
                        }
                        case 3 -> {
                            mem3 += res;
                            textFieldResult.setText(String.valueOf(mem3));
                        }
                        default -> {
                        }
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        JButton buttonMC = new JButton("MC");
        buttonMC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                Double res = Double.parseDouble(textFieldResult.getText());
                try {
                    switch (memId) {
                        case 1 -> {
                            mem1 = 0;
                            textFieldResult.setText(String.valueOf(mem1));
                        }
                        case 2 -> {
                            mem2 = 0;
                            textFieldResult.setText(String.valueOf(mem2));
                        }
                        case 3 -> {
                            mem3 = 0;
                            textFieldResult.setText(String.valueOf(mem3));
                        }
                        default -> {
                        }
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        JButton buttonReset = new JButton("Очистить поля");
        buttonReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                textFieldX.setText("0");
                textFieldY.setText("0");
                textFieldZ.setText("0");
                textFieldResult.setText("0");
            }
        });
        Box hboxButtons = Box.createHorizontalBox();
        hboxButtons.add(Box.createHorizontalGlue());
        hboxButtons.add(buttonM);
        hboxButtons.add(Box.createHorizontalStrut(30));
        hboxButtons.add(buttonMC);
        hboxButtons.add(Box.createHorizontalStrut(30));
        hboxButtons.add(buttonCalc);
        hboxButtons.add(Box.createHorizontalStrut(30));
        hboxButtons.add(buttonReset);
        hboxButtons.add(Box.createHorizontalGlue());


        hboxButtons.setBorder(
                BorderFactory.createLineBorder(Color.GREEN));
// Связать области воедино в компоновке BoxLayout
        Box contentBox = Box.createVerticalBox();
        contentBox.add(Box.createVerticalGlue());
        contentBox.add(hboxFormulaType);
        contentBox.add(hboxVariables);
        contentBox.add(hboxResult);
        contentBox.add(hboxButtons);
        contentBox.add(Box.createVerticalGlue());
        getContentPane().add(contentBox, BorderLayout.CENTER);
    }


}
