import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.io.InputStream;

public class LoginPanel extends JPanel {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JRadioButton stateARadio;
    private JRadioButton stateBRadio;
    private JButton loginButton;

    public LoginPanel(int frameWidth, int frameHeight) {

        setLayout(null);

        setBackground(new Color(158, 194, 193));
        Font font = getFont();

        // Dynamic font size for the title
        JLabel titleLabel = new JLabel("Alpha Shop");
        titleLabel.setFont(new Font("Brush Script MT", Font.BOLD, (int) (frameWidth * 0.13)));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(0, 20, (int) (frameWidth*0.7), (int) (frameHeight*0.2));
        add(titleLabel);

        // Username text field with placeholder
        usernameField = new RoundJTextField(20);
        usernameField.setBounds((int) (frameWidth * 0.1), (int) (frameHeight*0.3), (int) (frameWidth * 0.6), 40);
        add(usernameField);

        // Password text field with placeholder
        passwordField = new RoundJPasswordField(20);
        passwordField.setBounds((int) (frameWidth * 0.1), (int) (frameHeight*0.4), (int) (frameWidth * 0.6), 40);
        add(passwordField);

        // Radio buttons for states A and B
        ButtonGroup stateGroup = new ButtonGroup();
        stateARadio = new JRadioButton("State A");
        stateARadio.setBounds((int) (frameWidth * 0.2), (int) (frameHeight*0.6), 100, 30);
        stateBRadio = new JRadioButton("State B");
        stateBRadio.setBounds((int) (frameWidth * 0.5), (int) (frameHeight*0.6), 100, 30);
        stateGroup.add(stateARadio);
        stateGroup.add(stateBRadio);
        add(stateARadio);
        add(stateBRadio);

        // Login button
        loginButton = new JButton("Login");
        loginButton.setBounds((int) (frameWidth * 0.2), (int) (frameHeight*0.7), (int) (frameWidth * 0.4), 40);
        add(loginButton);
    }


    // Method to apply dark mode
    public void toggleDarkMode(boolean darkMode) {
        if (darkMode) {
            setBackground(Color.DARK_GRAY);
            usernameField.setBackground(Color.GRAY);
            passwordField.setBackground(Color.GRAY);
        } else {
            setBackground(Color.LIGHT_GRAY);
            usernameField.setBackground(Color.WHITE);
            passwordField.setBackground(Color.WHITE);
        }
    }

    // Method to dynamically resize components when window size changes
    public void resizeComponents(int frameWidth, int frameHeight) {
        // Resize and reposition components based on the new frame width and height
        // Update title font size
        JLabel titleLabel = (JLabel) getComponent(0);
        titleLabel.setFont(new Font("Serif", Font.BOLD, (int) (frameWidth * 0.1)));
        titleLabel.setBounds(0, 20, (int) (frameWidth*0.7), (int) (frameHeight*0.2));

        usernameField.setBounds((int) (frameWidth * 0.075), (int) (frameHeight*0.3), (int) (frameWidth * 0.6), 40);
        passwordField.setBounds((int) (frameWidth * 0.075), (int) (frameHeight*0.4), (int) (frameWidth * 0.6), 40);
        stateARadio.setBounds((int) (frameWidth * 0.2), (int) (frameHeight*0.6), 100, 30);
        stateBRadio.setBounds((int) (frameWidth * 0.5), (int) (frameHeight*0.6), 100, 30);
        loginButton.setBounds((int) (frameWidth * 0.2), (int) (frameHeight*0.7), (int) (frameWidth * 0.4), 40);
    }
}
