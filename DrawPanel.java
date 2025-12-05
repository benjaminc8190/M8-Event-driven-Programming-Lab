import java.awt.*;
import javax.swing.*;

public class DrawPanel extends JPanel{
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.drawString("Hello, World!", 60, 70);
    }
}