package simpleGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUITest01 {

    public void test01()//FlowLayout
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.RIGHT,20,20));
        for (int i = 0; i < 100; i++)
        {
            frame.getContentPane().add(new JButton("按钮"+i));
        }

        frame.pack();

        frame.setVisible(true);
    }
    public void test02()//BorderLayout
    {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout(30,10));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(new JButton("north"),BorderLayout.NORTH);
        frame.add(new JButton("south"),BorderLayout.SOUTH);
        frame.add(new JButton("west"),BorderLayout.WEST);
        frame.add(new JButton("east"),BorderLayout.EAST);
        frame.add(new JButton("center"),BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }
    public void test03()//GridLayout
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Panel p1 = new Panel();
        Panel p2 = new Panel();
        p1.add(new TextField(30));
        p2.setLayout(new GridLayout(3,5,5,5));
        for (int i = 0; i <= 9; i++)
        {
            p2.add(new JButton(i+""));
        }
        p2.add(new JButton("+"));
        p2.add(new JButton("-"));
        p2.add(new JButton("*"));
        p2.add(new JButton("/"));
        p2.add(new JButton("="));
        frame.add(p1,BorderLayout.NORTH);
        frame.add(p2,BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

    }
    public void test04()//CardLayout
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        CardLayout cardLayout = new CardLayout();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        p1.setLayout(cardLayout);
        for (int i = 1; i <= 10; i++)
        {
            p1.add(i+"",new JButton("第"+i+"张"));//前一个是组件的名称
        }
        frame.add(p1);
        JButton b1 = new JButton("上一张");
        JButton b2 = new JButton("下一张");
        JButton b3 = new JButton("第一张");
        JButton b4 = new JButton("最后一张");
        JButton b5 = new JButton("第5张");
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();//获取被点击按钮上的文字
                switch (command)
                {
                    case "上一张" -> cardLayout.previous(p1);
                    case "下一张" -> cardLayout.next(p1);
                    case "第一张" -> cardLayout.first(p1);
                    case "最后一张" -> cardLayout.last(p1);
                    case "第5张" -> cardLayout.show(p1,"5");
                }
            }
        };
        b1.addActionListener(listener);
        b2.addActionListener(listener);
        b3.addActionListener(listener);
        b4.addActionListener(listener);
        b5.addActionListener(listener);
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b5);
        frame.add(p2,BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }
    public void test05()//BoxLayout & Box
    {
        Frame frame = new Frame();
        //frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //BoxLayout boxLayout = new BoxLayout(frame,BoxLayout.X_AXIS);
        Box hbox = Box.createHorizontalBox();
        Box vbox = Box.createVerticalBox();
        hbox.add(new JButton("按钮1"));
        hbox.add(new JButton("按钮2"));
        vbox.add(new JButton("按钮3"));
        vbox.add(new JButton("按钮4"));
        //vbox.add(new JButton("按钮5"));
        frame.add(hbox,BorderLayout.NORTH);
        frame.add(vbox,BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        GUITest01 gt = new GUITest01();
        gt.test05();
    }
}
