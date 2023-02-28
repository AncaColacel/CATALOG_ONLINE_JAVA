package TEMA_POO;

public class Notification  {
    Grade nota;

    public Notification (Grade nota) {
        this.nota = nota;
    }

    public void setNota (Grade nota) {
        this.nota = nota;
    }

    public Grade getNota () {
        return nota;
    }

    @Override
    public String toString() {
        return " Copilul dvs. " + nota.getStudent() +  " are nota " + nota.getTotal() + " la materia " + nota.getCourse() + ".";
    }
}
