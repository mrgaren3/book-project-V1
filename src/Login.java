import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JTextField userField;
    private JPasswordField passField;
    private JComboBox<String> roleCombo;

    public Login() {
        setTitle("Library Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new GridLayout(4, 2));

        // Create labels and text fields
        JLabel userLabel = new JLabel("Username:");
        userField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        passField = new JPasswordField();
        JLabel roleLabel = new JLabel("Role:");
        String[] roles = {"Admin", "Customer"};
        roleCombo = new JComboBox<>(roles);

        // Create login button
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());
                String role = (String) roleCombo.getSelectedItem();

                // Validate login
                if (User.validateLogin(username, password, role)) {
                    JOptionPane.showMessageDialog(Login.this, "Login Successful as " + role);
                } else {
                    JOptionPane.showMessageDialog(Login.this, "Invalid login credentials", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add components to the frame
        add(userLabel);
        add(userField);
        add(passLabel);
        add(passField);
        add(roleLabel);
        add(roleCombo);
        add(new JLabel()); // empty cell for spacing
        add(loginButton);

        setVisible(true);
    }
}
