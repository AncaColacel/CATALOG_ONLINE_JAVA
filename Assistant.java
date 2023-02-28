package TEMA_POO;

public class Assistant extends User implements Element{

    public Assistant (String firstname, String lastname) {
        super (firstname, lastname);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public boolean equals(Object obj) {
        if (this.getFirstName().equals(((Teacher) obj).getFirstName()) && this.getLastName().equals(((Teacher) obj).getLastName())) {
            return true;
        }
        return false;
    }
}
