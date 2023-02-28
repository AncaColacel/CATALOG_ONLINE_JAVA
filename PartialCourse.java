package TEMA_POO;

import java.util.*;

public class PartialCourse extends Course  {
    private Strategy strategie;

    public PartialCourse(Strategy strategie) {

        this.strategie = strategie;
    }

    protected PartialCourse (CourseBuilder builder) {
        super(builder);
    }

    public PartialCourse() {
        super();
    }

    public static class PartialCourseBuilder extends CourseBuilder {

        public PartialCourseBuilder (String nume, Teacher profesor_titular, Set<Assistant> asistenti, SortedSet<Grade> note, Map<String, Group> dictionar, int puncte_credit) {
            super(nume, profesor_titular, asistenti, note, dictionar, puncte_credit);
        }

        public Course builder () {
            return new PartialCourse(this);
        }


    }

    // studentii promovati au total >=5
    public ArrayList<Student> getGraduatedStudents() {
        ArrayList<Student> studenti_promovati = new ArrayList<>();
        HashMap<Student, Grade> situatie_stud = new HashMap<>();
        situatie_stud = gettAllStudentGrades();
        for (Map.Entry<Student, Grade> element: situatie_stud.entrySet()) {
            Grade nota = new Grade();
            nota = element.getValue();
            System.out.println("nota: " + nota);
            if (nota.getTotal() >= 5) {
                studenti_promovati.add(element.getKey());
                System.out.println("ok");
            }
        }
        return studenti_promovati;
    }
}
