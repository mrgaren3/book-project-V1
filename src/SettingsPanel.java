import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsPanel extends JPanel {
    private AlphaBookShopLogin mainFrame;
    private LoginPanel loginPanel;

    public SettingsPanel(AlphaBookShopLogin frame, LoginPanel panel) {
        this.mainFrame = frame;
        this.loginPanel = panel;

        setLayout(new BorderLayout());

        // Settings button icon
        JButton settingsButton = new JButton(new ImageIcon("settings.png")); // Add your icon file
        add(settingsButton, BorderLayout.CENTER);

        // Action listener for settings button
        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSettingsMenu();
            }
        });
    }

    // Method to display the settings menu
    private void showSettingsMenu() {
        String[] options = {"Change Resolution", "Toggle Dark Mode"};
        int choice = JOptionPane.showOptionDialog(mainFrame, "Settings", "Settings Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            changeResolution();
        } else if (choice == 1) {
            toggleDarkMode();
        }
    }

    // Change resolution
    private void changeResolution() {
        String[] resolutions = {"800x600", "1024x768", "1280x720"};
        String selectedResolution = (String) JOptionPane.showInputDialog(mainFrame,
                "Select Resolution", "Resolution", JOptionPane.PLAIN_MESSAGE,
                null, resolutions, resolutions[0]);

        if (selectedResolution != null) {
            String[] parts = selectedResolution.split("x");
            int width = Integer.parseInt(parts[0]);
            int height = Integer.parseInt(parts[1]);
            mainFrame.setSize(width, height);
            loginPanel.setBounds((int) (width * 0.15), (int) (height * 0.075),
                    (int) (width * 0.7), (int) (height * 0.85));
            loginPanel.resizeComponents(width, height);
        }
    }

    // Toggle dark mode
    private void toggleDarkMode() {
        mainFrame.darkMode = !mainFrame.darkMode;
        loginPanel.toggleDarkMode(mainFrame.darkMode);
    }
}
