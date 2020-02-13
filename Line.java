import java.awt.Graphics;
import java.awt.Color;

public class Line extends Item {
  private Point p1;
  private Point p2;
  private Color col;
  
  public Line(Point p1, Point p2) {
    this(p1, p2, Color.BLACK);
  }
  
  public Line(Point p1, Point p2, Color col) {
    this.p1 = p1;
    this.p2 = p2;
    this.col = col;
  }

  public Point getP1() {
    return p1;
  }

  public void setP1(Point p1Neu) {
    p1 = p1Neu;
  }

  public Point getP2() {
    return p2;
  }

  public void setP2(Point p2Neu) {
    p2 = p2Neu;
  }
  
  void draw(Graphics g) {
    g.setColor(col);
    g.drawLine((int) p1.getX(), (int) p1.getY(), (int) p2.getX(), (int) p2.getY());
  }
  
  @Override
  public String toString() {
    return "Linie (" + p1.getX() + ", " + p1.getY() + ") -> (" + p2.getX() + ", " + p2.getY() + ")";
  }
}

