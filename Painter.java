import java.swing.*
import java.awt.*

public Painter extends JFrame{
  private JButton red = new JButton("Red");
  private JButton blue = new JButton("Blue");
  private JButton green = new JButton("Green");
  
  public Painter(){
    JPanel panel = new JPanel();
    panel.add(red);
    panel.add(blue);
    panel.add(green);
    this.add(canvas, BorderLayout.CENTER);
    this.add(panel, BorderLayout.SOUTH);   
  }
  public static void main(String[] args){
    Painter paint = new Painter();
    paint.setTitle("ControlCircle1");
    paint.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    paint.setSize(500, 500);
    paint.setVisible(true);
  }
}
