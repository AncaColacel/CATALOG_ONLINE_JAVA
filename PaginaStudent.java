package TEMA_POO;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;


public class PaginaStudent extends JFrame implements ListSelectionListener {
    private JLabel label_student;
    private JLabel label_cursuri;
    private JLabel label_info;
    private JList<Student> lista_stud;
    public JList<Course> lsc;
    private JScrollPane scroll;
    private JScrollPane scroll2;
    JTextArea text;



    public PaginaStudent(String nume) {
        super(nume);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setMinimumSize(new Dimension(700, 500));
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        label_student = new JLabel("Lista studenti: ");
        panel.add(label_student);
        int size = Catalog.getInstance().lista_cursuri.size();
        Vector<Course> cursuri = new Vector<>(size);
        for (int i = 0; i < size; i++) {
            cursuri.add(Catalog.getInstance().lista_cursuri.get(i));
        }
        Vector studenti = new Vector<>(cursuri.get(0).getAllStudents());


        lista_stud = new JList<>(studenti);

        lsc = new JList<>();
        scroll = new JScrollPane(lista_stud);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(scroll);
        label_cursuri = new JLabel("Cursurile la care este inrolat studentul: ");
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(2, 1));
        panel2.add(label_cursuri);
        scroll2 = new JScrollPane(lsc);
        scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel2.add(scroll2, BorderLayout.SOUTH);
        lista_stud.addListSelectionListener(this);
        add(panel, BorderLayout.WEST);
        add(panel2, BorderLayout.CENTER);

        label_info = new JLabel("Informatii despre cursuri: ");
        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(2, 1));
        panel3.add(label_info);
        text = new JTextArea(10, 10);
        panel3.add(text);
        add(panel3, BorderLayout.EAST);


        ListSelectionListener listener = new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                ArrayList studenti_per_curs = new ArrayList();
                Vector cursuri_per_student = new Vector<>();
                for (Course curs : Catalog.getInstance().lista_cursuri) {
                    studenti_per_curs = curs.getAllStudents();
                    cursuri_per_student.add(curs);
                }
                HashMap<Student, Grade> note = new HashMap<>();
                Student s = null;
                Map<String, Group> dict = new HashMap<>();
                s = lista_stud.getSelectedValue();
                Course c = null;
                Assistant asistent = null;
                c = lsc.getSelectedValue();
                for (Object curs : cursuri_per_student) {
                    if (curs.equals(c)) {
                        dict = c.getDictionar();
                        for (Map.Entry<String, Group> el : dict.entrySet()) {
                            if (el.getValue().contains(s)) {
                                asistent = el.getValue().getAssistant();
                            }

                        }
                        text.setText("Numele profesorului titular: " + ((Course) curs).getProfesor_titular().getFirstName() + " " + ((Course) curs).getProfesor_titular().getLastName() + "\n" + "Lista de asistenti: " + ((Course) curs).getAsistenti() + "\n" + "Nota studentului selectat: " + c.getGrade(s) + "Asistentul studentului selectat este: " + asistent);

                    }
                }

            }

        };

        lsc.addListSelectionListener(listener);



        pack();
        setVisible(true);
        show();


    }


    @Override
    public void valueChanged(ListSelectionEvent e) {
        ArrayList studenti_per_curs = new ArrayList();
        Vector cursuri_per_student = new Vector<>();
        Vector nume_cursuri = new Vector<>();
        nume_cursuri = new Vector<>();
        Student student = null;
        if (lista_stud.isSelectionEmpty()) {
            return;
        } else {
            student = lista_stud.getSelectedValue();
            for (Course curs : Catalog.getInstance().lista_cursuri) {
                studenti_per_curs = curs.getAllStudents();
                if (studenti_per_curs.contains(student)) {
                    cursuri_per_student.add(curs);
                    nume_cursuri.add(curs);
                }

            }
            lsc.setListData(cursuri_per_student);

        }
    }


}