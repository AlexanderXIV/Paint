import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 13.02.2020
 * @author 
 */

public class Main extends JFrame {
  // Anfang Attribute
  private JButton bdrawPoint = new JButton();
  private JButton bdrawCircle = new JButton();
  private JButton bdrawLine = new JButton();
  private JButton bLoescheZf = new JButton();
  private JButton bZeichneAlles = new JButton();
  private JButton bLoeschItem = new JButton();
  private JButton bLoescheAlles = new JButton();
  private JPanel jPanel1 = new MyPanel();
  private JList jList1 = new JList();
    private DefaultListModel jList1Model = new DefaultListModel();
    private JScrollPane jList1ScrollPane = new JScrollPane(jList1);
  private JNumberField jt1 = new JNumberField();
  private JNumberField jt2 = new JNumberField();
  private JNumberField jt3 = new JNumberField();
  private JNumberField jt4 = new JNumberField();
  private JColorChooser jColorChooser1 = new JColorChooser();
  private JButton bFarbewaehlen = new JButton();
  // Ende Attribute
  
  private static ArrayList<Item> litems = new ArrayList<>();
  private static Color col = Color.BLACK;
  
  public Main() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 809; 
    int frameHeight = 484;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Main");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    bdrawPoint.setBounds(520, 184, 100, 30);
    bdrawPoint.setText("zeichne Punkt");
    bdrawPoint.setMargin(new Insets(2, 2, 2, 2));
    bdrawPoint.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bdrawPoint_ActionPerformed(evt);
      }
    });
    cp.add(bdrawPoint);
    bdrawCircle.setBounds(520, 216, 100, 30);
    bdrawCircle.setText("zeichne Kreis");
    bdrawCircle.setMargin(new Insets(2, 2, 2, 2));
    bdrawCircle.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bdrawCircle_ActionPerformed(evt);
      }
    });
    cp.add(bdrawCircle);
    bdrawLine.setBounds(520, 248, 100, 30);
    bdrawLine.setText("zeichne Linie");
    bdrawLine.setMargin(new Insets(2, 2, 2, 2));
    bdrawLine.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bdrawLine_ActionPerformed(evt);
      }
    });
    cp.add(bdrawLine);
    bLoescheZf.setBounds(520, 280, 100, 30);
    bLoescheZf.setText("loesche Zf");
    bLoescheZf.setMargin(new Insets(2, 2, 2, 2));
    bLoescheZf.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bLoescheZf_ActionPerformed(evt);
      }
    });
    cp.add(bLoescheZf);
    bZeichneAlles.setBounds(520, 312, 100, 30);
    bZeichneAlles.setText("zeichne Alles");
    bZeichneAlles.setMargin(new Insets(2, 2, 2, 2));
    bZeichneAlles.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bZeichneAlles_ActionPerformed(evt);
      }
    });
    cp.add(bZeichneAlles);
    bLoeschItem.setBounds(520, 344, 100, 30);
    bLoeschItem.setText("loesch Item");
    bLoeschItem.setMargin(new Insets(2, 2, 2, 2));
    bLoeschItem.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bLoeschItem_ActionPerformed(evt);
      }
    });
    cp.add(bLoeschItem);
    bLoescheAlles.setBounds(520, 376, 100, 30);
    bLoescheAlles.setText("loesche Alles");
    bLoescheAlles.setMargin(new Insets(2, 2, 2, 2));
    bLoescheAlles.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bLoescheAlles_ActionPerformed(evt);
      }
    });
    cp.add(bLoescheAlles);
    jPanel1.setBounds(8, 8, 505, 433);
    jPanel1.setOpaque(false);
    cp.add(jPanel1);
    jList1.setModel(jList1Model);
    jList1ScrollPane.setBounds(624, 8, 161, 433);
    cp.add(jList1ScrollPane);
    jt1.setBounds(520, 56, 100, 30);
    jt1.setText("");
    cp.add(jt1);
    jt2.setBounds(520, 88, 100, 30);
    jt2.setText("");
    cp.add(jt2);
    jt3.setBounds(520, 120, 100, 30);
    jt3.setText("");
    cp.add(jt3);
    jt4.setBounds(520, 152, 100, 30);
    jt4.setText("");
    cp.add(jt4);
    bFarbewaehlen.setBounds(520, 8, 100, 41);
    bFarbewaehlen.setText("Farbe wählen");
    bFarbewaehlen.setMargin(new Insets(2, 2, 2, 2));
    bFarbewaehlen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bFarbewaehlen_ActionPerformed(evt);
      }
    });
    cp.add(bFarbewaehlen);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Main
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Main();
  } // end of main
  
  public void bdrawPoint_ActionPerformed(ActionEvent evt) {
    litems.add(new Point(jt1.getDouble(), jt2.getDouble(), col));
    akt();
  } // end of bdrawPoint_ActionPerformed

  public void bdrawCircle_ActionPerformed(ActionEvent evt) {
    Point p = new Point(jt1.getDouble(), jt2.getDouble());
    litems.add(new Circle(p, jt3.getDouble(), col));
    akt();
  } // end of bdrawCircle_ActionPerformed

  public void bdrawLine_ActionPerformed(ActionEvent evt) {
    Point p1 = new Point(jt1.getDouble(), jt2.getDouble());
    Point p2 = new Point(jt3.getDouble(), jt4.getDouble());
    litems.add(new Line(p1, p2, col));
    akt();
  } // end of bdrawLine_ActionPerformed

  public void bLoescheZf_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  } // end of bLoescheZf_ActionPerformed

  public void bZeichneAlles_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  } // end of bZeichneAlles_ActionPerformed

  public void bLoeschItem_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    int i = jList1.getSelectedIndex();
    if (i != -1) {
      litems.remove(i);
    }
    akt();
  } // end of bLoeschItem_ActionPerformed

  public void bLoescheAlles_ActionPerformed(ActionEvent evt) {
    litems.clear();
    akt();
  } // end of bLoescheAlles_ActionPerformed
  
  public Color jColorChooser1_getColor() {
    return jColorChooser1.showDialog(this, "", Color.BLACK);
  }

  public void bFarbewaehlen_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    col = jColorChooser1.showDialog(this, "Choose Background Color", col);
    setBackground(col);
  } // end of bFarbewaehlen_ActionPerformed

  // Ende Methoden
  
  public void akt() {
    jList1Model.clear();
    litems.forEach(item -> jList1Model.add(0, item));
    jPanel1.repaint();    
  }
  
  class MyPanel extends JPanel {
    public MyPanel() {
      super(null, true);
    }
  
    public void paintComponent (Graphics g) {
      super.paintComponent(g);
      setBackground(Color.WHITE);
      
      for (Item it : litems) {
        it.draw(g);
      } // end of for
    }   
  }
} // end of class Main
