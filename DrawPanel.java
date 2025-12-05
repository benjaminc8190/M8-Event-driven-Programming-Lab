import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class DrawPanel extends JPanel{

    private Color currentColor = Color.BLUE;
    private ArrayList<Stroke> strokes = new ArrayList<>();
    private Stroke currentStroke = null;

    public DrawPanel(){
        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                currentStroke = new Stroke(currentColor);
                currentStroke.addPoint(e.getPoint());
                strokes.add(currentStroke);
                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent e){
                if(currentStroke!=null){
                    currentStroke.addPoint(e.getPoint());
                    repaint();
                }
            }
        });
    }

    public void setCurrentColor(Color c){
        currentColor = c;
    }

    public void clearCanvas(){
        strokes.clear();
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        for (Stroke s: strokes) {
            g.setColor(s.color);
            for(int i=1; i<s.points.size(); i++){
                Point p1 = s.points.get(i-1);
                Point p2 = s.points.get(i);
                g.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }
    }

}