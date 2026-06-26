import javax.swing.*;
import java.awt.*;

public class StatisticsFrame extends JFrame {
    public StatisticsFrame(Player player) {
        PlayerService playerService = new PlayerService();
        Player freshPlayer = playerService.getPlayerById(player.getId());

        if (freshPlayer == null) {
            freshPlayer = player;
        }

        setTitle("Statistik - " + player.getUsername());
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 10, 10));

        add(new JLabel("Pemain:"));   add(new JLabel(player.getUsername()));
        add(new JLabel("Menang:"));   add(new JLabel(String.valueOf(player.getWins())));
        add(new JLabel("Kalah:"));    add(new JLabel(String.valueOf(player.getLosses())));
        add(new JLabel("Seri:"));     add(new JLabel(String.valueOf(player.getDraws())));
        add(new JLabel("Total Skor:"));add(new JLabel(String.valueOf(player.getScore())));

        JButton btnClose = new JButton("Tutup");
        btnClose.addActionListener(e -> this.dispose());
        add(new JLabel());
        add(btnClose);
    }
}