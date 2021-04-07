package simpleGUI;

import javax.swing.*;
import java.awt.*;

public class AWTBasic_Test {
    JFrame frame = new JFrame();
    TextArea textArea = new TextArea(5,20);
    Choice colorchooser = new Choice();

    CheckboxGroup cbg = new CheckboxGroup();
    Checkbox male = new Checkbox("男",cbg,true);
    Checkbox female = new Checkbox("女",cbg,false);

    Checkbox ismarried = new Checkbox("是否已婚");
    TextField tf = new TextField(20);
    Button button = new Button("确认");

    List colorlist = new List(6,true);

    public void init()//组装界面
    {
        Box bottlebox = Box.createHorizontalBox();
        bottlebox.add(tf);
        bottlebox.add(button);
        frame.add(bottlebox,BorderLayout.SOUTH);

        Box choicebox = Box.createHorizontalBox();
        colorchooser.add("红色");
        colorchooser.add("绿色");
        colorchooser.add("蓝色");
        choicebox.add(colorchooser);
        choicebox.add(male);
        choicebox.add(female);
        choicebox.add(ismarried);

        Box left = Box.createVerticalBox();
        left.add(textArea);
        left.add(choicebox);

        Box upbox = Box.createHorizontalBox();
        upbox.add(left);
        colorlist.add("红色");
        colorlist.add("绿色");
        colorlist.add("蓝色");
        upbox.add(colorlist);

        frame.add(upbox);
        frame.pack();
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        AWTBasic_Test at = new AWTBasic_Test();
        at.init();
    }
}
