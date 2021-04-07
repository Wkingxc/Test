package simpleGUI;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI2 {
    JTextField field = new JTextField(10);
    JTextField out = new JTextField("Please enter the password");
    public void go()
    {

        JFrame frame = new JFrame();
        Mykeylistener mykeylistener = new Mykeylistener();
        frame.setSize(200,200);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        field.setBounds(50,10,100,50);
        field.addKeyListener(mykeylistener);
        out.setEditable(false);
        out.setBounds(20,70,150,50);
        frame.getContentPane().add(field);
        frame.getContentPane().add(out);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        GUI2 gui2 = new GUI2();
        gui2.go();
    }

    class Mykeylistener implements KeyListener
    {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_ENTER)
            {
                out.setText("");
               if(field.getText().equals("123"))
               {
                   out.setText("right!");
               }else
               {
                   out.setText("wrong!");
               }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
