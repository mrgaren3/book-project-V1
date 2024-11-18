package veiw;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends RoundedPanel {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JRadioButton stateARadio;
    private JRadioButton stateBRadio;
    private JButton loginButton;

    public LoginPanel(int frameWidth, int frameHeight) {

        setLayout(null);

        setBackground(new Color(158, 194, 193));
//        Font font = getFont();

        // Dynamic font size for the title
        JLabel titleLabel = new JLabel("  Alpha Shop");
            titleLabel.setFont(new Font("TenaliRamakrishna", Font.BOLD, 117));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(0, 20, (int) (frameWidth*0.7), (int) (frameHeight*0.2));
        this.add(titleLabel);

        // Username text field with placeholder
        usernameField = new RoundJTextField(100);
        usernameField.setBounds((int) (frameWidth * 0.1), (int) (frameHeight*0.3), (int) (frameWidth * 0.6), 40);
        usernameField.setFont(new Font("TenaliRamakrishna", Font.ITALIC , 30));
        usernameField.setLocation(60 , 190);
        usernameField.setSize((int) (frameWidth * 0.6), 40);

        this.add(usernameField);

        // Password text field with placeholder
        passwordField = new RoundJPasswordField(20);
//        passwordField.setBounds((int) (frameWidth * 0.1), (int) (frameHeight*0.4), (int) (frameWidth * 0.6), 40);
        passwordField.setLocation(60 , 250);
        passwordField.setSize((int) (frameWidth * 0.6), 40);
        this.add(passwordField);

        // Radio buttons for states A and B
        ButtonGroup stateGroup = new ButtonGroup();
        stateARadio = new JRadioButton("State A");
        stateARadio.setBounds((int) (frameWidth * 0.2), (int) (frameHeight*0.6), 100, 30);
        stateBRadio = new JRadioButton("State B");
        stateBRadio.setBounds((int) (frameWidth * 0.5), (int) (frameHeight*0.6), 100, 30);
        stateARadio.setBackground(new Color(0,0,0,0));
        stateBRadio.setBackground(new Color(0,0,0,0));
        stateARadio.setForeground(new Color(0,0,0));
        stateBRadio.setForeground(new Color(0,0,0));
        stateGroup.add(stateARadio);
        stateGroup.add(stateBRadio);
        this.add(stateARadio);
        this.add(stateBRadio);

        // Login button
        loginButton = new RoundButton("Login",25);
//        loginButton.setBorder(new RoundedBorder(20));
//        loginButton.setForeground(Color.BLUE);
//        loginButton.setBackground(new Color(0,0,0,0));
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


}