import java.awt.Graphics;
import java.awt.Color;

public class Point extends Item {
  private double x;
  private double y;
  private Color col;
  
  public Point(double x, double y) {
    this(x, y, Color.BLACK);
  }
  
  public Point(double x, double y, Color col) {
    this.x = x;
    this.y = y;
    this.col = col;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public void setY(double yNeu) {
    y = yNeu;
  }

  public void setX(double xNeu) {
    x = xNeu;
  }
  
  void draw(Graphics g) {
    int r = 5;
    g.setColor(col);
    g.fillOval((int) x - r, (int) y - r, 2 * r, 2 * r);
  }
  
  @Override
  public String toString() {
    return "Punkt (" + x + ", " + y + ")";
  }
}

