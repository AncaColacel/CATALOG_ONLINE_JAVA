package TEMA_POO;

import java.util.Comparator;
import java.util.TreeSet;

public class Group extends TreeSet<Student> {
    // principiul incapsularii
    private Assistant assistant;
    private String ID;

    public Group(String ID, Assistant assistant, Comparator<Student> comp) {
        // se apeleaza constructorul clasei TreeSet cu comparator
        super(comp);
        this.assistant = assistant;
        this.ID = ID;

    }

    // setarea elementelor incapsulate
    public Group(String ID, Assistant assistant) {
        super();
        this.assistant = assistant;
        this.ID = ID;
    }

    // functii de setter pt elementele incapsulate

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setAssistant(Assistant assistant) {
        this.assistant = assistant;
    }

    // functii de getter pt elementele incapsulate
    public Assistant getAssistant () {
        return assistant;
    }

    public String getID () {
        return ID;
    }

    @Override
    public String toString() {
        return " ---> asistent: " + assistant;

    }
}
