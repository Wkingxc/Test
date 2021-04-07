package simpleGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileDialog_Test {
    public static void main(String[] args) {
        Frame frame = new Frame();
        FileDialog f1 = new FileDialog(frame,"打开",FileDialog.LOAD);
        FileDialog f2 = new FileDialog(frame,"保存",FileDialog.SAVE);
        Button b1 = new Button("open");
        Button b2 = new Button("save");
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==b1)
                {
                    f1.setVisible(true);
                    System.out.println(f1.getDirectory());
                    System.out.println(f1.getFile());
                }else if(e.getSource()==b2)
                {
                    f2.setVisible(true);
                    System.out.println(f2.getDirectory());
                    System.out.println(f2.getFile());
                }
            }
        };
        b1.addActionListener(actionListener);
        b2.addActionListener(actionListener);
        frame.add(b1,BorderLayout.NORTH);
        frame.add(b2,BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }
}
