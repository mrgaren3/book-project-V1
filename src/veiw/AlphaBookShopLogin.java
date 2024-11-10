package veiw;

import javax.swing.*;

public class AlphaBookShopLogin extends JFrame {
    private LoginPanel loginPanel;
    private SettingsPanel settingsPanel;
    boolean darkMode = false;

    public AlphaBookShopLogin() {
        setTitle("Alpha Book Shop Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Initial size (800x600) with resizable functionality
        setSize(800, 600);
        setLocationRelativeTo(null); // Center on screen

        // Create the login panel (center panel) and add it to the frame
        loginPanel = new LoginPanel(this.getWidth(), this.getHeight());
        loginPanel.setBounds((int) (getWidth() * 0.1), (int) (getHeight() * 0.1),
                (int) (getWidth() * 0.8), (int) (getHeight() * 0.8));
        add(loginPanel);

        // Create and add the settings panel
        settingsPanel = new SettingsPanel(this, loginPanel);
        settingsPanel.setBounds(10, 10, 40, 40);  // Settings icon at top-right
        add(settingsPanel);

        setVisible(true);
    }


}
