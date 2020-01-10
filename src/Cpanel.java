import javax.swing.JComboBox;

public class Cpanel extends javax.swing.JPanel
{
    static int[] a;

    public Cpanel(Visual v) throws java.awt.HeadlessException
    {
        setVisible(true);
        setSize(200, 600);
        javax.swing.JButton e = new javax.swing.JButton("Reverse");
        e.setLocation(620, 0);
        e.setSize(140, 20);
        e.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                try {
                    Cpanel.a = Main.reverse(Cpanel.a);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        });
        javax.swing.JButton b = new javax.swing.JButton("Shuffle");
        setLocation(600, 0);
        setLayout(null);
        b.setLocation(620, 20);
        b.setSize(140, 20);
        b.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                try {
                    Main.shuffle(Cpanel.a);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        });
        final javax.swing.JTextField t = new javax.swing.JTextField("Array size");
        t.setLocation(620, 50);
        t.setSize(70, 20);
        javax.swing.JButton s = new javax.swing.JButton("Set");
        s.setLocation(690, 50);
        s.setSize(70, 20);
        s.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                Cpanel.a = new int[Integer.parseInt(t.getText())];
                try {
                    Main.setup(Cpanel.a);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        });
        add(b);
        add(e);
        add(t);
        add(s);
        final JComboBox<Sort> bc = new JComboBox();
        for(Sort srt : Sort.sortList){
            bc.addItem(srt);
        }
        bc.setSize(140, 20);
        bc.setLocation(620, 80);
        add(bc);
        javax.swing.JButton r = new javax.swing.JButton("Sort");
        r.setLocation(620, 110);
        r.setSize(140, 20);
        r.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                v.setTitle(((Sort)bc.getSelectedItem()).getName());
                try {
                    ((Sort)bc.getSelectedItem()).sortAlgorithm(a);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        });
        add(r);
    }
}