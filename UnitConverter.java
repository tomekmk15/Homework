package kalkulator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnitConverter extends JFrame {
    private JTextField inputField;
    private JButton convertButton;
    private JLabel resultLabel;

    public UnitConverter() {
        setTitle("Konwerter jednostek");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("Wartość do przeliczenia:"));
        inputField = new JTextField();
        panel.add(inputField);

        panel.add(new JLabel("Jednostka wejściowa:"));
        JComboBox<String> inputUnitComboBox = new JComboBox<>(new String[]{"Metryczne", "Brytyjskie"});
        panel.add(inputUnitComboBox);

        panel.add(new JLabel("Jednostka wyjściowa:"));
        JComboBox<String> outputUnitComboBox = new JComboBox<>(new String[]{"Metryczne", "Brytyjskie"});
        panel.add(outputUnitComboBox);

        convertButton = new JButton("Przelicz");
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertUnits(inputUnitComboBox.getSelectedItem().toString(), outputUnitComboBox.getSelectedItem().toString());
            }
        });
        panel.add(convertButton);

        panel.add(new JLabel("Wynik:"));
        resultLabel = new JLabel();
        panel.add(resultLabel);

        add(panel);
    }

    private void convertUnits(String inputUnit, String outputUnit) {
        try {
            double inputValue = Double.parseDouble(inputField.getText());

            if (inputUnit.equals("Metryczne") && outputUnit.equals("Brytyjskie")) {
                double outputValue = inputValue * 39.37; // Przykładowa konwersja, można dostosować
                resultLabel.setText(String.format("%.2f cali", outputValue));
            } else if (inputUnit.equals("Brytyjskie") && outputUnit.equals("Metryczne")) {
                double outputValue = inputValue / 39.37; // Przykładowa konwersja, można dostosować
                resultLabel.setText(String.format("%.2f metrów", outputValue));
            } else {
                resultLabel.setText("Błąd: Wybierz różne jednostki.");
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Błąd: Wprowadź poprawną wartość.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                UnitConverter converter = new UnitConverter();
                converter.setVisible(true);
            }
        });
    }
}
