package validating;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        if (name != null && name.length() <= 40 && !name.isEmpty() && age >= 0 && age <= 120) {
            this.name = name;
            this.age = age;
        } else {
            throw new IllegalArgumentException("Name or age incorrect.");
        }

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
