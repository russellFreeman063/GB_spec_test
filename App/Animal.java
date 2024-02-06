package App;

public abstract class Animal {

    protected String name;
    protected int age;
    protected String commands;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCommands() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

    public String getInfo() {
        return String.format("[%s] %s - возраст: %d", getClass().getSimpleName(), name, age);
    }
}