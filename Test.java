package TEMA_POO;

//import java.awt.*;
import java.util.*;
import java.util.SortedSet;

public class Test {
    public static void main(String[] args) {

        // AFISARE DE CATALOG

        // creare parinti pentru studenti
        // folosire Factory
        UserFactory factory = new UserFactory();

        Parent m1 = (Parent)(factory.getUser("Parent", "Elena", "Popescu"));
        Parent t1 = (Parent)(factory.getUser("Parent", "Vlad", "Popescu"));
        Parent m2 = (Parent)(factory.getUser("Parent", "Cristina", "Ganciu"));
        Parent t2 = (Parent)(factory.getUser("Parent", "Andrei", "Ganciu"));
        Parent m3 = (Parent)(factory.getUser("Parent", "Geanina", "Stanescu"));
        Parent t3 = (Parent)(factory.getUser("Parent", "Cosmin", "Stanescu"));
        Parent m4 = (Parent)(factory.getUser("Parent", "Ana", "Adam"));
        Parent t4 = (Parent)(factory.getUser("Parent", "Mihai", "Adam"));
        Parent m5 = (Parent)(factory.getUser("Parent", "Anastasia", "Albu"));
        Parent t5 = (Parent)(factory.getUser("Parent", "Victor", "Albu"));
        Parent m6 = (Parent)(factory.getUser("Parent", "Bianca", "Andronic"));
        Parent t6 = (Parent)(factory.getUser("Parent", "Cristiano", "Andronic"));
        Parent m7 = (Parent)(factory.getUser("Parent", "Jeniffer", "Petrache"));
        Parent t7 = (Parent)(factory.getUser("Parent", "Mircea", "Petrache"));
        Parent m8 = (Parent)(factory.getUser("Parent", "Anamaria", "Teodoreanu"));
        Parent t8 = (Parent)(factory.getUser("Parent", "Nikolas", "Teodoreanu"));

        // creare studenti
        // folosire Factory

        Student st1 = (Student)(factory.getUser("Student", "Maria", "Popescu"));
        Student st2 = (Student)(factory.getUser("Student", "Natalia", "Ganciu"));
        Student st3 = (Student)(factory.getUser("Student", "Amalia", "Stanescu"));
        Student st4 = (Student)(factory.getUser("Student", "Izabela", "Adam"));
        Student st5 = (Student) (factory.getUser("Student", "Denisa", "Albu"));
        Student st6 = (Student) (factory.getUser("Student", "Radu", "Andronic"));
        Student st7 = (Student) (factory.getUser("Student", "Ariana", "Petrache"));
        Student st8 = (Student) (factory.getUser("Student", "Liviu", "Teodoreanu"));


        // setare parinti pt studenti

        st1.SetFather(t1);
        st1.SetMother(m1);
        st2.SetFather(t2);
        st2.SetMother(m2);
        st3.SetFather(t3);
        st3.SetMother(m3);
        st4.SetFather(t4);
        st4.SetMother(m4);
        st5.SetFather(t5);
        st5.SetMother(m5);
        st6.SetFather(t6);
        st6.SetMother(m6);
        st7.SetFather(t7);
        st7.SetMother(m7);
        st8.SetFather(t8);
        st8.SetMother(m8);

        // creare profesori pt fiecare materie
        // folosire Factory

        Teacher p1 = (Teacher) (factory.getUser("Teacher", "Carmen", "Odubasteanu"));
        Teacher p2 = (Teacher) (factory.getUser("Teacher", "Razvan", "Deaconescu"));
        Teacher p3 = (Teacher) (factory.getUser("Teacher", "Daniel", "Rosner"));
        Teacher p4 = (Teacher) (factory.getUser("Teacher", "Adrian", "Radu"));

        // creare asistenti
        // folosire Factory

        Assistant a1 = (Assistant) (factory.getUser("Assistant", "Diana", "Nucuta"));
        Assistant a2 = (Assistant) (factory.getUser("Assistant", "Mihai", "Nan"));
        Assistant a3 = (Assistant) (factory.getUser("Assistant", "Maia", "Oprea"));
        Assistant a4 = (Assistant) (factory.getUser("Assistant", "Tudor", "Gherasim"));

        Assistant a5 = (Assistant) (factory.getUser("Assistant", "Andreea", "Pavel"));
        Assistant a6 = (Assistant) (factory.getUser("Assistant", "Alex", "Dogariu"));
        Assistant a7 = (Assistant) (factory.getUser("Assistant", "Stefan", "Munteanu"));
        Assistant a8 = (Assistant) (factory.getUser("Assistant", "Irina", "Budaca"));

        Assistant a9 = (Assistant) (factory.getUser("Assistant", "Ioana", "Puscas"));
        Assistant a10 = (Assistant) (factory.getUser("Assistant", "Oana", "Mosneag"));
        Assistant a11 = (Assistant) (factory.getUser("Assistant", "Darius", "Mihai"));
        Assistant a12 = (Assistant) (factory.getUser("Assistant", "Petru", "Alexandrescu"));

        Assistant a13 = (Assistant) (factory.getUser("Assistant", "Dragos", "Petre"));
        Assistant a14 = (Assistant) (factory.getUser("Assistant", "Alexandra", "Gheorghe"));
        Assistant a15 = (Assistant) (factory.getUser("Assistant", "Marius", "Petraru"));
        Assistant a16 = (Assistant) (factory.getUser("Assistant", "Gina", "Oltean"));


        // creare multime de asistenti

        Set<Assistant> asistenti1 = new HashSet<>();
        Set<Assistant> asistenti2 = new HashSet<>();
        Set<Assistant> asistenti3 = new HashSet<>();
        Set<Assistant> asistenti4 = new HashSet<>();

        // asistenti pt primul curs
        asistenti1.add(a1);
        asistenti1.add(a2);
        asistenti1.add(a3);
        asistenti1.add(a4);

        // asistenti pt al doilea curs
        asistenti2.add(a5);
        asistenti2.add(a6);
        asistenti2.add(a7);
        asistenti2.add(a8);

        // asistenti pt al treilea curs
        asistenti3.add(a9);
        asistenti3.add(a10);
        asistenti3.add(a11);
        asistenti3.add(a12);

        // asistenti pt al patrulea curs
        asistenti4.add(a13);
        asistenti4.add(a14);
        asistenti4.add(a15);
        asistenti4.add(a16);

        // creare Grupe

        Group grupa1 = new Group("321CC", a1);
        Group grupa2 = new Group("322CC", a2);
        Group grupa3 = new Group ("323CC", a3);
        Group grupa4 = new Group("324CC", a4);

        Group grupa1_1 = new Group("321CC", a5);
        Group grupa2_1 = new Group("322CC", a6);
        Group grupa3_1 = new Group ("323CC", a7);
        Group grupa4_1 = new Group("324CC", a8);

        Group grupa1_2 = new Group("321CC", a9);
        Group grupa2_2 = new Group("322CC", a10);
        Group grupa3_2 = new Group ("323CC", a11);
        Group grupa4_2 = new Group("324CC", a12);

        Group grupa1_3 = new Group("321CC", a13);
        Group grupa2_3 = new Group("322CC", a14);
        Group grupa3_3 = new Group ("323CC", a15);
        Group grupa4_3 = new Group("324CC", a16);


        // adaugare studenti in grupe

        grupa1.add(st1);
        grupa1.add(st2);

        grupa2.add(st3);
        grupa2.add(st4);

        grupa3.add(st5);
        grupa3.add(st6);

        grupa4.add(st7);
        grupa4.add(st8);

        grupa1_1.add(st1);
        grupa1_1.add(st2);

        grupa2_1.add(st3);
        grupa2_1.add(st4);

        grupa3_1.add(st5);
        grupa3_1.add(st6);

        grupa4_1.add(st7);
        grupa4_1.add(st8);

        grupa1_2.add(st1);
        grupa1_2.add(st2);

        grupa2_2.add(st3);
        grupa2_2.add(st4);

        grupa3_2.add(st5);
        grupa3_2.add(st6);

        grupa4_2.add(st7);
        grupa4_2.add(st8);

        grupa1_3.add(st1);
        grupa1_3.add(st2);

        grupa2_3.add(st3);
        grupa2_3.add(st4);

        grupa3_3.add(st5);
        grupa3_3.add(st6);

        grupa4_3.add(st7);
        grupa4_3.add(st8);

        // setare note

        Grade n1 = new Grade();
        n1.setStudent(st1);
        n1.setPartialScore(7.8);
        n1.setExamScore(8.2);
        n1.setCourse("POO");



        Grade n2 = new Grade ();
        n2.setStudent(st2);
        n2.setPartialScore(7.2);
        n2.setExamScore(6.7);
        n2.setCourse("POO");



        Grade n3 = new Grade ();
        n3.setStudent(st3);
        n3.setPartialScore(5.6);
        n3.setExamScore(9.5);
        n3.setCourse("POO");


        Grade n4 = new Grade ();
        n4.setStudent(st4);
        n4.setPartialScore(6.9);
        n4.setExamScore(8.4);
        n4.setCourse("POO");

        Grade n5 = new Grade ();
        n5.setStudent(st5);
        n5.setPartialScore(9.4);
        n5.setExamScore(10.00);
        n5.setCourse("POO");

        Grade n6 = new Grade ();
        n6.setStudent(st6);
        n6.setPartialScore(4.7);
        n6.setExamScore(8.00);
        n6.setCourse("POO");

        Grade n7 = new Grade ();
        n7.setStudent(st7);
        n7.setPartialScore(3.00);
        n7.setExamScore(4.00);
        n7.setCourse("POO");

        Grade n8 = new Grade ();
        n8.setStudent(st8);
        n8.setPartialScore(6.9);
        n8.setExamScore(6.00);
        n8.setCourse("POO");

        Grade n9 = new Grade ();
        n9.setStudent(st1);
        n9.setPartialScore(4.4);
        n9.setExamScore(8.1);
        n9.setCourse("SO");

        Grade n10 = new Grade ();
        n10.setStudent(st2);
        n10.setPartialScore(3.2);
        n10.setExamScore(6.7);
        n10.setCourse("SO");

        Grade n11 = new Grade ();
        n11.setStudent(st3);
        n11.setPartialScore(8.9);
        n11.setExamScore(8.2);
        n11.setCourse("SO");

        Grade n12 = new Grade ();
        n12.setStudent(st4);
        n12.setPartialScore(7.00);
        n12.setExamScore(6.3);
        n12.setCourse("SO");

        Grade n13 = new Grade ();
        n13.setStudent(st5);
        n13.setPartialScore(4.6);
        n13.setExamScore(4.8);
        n13.setCourse("SO");

        Grade n14 = new Grade ();
        n14.setStudent(st6);
        n14.setPartialScore(5.00);
        n14.setExamScore(8.00);
        n14.setCourse("SO");

        Grade n15 = new Grade ();
        n15.setStudent(st7);
        n15.setPartialScore(9.8);
        n15.setExamScore(8.2);
        n15.setCourse("SO");

        Grade n16 = new Grade ();
        n16.setStudent(st8);
        n16.setPartialScore(10.00);
        n16.setExamScore(10.00);
        n16.setCourse("SO");

        Grade n17 = new Grade();
        n17.setStudent(st1);
        n17.setPartialScore(7.8);
        n17.setExamScore(8.2);
        n17.setCourse("DEEA");



        Grade n18 = new Grade ();
        n18.setStudent(st2);
        n18.setPartialScore(7.2);
        n18.setExamScore(6.7);
        n18.setCourse("DEEA");



        Grade n19 = new Grade ();
        n19.setStudent(st3);
        n19.setPartialScore(5.6);
        n19.setExamScore(9.5);
        n19.setCourse("DEEA");


        Grade n20 = new Grade ();
        n20.setStudent(st4);
        n20.setPartialScore(6.9);
        n20.setExamScore(8.4);
        n20.setCourse("DEEA");

        Grade n21 = new Grade ();
        n21.setStudent(st5);
        n21.setPartialScore(9.4);
        n21.setExamScore(10.00);
        n21.setCourse("DEEA");

        Grade n22 = new Grade ();
        n22.setStudent(st6);
        n22.setPartialScore(4.7);
        n22.setExamScore(8.00);
        n22.setCourse("DEEA");

        Grade n23 = new Grade ();
        n23.setStudent(st7);
        n23.setPartialScore(3.00);
        n23.setExamScore(4.00);
        n23.setCourse("DEEA");

        Grade n24 = new Grade ();
        n24.setStudent(st8);
        n24.setPartialScore(6.9);
        n24.setExamScore(6.00);
        n24.setCourse("DEEA");

        Grade n25 = new Grade();
        n25.setStudent(st1);
        n25.setPartialScore(7.8);
        n25.setExamScore(8.2);
        n25.setCourse("FIZICA");

        Grade n26 = new Grade ();
        n26.setStudent(st2);
        n26.setPartialScore(7.2);
        n26.setExamScore(6.7);
        n26.setCourse("FIZICA");

        Grade n27 = new Grade ();
        n27.setStudent(st3);
        n27.setPartialScore(5.6);
        n27.setExamScore(9.5);
        n27.setCourse("FIZICA");


        Grade n28 = new Grade ();
        n28.setStudent(st4);
        n28.setPartialScore(6.9);
        n28.setExamScore(8.4);
        n28.setCourse("FIZICA");

        Grade n29 = new Grade ();
        n29.setStudent(st5);
        n29.setPartialScore(9.4);
        n29.setExamScore(10.00);
        n29.setCourse("FIZICA");

        Grade n30 = new Grade ();
        n30.setStudent(st6);
        n30.setPartialScore(4.7);
        n30.setExamScore(8.00);
        n30.setCourse("FIZICA");

        Grade n31 = new Grade ();
        n31.setStudent(st7);
        n31.setPartialScore(3.00);
        n31.setExamScore(4.00);
        n31.setCourse("FIZICA");

        Grade n32 = new Grade ();
        n32.setStudent(st8);
        n32.setPartialScore(6.9);
        n32.setExamScore(6.00);
        n32.setCourse("FIZICA");

        // creare colectie note

        SortedSet<Grade> note1 = new TreeSet();
        SortedSet<Grade> note2 = new TreeSet();
        SortedSet<Grade> note3 = new TreeSet<>();
        SortedSet<Grade> note4 = new TreeSet<>();

        note1.add(n1);
        note1.add(n2);
        note1.add(n3);
        note1.add(n4);
        note1.add(n5);
        note1.add(n6);
        note1.add(n7);
        note1.add(n8);

        note2.add(n9);
        note2.add(n10);
        note2.add(n11);
        note2.add(n12);
        note2.add(n13);
        note2.add(n14);
        note2.add(n15);
        note2.add(n16);

        note3.add(n17);
        note3.add(n18);
        note3.add(n19);
        note3.add(n20);
        note3.add(n21);
        note3.add(n22);
        note3.add(n23);
        note3.add(n24);

        note4.add(n25);
        note4.add(n26);
        note4.add(n27);
        note4.add(n28);
        note4.add(n29);
        note4.add(n30);
        note4.add(n31);
        note4.add(n32);


        // creare dictionare pentru cele 4 cursuri

        Map<String, Group> dictionar1 = new HashMap<>();
        Map<String, Group> dictionar2 = new HashMap<>();
        Map<String, Group> dictionar3 = new HashMap<>();
        Map<String, Group> dictionar4 = new HashMap<>();

        dictionar1.put("321CC", grupa1);
        dictionar1.put("322CC", grupa2);
        dictionar1.put("323CC", grupa3);
        dictionar1.put("324CC", grupa4);

        dictionar2.put("321CC", grupa1_1);
        dictionar2.put("322CC", grupa2_1);
        dictionar2.put("323CC", grupa3_1);
        dictionar2.put("324CC", grupa4_1);

        dictionar3.put("321CC", grupa1_2);
        dictionar3.put("322CC", grupa2_2);
        dictionar3.put("323CC", grupa3_2);
        dictionar3.put("324CC", grupa4_2);

        dictionar4.put("321CC", grupa1_3);
        dictionar4.put("322CC", grupa2_3);
        dictionar4.put("323CC", grupa3_3);
        dictionar4.put("324CC", grupa4_3);

        // creare puncte credit

        int puncte_credit1 = 5;
        int puncte_credit2 = 4;
        int puncte_credit3 = 6;
        int puncte_credit4 = 7;

        // creare cursuri
        // folosire Build

        FullCourse curs1 = (FullCourse) new FullCourse.FullCourseBuilder("POO", p1, asistenti1, note1, dictionar1, puncte_credit1).builder();
        FullCourse curs2 = (FullCourse) new FullCourse.FullCourseBuilder("SO", p2, asistenti2, note2, dictionar2, puncte_credit2).builder();
        PartialCourse curs3 = (PartialCourse) new PartialCourse.PartialCourseBuilder("DEEA", p3, asistenti3, note3, dictionar3, puncte_credit3).builder();
        PartialCourse curs4 = (PartialCourse) new PartialCourse.PartialCourseBuilder("Fizica", p4, asistenti4, note4, dictionar4, puncte_credit4).builder();

        // creare catalog
        // folosire Singleton

        Catalog catalog = Catalog.getInstance();
        catalog.lista_cursuri.add(curs1);
        catalog.lista_cursuri.add(curs2);
        catalog.lista_cursuri.add(curs3);
        catalog.lista_cursuri.add(curs4);

        System.out.println("\n");
        System.out.println("AFISARE CATALOG ELECTRONIC: " + "\n");
        catalog.printareCursuri();


        // testare Strategy

        System.out.println("\n");
        System.out.println("CEI MAI BUNI STUDENTI: ");
        System.out.println("\n");
        curs1.setStrategie(new BestTotalScore());
        System.out.println("Studentul cu nota cea mai mare la cursul de POO :" + curs1.getBestStudent());
        curs2.setStrategie(new BestTotalScore());
        System.out.println("Studentul cu nota cea mai mare la cursul de SO :" + curs2.getBestStudent());
        curs3.setStrategie(new BestTotalScore());
        System.out.println("Studentul cu nota cea mai mare la cursul de DEEA :" + curs3.getBestStudent());
        curs4.setStrategie(new BestTotalScore());
        System.out.println("Studentul cu nota cea mai mare la cursul de Fizica :" + curs4.getBestStudent());

        // testare Visitor

        System.out.println("\n");
        System.out.println("AFISARE NOTIFICARI PARINTI: " + "\n");
        ScoreVisitor visitor = new ScoreVisitor();
        p1.accept(visitor);

        PaginaStudent pag_stud = new PaginaStudent("Pagina Student");
        System.out.println("\n");
        System.out.println("AFISARE NOTIFICARE PARINTI DIN INTERFATA GRAFICA:");
        System.out.println("\n");
        PaginaProfesor pag_prof = new PaginaProfesor(("Pagina profesor"));
        PaginaParinti pag_parinti = new PaginaParinti(("Pagina parinti"));































    }
}



