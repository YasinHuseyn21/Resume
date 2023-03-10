package entity;

public class Skill {
    private int id;
    private String name;

    public Skill() {

    }

    public Skill(int id, String skill) {
        this.id = id;
        this.name = skill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkill() {
        return name;
    }

    public void setSkill(String skill) {
        this.name = skill;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", skill='" + name + '\'' +
                '}';
    }
}
