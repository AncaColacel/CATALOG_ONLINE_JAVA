package TEMA_POO;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;

public class BestPartialScore implements Strategy {

    @Override
    public Student getBestStudent(SortedSet<Grade> note) {
        Double max = -1.00;
        Student student = null;
        for (Grade nota : note) {
            if (nota.getScorePartial() >= max) {
                max = nota.getScorePartial();
                student = nota.getStudent();
            }
        }
        return student;
    }
}
