import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {

    private JTextField     txtUsername;
    private JPasswordField txtPassword;
    private JButton        btnLogin;
    private PlayerService  playerService;

    public LoginFrame() {
        playerService = new PlayerService();

        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new java.awt.GridLayout(3, 2, 5, 5));

        add(new JLabel("Username:"));
        txtUsername = new JTextField();
        add(txtUsername);

        add(new JLabel("Password:"));
        txtPassword = new JPasswordField();
        add(txtPassword);

        add(new JLabel()); // kolom kiri kosong
        btnLogin = new JButton("Login");
        add(btnLogin);

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // TODO 1: Get username from txtUsername
                String username = txtUsername.getText();

                // TODO 2: Get password from txtPassword
                String password = new String(txtPassword.getPassword());

                // TODO 3: Call playerService.login(username, password)
                Player player = playerService.login(username, password);

                // TODO 4: If login succeeds, open MainMenuFrame
                if (player != null) {
                    JOptionPane.showMessageDialog(
                            LoginFrame.this,
                            "Login berhasil! Selamat datang, " + player.getUsername()
                    );
                    MainMenuFrame menuFrame = new MainMenuFrame(player);
                    menuFrame.setVisible(true);
                    dispose(); // tutup jendela login ini

                    // TODO 5: If login fails, show JOptionPane error message
                } else {
                    JOptionPane.showMessageDialog(
                            LoginFrame.this,
                            "Username atau password salah!",
                            "Login Gagal",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
    }
}