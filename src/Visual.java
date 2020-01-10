import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class Visual extends javax.swing.JFrame
{

    private static Visual instance = null;
    Synthesizer s = javax.sound.midi.MidiSystem.getSynthesizer();
    javax.sound.midi.Soundbank sb = s.getDefaultSoundbank();

    public Visual() throws java.awt.HeadlessException, javax.sound.midi.MidiUnavailableException {
        s.open();

        s.loadAllInstruments(sb);
        Cpanel c = new Cpanel(this);
        setDefaultCloseOperation(3);
        setSize(800, 600);
        setVisible(true);
        getContentPane().add(c);
        getContentPane().setBackground(Color.BLACK);
    }

    public static Visual getInstance() throws MidiUnavailableException {
        if(instance == null){
            instance = new Visual();
        }
        return instance;
    }

    public void paint(Graphics g) { super.paint(g); }

    public void display(int[] a, int current, int check) throws InterruptedException {
        //Thread.sleep(50);
        BufferedImage b = new BufferedImage(600, 600, 2);
        Graphics g = b.getGraphics();
        s.getChannels()[0].programChange(81);
        s.getChannels()[1].programChange(81);
        if(current != -1)
            s.getChannels()[0].noteOn(a[current] / (int)Math.ceil(a.length / 120.0D), 75);
        if(check != -1)
            s.getChannels()[1].noteOn(a[check] / (int)Math.ceil(a.length / 120.0D), 75);
        g.setColor(Color.black);
        g.fillRect(0, 0, 600, 600);
        g.setColor(Color.WHITE);
        g.setFont(new java.awt.Font("Arial", 0, 20));
        g.drawString(getTitle(), 10, 50);
        for (int i = 0; i < a.length; i++) {
            if ((i == current) || (i == check)) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.WHITE);
            }
            g.fillRect(i * (480 / a.length) + 40, 560 - a[i] * (480 / a.length), 480 / a.length, a[i] * (480 / a.length));
        }

        getGraphics().drawImage(b, 0, 0, null);
        if(current != -1)
            s.getChannels()[0].noteOff(a[current] / (int)Math.ceil(a.length / 120.0D), 75);
        if(check != -1)
            s.getChannels()[1].noteOff(a[check] / (int)Math.ceil(a.length / 120.0D), 75);
    }
}