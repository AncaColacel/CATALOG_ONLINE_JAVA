package TEMA_POO;

import java.util.SortedSet;

public interface Strategy {
    public Student getBestStudent (SortedSet<Grade> note);
}
