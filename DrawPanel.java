import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class DrawPanel extends JPanel{

    private Color currentColor = Color.BLUE;
    private ArrayList<Point> points = new ArrayList<Point>();

    public DrawPanel(){
        setBackground(Color.WHITE);

        MouseAdapter mouse = new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                points.add(e.getPoint());
                repaint();
            }

            public void mouseDragged(MouseEvent e){
                points.add(e.getPoint());
                repaint();
            }
        };

        addMouseListener(mouse);
        addMouseMotionListener(mouse);
    }

    public void setCurrentColor(Color c){
        currentColor = c;
    }



    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(currentColor);
        
        for (Point p : points) {
            g.fillOval(p.x, p.y, 8, 8);
        }
    }

}