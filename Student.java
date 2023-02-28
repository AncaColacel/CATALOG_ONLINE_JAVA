package TEMA_POO;

public class Student extends User implements Comparable {
    private Parent mother;
    private Parent father;

    public Student (String firstname, String lastname) {
        super (firstname, lastname);
    }

    @Override
    public String toString() {
        return super.toString();

    }

    public void SetMother (Parent mother) {
        this.mother = mother;
    }

    public void SetFather (Parent father) {
        this.father = father;
    }

    public Parent getFather() {
        return father;
    }

    public Parent getMother() {
        return mother;
    }

    @Override
    public int compareTo(Object o) {
        if (this.toString().compareTo(((Student)o).toString()) == 0) {
            return 0;
        }
        if (this.toString().compareTo(((Student)o).toString()) < 0 ) {
            return -1;
        }
        else {
            return 1;
        }
    }
}
