package kalkulator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculator extends JFrame {
    private JTextField heightField;
    private JTextField weightField;
    private JButton calculateButton;
    private JLabel resultLabel;

    public BMICalculator() {
        setTitle("Kalkulator BMI");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("Wzrost (cm):"));
        heightField = new JTextField();
        panel.add(heightField);

        panel.add(new JLabel("Waga (kg):"));
        weightField = new JTextField();
        panel.add(weightField);

        calculateButton = new JButton("Oblicz BMI");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateBMI();
            }
        });
        panel.add(calculateButton);

        panel.add(new JLabel("Wynik:"));
        resultLabel = new JLabel();
        panel.add(resultLabel);

        add(panel);
    }

    private void calculateBMI() {
        try {
            double height = Double.parseDouble(heightField.getText());
            double weight = Double.parseDouble(weightField.getText());

            double bmi = calculateBMIValue(height, weight);
            String result = interpretBMI(bmi);

            resultLabel.setText("BMI: " + bmi + " - " + result);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Błąd: Wprowadź poprawne wartości.");
        }
    }

    private double calculateBMIValue(double height, double weight) {
        return weight / ((height / 100) * (height / 100));
    }

    private String interpretBMI(double bmi) {
        if (bmi < 18.5) {
            return "Niedowaga";
        } else if (bmi < 24.9) {
            return "Waga normalna";
        } else if (bmi < 29.9) {
            return "Nadwaga";
        } else {
            return "Otyłość";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                BMICalculator calculator = new BMICalculator();
                calculator.setVisible(true);
            }
        });
    }
}
