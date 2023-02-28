package TEMA_POO;

public class Teacher extends User implements Element{


    public Teacher (String firstname, String lastname) {
        super (firstname, lastname);
    }

    @Override
    public void accept(Visitor visitor) {

        visitor.visit(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getFirstName().equals(((Teacher)obj).getFirstName()) && this.getLastName().equals(((Teacher)obj).getLastName())) {
            return true;
        }
        return  false;
    }
}
