import javax.swing.*
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

  protected void paintComponent(Graphics g){
    super.paintComponent(g);
    g.setColor(Color.BLUE);
    g.drawString("Hello, World!", 60, 70);
  }
  
  public static void main(String[] args){
    Painter paint = new Painter();
    paint.setTitle("Painter");
    paint.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    paint.setSize(500, 500);
    paint.setVisible(true);
  }
}
