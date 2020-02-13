import java.awt.Graphics;
import java.awt.Color;

public class Circle extends Item {
  private Point p;
  private double r;
  private Color col;
  
  public Circle(Point p, double r) {
    this(p, r, Color.BLACK);
  }
  
  public Circle(Point p, double r, Color col) {
    this.p = p;
    this.r = r;
    this.col = col;
  }

  public Point getP() {
    return p;
  }

  public double getR() {
    return r;
  }
  
  void draw(Graphics g) {
    g.setColor(col);
    g.drawOval((int) (p.getX() - r), (int) (p.getY() - r), (int) (2 * r), (int) (2 * r));
  }
  
  @Override
  public String toString() {
    return "Kreis (" + p.getX() + ", " + p.getY() + "), " + r;
  }
}

