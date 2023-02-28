package TEMA_POO;

import java.util.*;

public class FullCourse extends Course {

    protected FullCourse (CourseBuilder builder) {
        super (builder);
    }

    public FullCourse () {

    }

    public static class FullCourseBuilder extends CourseBuilder {
        public FullCourseBuilder (String nume, Teacher profesor_titular, Set<Assistant> asistenti, SortedSet<Grade> note, Map<String, Group> dictionar, int puncte_credit) {
            super(nume, profesor_titular, asistenti, note, dictionar, puncte_credit);
        }
        public Course builder () {
            return new FullCourse(this);
        }

    }

    // studentii promovati au partial >=3 si exam >= 2
    public ArrayList<Student> getGraduatedStudents() {
        ArrayList<Student> studenti_promovati = new ArrayList<>();
        HashMap<Student, Grade> situatie_stud = new HashMap<>();
        situatie_stud = gettAllStudentGrades();
        for (Map.Entry<Student, Grade> element: situatie_stud.entrySet()) {
            Grade nota = element.getValue();
            if (nota.getScorePartial() >= 3 && nota.getScoreExam() >= 2) {
                studenti_promovati.add(element.getKey());
            }
        }
        return studenti_promovati;
    }
}
