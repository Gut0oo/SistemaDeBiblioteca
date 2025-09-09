package entity.usuario;

public class Student extends User {
    public Student(int id, String name, String course){
        super(id, name, "Aluno", course);
    }
}
