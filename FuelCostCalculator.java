package kalkulator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FuelCostCalculator extends JFrame {
    private JTextField fuelConsumptionField;
    private JTextField fuelPriceField;
    private JTextField distanceField;
    private JButton calculateButton;
    private JLabel totalCostLabel;

    public FuelCostCalculator() {
        setTitle("Kalkulator kosztów podróży");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        panel.add(new JLabel("Spalanie (l/100 km):"));
        fuelConsumptionField = new JTextField();
        panel.add(fuelConsumptionField);

        panel.add(new JLabel("Cena paliwa (zł/l):"));
        fuelPriceField = new JTextField();
        panel.add(fuelPriceField);

        panel.add(new JLabel("Długość trasy (km):"));
        distanceField = new JTextField();
        panel.add(distanceField);

        calculateButton = new JButton("Oblicz koszt");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTotalCost();
            }
        });
        panel.add(calculateButton);

        panel.add(new JLabel("Koszt całkowity:"));
        totalCostLabel = new JLabel();
        panel.add(totalCostLabel);

        add(panel);
    }

    private void calculateTotalCost() {
        try {
            double fuelConsumption = Double.parseDouble(fuelConsumptionField.getText());
            double fuelPrice = Double.parseDouble(fuelPriceField.getText());
            double distance = Double.parseDouble(distanceField.getText());

            double totalCost = (fuelConsumption / 100) * distance * fuelPrice;

            totalCostLabel.setText(String.format("%.2f zł", totalCost));
        } catch (NumberFormatException ex) {
            totalCostLabel.setText("Błąd: Wprowadź poprawne wartości.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FuelCostCalculator calculator = new FuelCostCalculator();
                calculator.setVisible(true);
            }
        });
    }
}
