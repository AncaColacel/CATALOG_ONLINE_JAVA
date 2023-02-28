package TEMA_POO;

import java.util.ArrayList;

public class Catalog implements Subject {
    private  ArrayList<Observer> ascultatori;
    private static Catalog instance = null;
    ArrayList<Course> lista_cursuri;

    private Catalog () {
        lista_cursuri = new ArrayList<>();
        ascultatori = new ArrayList<>();
    }

    public static Catalog getInstance() {
        if (instance == null) {
            instance = new Catalog();
        }
        return instance;
    }

    public ArrayList<Observer> getAscultatori() {
        return ascultatori;
    }



    public void printareCursuri () {
        for (Course curs : lista_cursuri) {
            System.out.println(curs);
            System.out.println("************************************************************************************************************");
        }
    }

    public void addCourse(Course course) {
        Catalog.getInstance().lista_cursuri.add(course);
    }

    public void removeCourse(Course course) {
        Catalog.getInstance().lista_cursuri.remove(course);
    }

    public void addObserver(Observer parent) {
        ascultatori.add(parent);
    }

    public void removeObserver(Observer parent) {
        ascultatori.remove(parent);
    }

    public void notifyObservers(Grade grade) {
        Notification notificare = new Notification(grade);
        for (Observer parinte : ascultatori) {
            if (((Parent)parinte).getLastName().equals(grade.getStudent().getLastName())) {
                parinte.update(notificare);
            }

        }
    }

    public void nota_noua(Grade nota) {
        notifyObservers(nota);
    }




}







