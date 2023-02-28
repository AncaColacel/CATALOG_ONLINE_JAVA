package TEMA_POO;


public class Parent extends User implements Observer {

    public  Parent (String firstname, String lastname) {
        super(firstname, lastname);
        Catalog.getInstance().addObserver(this);

    }

    public Parent (String firstname, String lastname, Catalog catalog) {
        super (firstname, lastname);
        Catalog.getInstance().addObserver(this);


    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void update(Notification notification) {
        System.out.println("Parintele" + " " + getFirstName() + " " + getLastName() + " este anuntat de nota copilului: " + notification);
    }
}
