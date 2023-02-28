package TEMA_POO;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;

public class BestExamScore implements Strategy {
    public Student getBestStudent(SortedSet<Grade> note) {
        Double max = -1.00;
        Student student = null;
        for (Grade nota : note) {
            if (nota.getScoreExam() >= max) {
                max = nota.getScoreExam();
                student = nota.getStudent();
            }
        }
        return student;
    }
}
