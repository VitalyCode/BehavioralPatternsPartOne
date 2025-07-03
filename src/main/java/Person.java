import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected final OptionalInt age;
    protected String address;

    private Person(String name, String surname, OptionalInt age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public Person(String name, String surname) {
        this(name, surname, OptionalInt.empty(), null);
    }

    public Person(String name, String surname, int age) {
        this(name, surname, OptionalInt.of(age), null);
    }

    public boolean hasAge() {
        return age.isPresent();
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (age.isPresent()) {
            age.ifPresent(value -> {
                throw new UnsupportedOperationException("Невозможно увеличить возраст. Создайте новый объект Person.");
            });
        }
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder childBuilder = new PersonBuilder();
        childBuilder.setSurname(this.surname);
        if (this.age.isPresent()) {
            childBuilder.setAge(0);
        }
        childBuilder.setAddress(this.address);
        return childBuilder;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + (age.isPresent() ? age.getAsInt() : "N/A") +
                ", address='" + address + '\'' +
                '}';
    }
}
