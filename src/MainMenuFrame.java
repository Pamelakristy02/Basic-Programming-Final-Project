import javax.swing.*;
import java.awt.*;

public class MainMenuFrame extends JFrame {
    private Player currentPlayer;
    private JButton btnStartGame;
    private JButton btnStatistics;
    private JButton btnTopScorers;
    private JButton btnExit;
    public MainMenuFrame(Player player) {
        this.currentPlayer = player;

        setTitle("Main Menu - " + player.getUsername());
        setSize(300, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 8, 8));

        btnStartGame  = new JButton("🎮 Start Game");
        btnStatistics = new JButton("📊 My Statistics");
        btnTopScorers = new JButton("🏆 Top 5 Scorers");
        btnExit       = new JButton("❌ Exit");

        add(btnStartGame);
        add(btnStatistics);
        add(btnTopScorers);
        add(btnExit);

        btnStartGame.addActionListener(e -> {
            GameFrame gameFrame = new GameFrame(currentPlayer);
            gameFrame.setVisible(true);
            this.dispose();
        });
        btnStatistics.addActionListener(e -> {
            PlayerService playerService = new PlayerService();
            Player freshPlayer = playerService.getPlayerById(currentPlayer.getId());

            if (freshPlayer == null) freshPlayer = currentPlayer;

            StatisticsFrame statisticsFrame = new StatisticsFrame(
                    currentPlayer);
            statisticsFrame.setVisible(true);
        });
        btnTopScorers.addActionListener(e -> {
            TopScorersFrame topFrame = new TopScorersFrame();
            topFrame.setVisible(true);
        });
        btnExit.addActionListener(e -> {
            System.exit(0);
        });
    }
}