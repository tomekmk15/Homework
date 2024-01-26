package kalkulator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoinVendingMachine extends JFrame {
    private JTextField hoursField;
    private JButton calculateButton;
    private JButton coinButton1;
    private JButton coinButton2;
    private JButton coinButton5;
    private JButton coinButton10;
    private JLabel totalLabel;
    private JLabel changeLabel;

    private double totalAmount = 0.0;
    private double hoursRate = 2.0; // Stawka za godzinę

    public CoinVendingMachine() {
        setTitle("Automat na monety");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        panel.add(new JLabel("Liczba godzin:"));
        hoursField = new JTextField();
        panel.add(hoursField);

        calculateButton = new JButton("Oblicz opłatę");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTotalAmount();
            }
        });
        panel.add(calculateButton);

        panel.add(new JLabel("Kwota do zapłaty:"));
        totalLabel = new JLabel("0.0 zł");
        panel.add(totalLabel);

        coinButton1 = new JButton("Wrzuć 1 zł");
        coinButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertCoin(1.0);
            }
        });
        panel.add(coinButton1);

        coinButton2 = new JButton("Wrzuć 2 zł");
        coinButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertCoin(2.0);
            }
        });
        panel.add(coinButton2);

        coinButton5 = new JButton("Wrzuć 5 zł");
        coinButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertCoin(5.0);
            }
        });
        panel.add(coinButton5);

        coinButton10 = new JButton("Wrzuć 10 zł");
        coinButton10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertCoin(10.0);
            }
        });
        panel.add(coinButton10);

        panel.add(new JLabel("Reszta do wydania:"));
        changeLabel = new JLabel("0.0 zł");
        panel.add(changeLabel);

        add(panel);
    }

    private void calculateTotalAmount() {
        try {
            double hours = Double.parseDouble(hoursField.getText());
            totalAmount = hours * hoursRate;
            totalLabel.setText(String.format("%.2f zł", totalAmount));
        } catch (NumberFormatException ex) {
            totalLabel.setText("Błąd: Wprowadź poprawną liczbę godzin.");
        }
    }

    private void insertCoin(double value) {
        if (totalAmount > 0) {
            totalAmount -= value;
            if (totalAmount < 0) {
                totalAmount = 0;
            }
            changeLabel.setText(String.format("%.2f zł", totalAmount));
        } else {
            JOptionPane.showMessageDialog(this, "Opłata została już uiszczona.", "Informacja", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CoinVendingMachine vendingMachine = new CoinVendingMachine();
                vendingMachine.setVisible(true);
            }
        });
    }
}
