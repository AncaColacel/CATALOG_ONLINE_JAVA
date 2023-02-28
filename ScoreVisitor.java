package TEMA_POO;

import java.util.HashMap;
import java.util.Map;

public class ScoreVisitor implements Visitor{
    Map<Teacher, Tuple> examScore = new HashMap<>();
    Map<Assistant, Tuple> partialScore = new HashMap<>();

    public void visit(Assistant assistant) {
        Catalog catalog = Catalog.getInstance();
        Course curs_asistent = null;
        Group grupa_asistent = null;
        for (Course  curs : catalog.lista_cursuri) {
            if (curs.getAsistenti().contains(assistant)) {
                curs_asistent = curs;
                break;
            }
        }
        for (Group grupa : curs_asistent.getDictionar().values()) {
            if (grupa.getAssistant().equals(assistant)) {
                grupa_asistent = grupa;
                break;
            }
        }

        for (Student student : grupa_asistent) {
            Grade nota = curs_asistent.getGrade(student);
            Tuple<Student, String, Double> t = new Tuple<>(nota.getStudent(), nota.getCourse(), nota.getScorePartial());
            partialScore.put(assistant, t);
            catalog.notifyObservers(nota);

        }
    }

    @Override
    public void visit(Teacher teacher) {
        Catalog catalog = Catalog.getInstance();
        Course curs_prof = null;
        for (Course curs : catalog.lista_cursuri) {
            if (curs.getProfesor_titular().equals(teacher)) {
                curs_prof = curs;
                break;
            }
        }
        Map<Student, Grade> situatie_studenti = new HashMap<>();
        situatie_studenti = curs_prof.gettAllStudentGrades();
        Grade nota = null;
        for (Map.Entry<Student, Grade> element : situatie_studenti.entrySet()) {
            nota = element.getValue();
            Tuple<Student, String, Double> t = new Tuple<>(nota.getStudent(), nota.getCourse(), nota.getScoreExam());
            examScore.put(teacher, t);
            // dupa ce nota finala este trecuta de catre profesor sa fie anuntat si parintele
            if (nota.getScoreExam() != null) {
                catalog.notifyObservers(nota);

            }
        }



    }

    private class Tuple<Student, String, Double> {
        private Student student;
        private String nume_curs;
        private Double nota;

        private Tuple (Student student, String nume_curs, Double nota) {
            this.student = student;
            this.nume_curs = nume_curs;
            this.nota = nota;
        }

        public Student getStudent() {
            return student;
        }

        public String getNume_curs() {
            return nume_curs;
        }

        public Double getNota() {
            return nota;
        }
    }
}
