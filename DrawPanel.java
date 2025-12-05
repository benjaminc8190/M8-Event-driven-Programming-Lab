import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class DrawPanel extends JPanel{

    private Color currentColor = Color.BLUE;
    private ArrayList<Stroke> strokes = new ArrayList<>();
    private Stroke currentStroke = null;
    private boolean erasing = false;
    private int brushSize = 8;

    public DrawPanel(){
        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                Color strokeColor;
                if (erasing) {
                    strokeColor = Color.WHITE;
                } else {
                    strokeColor = currentColor;
                }

                currentStroke = new Stroke(strokeColor, brushSize);
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

    // public void mouseDragged(MouseEvent e){
    //     if(currentStroke!=null){
    //         currentStroke.addPoint(e.getPoint());
    //         repaint();
    //     }
    // }

    public void setEraser(boolean e) {
        erasing = e;
    }

    public void setBrushSize(int size){
        brushSize = size;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (Stroke s: strokes) {
            g2.setColor(s.color);
            g2.setStroke(new BasicStroke(s.size, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            for(int i=1; i<s.points.size(); i++){
                Point p1 = s.points.get(i-1);
                Point p2 = s.points.get(i);
                g.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }
        g2.dispose();
    }

}