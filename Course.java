package TEMA_POO;

import java.util.*;

public abstract class Course {
    private String nume;
    private Teacher profesor_titular;
    private Set<Assistant> asistenti;
    private SortedSet<Grade> note;
    private Map<String, Group> dictionar;
    private int puncte_credit;


    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setProfesor_titular(Teacher profesor_titular) {
        this.profesor_titular = profesor_titular;
    }

    public void setAsistenti(Set<Assistant> asistenti) {
        this.asistenti = asistenti;
    }

    public void setNote(SortedSet<Grade> note) {

        this.note = note;
    }

    public void setDictionar(Map<String, Group> dictionar) {
        this.dictionar = dictionar;
    }

    public void setPuncte_credit(int puncte_credit) {
        this.puncte_credit = puncte_credit;
    }

    public String getNume() {
        return nume;
    }

    public Teacher getProfesor_titular() {
        return profesor_titular;
    }

    public Set<Assistant> getAsistenti() {
        return asistenti;
    }

    public SortedSet<Grade> getNote() {
        return note;
    }

    public Map<String, Group> getDictionar() {
        return dictionar;
    }

    public int getPuncte_credit() {
        return puncte_credit;
    }

    protected Course(CourseBuilder builder) {
        this.nume = builder.nume;
        this.profesor_titular = builder.profesor_titular;
        this.asistenti = builder.asistenti;
        this.note = builder.note;
        this.dictionar = builder.dictionar;
        this.puncte_credit = builder.puncte_credit;
    }

    public Course() {
    }

    public static abstract class CourseBuilder {
        private String nume;
        private Teacher profesor_titular;
        private Set<Assistant> asistenti;
        private SortedSet<Grade> note;
        private Map<String, Group> dictionar;
        private int puncte_credit;

        public CourseBuilder(String nume, Teacher profesor_titular, Set<Assistant> asistenti, SortedSet<Grade> note, Map<String, Group> dictionar, int puncte_credit) {
            this.nume = nume;
            this.profesor_titular = profesor_titular;
            this.asistenti = asistenti;
            this.note = note;
            this.dictionar = dictionar;
            this.puncte_credit = puncte_credit;
        }

        public String getNume() {
            return nume;
        }

        public Teacher getProfesor_titular() {
            return profesor_titular;
        }

        public Set<Assistant> getAsistenti() {
            return asistenti;
        }

        public SortedSet<Grade> getNote() {
            return note;
        }

        public Map<String, Group> getDictionar() {
            return dictionar;
        }

        public int getPuncte_credit() {
            return puncte_credit;
        }

        public String toString() {
            return "NUME CURS: " + nume + "\n" + "PROFESOR TITULAR:" + profesor_titular + "\n" + "ASISTENTI:" + asistenti + "\n" + "GRUPE:" + " " + dictionar + "\n" + "PUNCTE CREDIT:" + puncte_credit;
        }

        // va fi implementata in clasele care implementeaza clasa Course si CourseBuilder
        public abstract Course builder();

    }

    // Seteaza asistentul în grupa cu ID-ul indicat
    // Daca nu exista deja, adauga asistentul si in multimea asistentilor
    public void addAssistent(String ID, Assistant assistant) {
        Group grupa = new Group("", null);
        grupa = dictionar.get(ID);
        grupa.setAssistant(assistant);
        if (!asistenti.contains(assistant)) {
            asistenti.add(assistant);
        }
    }

    // Adauga studentul în grupa cu ID-ul indicat
    public void addStudent(String ID, Student student) {
        // obtinere grupa pe baza ID-ului
        Group grupa = dictionar.get(ID);
        System.out.println(grupa.getID());
        grupa.add(student);
    }

    // Adauga grupa
    public void addGroup(Group group) {
        dictionar.put(group.getID(), group);
    }

    // Instantiaza o grupa si o adauga
    public void addGroup(String ID, Assistant assistant) {
        Group grupa = new Group(ID, assistant);
        dictionar.put(ID, grupa);
    }

    // Instantiaza o grupa si o adauga
    public void addGroup(String ID, Assistant assist, Comparator<Student> comp) {
        Group grupa = new Group(ID, assist, comp);
        dictionar.put(ID, grupa);
    }

    // Returneaza nota unui student sau null
    public Grade getGrade(Student student) {
        Grade nota = new Grade();
        for (Grade grade : note) {
            if (grade.getStudent().equals(student)) {
                nota = grade;
            }
        }
        return nota;
    }

    // Adauga o nota
    public void addGrade(Grade grade) {
        note.add(grade);
    }

    // Returneaza o lista cu toti studentii
    public ArrayList<Student> getAllStudents () {
        ArrayList<Student> studenti = new ArrayList<>();
        Collection <Group> grupe = new HashSet<>();
        grupe = dictionar.values();
        for (Group grupa : grupe) {
            for (Student student: grupa) {
                studenti.add(student);
            }
        }
        return studenti;
    }

    // Returneaza un dictionar cu situatia studentilor
    public HashMap<Student, Grade> gettAllStudentGrades() {
        HashMap<Student, Grade> situatie_studenti = new HashMap<>();
        ArrayList<Student> studenti = new ArrayList<>();
        studenti = getAllStudents();
        for (Student student : studenti) {
            situatie_studenti.put(student, getGrade(student));
        }
        return situatie_studenti;
    }

    // Metoda ce o sa fie implementata pentru a determina studentii promovati
    public abstract ArrayList<Student> getGraduatedStudents();

    @Override
    public String toString() {
        //return "NUME CURS: " + nume + "\n" + "PROFESOR TITULAR: " + profesor_titular + "\n" + "ASISTENTI:" + asistenti + "\n"  + "STUDENTI: " + "\n" + note + "\n" + dictionar  + "\n"  + "PUNCTE CREDIT pentru curs : " +  puncte_credit;
        return nume;
    }


    // Va returna cel mai bun student, tinând cont de strategia aleasa
    // de profesor pentru curs

    private Strategy strategie;


    public void setStrategie(Strategy strategie) {

        this.strategie = strategie;
    }

    public Student getBestStudent() {

        return strategie.getBestStudent(note);
    }

    private class Snapshot {
       private SortedSet<Grade> note_copie;

        private Snapshot() throws CloneNotSupportedException {
            note_copie = new TreeSet<>();
            for (Grade nota : note) {
                note_copie.add((Grade) nota.clone());
            }
        }


    }
    private Snapshot backup;

    public void makeBackup () throws CloneNotSupportedException {
        backup = new Snapshot();
    }

    public void undo() {
        this.setNote(backup.note_copie);
    }



}


