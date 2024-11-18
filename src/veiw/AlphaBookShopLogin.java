package veiw;

import javax.swing.*;
import java.awt.*;
public class AlphaBookShopLogin extends JFrame {
    private LoginPanel loginPanel;
    private SettingsPanel settingsPanel;
    boolean darkMode = false;
    private Color backYellow ;
    private JPanel Container ;
    private JPanel fixedSizeWrapper ;

    public AlphaBookShopLogin() {
        backYellow = new Color(236, 247, 213);


        this.setTitle("Alpha Book Shop Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(1,1));// make the container full size , temp solution till  remember how to do it
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Start maximized
        // Initial size (800x600) with resizable functionality
        this.setSize(800, 600);
        this.setLocationRelativeTo(null); // Center on screen

        // Create the login panel (center panel) and add it to the frame
        loginPanel = new LoginPanel(this.getWidth(), this.getHeight());
        loginPanel.setPreferredSize(new Dimension(600,500));

        /////fixed size wrap///////////////////////////////////////////
        fixedSizeWrapper = new JPanel();
        fixedSizeWrapper.setLayout(new GridBagLayout()); // Use GridBagLayout to center the child panel
        fixedSizeWrapper.setPreferredSize(new Dimension(600, 500)); // Fixed size for the centered panel
        fixedSizeWrapper.setBackground(backYellow);
        fixedSizeWrapper.add(loginPanel);

        // EL CONTAINER
        Container = new JPanel();
        Container.setLayout(new BorderLayout());
        this.add(Container);
        Container.add(fixedSizeWrapper, BorderLayout.CENTER);

        //////////////////////////////////////////
        // Create and add the settings panel
        settingsPanel = new SettingsPanel(this, loginPanel);
        settingsPanel.setBounds(10, 10, 40, 40);  // Settings icon at top-right
//        add(settingsPanel);////////////////////




        this.setVisible(true);
    }


}