
import java.awt.*;
import java.util.ArrayList;

public class Stroke{
    public Color color;
    public java.util.ArrayList<Point> points;

    Stroke(Color c){
        this.color=c;
        this.points= new ArrayList<Point>();
    }

    public void addPoint(Point p){
        points.add(p);
    }
}