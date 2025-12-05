import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Painter extends JFrame{
  private JButton red = new JButton("Red");
  private JButton blue = new JButton("Blue");
  private JButton green = new JButton("Green");
  private JButton clear = new JButton("Clear");
  private JButton erase = new JButton("Eraser");
  private DrawPanel canvas = new DrawPanel();
  
  public Painter(){
    JPanel panel = new JPanel();
    panel.add(red);
    panel.add(blue);
    panel.add(green);
    panel.add(clear);
    panel.add(erase);

    red.addActionListener(new ActionListener(){
      public void actionPerformed(java.awt.event.ActionEvent e){
        canvas.setEraser(false);
        canvas.setBrushSize(8);
        canvas.setCurrentColor(Color.RED);
      }
    });
    blue.addActionListener(new ActionListener(){
      public void actionPerformed(java.awt.event.ActionEvent e){
        canvas.setEraser(false);
        canvas.setBrushSize(8);
        canvas.setCurrentColor(Color.BLUE);
      }
    });
    green.addActionListener(new ActionListener(){
      public void actionPerformed(java.awt.event.ActionEvent e){
        canvas.setEraser(false);
        canvas.setBrushSize(8);
        canvas.setCurrentColor(Color.GREEN);
      }
    });
    clear.addActionListener(new ActionListener(){
      public void actionPerformed(java.awt.event.ActionEvent e){
        canvas.clearCanvas();
      }
    });
    erase.addActionListener(new ActionListener(){
      public void actionPerformed(java.awt.event.ActionEvent e){
        canvas.setEraser(true);
        canvas.setBrushSize(30);
      }
    });

    this.add(canvas, BorderLayout.CENTER);
    this.add(panel, BorderLayout.SOUTH);
  }
  
  public static void main(String[] args){
    Painter paint = new Painter();
    paint.setTitle("Painter");
    paint.setLocationRelativeTo(null);
    paint.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    paint.setSize(800, 800);
    paint.setVisible(true);
  }
}

