package simpleGUI;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MusicPlayer{
    static JFrame frame = new JFrame();
    static MyPanel m1;

    public static void main(String[] args) {
        MusicPlayer mp = new MusicPlayer();
        mp.go();

    }
    public void start()
    {
        m1 = new MyPanel();
        frame.setContentPane(m1);
        frame.setBounds(30,30,300,300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void go()
    {
        start();
        try
        {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            int[] eventwant = {127};
            sequencer.addControllerEventListener(m1,eventwant);
            Sequence seq = new Sequence(Sequence.PPQ,4);
            Track track = seq.createTrack();

            int r;

            for (int i = 0; i < 600; i+=4)
            {
                r = (int)((Math.random()*50)+1);
                track.add(makeEvent(144,1,r,100,i));
                track.add(makeEvent(176,1,127,0,i));
                track.add(makeEvent(128,1,r,100,i+2));
            }

            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(120);
            sequencer.start();
        }
        catch(Exception ex){}
    }

    public static MidiEvent makeEvent(int cmd, int chan, int one, int two, int tick)
    {
        MidiEvent event = null;
        try
        {
            ShortMessage a = new ShortMessage();
            a.setMessage(cmd,chan,one,two);
            event = new MidiEvent(a,tick);
        }catch (Exception e) {}
        return event;
    }


    class MyPanel extends JPanel implements ControllerEventListener
    {
        boolean msg = false;
        public void controlChange(ShortMessage event)
        {
            msg = true;
            repaint();
        }

        @Override
        public void paintComponent(Graphics g) {
            if(msg)
            {
                Graphics2D g2 = (Graphics2D) g;
                Random random = new Random();
                int r = random.nextInt(250);
                int gr = random.nextInt(250);
                int b = random.nextInt(250);

                g2.setColor(new Color(r,gr,b));

                int ht = 10 + random.nextInt(120);
                int width = 10 + random.nextInt(120);
                int x = random.nextInt(200);
                int y = random.nextInt(200);

                g2.fillRect(x,y,width,ht);
                msg = false;

            }
        }

    }

}
