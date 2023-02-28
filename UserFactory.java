package TEMA_POO;

public class UserFactory {

    public User getUser (String type, String firstname, String lastname) {
        if (type == "Student") {
            Student student = new Student(firstname, lastname);
            return student;
        }

        if (type == "Parent") {
            Parent parent = new Parent(firstname, lastname);
            return parent;
        }

        if (type == "Teacher") {
            Teacher teacher = new Teacher(firstname, lastname);
            return teacher;
        }

        if (type == "Assistant") {
            Assistant assistant = new Assistant(firstname, lastname);
            return assistant;
        }
        return null;
    }
}
