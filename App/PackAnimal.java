package App;

public class PackAnimal extends Animal{

    public PackAnimal(String name, int age) {
        super(name, age);
    }

    public boolean isPet() {
        return false;
    }
}
