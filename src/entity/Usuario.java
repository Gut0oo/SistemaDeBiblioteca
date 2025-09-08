package entity;

public class Usuario {
    private int id;
    private String name;
    private String type;
    private String course;

    public Usuario(int id, String name, String type, String course){
        this.id = id;
        this.name = name;
        this.type = type;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
