/*
 * CSCI 185 M03
 * Fall 2025
 * M8: Event-driven Programming Lab (*BONUS*)
 * Authors: Benjamin Chau
 * Date: 12/05/2025
 */


import java.awt.*;
import java.util.ArrayList;

public class Stroke{
    public Color color;
    public int size;
    public java.util.ArrayList<Point> points;

    public Stroke(Color c, int s){
        this.color=c;
        this.points= new ArrayList<Point>();
        this.size=s;
    }

    public void addPoint(Point p){
        points.add(p);
    }
}