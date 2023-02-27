import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.text.DefaultCaret;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.io.Console;
import java.awt.EventQueue;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        createSimpleFrame();
    }

    public static void createSimpleFrame() {
        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                // TODO Auto-generated method stub
                super.paintComponent(g);
                   
                var p = new java.awt.Polygon(new int[]{100, 100, 200, 200, 100}, new int[]{100, 200, 200, 100, 100}, 4);
                g.drawPolygon(p);
                var p2 = new java.awt.Polygon(new int[]{100, 200, 250, 150}, new int[]{200, 200, 250, 250}, 4);
                g.drawPolygon(p2);

                g.fillRect(100, 100, 100, 100);
            }
        };
        frame.setVisible(true);   
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.pack();
        frame.setSize(new java.awt.Dimension(400, 400));     
    }

    public static void createFrame()
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                try 
                {
                   UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                   e.printStackTrace();
                }
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                panel.setOpaque(true);
                JTextArea textArea = new JTextArea(15, 50);
                textArea.setWrapStyleWord(true);
                textArea.setEditable(false);
                textArea.setFont(Font.getFont(Font.SANS_SERIF));
                JScrollPane scroller = new JScrollPane(textArea);
                scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                JPanel inputpanel = new JPanel();
                inputpanel.setLayout(new FlowLayout());
                JTextField input = new JTextField(20);
                JButton button = new JButton("Enter");
                DefaultCaret caret = (DefaultCaret) textArea.getCaret();
                caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
                panel.add(scroller);
                inputpanel.add(input);
                inputpanel.add(button);
                panel.add(inputpanel);
                frame.getContentPane().add(BorderLayout.CENTER, panel);
                frame.pack();
                frame.setLocationByPlatform(true);
                frame.setVisible(true);
                frame.setResizable(false);
                input.requestFocus();
            }
        });
    }
}
