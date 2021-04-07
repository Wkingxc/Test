package simpleGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI1 implements ActionListener {

    JFrame frame = new JFrame();
    JButton button1 = new JButton();
    JButton button2 = new JButton();
    Mypanel mypanel = new Mypanel();

    int x,y;
    public void go()
    {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);

        frame.getContentPane().add(BorderLayout.CENTER,mypanel);
        frame.getContentPane().add(BorderLayout.WEST,button1);
        frame.getContentPane().add(BorderLayout.EAST,button2);

        button1.addActionListener(this);
        button2.addActionListener(this);

        frame.setVisible(true);

        for (int i = 0; i < 150; i++)
        {
            x++;
            mypanel.repaint();
            try
            {
                Thread.sleep(5);
            }catch (Exception exception){}
        }

    }
    public static void main(String[] args) {
        GUI1 gui = new GUI1();
        gui.go();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object key = e.getSource();
        if (key == button1)
        {
            frame.repaint();
        }else if(key == button2)
        {

        }
    }
    class Mypanel extends JPanel
    {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.setColor(Color.black);
            g.fillRect(0,0,this.getWidth(),this.getHeight());

            g.setColor(Color.green);
            g.fillOval(x,y,50,50);
        }
    }
}



