import javax.swing.JComboBox;

public class Cpanel extends javax.swing.JPanel
{
    Visual v;
    static int[] a;

    public Cpanel(Visual v) throws java.awt.HeadlessException
    {
        v = this.v;
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
        final JComboBox<String> bc = new JComboBox();
        bc.addItem("Bubble Sort");
        bc.addItem("Cocktail Shaker Sort");
        bc.addItem("Selection Sort");
        bc.addItem("Radix LSD Base-10 Sort");
        bc.addItem("Slow Sort");
        bc.addItem("Merge Sort");
        bc.addItem("Quick Sort");
        bc.addItem("Counting Sort");
        bc.addItem("Insertion Sort");
        bc.addItem("Double Selection Sort");
        bc.addItem("INPLC Quick Sort");
        bc.setSize(140, 20);
        bc.setLocation(620, 80);
        add(bc);
        javax.swing.JButton r = new javax.swing.JButton("Sort");
        r.setLocation(620, 110);
        r.setSize(140, 20);
        r.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (bc.getSelectedItem().equals(bc.getItemAt(0))) {
                    try {
                        Main.bubbleSort(Cpanel.a);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                } else if (bc.getSelectedItem().equals(bc.getItemAt(1))) {
                    try {
                        Main.cocktailShakerSort(Cpanel.a);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                } else if (bc.getSelectedItem().equals(bc.getItemAt(2))) {
                    try {
                        Main.selectionSort(Cpanel.a, 0);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                } else if (bc.getSelectedItem().equals(bc.getItemAt(3))) {
                    try {
                        Main.radixLSDBase10(Cpanel.a);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                } else if (bc.getSelectedItem().equals(bc.getItemAt(4))) {
                    try {
                        Main.slowSort(Cpanel.a, 0, Cpanel.a.length - 1);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                } else if (bc.getSelectedItem().equals(bc.getItemAt(5))) {
                    try {
                        Main.mergeSort(Cpanel.a, 0);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                } else if (bc.getSelectedItem().equals(bc.getItemAt(6))) {
                    try {
                        Main.quickSort(Cpanel.a, 0);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                } else if (bc.getSelectedItem().equals(bc.getItemAt(7))) {
                    try {
                        Main.countingSort(Cpanel.a);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                } else if (bc.getSelectedItem().equals(bc.getItemAt(8))) {
                    try {
                        Main.insertionSort(Cpanel.a);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                } else if (bc.getSelectedItem().equals(bc.getItemAt(9))) {
                    try {
                        Main.doubleSelectionSort(Cpanel.a);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                } else if (bc.getSelectedItem().equals(bc.getItemAt(10))) {
                    try {
                        Main.inplcQuickSort(Cpanel.a, 0, Cpanel.a.length-1);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        add(r);
    }
}