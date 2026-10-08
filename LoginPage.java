import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * LoginPage - A GUI login interface for the Star Wars Game
 */
public class LoginPage extends JFrame {
    private JPanel panel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private JButton exitButton;

    public LoginPage() {
        // Frame settings
        setTitle("Star Wars Game - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);

        // Create panel with dark background (Star Wars theme)
        panel = new JPanel();
        panel.setBackground(new Color(20, 20, 20));
        panel.setLayout(null);

        // Username Label
        usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        usernameLabel.setForeground(new Color(255, 232, 31)); // Star Wars yellow
        usernameLabel.setBounds(50, 50, 100, 25);
        panel.add(usernameLabel);

        // Username TextField
        usernameField = new JTextField();
        usernameField.setBounds(150, 50, 200, 25);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 12));
        usernameField.setBackground(new Color(50, 50, 50));
        usernameField.setForeground(Color.WHITE);
        usernameField.setCaretColor(Color.WHITE);
        panel.add(usernameField);

        // Password Label
        passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        passwordLabel.setForeground(new Color(255, 232, 31)); // Star Wars yellow
        passwordLabel.setBounds(50, 100, 100, 25);
        panel.add(passwordLabel);

        // Password Field
        passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 200, 25);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 12));
        passwordField.setBackground(new Color(50, 50, 50));
        passwordField.setForeground(Color.WHITE);
        passwordField.setCaretColor(Color.WHITE);
        panel.add(passwordField);

        // Login Button
        loginButton = new JButton("Login");
        loginButton.setBounds(80, 160, 80, 35);
        loginButton.setFont(new Font("Arial", Font.BOLD, 12));
        loginButton.setBackground(new Color(255, 232, 31));
        loginButton.setForeground(Color.BLACK);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });
        panel.add(loginButton);

        // Register Button
        registerButton = new JButton("Register");
        registerButton.setBounds(170, 160, 80, 35);
        registerButton.setFont(new Font("Arial", Font.BOLD, 12));
        registerButton.setBackground(new Color(100, 100, 100));
        registerButton.setForeground(Color.WHITE);
        registerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleRegister();
            }
        });
        panel.add(registerButton);

        // Exit Button
        exitButton = new JButton("Exit");
        exitButton.setBounds(260, 160, 80, 35);
        exitButton.setFont(new Font("Arial", Font.BOLD, 12));
        exitButton.setBackground(new Color(200, 50, 50));
        exitButton.setForeground(Color.WHITE);
        exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(exitButton);

        add(panel);
        setVisible(true);
    }

    /**
     * Handle login button action
     */
    private void handleLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter both username and password!",
                    "Input Error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // TODO: Implement authentication logic
        JOptionPane.showMessageDialog(this,
                "Welcome, " + username + "! Starting Star Wars Game...",
                "Login Successful",
                JOptionPane.INFORMATION_MESSAGE);

        // TODO: Open main game window
        // new StarWarsGame(username).setVisible(true);
        // this.dispose();
    }

    /**
     * Handle register button action
     */
    private void handleRegister() {
        // TODO: Open registration window
        JOptionPane.showMessageDialog(this,
                "Registration window coming soon!",
                "Registration",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Main method to launch the login page
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginPage());
    }
}
