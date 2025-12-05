import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;


public class Painter extends JFrame{
  private JButton red = new JButton("Red");
  private JButton blue = new JButton("Blue");
  private JButton green = new JButton("Green");
  private JButton clear = new JButton("Clear");
  private JButton erase = new JButton("Eraser");
  private JButton size = new JButton("Brush Size Smaall");
  private JButton size2 = new JButton("Brush Size Large");
  private JButton save = new JButton("Save");
  private DrawPanel canvas = new DrawPanel();
  private int small=8;
  private int large=30;
  
  public Painter(){
    JPanel panel = new JPanel();
    panel.add(red);
    panel.add(blue);
    panel.add(green);
    panel.add(clear);
    panel.add(erase);
    panel.add(size);
    panel.add(size2);
    panel.add(save);

    red.addActionListener(new ActionListener(){
      public void actionPerformed(java.awt.event.ActionEvent e){
        canvas.setEraser(false);
        canvas.setCurrentColor(Color.RED);
      }
    });
    blue.addActionListener(new ActionListener(){
      public void actionPerformed(java.awt.event.ActionEvent e){
        canvas.setEraser(false);
        canvas.setCurrentColor(Color.BLUE);
      }
    });
    green.addActionListener(new ActionListener(){
      public void actionPerformed(java.awt.event.ActionEvent e){
        canvas.setEraser(false);
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
      }
    });
    size.addActionListener(new ActionListener(){
      public void actionPerformed(java.awt.event.ActionEvent e){
        canvas.setBrushSize(small);
      }
    });
    size2.addActionListener(new ActionListener(){
      public void actionPerformed(java.awt.event.ActionEvent e){
        canvas.setBrushSize(large);
      }
    });

    save.addActionListener(new ActionListener(){
      public void actionPerformed(java.awt.event.ActionEvent e){
        JFileChooser chooser = new JFileChooser();
        int option = chooser.showSaveDialog(null);
        if(option == JFileChooser.APPROVE_OPTION){
          File file = chooser.getSelectedFile();
          canvas.save(file.getAbsolutePath());
        }
      }
    });

    this.add(canvas, BorderLayout.CENTER);
    this.add(panel, BorderLayout.SOUTH);
  }
  
  public static void main(String[] args){
    Painter paint = new Painter();
    paint.setTitle("Painter");
    paint.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    paint.setSize(800, 800);
    paint.setVisible(true);
  }
}

