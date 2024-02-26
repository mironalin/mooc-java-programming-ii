public class Dog extends Animal implements NoiseCapable {
    private String name;

    public Dog(String name) {
        super(name);
    }
    
    public Dog() {
        super("Dog");
    }

    public void bark() {
        System.out.println(getName() + " barks");
    }

    @Override
    public void makeNoise() {
        this.bark();
    }
}
