package veiw;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class RoundButton extends JButton {

    public RoundButton(String label) {
        super(label);

        // Make the button circular
        setContentAreaFilled(false); // Disable default button background filling
        setFocusPainted(false);      // Remove focus ring
        setBorderPainted(false);     // Remove border
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Antialiasing for smoother edges
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Fill the circle with color based on button state (hover, pressed, etc.)
        if (getModel().isArmed()) {
            g2.setColor(Color.LIGHT_GRAY); // Change to lighter shade on click
        } else {
            g2.setColor(getBackground()); // Use the background color for default state
        }
        g2.fill(new Ellipse2D.Double(0, 0, getWidth() - 1, getHeight() - 1));

        // Draw the button text
        g2.setColor(getForeground());
        FontMetrics fm = g2.getFontMetrics();
        int textWidth = fm.stringWidth(getText());
        int textHeight = fm.getAscent();
        g2.drawString(getText(), (getWidth() - textWidth) / 2, (getHeight() + textHeight) / 2 - 3);

        g2.dispose(); // Dispose the Graphics2D object
        super.paintComponent(g); // Ensure other UI elements are painted
    }
    @Override
    public Dimension getPreferredSize() {
        // Keep the button size square to ensure a circular shape
        Dimension size = super.getPreferredSize();
        int diameter = Math.max(size.width, size.height);
        return new Dimension(diameter, diameter);
    }

    @Override
    public boolean contains(int x, int y) {
        // Only detect clicks within the circular area
        int radius = getWidth() / 2;
        int centerX = radius;
        int centerY = radius;
        return Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2) <= Math.pow(radius, 2);
    }
}