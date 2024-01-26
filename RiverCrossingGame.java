package kalkulator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RiverCrossingGame extends JFrame {
    private JButton boatButton;
    private JButton wolfButton;
    private JButton goatButton;
    private JButton cabbageButton;
    private JLabel statusLabel;

    private boolean boatOnLeft;
    private boolean wolfOnLeft;
    private boolean goatOnLeft;
    private boolean cabbageOnLeft;

    public RiverCrossingGame() {
        setTitle("Wilk, koza, kapusta");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 5));

        boatButton = new JButton("Łódź");
        boatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveBoat();
            }
        });
        panel.add(boatButton);

        wolfButton = new JButton("Wilk");
        wolfButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveWolf();
            }
        });
        panel.add(wolfButton);

        goatButton = new JButton("Koza");
        goatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveGoat();
            }
        });
        panel.add(goatButton);

        cabbageButton = new JButton("Kapusta");
        cabbageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveCabbage();
            }
        });
        panel.add(cabbageButton);

        statusLabel = new JLabel("Początkowy stan: Łódź na lewym brzegu");
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(statusLabel);

        add(panel);
    }

    private void moveBoat() {
        if (boatOnLeft) {
            boatOnLeft = false;
            statusLabel.setText("Łódź na prawym brzegu");
        } else {
            boatOnLeft = true;
            statusLabel.setText("Łódź na lewym brzegu");
        }
        checkGameState();
    }

    private void moveWolf() {
        if (boatOnLeft) {
            wolfOnLeft = !wolfOnLeft;
        }
        checkGameState();
    }

    private void moveGoat() {
        if (boatOnLeft) {
            goatOnLeft = !goatOnLeft;
        }
        checkGameState();
    }

    private void moveCabbage() {
        if (boatOnLeft) {
            cabbageOnLeft = !cabbageOnLeft;
        }
        checkGameState();
    }

    private void checkGameState() {
        if ((wolfOnLeft && goatOnLeft && !cabbageOnLeft) || (!wolfOnLeft && !goatOnLeft && cabbageOnLeft)) {
            statusLabel.setText("Wilk zje kozę!");
            disableButtons();
        } else if ((!wolfOnLeft && goatOnLeft && !cabbageOnLeft) || (wolfOnLeft && !goatOnLeft && cabbageOnLeft)) {
            statusLabel.setText("Koza zje kapustę!");
            disableButtons();
        } else if (!boatOnLeft && (wolfOnLeft || goatOnLeft || cabbageOnLeft)) {
            statusLabel.setText("Przewieź elementy na drugą stronę.");
        } else {
            statusLabel.setText("Początkowy stan: Łódź na lewym brzegu");
        }
    }

    private void disableButtons() {
        boatButton.setEnabled(false);
        wolfButton.setEnabled(false);
        goatButton.setEnabled(false);
        cabbageButton.setEnabled(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                RiverCrossingGame game = new RiverCrossingGame();
                game.setVisible(true);
            }
        });
    }
}
