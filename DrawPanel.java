/*
 * CSCI 185 M03
 * Fall 2025
 * M8: Event-driven Programming Lab (*BONUS*)
 * Authors: Benjamin Chau
 * Date: 12/05/2025
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
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

    public void setEraser(boolean e) {
        erasing = e;
    }

    public void setBrushSize(int size){
        brushSize = size;
    }

    public void save(String filename){
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();
        paint(g2);
        g2.dispose();
        try {
            File file = new File("myDrawing.png");
            ImageIO.write(image, "png", file);
            System.out.println("Saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
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