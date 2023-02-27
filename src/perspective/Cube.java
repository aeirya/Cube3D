package perspective;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;
import java.awt.BorderLayout;
import javax.swing.WindowConstants;

import util.Vector;

public class Cube extends JPanel {
    private final int x, y, w, d, h;
    private final List<Vector> points;

    public Cube() {
        x = y = 50;
        w = d = h = 100;
        points = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Vector p = new Vector(300, 300); // perspective point
        
        Vector p0 = new Vector(x, y);
        Vector p1 = p0.addY(h);
        Vector p2 = p1.addX(w);
        Vector p3 = p0.addX(w);

        points.add(p0);
        points.add(p1);
        points.add(p2);
        points.add(p3);

        paintPolygon(g, p0, p1, p2, p3);

        // float k = 1.0f;
        int k = d/2;
        paintPolygon(g, p1, p2, p2.scale(k, p), p1.scale(k, p));

        paintPolygon(g, p3, p2, p2.scale(k, p), p3.scale(k, p));
    }

    private void paintPolygon(Graphics g, Vector p1, Vector p2, Vector p3, Vector p4) {
        g.drawPolygon(new Polygon(new int[]{p1.x, p2.x, p3.x, p4.x}, new int[]{p1.y, p2.y, p3.y, p4.y}, 4));
    }
    
    private void paintRect(Graphics g, int x1, int x2, int y1, int y2) {
        g.drawPolygon(new Polygon(new int[]{x1, x1, x2, x2}, new int[]{y1, y2, y2, y1}, 4));
    }
    
    private void paintRect(Graphics g, int x1, int x2, int y1, int y2, int px, int py, int theta) {
        g.drawPolygon(new Polygon(new int[]{x1, x1, x2, x2}, new int[]{y1, y2, y2, y1}, 4));
    }

    private void paintShape(Graphics g, int x1, int x2, int y1, int y2) {

    }

    public static void createSimpleFrame() {
        JFrame frame = new JFrame("Test");
        var panel = new Cube();

        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);   
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.pack();
        frame.setSize(new java.awt.Dimension(400, 400));    
    }

    public static void main(String[] args) {
        createSimpleFrame();
    }
}
