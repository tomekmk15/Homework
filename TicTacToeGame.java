package kalkulator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGame extends JFrame {
    private JButton[][] buttons;
    private char currentPlayer;
    private JLabel statusLabel;

    public TicTacToeGame() {
        setTitle("Kółko i krzyżyk");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));

        buttons = new JButton[3][3];
        currentPlayer = 'X';

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                panel.add(buttons[i][j]);
            }
        }

        statusLabel = new JLabel("Ruch gracza: " + currentPlayer);
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(panel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);
    }

    private void checkWinner(int row, int col) {
        if (checkRow(row) || checkColumn(col) || checkDiagonals()) {
            statusLabel.setText("Gracz " + currentPlayer + " wygrywa!");
            disableButtons();
        } else if (isBoardFull()) {
            statusLabel.setText("Remis!");
        } else {
            switchPlayer();
        }
    }

    private boolean checkRow(int row) {
        return buttons[row][0].getText().equals(String.valueOf(currentPlayer)) &&
               buttons[row][1].getText().equals(String.valueOf(currentPlayer)) &&
               buttons[row][2].getText().equals(String.valueOf(currentPlayer));
    }

    private boolean checkColumn(int col) {
        return buttons[0][col].getText().equals(String.valueOf(currentPlayer)) &&
               buttons[1][col].getText().equals(String.valueOf(currentPlayer)) &&
               buttons[2][col].getText().equals(String.valueOf(currentPlayer));
    }

    private boolean checkDiagonals() {
        return (buttons[0][0].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[1][1].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[2][2].getText().equals(String.valueOf(currentPlayer))) ||
               (buttons[0][2].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[1][1].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[2][0].getText().equals(String.valueOf(currentPlayer)));
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().isEmpty()) {
                    return false;
                }
            }
        }
        disableButtons();
        return true;
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        statusLabel.setText("Ruch gracza: " + currentPlayer);
    }

    private void disableButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }

    private class ButtonClickListener implements ActionListener {
        private int row;
        private int col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (buttons[row][col].getText().isEmpty()) {
                buttons[row][col].setText(String.valueOf(currentPlayer));
                checkWinner(row, col);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TicTacToeGame game = new TicTacToeGame();
                game.setVisible(true);
            }
        });
    }
}
