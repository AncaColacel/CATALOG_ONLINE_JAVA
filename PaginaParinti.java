package TEMA_POO;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.Vector;

public class PaginaParinti extends JFrame implements ListSelectionListener {
    JLabel parinti;
    JLabel notificare;
    JList lista_parinti;
    JList text;
    JScrollPane scroll;
    JScrollPane scroll2;


    public PaginaParinti (String nume) {
        super (nume);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setMinimumSize(new Dimension(700, 500));
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        parinti = new JLabel("Lista parinti: ");
        panel.add(parinti);
        int size = Catalog.getInstance().lista_cursuri.size();
        Vector<Course> cursuri = new Vector<>(size);
        Vector<Student> studenti = new Vector<>();
        Vector<Parent> parinti = new Vector<>();
        for (int i = 0; i < size; i++) {
            cursuri.add(Catalog.getInstance().lista_cursuri.get(i));
        }
        studenti.addAll(cursuri.get(0).getAllStudents());
        for (int i = 0; i < studenti.size(); i++) {
            parinti.add(studenti.get(i).getFather());
            parinti.add(studenti.get(i).getMother());
        }
        lista_parinti = new JList<>(parinti);
        scroll = new JScrollPane(lista_parinti);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(scroll);
        add(panel, BorderLayout.WEST);
        text = new JList();
        JPanel panel2 = new JPanel();
        notificare = new JLabel("Afisare notificare pentru parinti: ");
        panel2.setLayout(new GridLayout(2, 1));
        panel2.add(notificare);
        scroll2 = new JScrollPane(text);
        scroll2.setSize(new Dimension(200, 200));
        panel2.add(scroll2, BorderLayout.EAST);


        add(panel, BorderLayout.WEST);
        add(panel2, BorderLayout.EAST);

        ListSelectionListener listener = new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                Parent p = null;
                Vector<Parent> parinti = new Vector<>();
                Vector<Course> cursuri = new Vector<>();
                Vector<Student> studenti = new Vector<>();
                Vector<String> buffer = new Vector<>();
                if (lista_parinti.isSelectionEmpty()) {
                    return;
                } else {
                    p = (Parent) lista_parinti.getSelectedValue();
                    int size = Catalog.getInstance().lista_cursuri.size();
                    //System.out.println(size);
                    for (int i = 0; i < size; i++) {
                        cursuri.add(Catalog.getInstance().lista_cursuri.get(i));
                    }
                    //System.out.println(cursuri);
                    //System.out.println(cursuri.size());
                    studenti.addAll(cursuri.get(0).getAllStudents());
                    for (int i = 0; i < studenti.size(); i++) {
                        parinti.add(studenti.get(i).getFather());
                        parinti.add(studenti.get(i).getMother());
                    }
                    for (Parent pi : parinti) {
                        if (pi.toString().compareTo(p.toString()) == 0) {
                            for (Student s : studenti) {
                                if (p.toString().compareTo(s.getFather().toString()) == 0 || p.toString().compareTo(s.getMother().toString()) == 0) {
                                    for (int k = 0; k < cursuri.size(); k++) {
                                        buffer.add("Copilul dvs " + s.getFirstName() + " " + s.getLastName() + " are urmatoarele note: " + "\n" + cursuri.get(k).getGrade(s) + "\n");
                                        text.setListData(buffer);
                                    }

                                }

                            }
                        }

                    }

                }


            }

        };

        lista_parinti.addListSelectionListener(listener);

        //pack();
        setVisible(true);
        show();


    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
    }



}
