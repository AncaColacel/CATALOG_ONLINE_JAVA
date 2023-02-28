package TEMA_POO;

public class Grade implements Comparable, Cloneable{
    private Double partialScore, examScore;
    private Student student;
    private String course; // Numele cursului

    public void setScore (Double partialScore, Double examScore) {
        this.partialScore = partialScore;
        this.examScore = examScore;
    }
    public Double getScorePartial () {
        return partialScore;
    }

    public void setPartialScore(Double partialScore) {
        this.partialScore = partialScore;
    }

    public void setExamScore(Double examScore) {
        this.examScore = examScore;
    }

    public Double getScoreExam () {
        return examScore;
    }

    public void setStudent (Student student) {
        this.student = student;
    }

    public Student getStudent () {
        return student;
    }

    public void setCourse (String course) {
        this.course = course;
    }

    public String getCourse () {
        return course;
    }

    public Double getTotal () {
        Double medie = 0.00;
        medie = partialScore + examScore;
        return medie/2;
    }

    public int compareTo (Object o) {
        Double total = this.getTotal();
        if (total.compareTo(((Grade) o).getTotal()) == 0) {
            return 0;
        }
        if (total.compareTo(((Grade) o).getTotal()) < 0) {
            return -1;
        }
        else {
            return 1;
        }
    }

    public String toString() {
        //return "Nume student: " + getStudent() + "   Parinti: " + getStudent().getFather() + " " + getStudent().getMother() + "   nota partial: " + getScorePartial() + "   nota examen final: " + getScoreExam() + "   nota finala curs: " + getTotal() + "\n";
        return "nume curs: " + getCourse() + " nota partial: " + getScorePartial() + "   nota examen final: " + getScoreExam() + "   nota finala curs: " + getTotal() + "\n";
    }

    public Object clone () throws CloneNotSupportedException {
        Grade g = new Grade();
        g.setPartialScore(partialScore.doubleValue());
        g.setExamScore(examScore.doubleValue());
        g.setStudent(student);
        g.setCourse(course);
        return g;
    }


}
