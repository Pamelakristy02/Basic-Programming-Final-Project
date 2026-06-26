import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    private Player        currentPlayer;
    private PlayerService playerService;
    private GameLogic     gameLogic;
    private JButton[]     buttons;
    private JLabel        lblStatus;
    private boolean       gameOver;

    public GameFrame(Player player) {
        this.currentPlayer = player;
        this.playerService = new PlayerService();
        this.gameLogic     = new GameLogic();
        this.gameOver      = false;

        setTitle("Tic-Tac-Toe - " + player.getUsername());
        setSize(400, 470);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5, 5));

        lblStatus = new JLabel("Your turn! Click a cell to play.", SwingConstants.CENTER);
        lblStatus.setFont(new Font("Arial", Font.BOLD, 14));
        add(lblStatus, BorderLayout.NORTH);

        JPanel boardPanel = new JPanel(new GridLayout(3, 3, 5, 5));
        buttons = new JButton[9];

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.BOLD, 48));
            buttons[i].setBackground(Color.WHITE);
            buttons[i].setFocusPainted(false);

            final int index = i;
            buttons[i].addActionListener(e -> handlePlayerMove(index));

            boardPanel.add(buttons[i]);
        }
        add(boardPanel, BorderLayout.CENTER);

        JButton btnBack = new JButton("Back to Menu");
        btnBack.addActionListener(e -> {
            MainMenuFrame menuFrame = new MainMenuFrame(currentPlayer);
            menuFrame.setVisible(true);
            this.dispose();
        });
        add(btnBack, BorderLayout.SOUTH);
    }

    private void handlePlayerMove(int index) {
        if (gameOver) return;

        boolean validMove = gameLogic.makeMove(index, 'X');
        if (!validMove) {
            JOptionPane.showMessageDialog(
                    this,
                    "That cell is already taken! Choose another.",
                    "Invalid Move",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        buttons[index].setText("X");
        buttons[index].setForeground(Color.BLUE);
        buttons[index].setEnabled(false);

        if (gameLogic.checkWinner('X')) { finishGame("WIN");  return; }
        if (gameLogic.isDraw())         { finishGame("DRAW"); return; }

        lblStatus.setText("Computer is thinking...");
        int compIndex = gameLogic.computerMove();
        gameLogic.makeMove(compIndex, 'O');

        buttons[compIndex].setText("O");
        buttons[compIndex].setForeground(Color.RED);
        buttons[compIndex].setEnabled(false);

        if (gameLogic.checkWinner('O')) { finishGame("LOSE"); return; }
        if (gameLogic.isDraw())         { finishGame("DRAW"); return; }

        lblStatus.setText("Your turn! Click a cell to play.");
    }

    private void finishGame(String result) {
        gameOver = true;

        for (JButton btn : buttons) {
            btn.setEnabled(false);
        }

        playerService.updateStatistics(currentPlayer, result);

        String pesan = "";
        if (result.equals("WIN"))  pesan = "You WIN! +10 points";
        if (result.equals("LOSE")) pesan = "You LOSE! Better luck next time.";
        if (result.equals("DRAW")) pesan = "DRAW! +3 points";

        JOptionPane.showMessageDialog(this, "Game result: " + result + "\n" + pesan);

        SwingUtilities.invokeLater(() -> {
            PlayerService ps       = new PlayerService();
            Player updatedPlayer   = ps.getPlayerById(currentPlayer.getId());

            if (updatedPlayer == null) updatedPlayer = currentPlayer;

            MainMenuFrame menuFrame = new MainMenuFrame(updatedPlayer);
            menuFrame.setVisible(true);
            dispose();
        });
    }
}