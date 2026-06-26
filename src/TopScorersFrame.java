import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.awt.*;

public class TopScorersFrame extends JFrame {

    private JTable        table;
    private PlayerService playerService;

    public TopScorersFrame() {
        playerService = new PlayerService();

        setTitle("Top 5 Scorers");
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5, 5));

        JLabel lblTitle = new JLabel("Top 5 Scorers", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblTitle, BorderLayout.NORTH);

        String[] columns = {"#", "Username", "Wins", "Losses", "Draws", "Score"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // TODO 1: Get Top 5 players from playerService
        ArrayList<Player> topFive = playerService.getTopFiveScorers();

        // TODO 2: Add each player data into the table model
        for (int i = 0; i < topFive.size(); i++) {
            Player p = topFive.get(i);
            model.addRow(new Object[]{
                    i + 1,                // kolom peringkat (#)
                    p.getUsername(),      // kolom username
                    p.getWins(),          // kolom wins
                    p.getLosses(),        // kolom losses
                    p.getDraws(),         // kolom draws
                    p.getScore()          // kolom score
            });
        }

        table = new JTable(model);
        table.setRowHeight(25);
        table.getTableHeader().setReorderingAllowed(false); // header tidak bisa digeser
        add(new JScrollPane(table), BorderLayout.CENTER);

        JButton btnClose = new JButton("Close");
        btnClose.addActionListener(e -> this.dispose());
        add(btnClose, BorderLayout.SOUTH);
    }
}