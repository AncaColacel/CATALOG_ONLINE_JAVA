package TEMA_POO;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.Style;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class PaginaProfesor extends JFrame implements ListSelectionListener, ActionListener {
    JLabel profi;
    JLabel note;
    JLabel v;
    JList lista_profi;
    JList lista_note;
    JButton validare;
    JList val;
    JScrollPane scroll;
    JScrollPane scroll2;
    JButton buton;
    JTextArea text;


    public PaginaProfesor (String nume) {
        super (nume);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 500);
        setMinimumSize(new Dimension(1000, 500));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        profi = new JLabel("Lista profesori: ");
        panel.add(profi);
        int size = Catalog.getInstance().lista_cursuri.size();
        Vector<Course> cursuri = new Vector<>(size);
        Vector<Teacher> profi = new Vector<>(size);
        for (int i = 0; i < size; i++) {
            cursuri.add(Catalog.getInstance().lista_cursuri.get(i));
        }
        for (int i = 0; i < size; i++) {
            profi.add(cursuri.get(i).getProfesor_titular());
        }
        lista_profi= new JList<>(profi);
        lista_note = new JList<>();
        scroll = new JScrollPane(lista_profi);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(scroll);
        note = new JLabel("Note de validat: ");
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(2, 1));
        panel2.add(note);
        scroll2 = new JScrollPane(lista_note);
        scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel2.add(scroll2, BorderLayout.SOUTH);
        lista_profi.addListSelectionListener(this);
        add(panel, BorderLayout.WEST);
        add(panel2, BorderLayout.CENTER);
        buton = new JButton("VALIDARE");
        JPanel panel3 = new JPanel();
        text = new JTextArea();
        v = new JLabel("Apasati butonul pentru validare");
        panel3.add(v);
        panel3.add(buton);
        panel3.add(text);
        add(panel3, BorderLayout.NORTH);
        buton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScoreVisitor visitor = new ScoreVisitor();
                Teacher prof = null;
                prof = (Teacher) lista_profi.getSelectedValue();
                if (e.getSource() instanceof JButton) {
                    for (int i = 0; i < profi.size(); i++) {
                        if (profi.get(i).equals(prof)) {
                            profi.get(i).accept(visitor);
                            Color color=new Color(255,0,0);
                            Font newTextFieldFont=new Font(text.getFont().getName(),Font.BOLD,14);
                            text.setFont(newTextFieldFont);
                            text.setText("Felicitari!" + "\n" + "Validare realizata cu succes!");
                            text.setForeground(color);
                        }
                    }
                }

            }
        });

        getContentPane().setBackground(Color.PINK);
        pack();
        setVisible(true);
        show();
    }











    @Override
    public void valueChanged(ListSelectionEvent e) {
        Teacher prof = null;
        Map<Student, Grade> situatie_scolara = new HashMap<>();
        Vector <Grade> note = new Vector<>();
        Vector <Double> note_finale = new Vector<>();
        if (lista_profi.isSelectionEmpty()) {
            return;
        } else {
            prof = (Teacher) lista_profi.getSelectedValue();
            for (Course curs : Catalog.getInstance().lista_cursuri) {
                if (curs.getProfesor_titular().equals(prof)) {
                    situatie_scolara = curs.gettAllStudentGrades();
                    note.addAll(situatie_scolara.values());
                    for (int i = 0; i < note.size(); i++) {
                        note_finale.add(note.get(i).getScoreExam());
                        lista_note.setListData(note_finale);
                    }
                }
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
