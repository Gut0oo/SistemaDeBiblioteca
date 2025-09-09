package entity.usuario;

public class Teacher extends User {
    public Teacher(int id, String name, String course){
        super(id, name, "Professor", course);
    }
}
